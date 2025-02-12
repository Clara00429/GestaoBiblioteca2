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
        this.setLocationRelativeTo(null);
        this.setSize(640, 480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public void criarMenu() {
        this.setJMenuBar(barraMenu);

        JMenu cadastro = new JMenu("Cadastrar");
        JMenuItem cadUsuario = new JMenuItem("Cadastrar Usuário");
        JMenuItem cadLivro = new JMenuItem("Cadastrar Livro");
        cadastro.add(cadUsuario);
        cadastro.add(cadLivro);

        JMenu opcoes = new JMenu("Opções Livro");
        JMenuItem emp = new JMenuItem("Fazer Empréstimo");
        JMenuItem devolucao = new JMenuItem("Fazer Devolução");
        JMenuItem listar = new JMenuItem("Listar Livros");
        opcoes.add(emp);
        opcoes.add(devolucao);
        opcoes.add(listar);

        JMenu opcoesU = new JMenu("Opções Usuário");
        JMenuItem buscarUsuario = new JMenuItem("Buscar Usuário");
        JMenuItem listarEmpretimos = new JMenuItem("Listar Emprestimos");
        opcoesU.add(buscarUsuario);
        opcoesU.add(listarEmpretimos);

        barraMenu.add(cadastro);
        barraMenu.add(opcoes);
        barraMenu.add(opcoesU);

        // adicionado os eventos para os botoes do crud, controla os botoes principais da aplicacao
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

        buscarUsuario.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new BuscarUsuario();
            }
        });

        listarEmpretimos.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListarEmprestimos();
            }
        });


        emp.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new EmprestimoView();
            }
        });

        devolucao.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new DevolverLivroView();
            }
        });

        listar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ListarLivro();
            }
        });
    }

    private void createUIComponents() {
    }
}