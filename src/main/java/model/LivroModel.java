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
    private LocalDate dataPublicacao;

    public LivroModel(Date dataPublicacao) {
    }

    public LivroModel(long idLivro,LocalDate dataPublicacao, String tema, String titulo, String autor, int quantidade, int isbn) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.autor = autor;
        this.quantidade = quantidade;
        this.isbn = isbn;
        this.dataPublicacao = dataPublicacao;
    }

    public LivroModel() {}

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


    public String getAutor()
    {
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


    public LocalDate getDataPublicacao() {
        return dataPublicacao;
    }
    public void setDataPublicacao(LocalDate dataPublicacao) {
        this.dataPublicacao = dataPublicacao;
    }
}
