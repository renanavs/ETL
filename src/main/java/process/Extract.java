package process;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Extract {

    private static final String FILE_NAME = "src/main/resources/p2d2.xlsx";

    public static List<Row> extract() {
        List<Row> rows = new ArrayList<>();

        try {
            FileInputStream excelFile = new FileInputStream(FILE_NAME);
            Workbook workbook = new XSSFWorkbook(excelFile);
            Sheet datatypeSheet = workbook.getSheetAt(0);
            Iterator<Row> iterator = datatypeSheet.iterator();

            while (iterator.hasNext()) {
                Row currentRow = iterator.next();
                rows.add(currentRow);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        rows.remove(0); // removendo os headers;
        return rows;
    }

}
