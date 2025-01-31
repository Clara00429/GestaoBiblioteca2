package model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name="livro")
public class LivroModel {
    @Id
    @GeneratedValue
    private long idLivro;
    private String titulo;
    private String autor;
    private int quantidade;
    private int isbn;
    private String tema;
    private Date dataPublicacao;

    public long getIdLivro() {

        return idLivro;
    }

    public void setIdLivro(long idLivro) {

        this.idLivro = idLivro;
    }

    public String getTitulo() {

        return titulo;
    }

    public void setTitulo(String titulo) {

        this.titulo = titulo;
    }

    public String getAutor() {

        return autor;
    }

    public void setAutor(String autor) {

        this.autor = autor;
    }

    public int getQuantidade() {

        return quantidade;
    }

    public void setQuantidade(int quantidade) {

        this.quantidade = quantidade;
    }

    public int getIsbn() {

        return isbn;
    }

    public void setIsbn(int isbn) {

        this.isbn = isbn;
    }

    public String getTema() {

        return tema;
    }

    public void setTema(String tema) {

        this.tema = tema;
    }

    public Date getDataPublicacao() {

        return dataPublicacao;
    }

    public void setDataPublicacao(Date dataPublicacao) {


        this.dataPublicacao = dataPublicacao;
    }
}
