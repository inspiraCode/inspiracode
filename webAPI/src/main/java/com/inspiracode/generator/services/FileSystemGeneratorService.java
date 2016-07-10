package com.inspiracode.generator.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.EndpointAutoConfiguration.GitInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

	@Override
	public void generate(Djson djson) throws GeneratorServiceException {
		// scaffoldBaseCode();
		installSpoc();
		// scaffoldDJSON(djson);
	}

	private void installSpoc() throws GeneratorServiceException {

		String[] spocParameters = { "clone", spocGitUrl };
		runCommand(targetDirectory, "git", spocParameters);
		System.out.println("Spoc project cloned successfully.");

		System.out.println("Installing Spoc...");
		String[] spocInstallParameters = { "clean", "install" };
		runCommand(targetDirectory + "inspiracode-seed\\Backend\\spoc",
				"mvn", spocInstallParameters);
		System.out.println("Spoc Installation process completed.");
	}

	private void scaffoldBaseCode() throws GeneratorServiceException {
		String groupId = String.format("-DgroupId=com.%s.%s", "inspiracode",
				"spoc");
		String artifactId = String.format("-DartifactId=%s", "spoc");
		String[] mvnParameters = { "-B", "archetype:generate",
				"-DarchetypeArtifactId=maven-archetype-quickstart", groupId,
				artifactId, "-DinteractiveMode=false" };
		runCommand("c:\\gitRepositories\\inspiracode-seed\\Backend", mavenCMD,
				mvnParameters);
	}

	private void scaffoldDJSON(Djson djson) throws GeneratorServiceException {
		String targetCompany = Utils.ToVariable(djson.getTargetCompany());
		String projectName = Utils.ToVariable(djson.getProjectName());

		createDirectory(targetDirectory);
		String backendDirectory = targetDirectory + "backend";
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
