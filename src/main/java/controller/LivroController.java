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

}
