package controller;

import model.LivroModel;
import repository.LivroRepository;
import view.TelaPrincipal;

public class LivroController {
    LivroRepository livroR = new LivroRepository();

    public void iniciaApLivro(){
        LivroModel livroM = new LivroModel();

        TelaPrincipal livro = new TelaPrincipal();
        livro.criarMenu();
    }

    public String salvar(LivroModel livro){
        String retornoRepository = livroR.salvarLivro(livro);
        return retornoRepository;
    }

}
