package com.inspiracode.generator.services;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.inspiracode.generator.webapi.model.Deployment;
import com.inspiracode.generator.webapi.model.Djson;

@Service("fileSystemGeneratorService")
@Transactional
public class FileSystemGeneratorService implements GeneratorService {

	@Value("${fs.destination}")
	private String targetDirectory;

	@Override
	public void generate(Djson djson) {
		String pomFile = readFile("molds/backend/pom.xml");
		//TODO Null safe for deployments
		Deployment deployment = djson.getDeployments().iterator().next();
		pomFile = pomFile.replaceAll("[\\{]{2}appName[\\}]{2}", deployment.getAppName());		
		pomFile = pomFile.replaceAll("[\\{]{2}company[\\}]{2}", djson.getTargetCompany());
		pomFile = pomFile.replaceAll("[\\{]{2}version[\\}]{2}", deployment.getVersion());
		pomFile = pomFile.replaceAll("[\\{]{2}description[\\}]{2}", djson.getDescription());		
		System.out.println(pomFile);
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
