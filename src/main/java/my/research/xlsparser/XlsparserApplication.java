package my.research.xlsparser;

import my.research.xlsparser.service.TxtWriter;
import my.research.xlsparser.service.XlsParser;
import my.research.xlsparser.service.XlsWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.IOException;
import java.util.*;

@SpringBootApplication
public class XlsparserApplication {

    public static void main(String[] args) throws IOException {

        SpringApplication.run(XlsparserApplication.class, args);

        File firstFile = new File("src/main/resources/Файл1.xls");
        File secondFile = new File("src/main/resources/Файл2.xls");

        Map<String, List<String>> firstParsedXls = XlsParser.parse(firstFile.getPath());
        Map<String, List<String>> secondParsedXls = XlsParser.parse(secondFile.getPath());

        Map<String, List<String>> firstResult = XlsParser.createDiff(firstParsedXls, secondParsedXls);
        Map<String, List<String>> secondResult = XlsParser.createDiff(secondParsedXls, firstParsedXls);

        XlsWriter.writeXls(firstResult,firstFile.getName(),secondFile.getName());
        XlsWriter.writeXls(secondResult,secondFile.getName(),firstFile.getName());

        TxtWriter.writeTxt(firstParsedXls);
        TxtWriter.writeTxt(secondParsedXls);
    }

}
