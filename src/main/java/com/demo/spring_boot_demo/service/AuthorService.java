package com.demo.spring_boot_demo.service;

import com.demo.spring_boot_demo.dto.AuthorRequestDTO;
import com.demo.spring_boot_demo.model.Author;

public interface AuthorService {

    Author create(AuthorRequestDTO authorRequestDTO);
}
