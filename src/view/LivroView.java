package view;

import model.LivroModel;

import javax.swing.*;

public class LivroView {
    public LivroModel lerInfoLivro(LivroModel livro) {
        livro.setTitulo(JOptionPane.showInputDialog(null,"Informe o titulo"));
        livro.setAutor(JOptionPane.showInputDialog(null,"Informe autor"));
        livro.setIsbn(Integer.parseInt(JOptionPane.showInputDialog(null,"Informe o ISBN:")));
        livro.setQuantidade(Integer.parseInt(JOptionPane.showInputDialog(null,"Informe a quantidade disponivel:")));
        return livro;

    }
}

