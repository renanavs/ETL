package process;

import model.Fato;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class Loader {
    private List<Fato> listFato;
    private EntityManager entityManager;

    public Loader(List<Fato> listFato, EntityManager entityManager) {
        this.listFato = listFato;
        this.entityManager = entityManager;
    }

    public List<Fato> getListFato() {
        return listFato;
    }

    public void setListFato(List<Fato> listFato) {
        this.listFato = listFato;
    }

    public boolean loadOnWarehouse() {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            for (Fato item :
                    listFato) {
                this.entityManager.persist(item
                );
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
