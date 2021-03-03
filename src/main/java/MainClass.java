import org.apache.poi.ss.usermodel.Row;
import process.Extract;
import process.Transform;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class MainClass {
    public static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("mineracao_de_dados");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        //Extract
        List<Row> rows = Extract.extract();

        //Transform
        Transform transform = new Transform(rows);
        transform.transform();
    }
}
