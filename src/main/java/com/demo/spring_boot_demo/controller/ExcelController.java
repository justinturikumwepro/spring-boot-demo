package com.demo.spring_boot_demo.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring_boot_demo.model.Users;
import com.demo.spring_boot_demo.service.ExcelService;

@RestController
@RequestMapping("/api/v1/excel")
@CrossOrigin(origins = "http://localhost:3001") // Your frontend URL
public class ExcelController {

    @Autowired
    private ExcelService excelService;

    @PostMapping("/users")
    public ResponseEntity<byte[]> generateExcel(@RequestBody List<Users> users) throws IOException {
        if (users == null || users.isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        // Create the Excel file
        ByteArrayInputStream in = excelService.generateExcel(users);

        // Convert to byte array
        byte[] bytes = in.readAllBytes();

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Disposition", "attachment; filename=users.xlsx");
        return new ResponseEntity<>(bytes, headers, HttpStatus.OK);
    }
}
