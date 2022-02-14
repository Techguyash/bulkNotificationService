package com.notification.backend.bulkNotificationService.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class ExcelFileReader
{
    public List<String> readFileData(InputStream inputStream)
    {
        List<String> mailList=null;
        try
        {
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.iterator();
            mailList=new ArrayList<>(100);
            while (rowIterator.hasNext())
            {
                Row row = rowIterator.next();
                Iterator<Cell> cellIterator = row.cellIterator();
                while(cellIterator.hasNext())
                {
                    Cell cell = cellIterator.next();
                    String stringCellValue = cell.getStringCellValue();
                    mailList.add(stringCellValue);
                }
            }
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return mailList;
    }
}
