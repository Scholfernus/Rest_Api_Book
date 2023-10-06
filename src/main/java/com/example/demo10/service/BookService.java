package com.example.demo10.service;

import com.example.demo10.model.BookModel;
import com.example.demo10.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;

    /*Pobieranie wszystkich pozycji*/
    public List<BookModel> getBookLIst() {
        return bookRepository.findAll();
    }
}
