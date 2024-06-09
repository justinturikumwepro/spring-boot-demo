package com.demo.spring_boot_demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.spring_boot_demo.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

}
