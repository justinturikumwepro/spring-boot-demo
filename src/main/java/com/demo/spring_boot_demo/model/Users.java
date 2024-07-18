package com.demo.spring_boot_demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class Users {

    private String name;
    private String department;
    private String email;
}
