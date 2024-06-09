package com.demo.spring_boot_demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring_boot_demo.model.Book;
import com.demo.spring_boot_demo.repository.BookRepository;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/books")
@AllArgsConstructor
@Slf4j
public class BooksRestController {

    private final BookRepository bookRepository;

    @RequestMapping("/")
    public List<Book> list() {
        List<Book> books = new ArrayList<>();
        try {
            log.info("Fetching all books...Started");
            books = bookRepository.findAll();
        } catch (Exception e) {
            log.error("Error while fetching all books", e.getMessage());
            return null;
        }
        return books;
    }

}
