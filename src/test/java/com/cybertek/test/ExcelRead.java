package com.cybertek.test;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class ExcelRead {

    @Test
    public void excelRead_test() throws IOException {

        File file = new File("VytrackTestUsers.xlsx");

        System.out.println(file.exists());//if file exists, it should print true

        //load the file into java memory using FileInputStream
        FileInputStream fileInputStream = new FileInputStream(file);

        //workbook ==> sheet ==> row ==> cell

        //load the excel workbook into java class
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        //getting the sheet from workbook
        XSSFSheet sheet = workbook.getSheet("QA1-short");

        //getting specified row from sheet using indexes, and they start from 0
        XSSFRow row = sheet.getRow(2);

        //getting specified column data from row using indexes, and they start from 0
        XSSFCell cell = row.getCell(1);

       // System.out.println(sheet.getRow(2).getCell(1));
        System.out.println(row.getCell(1));

        // getPhysicalNumberOfRows() will count only used cells, starts counting from 1
        //if there are some cells not used, they will not be counted
        int usedRows = sheet.getPhysicalNumberOfRows();
        System.out.println("usedRows = " + usedRows);

        //will count from top to bottom, does not care if cell is used or empty
        //starts counting from 0
        int lastUsedRow = sheet.getLastRowNum();
        System.out.println("lastUsedRow = " + lastUsedRow);


        //get data dynamically

        for (int rowNumber = 0; rowNumber < usedRows; rowNumber++){

            if (sheet.getRow(rowNumber).getCell(1).toString().equals("user1")){

                System.out.println(sheet.getRow(rowNumber).getCell(1));
               // System.out.println("user1");
            }

        }





    }
}
