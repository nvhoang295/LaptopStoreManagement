package com.haui_megatech.util;

import com.haui_megatech.dto.CommonResponseDTO;
import com.haui_megatech.model.Product;
import com.haui_megatech.model.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author vieth
 */
public class ExcelUtil {

    private static final String SELECTED_SHEET_NAME = "Sheet1";
    private static final String EXCEL_FILENAME_EXTENSION = ".xlsx";

    public static ArrayList<User> excelToUsers(File file)  {
        
        InputStream is = null;
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet(SELECTED_SHEET_NAME);
            Iterator<Row> rows = sheet.iterator();
            
            ArrayList<User> users = new ArrayList<>();
            
            int rowNumber = 0;
            for (Row row : sheet) {
                if (rowNumber == 0) {
                    ++rowNumber;
                    continue;
                }
                User user = new User();
                
                short firstCellNum = row.getFirstCellNum();
                short lastCellNum = row.getLastCellNum();
                
                for (int cellIndex = firstCellNum; cellIndex < lastCellNum; ++cellIndex) {
                    Cell currentCell = row.getCell(cellIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    
                    switch (cellIndex) {
                        case 0 -> {
                            user.setUsername(currentCell.getStringCellValue());
                            break;
                        }
                        case 1 -> {
                            user.setPassword(currentCell.getStringCellValue());
                            break;
                        }
                        case 2 -> {
                            user.setFirstName(currentCell.getStringCellValue());
                            break;
                        }
                        case 3 -> {
                            user.setLastName(currentCell.getStringCellValue());
                            break;
                        }
                        case 4 -> {
                            user.setPhoneNumber(currentCell.getStringCellValue());
                            break;
                        }
                        case 5 -> {
                            user.setEmail(currentCell.getStringCellValue());
                            break;
                        }
                        default -> {
                            break;
                        }
                    }
                }
                users.add(user);
            }
            workbook.close();
            return users;
        } catch (IOException e) {
            throw new RuntimeException("Fail to parse Excel file: " + e.getMessage());
        }
    }
    
    public static CommonResponseDTO usersToExcel(List<User> users, String savedPath) {
        String savedFilePath = "";
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet("Sheet1");

            XSSFRow row = null;
            Cell cell = null;

            row = spreadsheet.createRow((short) 0);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("id");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("username");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("first_name");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("last_name");
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("phone_number");
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("email");

            for (int i = 0; i < users.size(); i++) {
                User user = users.get(i);
                row = spreadsheet.createRow(i + 1);
                row.setHeight((short) 400);
                row.createCell(0).setCellValue(user.getId());
                row.createCell(1).setCellValue(user.getUsername());
                row.createCell(2).setCellValue(user.getFirstName());
                row.createCell(3).setCellValue(user.getLastName());
                row.createCell(4).setCellValue(user.getPhoneNumber());
                row.createCell(5).setCellValue(user.getEmail());
            }
            System.out.println(savedFilePath);
            try (FileOutputStream out = new FileOutputStream(new File(
                            savedPath.replace("\\", "/") + EXCEL_FILENAME_EXTENSION
            ))) {
                workbook.write(out);
            }
        } catch (IOException e) {
            return CommonResponseDTO
                .builder()
                .success(false)
                .message("Có lỗi trong quá trình ghi file.")
                .build();
        }
        
        return CommonResponseDTO
                .builder()
                .success(true)
                .message(String.format("Xuất thành công %d người dùng.", users.size()))
                .build();
    }
    
    public static ArrayList<Product> excelToProducts(File file)  {
        
        InputStream is = null;
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ExcelUtil.class.getName()).log(Level.SEVERE, null, ex);
        }

        try {
            Workbook workbook = new XSSFWorkbook(is);
            Sheet sheet = workbook.getSheet(SELECTED_SHEET_NAME);
            Iterator<Row> rows = sheet.iterator();
            
            ArrayList<Product> products = new ArrayList<>();
            
            int rowNumber = 0;
            for (Row row : sheet) {
                if (rowNumber == 0) {
                    ++rowNumber;
                    continue;
                }
                Product product = new Product();
                
                short firstCellNum = row.getFirstCellNum();
                short lastCellNum = row.getLastCellNum();
                
                for (int cellIndex = firstCellNum; cellIndex < lastCellNum; ++cellIndex) {
                    Cell currentCell = row.getCell(cellIndex, Row.MissingCellPolicy.CREATE_NULL_AS_BLANK);
                    
                    switch (cellIndex) {
                        case 0 -> {
                            product.setName(currentCell.getStringCellValue());
                            break;
                        }
                        case 1 -> {
                            product.setProcessor(currentCell.getStringCellValue());
                            break;
                        }
                        case 2 -> {
                            product.setMemory(currentCell.getStringCellValue());
                            break;
                        }
                        case 3 -> {
                            product.setStorage(currentCell.getStringCellValue());
                            break;
                        }
                        case 4 -> {
                            product.setDisplay(currentCell.getStringCellValue());
                            break;
                        }
                        case 5 -> {
                            product.setBattery(currentCell.getStringCellValue());
                            break;
                        }
                        case 6 -> {
                            product.setCard(currentCell.getStringCellValue());
                            break;
                        }
                        case 7 -> {
                            product.setWeight(currentCell.getStringCellValue());
                            break;
                        }
                        default -> {
                            break;
                        }
                    }
                }
                products.add(product);
            }
            workbook.close();
            return products;
        } catch (IOException e) {
            throw new RuntimeException("Fail to parse Excel file: " + e.getMessage());
        }
    }
    
     public static CommonResponseDTO productsToExcel(List<Product> products, String savedPath) {
        String savedFilePath = "";
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet spreadsheet = workbook.createSheet("Sheet1");

            XSSFRow row = null;
            Cell cell = null;

            row = spreadsheet.createRow((short) 0);
            row.setHeight((short) 500);
            cell = row.createCell(0, CellType.STRING);
            cell.setCellValue("id");
            cell = row.createCell(1, CellType.STRING);
            cell.setCellValue("name");
            cell = row.createCell(2, CellType.STRING);
            cell.setCellValue("memory");
            cell = row.createCell(3, CellType.STRING);
            cell.setCellValue("storage");
            cell = row.createCell(4, CellType.STRING);
            cell.setCellValue("display");
            cell = row.createCell(5, CellType.STRING);
            cell.setCellValue("battery");
            cell = row.createCell(6, CellType.STRING);
            cell.setCellValue("graphic_card");
            cell = row.createCell(7, CellType.STRING);
            cell.setCellValue("weight");

            for (int i = 0; i < products.size(); i++) {
                Product product = products.get(i);
                row = spreadsheet.createRow(i + 1);
                row.setHeight((short) 400);
                row.createCell(0).setCellValue(product.getId());
                row.createCell(1).setCellValue(product.getName());
                row.createCell(2).setCellValue(product.getMemory());
                row.createCell(3).setCellValue(product.getStorage());
                row.createCell(4).setCellValue(product.getDisplay());
                row.createCell(5).setCellValue(product.getBattery());
                row.createCell(6).setCellValue(product.getCard());
                row.createCell(7).setCellValue(product.getWeight());
            }
            System.out.println(savedFilePath);
            try (FileOutputStream out = new FileOutputStream(new File(
                            savedPath.replace("\\", "/") + EXCEL_FILENAME_EXTENSION
            ))) {
                workbook.write(out);
            }
        } catch (IOException e) {
            return CommonResponseDTO
                .builder()
                .success(false)
                .message("Có lỗi trong quá trình ghi file.")
                .build();
        }
        
        return CommonResponseDTO
                .builder()
                .success(true)
                .message(String.format("Xuất thành công %d sản phẩm.", products.size()))
                .build();
    }
    
}
