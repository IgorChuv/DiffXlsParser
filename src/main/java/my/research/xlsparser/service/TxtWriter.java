package my.research.xlsparser.service;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TxtWriter {

    public static void writeTxt(Map<String, List<String>> mapToWrite)
            throws IOException {
        FileWriter fileWriter = new FileWriter("result.txt");
        PrintWriter printWriter = new PrintWriter(fileWriter);
        List<String> artists = new ArrayList<>(mapToWrite.keySet());

        for (String artist : artists) {
            List<String> tracks = mapToWrite.get(artist);
            printWriter.print("Исполнитель: " + artist + "\n");
            for (String track : tracks)
                printWriter.println(track);
            printWriter.println();
        }
        printWriter.close();
    }


}
