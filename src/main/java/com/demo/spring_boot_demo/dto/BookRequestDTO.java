package com.demo.spring_boot_demo.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookRequestDTO {

    private String title;
    private String publisher;
    private Long authorId;
}
