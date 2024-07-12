package com.demo.spring_boot_demo.service;

import java.util.List;

import com.demo.spring_boot_demo.dto.AuthorRequestDTO;
import com.demo.spring_boot_demo.model.Author;

public interface AuthorService {

    Author create(AuthorRequestDTO authorRequestDTO);

    List<Author> findAll();

    Author findById(Long id);
}
