package controller;

import model.LivroModel;
import repository.LivroRepository;

import java.sql.SQLException;
import java.util.List;

public class LivroController {
    LivroRepository livroR = new LivroRepository();

    public String Salvar(LivroModel livro) throws SQLException
    {
        return livroR.Salvar(livro);
    }
    public List<LivroModel> listarTodos() throws SQLException {
        return livroR.listarTodos();
    }

}
