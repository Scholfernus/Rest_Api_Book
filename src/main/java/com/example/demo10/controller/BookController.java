package com.example.demo10.controller;

import com.example.demo10.model.BookModel;
import com.example.demo10.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping(value = "/books")
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @GetMapping// pobieranie wszystkich książek
    public ResponseEntity<List<BookModel>> getBookList() {
        try {
            List<BookModel> books = bookService.getBookLIst();
            return ResponseEntity.ok(books);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/author/{author}")
    public ResponseEntity<List<BookModel>> getBooksByAuthor(@PathVariable String author) {
        try {
            List<BookModel> books = bookService.getAllBooksByAuthor(author);
            return ResponseEntity.ok(books);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
    @GetMapping("/id/{id}")
    public ResponseEntity<Optional<BookModel>> getBookById(@PathVariable Long id){
        try {
            Optional<BookModel> bookById = bookService.getBookById(id);
            return ResponseEntity.ok(bookById);
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
