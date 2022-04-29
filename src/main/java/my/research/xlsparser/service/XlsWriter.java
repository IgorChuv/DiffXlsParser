package my.research.xlsparser.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.util.*;

@Service
public class XlsWriter {

    public static void writeXls(Map<String, List<String>> mapToWrite, String firstFilename, String secondFilename) {
        try (XSSFWorkbook workBook = new XSSFWorkbook()) {
            XSSFSheet sheet = workBook.createSheet("parsed_data");
            List<String> artists = new ArrayList<>(mapToWrite.keySet());

            int rowsCount = 0;
            Row headerRow = sheet.createRow(rowsCount);
            Cell firstHeader = headerRow.createCell(0);
            Cell secondHeader = headerRow.createCell(1);
            firstHeader.setCellValue("Исполнитель");
            secondHeader.setCellValue("Трек");
            rowsCount++;

            for (String artist : artists) {
                List<String> tracks = mapToWrite.get(artist);
                for (String track : tracks) {
                    Row row = sheet.createRow(rowsCount);
                    rowsCount++;
                    Cell mainCell = row.createCell(0);
                    mainCell.setCellValue(artist);
                    Cell subCell = row.createCell(1);
                    subCell.setCellValue(track);
                }
            }

            FileOutputStream out = new FileOutputStream("Есть в " + firstFilename + " но нет в " + secondFilename + " result.xlsx");
            workBook.write(out);
            out.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
