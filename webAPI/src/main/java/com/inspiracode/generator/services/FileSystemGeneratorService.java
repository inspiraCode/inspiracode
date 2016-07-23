package com.inspiracode.generator.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.inspiracode.generator.utils.Utils;
import com.inspiracode.generator.webapi.model.Djson;

@Service("fileSystemGeneratorService")
@Transactional
public class FileSystemGeneratorService implements GeneratorService {

	@Value("${fs.destination}")
	private String targetDirectory;

	@Value("${spoc.gitURL}")
	private String spocGitUrl;

	@Value("${MAVEN_COMMAND}")
	private String mavenCMD;

	@Value("${os.name}")
	String osName;

	@Value("${spoc.version}")
	String spocVersion;

	private String targetCompany;
	private String projectName;
	private String backendDirectory;

	@Override
	public void generate(Djson djson) throws GeneratorServiceException {
		init(djson);
		installSpoc();
		scaffoldDJSON(djson);

		// Adding Spoc Dependency:
		addPomDependency(backendDirectory + "/" + projectName + "/pom.xml",
				"com.inspiracode.spoc", "spoc", spocVersion);
	}

	private void init(Djson djson) {
		targetCompany = Utils.ToVariable(djson.getTargetCompany());
		projectName = Utils.ToVariable(djson.getProjectName());
		backendDirectory = targetDirectory + "backend";
	}

	private void addPomDependency(String pomTargetName, String groupId,
			String artifactId, String version) {
		try {
			File fXmlFile = new File(pomTargetName);
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory
					.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(fXmlFile);

			// optional, but recommended
			// read this -
			// http://stackoverflow.com/questions/13786607/normalization-in-dom-parsing-with-java-how-does-it-work
			doc.getDocumentElement().normalize();

			System.out.println("-------------------------------------------");
			System.out.println("Adding dependency to:" + pomTargetName
					+ "\t\nGroupID: " + groupId + "\t\nArtifactId" + artifactId
					+ "\t\nVersion" + version);
			System.out.println("-------------------------------------------");

			NodeList dependenciesNodeList = doc
					.getElementsByTagName("dependencies");

			Node nodeDependencies = dependenciesNodeList.item(0);

			Element spocDependency = doc.createElement("dependency");

			Element groupIdElement = doc.createElement("groupId");
			groupIdElement.appendChild(doc.createTextNode(groupId));
			spocDependency.appendChild(groupIdElement);

			Element artifactIdElement = doc.createElement("artifactId");
			artifactIdElement.appendChild(doc.createTextNode(artifactId));
			spocDependency.appendChild(artifactIdElement);

			Element versionElement = doc.createElement("version");
			versionElement.appendChild(doc.createTextNode(version));
			spocDependency.appendChild(versionElement);

			nodeDependencies.appendChild(spocDependency);

			DOMSource source = new DOMSource(doc);

			TransformerFactory transformerFactory = TransformerFactory
					.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			StreamResult result = new StreamResult(pomTargetName);
			transformer.transform(source, result);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void installSpoc() throws GeneratorServiceException {

		String[] spocParameters = { "clone", spocGitUrl };
		runCommand(targetDirectory, "git", spocParameters);
		System.out.println("Spoc project cloned successfully.");

		System.out.println("Installing Spoc...");
		String[] spocInstallParameters = { "clean", "install" };
		runCommand(targetDirectory + "inspiracode-seed\\Backend\\spoc", "mvn",
				spocInstallParameters);
		System.out.println("Spoc Installation process completed.");
	}

	private void scaffoldDJSON(Djson djson) throws GeneratorServiceException {
		createDirectory(targetDirectory);
		createDirectory(backendDirectory);

		String groupId = String.format("-DgroupId=com.%s.%s", targetCompany,
				projectName);
		String artifactId = String.format("-DartifactId=%s", projectName);
		String[] mvnParameters = { "-B", "archetype:generate",
				"-DarchetypeGroupId=am.ik.archetype",
				"-DarchetypeArtifactId=spring-boot-blank-archetype",
				"-DarchetypeVersion=1.0.6", groupId, artifactId,
				"-DinteractiveMode=false" };
		runCommand(backendDirectory, mavenCMD, mvnParameters);
		try {
			cleanup(targetCompany, projectName);
		} catch (IOException e) {
			throw new GeneratorServiceException(e.getMessage());
		}
	}

	private void cleanup(String company, String projectName) throws IOException {
		// remove useless Controller from SpringBoot artifact
		Files.delete(Paths.get(targetDirectory, "backend\\" + projectName
				+ "\\src\\main\\java\\com\\" + company + "\\" + projectName
				+ "\\HelloController.java"));
		Files.delete(Paths.get(targetDirectory, "backend\\" + projectName
				+ "\\src\\main\\resources\\templates\\hello.html"));
		Files.delete(Paths.get(targetDirectory, "backend\\" + projectName
				+ "\\src\\test\\java\\com\\" + company + "\\" + projectName
				+ "\\HelloControllerTest.java"));
	}

	private boolean isWindows() {
		return osName.startsWith("Windows");
	}

	private void runCommand(String targetDirectory, String command,
			String... args) throws GeneratorServiceException {

		try {
			if (isWindows()) {
				command = "cmd /c " + command;
			}
			CommandLine cmdLine = CommandLine.parse(command);

			for (String arg : args) {
				cmdLine.addArgument(arg);
			}

			DefaultExecutor executor = new DefaultExecutor();
			executor.setWorkingDirectory(new File(targetDirectory));

			executor.execute(cmdLine);

		} catch (IOException e) {
			throw new GeneratorServiceException("Error during : " + command);
		}
	}

	private void createDirectory(String targetDirectory) {
		Path p = Paths.get(targetDirectory);

		try {
			Files.createDirectories(p);

		} catch (IOException x) {
			System.err.println(x);
		}
	}

	/**
	 * @return the targetDirectory
	 */
	public String getTargetDirectory() {
		return targetDirectory;
	}

	/**
	 * @param targetDirectory
	 *            the targetDirectory to set
	 */
	public void setTargetDirectory(String targetDirectory) {
		this.targetDirectory = targetDirectory;
	}
}
