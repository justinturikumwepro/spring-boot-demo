package com.demo.spring_boot_demo.service;

import com.demo.spring_boot_demo.dto.BookRequestDTO;
import com.demo.spring_boot_demo.model.Book;

public interface BookService {
    public Book create(BookRequestDTO bookRequestDTO);
    public List<Book> findAll();
    public Book findById(Long id);
}
