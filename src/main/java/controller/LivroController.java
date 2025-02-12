package controller;

import model.LivroModel;
import repository.LivroRepository;

import java.sql.SQLException;
import java.util.List;

public class LivroController {
    LivroRepository livroR = new LivroRepository();

    /* public void iniciaApLivro(){
        LivroModel livroM = new LivroModel();

        TelaPrincipal livro = new TelaPrincipal();
        livro.criarMenu();
    }*/

    public String Salvar(LivroModel livro) throws SQLException
    {
        return livroR.Salvar(livro);
    }
    public List<LivroModel> listarTodos() throws SQLException {
        return livroR.listarTodos();
    }

    public String emprestarLivro(LivroModel livro, String usuario) throws SQLException {
        try {
            return livroR.emprestarLivro(livro, usuario);
        } catch (Exception e) {
            e.printStackTrace();
            return "Erro!";
        }
    }
    public List<LivroModel> listarDisponiveis() throws SQLException {
        try {
            return livroR.listarDisponiveis();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }
    /*public String removerLivro(Long idLivro) throws SQLException {
        return livroR.removerLivro(idLivro);
    }*/
}


