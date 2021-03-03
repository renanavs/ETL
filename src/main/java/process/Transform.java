package process;

import model.Ambiente;
import model.Cliente;
import model.Fato;
import model.Job;
import org.apache.poi.ss.usermodel.Row;

import java.sql.Date;
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
            System.out.println(new Date((long) row.getCell(3).getNumericCellValue()));
            /*fato.setDataExecucao(String.valueOf(row.getCell(3).getNumericCellValue()));
            fato.setHoraInicio(new Time((long) row.getCell(3).getNumericCellValue()));
            fato.setHoraFim(new Time((long)row.getCell(3).getNumericCellValue()));
            fato.setTempoExecucao(new Time((long) row.getCell(3).getNumericCellValue()));
            fato.setMetaAtualExecucao(new Time((long) row.getCell(3).getNumericCellValue()));*/
            fatos.add(fato);
        });

        return fatos;
    }
}
