package model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

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


    public LivroModel(long idLivro, String titulo, String autor, int quantidade, int isbn) {
        this.idLivro = idLivro;
        this.titulo = titulo;
        this.autor = autor;
        this.quantidade = quantidade;
        this.isbn = isbn;
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
}
