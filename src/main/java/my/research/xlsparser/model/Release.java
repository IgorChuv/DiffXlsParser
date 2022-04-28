package my.research.xlsparser.model;

import com.poiji.annotation.ExcelCell;
import com.poiji.annotation.ExcelRow;
import io.github.millij.poi.ss.model.annotations.Sheet;
import io.github.millij.poi.ss.model.annotations.SheetColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Sheet
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Release {

    @ExcelRow
    private int rowIndex;

    @ExcelCell(0)
    private int artistId;

    @ExcelCell(1)
    private String artistName;

    @ExcelCell(2)
    private String trackName;

    @ExcelCell(3)
    private String albumName;


}
