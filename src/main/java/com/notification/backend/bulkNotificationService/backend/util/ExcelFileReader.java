package com.notification.backend.bulkNotificationService.backend.util;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

import java.io.IOException;
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
            mailList=new ArrayList<>(100);
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);
            Iterator<Row> rowIterator = sheet.rowIterator();
            while (rowIterator.hasNext())
            {
                Row next = rowIterator.next();
                Cell cell = next.getCell(0);
                String stringCellValue = cell.getStringCellValue();
                if(!stringCellValue.equalsIgnoreCase("Email"))
                {
                    mailList.add(stringCellValue);
                }
            }


        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return mailList;
    }
}
