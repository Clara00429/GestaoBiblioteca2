package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class UsuarioModel
{
    @Id
    @GeneratedValue
    private String nome;
    private String email;
    private int idUsuario;
    private String sexo;
    private String num_celular;

    public UsuarioModel(){}

    public UsuarioModel(String sexo, String num_celular, String nome, String email, int idUsuario) {
        this.nome = nome;
        this.email = email;
        this.idUsuario = idUsuario;
        this.sexo = sexo;
        this.num_celular = num_celular;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdUsuario() {
        return idUsuario;
    }
    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public String getSexo() {
        return sexo;
    }
    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNum_celular() {
        return num_celular;
    }
    public void setNum_celular(String num_celular) {
        this.num_celular = num_celular;
    }
}
