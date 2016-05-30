package com.inspiracode.generator.services;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspiracode.generator.utils.Utils;
import com.inspiracode.generator.webapi.model.Deployment;
import com.inspiracode.generator.webapi.model.Djson;

@Service("fileSystemGeneratorService")
@Transactional
public class FileSystemGeneratorService implements GeneratorService {

	@Value("${fs.destination}")
	private String targetDirectory;

	@Override
	public void generate(Djson djson) {

		createDirectory(targetDirectory);
		createDirectory(targetDirectory + "\\backend");

		// String pomFile = readFile("molds/backend/pom.xml");
		// // TODO Null safe for deployments
		// Deployment deployment = djson.getDeployments().iterator().next();
		// pomFile = pomFile.replaceAll("[\\{]{2}appName[\\}]{2}",
		// Utils.ToVariable(deployment.getAppName()));
		// pomFile = pomFile.replaceAll("[\\{]{2}companyVar[\\}]{2}",
		// Utils.ToVariable(djson.getTargetCompany()));
		// pomFile = pomFile.replaceAll("[\\{]{2}version[\\}]{2}",
		// deployment.getVersion());
		// pomFile = pomFile.replaceAll("[\\{]{2}description[\\}]{2}",
		// djson.getDescription());

		// System.out.println(pomFile);
		// writeFile(pomFile, "pom.xml", targetDirectory);

	}

	private void runCommand(String targetDirectory, String command, String... args){
		ProcessBuilder pb = new ProcessBuilder(command);
		pb.directory(new File(targetDirectory));
		try {
			pb.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
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

	private String readFile(String fileName) {
		StringBuilder result = new StringBuilder();

		ClassLoader classLoader = getClass().getClassLoader();

		File file = new File(classLoader.getResource(fileName).getFile());

		try (RandomAccessFile aFile = new RandomAccessFile(file, "r");
				FileChannel inChannel = aFile.getChannel();) {

			long fileSize = inChannel.size();
			ByteBuffer buffer = ByteBuffer.allocate((int) fileSize);
			inChannel.read(buffer);
			// buffer.rewind();
			buffer.flip();
			for (int i = 0; i < fileSize; i++) {
				result.append((char) buffer.get());
			}
		} catch (IOException exc) {
			System.out.println(exc);
			System.exit(1);
		}

		return result.toString();
	}

	private void writeFile(String content, String file, String targetDirectory) {

		Path p = Paths.get(targetDirectory + file);

		byte data[] = content.getBytes();
		try (OutputStream out = new BufferedOutputStream(Files.newOutputStream(
				p, StandardOpenOption.CREATE,
				StandardOpenOption.TRUNCATE_EXISTING))) {

			Files.createDirectories(p);
			out.write(data, 0, data.length);
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
