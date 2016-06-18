package com.inspiracode.generator.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspiracode.generator.utils.Utils;
import com.inspiracode.generator.webapi.model.Djson;

@Service("fileSystemGeneratorService")
@Transactional
public class FileSystemGeneratorService implements GeneratorService {

	@Value("${fs.destination}")
	private String targetDirectory;

	@Value("${MAVEN_COMMAND}")
	private String mavenCMD;

	@Value("${os.name}")
	String osName;

	@Override
	public void generate(Djson djson) throws GeneratorServiceException {

		createDirectory(targetDirectory);
		String backendDirectory = targetDirectory + "backend";
		createDirectory(backendDirectory);

		String groupId = String.format("-DgroupId=com.%s.%s",
				Utils.ToVariable(djson.getTargetCompany()),
				Utils.ToVariable(djson.getProjectName()));
		String artifactId = String.format("-DartifactId=%s",
				Utils.ToVariable(djson.getProjectName()));
		String[] mvnParameters = { "-B", "archetype:generate",
				"-DarchetypeGroupId=am.ik.archetype",
				"-DarchetypeArtifactId=spring-boot-blank-archetype",
				"-DarchetypeVersion=1.0.6", 
				groupId, artifactId, "-DinteractiveMode=false" };
		runCommand(backendDirectory, mavenCMD, mvnParameters);		
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
