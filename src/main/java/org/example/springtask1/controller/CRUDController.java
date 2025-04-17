//package org.example.springtask1.controller;
//
//import org.example.springtask1.persistence.entity.Author;
//import org.example.springtask1.persistence.entity.Book;
//import org.example.springtask1.service.CRUDService;
//import org.example.springtask1.service.CSVUploadService;
//import org.example.springtask1.service.additional.BookError;
//import org.example.springtask1.service.additional.BookUploadResult;
//import org.example.springtask1.service.dto.csvreader.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.multipart.MultipartFile;
//
//@RestController
//@RequestMapping("/crud/")
//public class CRUDController {
//
//    private final CRUDService service;
//
//    @Autowired
//    public CRUDController(CRUDService service) {
//        this.service = service;
//    }
//
//    @PostMapping("/author/{id}")
//    public BookDto createBook(@RequestBody BookDto bookDto) {
//        return service.createBook(bookDto);
//    }
//
//    @PutMapping("/author/{id}")
//    public BookDto updateBook(@PathVariable Long id, @RequestBody BookDto bookDto) {
//        return service.updateBook(id, bookDto);
//    }
//
//    @DeleteMapping("/book/{id}")
//    public BookDto deleteBook(@PathVariable Long id) {
//        return service.deleteBook(id);
//    }
//}
