package my.research.xlsparser;

import my.research.xlsparser.service.TxtWriter;
import my.research.xlsparser.service.XlsParser;
import my.research.xlsparser.service.XlsWriter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.*;

@SpringBootApplication
public class XlsparserApplication {

    public static void main(String[] args) throws IOException {

        SpringApplication.run(XlsparserApplication.class, args);
        Map<String, List<String>> firstParsedXls = XlsParser.parse("C:/IdeaProjects/xlsparser/src/main/resources/Зайцев.нет.xls");
        Map<String, List<String>> secondParsedXls = XlsParser.parse("C:/IdeaProjects/xlsparser/src/main/resources/Мун Рекордс.xls");

        Map<String, List<String>> result = XlsParser.areEqualKeyValues(firstParsedXls, secondParsedXls);
        System.out.println(XlsParser.areEqualKeyValues(firstParsedXls, secondParsedXls));
        XlsWriter.writeXls(result);
        TxtWriter.writeTxt(result);
    }

}
