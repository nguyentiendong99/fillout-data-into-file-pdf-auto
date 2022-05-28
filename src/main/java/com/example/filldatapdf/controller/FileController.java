package com.example.filldatapdf.controller;

import com.example.filldatapdf.entity.GetAllFileRequest;
import com.example.filldatapdf.service.OnboardingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FileController {
    @Autowired
    private OnboardingService onboardingService;

    @GetMapping("/list-file")
    public ResponseEntity<String> getAllFile() throws Exception {
        String name = onboardingService.getAllFile();
        return ResponseEntity.ok().body(name);
    }
}
