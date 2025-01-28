package view;

import repository.LivroRepository;

import javax.swing.*;

public class ListarLivro extends JFrame{
    private LivroRepository livroRepository = new LivroRepository();
    private JTable tableListaLivro;
    private JScrollPane scrollLista;

    public ListarLivro() {
        this.setTitle("Cadastro de Livro");


    }
}
