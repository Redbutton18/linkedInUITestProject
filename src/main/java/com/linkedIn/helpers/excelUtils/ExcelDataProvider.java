package com.linkedIn.helpers.excelUtils;

import org.testng.annotations.DataProvider;

import java.io.IOException;

public class ExcelDataProvider {
    static String path = "C:/Users/Redbutton/IdeaProjects/linkedInUITestProject/src/main/java/com/linkedIn/helpers/dataProviderData/SignInDataProviderData.xlsx";
    static String sheet = "Лист1";

    @DataProvider(name = "Wrong data for user login")
    public Object[][] getExcelData() throws IOException {
        Object data[][] = testData(path,sheet);
        return data;
    }

    public static Object[][] testData(String path, String sheet) throws IOException {

        ExcelUtils excel = new ExcelUtils(path, sheet);

        int rowCount = excel.getRowCount();
        int colCount = excel.getColCount();

        Object data[][] = new Object[rowCount-1][colCount];

        for (int i = 1; i < rowCount; i++) {
            for (int j = 0; j < colCount; j++) {
                String cellData = excel.getCellData(i,j);
                data[i-1][j] = cellData;
            }
        }
        return data;
    }

    //Extract value of current cell
    public static void main(String[] args) throws IOException {
        ExcelUtils excelUtils = new ExcelUtils(path, sheet);

        Object data = excelUtils.getCellData(1, 1);
        System.out.println(data);
    }
}
