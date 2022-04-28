package my.research.xlsparser.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Response {

    String artist;
    List<String> tracks;
}
