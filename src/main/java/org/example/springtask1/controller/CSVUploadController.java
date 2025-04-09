package org.example.springtask1.controller;

import org.example.springtask1.service.CSVUploadService;
import org.example.springtask1.service.additional.BookError;
import org.example.springtask1.service.additional.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/csv")
public class CSVUploadController {

    private final CSVUploadService service;

    @Autowired
    public CSVUploadController(CSVUploadService service) {
        this.service = service;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadCSV(@RequestParam("file") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("File is empty");
        }

        Result result = service.upload(file);

        if (result == null) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Unable to perform request");
        }

        StringBuilder response = new StringBuilder();

        for (BookError bookError : result.getBookErrorList()) {
            response.append(bookError.getBookErrorState());
            response.append(": ");
            response.append(bookError.getBookDto());
            response.append("\n");
        }

        return ResponseEntity.ok(response.toString());
    }
}