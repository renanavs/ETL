package process;

import model.Ambiente;
import model.Cliente;
import model.Fato;
import model.Job;
import model.Status;
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

            fato.setHoraInicio(Time.valueOf(row.getCell(4).getStringCellValue()));
            fato.setHoraFim(Time.valueOf(row.getCell(5).getStringCellValue()));
            fato.setTempoExecucao(Long.parseLong(row.getCell(6).getStringCellValue()));
            fato.setMetaAtualExecucao(Long.parseLong(row.getCell(7).getStringCellValue()));
            fato.setStatus(row.getCell(8).getStringCellValue());

            fatos.add(fato);
        });

        return fatos;
    }

    private static Date parseDate(String date) {
        final String dateTransform = date.substring(0,4) + "-" + date.substring(4, 6) + "-" + date.substring(6);

        return Date.valueOf(dateTransform);
    }
}
