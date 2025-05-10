package com.kopyatanimabackend.controller;


import com.example.plagiarismdetector.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/files")


public class filecontroller {
	

    @Autowired
    private FileService fileService;

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        fileService.saveFile(file);
        return "File uploaded successfully";
    }

    @GetMapping("/compare")
    public double compareFiles(@RequestParam String file1, @RequestParam String file2) throws IOException {
        return fileService.compareFiles(file1, file2);
    }

}
