package com.cybertek.test;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class ExcelWrite {

    @Test
    public void excel_write_test() throws IOException {

        XSSFWorkbook workbook;
        XSSFSheet sheet;
        XSSFRow row;
        XSSFCell cell;

        String path = "VytrackTestUsers.xlsx";

        FileInputStream input = new FileInputStream(path);

        //workbook ==>  sheet ==> row ==> cell

        //loading excel workbook into class
        workbook = new XSSFWorkbook(input);

        //getting our sheet from workbook
        sheet = workbook.getSheet("QA1-short");

        //getting row number 1
        row = sheet.getRow(1);

        //getting cell 1
        cell = row.getCell(1);

        System.out.println("cell = " + cell);
        System.out.println(sheet.getRow(1).getCell(1));

        //create a file output stream to specify which file we are writing to
        FileOutputStream output = new FileOutputStream(path);


        workbook.write(output);

        cell.setCellValue("user123");

        System.out.println("cell = " + cell);


        for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++){

            if(sheet.getRow(i).getCell(1).toString().equals("user1")){

                sheet.getRow(i).getCell(1).setCellValue("user123");
            }
        }


        //closing all resources we openend
        input.close();
        output.close();
        workbook.close();

    }
}
