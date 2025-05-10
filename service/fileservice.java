package com.kopyatanimabackend.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service

public class fileservice {

	 private final Path fileStorageLocation = Paths.get("uploads").toAbsolutePath().normalize();

	    public FileService() throws IOException {
	        Files.createDirectories(this.fileStorageLocation);
	    }

	    public void saveFile(MultipartFile file) throws IOException {
	        Path target = this.fileStorageLocation.resolve(file.getOriginalFilename());
	        Files.copy(file.getInputStream(), target);
	    }

	    public double compareFiles(String filename1, String filename2) throws IOException {
	        String content1 = Files.readString(fileStorageLocation.resolve(filename1));
	        String content2 = Files.readString(fileStorageLocation.resolve(filename2));

	        return calculateSimilarity(content1, content2);
	    }

	    private double calculateSimilarity(String text1, String text2) {
	        
	        return 0.75; 
	    }
}
