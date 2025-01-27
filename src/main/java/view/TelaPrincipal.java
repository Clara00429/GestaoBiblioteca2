package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaPrincipal extends JFrame {
    private JMenuBar barraMenu = new JMenuBar();
    private JMenu menu;
    private JMenuItem menuItem;
    private JPanel principal;

    public TelaPrincipal() {
        criarMenu();
        this.setTitle("Gestão Biblioteca");
        this.setContentPane(principal);
        this.setSize(640, 480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }

    public void criarMenu(){
        this.setJMenuBar(barraMenu);
        JMenu cadastro =new JMenu("Cadastrar");
        JMenuItem cadUsuario = new JMenuItem("Cadastrar Usuário");
        JMenuItem cadLivro = new JMenuItem("Cadastrar Livro");
        cadastro.add(cadUsuario);
        cadastro.add(cadLivro);

        JMenu opcoes =new JMenu("Opções Livro");
        JMenuItem emp = new JMenuItem("Fazer Empréstimo");
        JMenuItem devolucao = new JMenuItem("Fazer Devolução");
        JMenuItem listar = new JMenuItem("Listar Livros");
        opcoes.add(emp);
        opcoes.add(devolucao);
        opcoes.add(listar);

        JMenu opcoesU = new JMenu("Opções Usuário");
        JMenuItem buscarUsuario = new JMenuItem("Buscar Usuário");
        JMenuItem removerUsuario = new JMenuItem("Remover Usuário");
        opcoesU.add(buscarUsuario);
        opcoesU.add(removerUsuario);

        barraMenu.add(cadastro);
        barraMenu.add(opcoes);

        cadUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Usuario();
            }
        });
        cadLivro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Livro();
            }
        });
    }
    private void createUIComponents() {

    }

}
