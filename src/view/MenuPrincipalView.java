package view;

import controller.LivroController;
import controller.UsuarioController;
import model.LivroModel;
import model.UsuarioModel;

import javax.swing.*;
import java.text.SimpleDateFormat;

public class MenuPrincipalView {
    static SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public void menuPrincipal() {
        LivroModel livro = new LivroModel();
        LivroController livroC = new LivroController();
        LivroView livroV = new LivroView();

        UsuarioModel usuario = new UsuarioModel();
        UsuarioController usuarioC = new UsuarioController();
        UsuarioView usuarioV = new UsuarioView();

        int opcao;

        do{
            opcao = menu();
            switch (opcao) {
                case 1:
                    livro = livroV.lerInfoLivro(livro);
                    String retornoController = livroC.salvar(livro);
                    JOptionPane.showMessageDialog(null, retornoController);
                    break;
                case 2:
                    usuario = usuarioV.lerInfoUsuario(usuario);
                    String retornoControllerUsuario = usuarioC.salvarUsuario(usuario);
                    JOptionPane.showMessageDialog(null, retornoControllerUsuario);
                    break;
                case 0:
                    break;
            }
        }while (opcao != 0);

    }

    static int menu() {

        String menu = "Digite a opcao desejada:\n"+
                "1- Cadastrar livro\n" +
                "2- Cadastrar usuario\n" +
                "3- Fazer emprestimo\n" +
                "4- Registar devolucao\n" +
                "5- Listar livros disponiveis\n" +
                "0- Sair\n";
        String opt = JOptionPane.showInputDialog(null, menu);
        return Integer.parseInt(opt);
    }

}
