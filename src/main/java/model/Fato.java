package model;

import javax.persistence.*;
import java.sql.Time;
import java.sql.Date;

@Entity
public class Fato {
    @Id
    @GeneratedValue
    private Integer id;

    @ManyToOne
    private Cliente cliente;

    @ManyToOne
    private Ambiente ambiente;

    @ManyToOne
    private Job job;

    private Date dataExecucao;

    private Time horaInicio;

    private Time horaFim;

    private Time tempoExecucao;

    private Time metaAtualExecucao;

    private Status status;

    public Fato() {
    }

    public Fato(Integer id, Cliente cliente, Ambiente ambiente, Job job, Date dataExecucao, Time horaInicio, Time horaFim, Time tempoExecucao, Time metaAtualExecucao, Status status) {
        this.id = id;
        this.cliente = cliente;
        this.ambiente = ambiente;
        this.job = job;
        this.dataExecucao = dataExecucao;
        this.horaInicio = horaInicio;
        this.horaFim = horaFim;
        this.tempoExecucao = tempoExecucao;
        this.metaAtualExecucao = metaAtualExecucao;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Ambiente getAmbiente() {
        return ambiente;
    }

    public void setAmbiente(Ambiente ambiente) {
        this.ambiente = ambiente;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
    }

    public Date getDataExecucao() {
        return dataExecucao;
    }

    public void setDataExecucao(Date dataExecucao) {
        this.dataExecucao = dataExecucao;
    }

    public Time getHoraInicio() {
        return horaInicio;
    }

    public void setHoraInicio(Time horaInicio) {
        this.horaInicio = horaInicio;
    }

    public Time getHoraFim() {
        return horaFim;
    }

    public void setHoraFim(Time horaFim) {
        this.horaFim = horaFim;
    }

    public Time getTempoExecucao() {
        return tempoExecucao;
    }

    public void setTempoExecucao(Time tempoExecucao) {
        this.tempoExecucao = tempoExecucao;
    }

    public Time getMetaAtualExecucao() {
        return metaAtualExecucao;
    }

    public void setMetaAtualExecucao(Time metaAtualExecucao) {
        this.metaAtualExecucao = metaAtualExecucao;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
