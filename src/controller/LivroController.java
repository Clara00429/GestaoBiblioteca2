package controller;

import model.LivroModel;
import repository.LivroRepository;
import view.MenuPrincipalView;

public class LivroController {
    LivroRepository livroR = new LivroRepository();

    public void iniciaApLivro(){
        LivroModel livroM = new LivroModel();

        MenuPrincipalView livro = new MenuPrincipalView();
        livro.menuPrincipal();
    }

    public String salvar(LivroModel livro){
        String retornoRepository = livroR.salvarLivro(livro);
        return retornoRepository;
    }

}
