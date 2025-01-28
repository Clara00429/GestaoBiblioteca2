package controller;

import model.LivroModel;
import repository.LivroRepository;
import view.TelaPrincipal;

import java.sql.SQLException;
import java.util.List;

public class LivroController {
    LivroRepository livroR = new LivroRepository();

    /* public void iniciaApLivro(){
        LivroModel livroM = new LivroModel();

        TelaPrincipal livro = new TelaPrincipal();
        livro.criarMenu();
    }*/

    public String salvar(LivroModel livro){
        String retornoRepository = livroR.salvar(livro);
        return retornoRepository;
    }
    public List<LivroModel> buscarTodos () throws SQLException {
        return livroR.buscarTodos();
    }

}
