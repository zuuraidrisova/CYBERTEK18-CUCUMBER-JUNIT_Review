package com.cybertek.test;

import com.cybertek.pages.GasMileageCalculator;
import com.cybertek.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDate;

public class GasMileageTest {

    XSSFWorkbook workbook;
    XSSFSheet sheet;

    FileInputStream input;
    FileOutputStream output;

    GasMileageCalculator gasMileageCalculator = new GasMileageCalculator();

    @Test
    public void  gasMileageCalculator_test() throws IOException, InterruptedException {

        Driver.getDriver().get("https://www.calculator.net/gas-mileage-calculator.html");

        String path = "src/test/resources/testData/gasTestData.xlsx";

        //loading the file to class
        input = new FileInputStream(path);

        //loading the workbook to class
        workbook = new XSSFWorkbook(input);

        sheet = workbook.getSheet("Sheet1");

        for(int rowNumber = 1; rowNumber <= sheet.getLastRowNum(); rowNumber++) {

            XSSFRow currentRow = sheet.getRow(rowNumber);

            if(! currentRow.getCell(0).toString().equals("Y")){

                if(currentRow.getCell(6) == null){

                    currentRow.createCell(6);
                }

                currentRow.getCell(6).setCellValue("Skipped");
                continue;
            }


            // double current = 123000;
            double current = currentRow.getCell(1).getNumericCellValue();
            gasMileageCalculator.currentOdometer.clear();
            Thread.sleep(2000);
            gasMileageCalculator.currentOdometer.sendKeys(String.valueOf(current));

            Thread.sleep(2000);

            //double previous = 122000;
            double previous = currentRow.getCell(2).getNumericCellValue();
            gasMileageCalculator.previousOdometer.clear();
            gasMileageCalculator.previousOdometer.sendKeys(String.valueOf(previous));

            //double gas = 70;
            double gas = currentRow.getCell(3).getNumericCellValue();
            gasMileageCalculator.gasAdded.clear();
            gasMileageCalculator.gasAdded.sendKeys(String.valueOf(gas));

            gasMileageCalculator.calculateButton.click();

            double expectedResult = (current - previous) / gas;
            System.out.println("expectedResult = " + expectedResult);

            String actualResult = gasMileageCalculator.mpgResult.getText();
            System.out.println("actualResult = " + actualResult);

            DecimalFormat decimalFormat = new DecimalFormat("#0.00");
            System.out.println(decimalFormat.format(expectedResult));


            if (currentRow.getCell(4) == null) {

                currentRow.createCell(4);
            }

            //sending  the expected value from our formula
            currentRow.getCell(4).setCellValue(decimalFormat.format(expectedResult));


            if (currentRow.getCell(5) == null) {

                currentRow.createCell(5);
            }

            //sending  the actual value from our formula
            currentRow.getCell(5).setCellValue(actualResult);


            //checking and comparing actual  v expected
            if (actualResult.startsWith(String.valueOf(decimalFormat.format(expectedResult)))) {

                if (currentRow.getCell(6) == null) {

                    currentRow.createCell(6);
                }

                currentRow.getCell(6).setCellValue("Pass");
                System.out.println("Pass");

            } else {

                if (currentRow.getCell(6) == null) {

                    currentRow.createCell(6);
                }

                currentRow.getCell(6).setCellValue("Fail");
                System.out.println("Fail");
            }

            if (currentRow.getCell(7) == null) {

                currentRow.createCell(7);
            }

            currentRow.getCell(7).setCellValue(LocalDate.now().toString());

        }

        output = new FileOutputStream(path);

        workbook.write(output);



        //closing all open resources
        workbook.close();
        input.close();
        output.close();

    }



}
