import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MainClass {
    public static final EntityManagerFactory entityManagerFactory =
            Persistence.createEntityManagerFactory("mineracao_de_dados");

    public static void main(String[] args) {
        EntityManager entityManager = entityManagerFactory.createEntityManager();
    }
}
