package com.demo.spring_boot_demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring_boot_demo.model.Author;
import com.demo.spring_boot_demo.repository.AuthorRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/api/v1/authors")
@AllArgsConstructor
@Slf4j
public class AuthorsController {

    private final AuthorRepository authorRepository;

    @RequestMapping("/")
    public List<Author> getAuthors() {
        log.info("Fetching all authors...Started");
        List<Author> authors = new ArrayList<>();
        try {
            authors = authorRepository.findAll();
        } catch (Exception e) {
            log.error("Error while fetching all authors", e.getMessage());
            return null;
        }
        return authors;
    }

}
