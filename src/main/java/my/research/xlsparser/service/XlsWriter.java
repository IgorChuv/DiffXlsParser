package my.research.xlsparser.service;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileOutputStream;
import java.util.*;

@Service
public class XlsWriter {

    public static void writeXls(Map<String, List<String>> mapToWrite) {
        try (XSSFWorkbook workBook = new XSSFWorkbook()) {
            XSSFSheet sheet = workBook.createSheet("data2");
            int rows = mapToWrite.size();
            List<String> artists = new ArrayList<>(mapToWrite.keySet());

            for (int i = 0; i < rows; i++) {
                List<String> tracks = mapToWrite.get(artists.get(i));
                Row row = sheet.createRow(i);
                Cell cell = row.createCell(0);
                cell.setCellValue(artists.get(i));
                for (int j = 1; j < tracks.size() + 1; j++) {
                    Cell subCell = row.createCell(j);
                    subCell.setCellValue(tracks.get(j - 1));
                }
            }
            FileOutputStream out = new FileOutputStream("result.xlsx");
            workBook.write(out);
            out.close();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
