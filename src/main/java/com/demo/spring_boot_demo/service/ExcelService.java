package com.demo.spring_boot_demo.service;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import com.demo.spring_boot_demo.model.Users;

@Service
public class ExcelService {

    public ByteArrayInputStream generateExcel(List<Users> users) throws IOException {
        if (users == null || users.isEmpty()) {
            return null;
        }
        try (Workbook workbook = new XSSFWorkbook(); ByteArrayOutputStream out = new ByteArrayOutputStream()) {
            Sheet sheet = workbook.createSheet("Users Summary");
            // Create header row
            Row headerRow = sheet.createRow(0);
            headerRow.createCell(0).setCellValue("Department");
            headerRow.createCell(1).setCellValue("Name");
            headerRow.createCell(2).setCellValue("Email");
            int rowNum = 1;
            for (Users user : users) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(user.getDepartment());
                row.createCell(1).setCellValue(user.getName());
                row.createCell(2).setCellValue(user.getEmail());
            }
            workbook.write(out);
            return new ByteArrayInputStream(out.toByteArray());
        }

    }
}
