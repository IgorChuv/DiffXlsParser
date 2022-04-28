package my.research.xlsparser.service;

import com.poiji.bind.Poiji;
import my.research.xlsparser.model.Release;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class XlsParser {

    public static Map<String, List<String>> parse(String filePath) {
        List<Release> list = Poiji.fromExcel(new File(filePath), Release.class);
        return list.stream().collect(Collectors.groupingBy(Release::getArtistName,
                Collectors.mapping(Release::getTrackName, Collectors.toList())));
    }

    public static Map<String, List<String>> areEqualKeyValues(Map<String, List<String>> first, Map<String, List<String>> second) {
        Map<String, List<String>> result = new HashMap<>();


        for (Map.Entry<String, List<String>> entry : first.entrySet()) {
            if (!second.containsKey(entry.getKey())) {
                result.put(entry.getKey(), entry.getValue());
            } else {
                List<String> firstList = entry.getValue();
                List<String> secondList = second.get(entry.getKey());
                List<String> notContainsInSecondList = firstList.stream()
                        .filter(x -> !secondList.contains(x))
                        .collect(Collectors.toList());
                if (!notContainsInSecondList.isEmpty()) {
                    result.put(entry.getKey(), notContainsInSecondList);
                }
            }
        }
        return result;

    }
}
