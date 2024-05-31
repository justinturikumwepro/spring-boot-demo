package com.demo.spring_boot_demo.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorsController {

    @RequestMapping("/")
    public String list() {
        return "Authors list";
    }

}
