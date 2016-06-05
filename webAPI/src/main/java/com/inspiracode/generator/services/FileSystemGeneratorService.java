package com.inspiracode.generator.services;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;

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

	@Override
	public void generate(Djson djson) throws GeneratorServiceException {

		createDirectory(targetDirectory);
		String backendDirectory = targetDirectory + "backend";
		createDirectory(backendDirectory);

		String groupId = String.format("-DgroupId=com.%s.%s", Utils.ToVariable(djson.getTargetCompany()),
				Utils.ToVariable(djson.getProjectName()));
		String artifactId = String.format("-DartifactId=%s", Utils.ToVariable(djson.getProjectName()));
		String[] mvnParameters = {"-B", "archetype:generate", "-DarchetypeGroupId=org.apache.maven.archetypes", groupId, artifactId, "-DinteractiveMode=false" };
		runCommand(backendDirectory, mavenCMD, mvnParameters);
	}

	private void runCommand(String targetDirectory, String command, String... args) throws GeneratorServiceException {
		ProcessBuilder pb = new ProcessBuilder(command);
		pb.command().addAll(Arrays.asList(args));
		
		pb.directory(new File(targetDirectory));
		//TODO Configure Log destination
		pb.redirectOutput(new File("c:\\temp\\Maven.log"));
		try {
			pb.start();
			//TODO evaluate process result
		} catch (IOException e) {
			e.printStackTrace();
			throw new GeneratorServiceException("Unable to execute command: " + command + ", " + e.getMessage());
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
