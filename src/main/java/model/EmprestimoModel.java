package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "emprestimo")
public class EmprestimoModel {
    @Id
    @GeneratedValue
    private int idEmprestimo;
    private Date dataInicio; // data_emp
    private Date dataFim;//data_dev
    private int idUsuario;

    /*
    usuario
    data_prevista
    id_emp
     */

    public EmprestimoModel(Date dataInicio, Date dataFim) {
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public EmprestimoModel() {}

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }

    public Date getDataFim() {
        return dataFim;
    }

    public void setDataFim(Date dataFim) {
        this.dataFim = dataFim;
    }
}
