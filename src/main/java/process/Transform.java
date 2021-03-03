package process;

import model.Ambiente;
import model.Cliente;
import model.Fato;
import model.Job;
import org.apache.poi.ss.usermodel.Row;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

public class Transform {
    private List<Row> rows;

    public Transform(List<Row> rows) {
        this.rows = rows;
    }

    public List<Row> getRows() {
        return rows;
    }

    public void setRows(List<Row> rows) {
        this.rows = rows;
    }

    public List<Fato> transform() {
        List<Fato> fatos = new ArrayList();

        getRows().forEach(row -> {
            Fato fato = new Fato();
            fato.setCliente(new Cliente(row.getCell(0).getStringCellValue()));
            fato.setAmbiente(new Ambiente(row.getCell(1).getStringCellValue()));
            fato.setJob(new Job(row.getCell(2).getStringCellValue()));
            final String dataString = String.valueOf(row.getCell(3).getStringCellValue());
            fato.setDataExecucao(parseDate(dataString));
            //fato.setHoraInicio(new Time((long) row.getCell(3).getNumericCellValue()));
            //fato.setHoraFim(new Time((long)row.getCell(3).getNumericCellValue()));
            //fato.setTempoExecucao(new Time((long) row.getCell(3).getNumericCellValue()));
            //fato.setMetaAtualExecucao(new Time((long) row.getCell(3).getNumericCellValue()));
            //fatos.add(fato);
            System.out.println("test");
        });

        return fatos;
    }

    private static Date parseDate(String date) {
        final String dateTransform = date.substring(0,4) + "-" + date.substring(4, 6) + "-" + date.substring(6);

        return Date.valueOf(dateTransform);
    }
}
