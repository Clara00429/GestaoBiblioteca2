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
    public String removerLivro(Long idLivro) throws SQLException {
        LivroModel livro = livroR.buscarPorId(idLivro);
        return livroR.remover(livro);
    }
    public List<LivroModel> listarTodos() throws SQLException {
        return livroR.listarTodos();
    }

}
