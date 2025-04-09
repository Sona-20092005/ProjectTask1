//package org.example.springtask1.controller;
//
//import com.opencsv.CSVReader;
//import com.opencsv.exceptions.CsvValidationException;
//import lombok.SneakyThrows;
//import org.example.springtask1.persistence.repository.*;
//import org.example.springtask1.service.CSVUploadService;
//import org.example.springtask1.service.FilterService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.convert.Delimiter;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//import java.io.IOException;
//import java.io.InputStreamReader;
//
//@RestController
//@RequestMapping("/filter")
//public class FilterController {
//
//    private final FilterService service;
//
//    @Autowired
//    public FilterController(FilterService service) {
//        this.service = service;
//    }
//
//}