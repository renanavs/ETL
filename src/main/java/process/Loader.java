package process;

import model.Ambiente;
import model.Cliente;
import model.Fato;
import model.Job;
import org.hibernate.Transaction;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.List;

public class Loader {
    private List<Fato> listFato;
    private static EntityManager entityManager;

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
                merge(item);
                System.out.println("Persistindo Fato id:"+item);
                entityManager.persist(item);
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    private static Cliente findClienteInDatabase(Cliente obj) {
        String sql = "FROM " + Cliente.class.getName();
        sql += " WHERE descricao = :descricao ";

        List<Cliente> result = entityManager.createQuery(sql, Cliente.class).
                setParameter("descricao", obj.getDescricao()).
                getResultList();

        if(result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    private static Ambiente findAmbienteInDatabase(Ambiente obj) {
        String sql = "FROM " + Ambiente.class.getName();
        sql += " WHERE descricao = :descricao ";


        List<Ambiente> result = entityManager.createQuery(sql, Ambiente.class).
                setParameter("descricao", obj.getDescricao()).
                getResultList();

        if(result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    private static Job findJobInDatabase(Job obj) {
        String sql = "FROM " + Job.class.getName();
        sql += " WHERE descricao = :descricao ";


        List<Job> result = entityManager.createQuery(sql, Job.class).
                setParameter("descricao", obj.getDescricao()).
                getResultList();

        if(result.isEmpty()) {
            return null;
        }
        return result.get(0);
    }

    private static void merge(Fato f) {
        final Cliente cliente = findClienteInDatabase(f.getCliente());
        final Ambiente ambiente = findAmbienteInDatabase(f.getAmbiente());
        final Job job = findJobInDatabase(f.getJob());

        if(cliente != null) {
            f.setCliente(cliente);
        }
        if(ambiente != null) {
            f.setAmbiente(ambiente);
        }
        if (job != null) {
            f.setJob(job);
        }
    }
}
