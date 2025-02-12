package model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "emprestimo") // garantindo que o nome da tabela esta correto como no banco de dados, pode ser alterado para emprestimoModel, para controle
public class EmprestimoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmprestimo; // nome identico ao banco de dados

    @ManyToOne
    @JoinColumn(name = "idLivro", nullable = false) // aq o mesmo, porem garantindo que existe no BD, nao sendo nulo
    private LivroModel livro;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false)
    private UsuarioModel usuario;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(nullable = false)
    private Date dataInicio;

    @Temporal(TemporalType.TIMESTAMP)
    private Date dataFim;

    public EmprestimoModel() {}

    //construtor geral, nao utilizado
    public EmprestimoModel(LivroModel livro, UsuarioModel usuario, Date dataInicio, Date dataFim) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataInicio = dataInicio;
        this.dataFim = dataFim;
    }

    public Long getIdEmprestimo() {
        return idEmprestimo;
    }
    public LivroModel getLivro() {
        return livro;
    }

    public void setLivro(LivroModel livro) {
        this.livro = livro;
    }

    public UsuarioModel getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioModel usuario) {
        this.usuario = usuario;
    }

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
