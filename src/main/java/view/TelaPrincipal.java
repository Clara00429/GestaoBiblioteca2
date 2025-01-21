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
        JMenu opcoes =new JMenu("Opções");
        JMenuItem emp = new JMenuItem("Fazer Empréstimo");
        JMenuItem devolucao = new JMenuItem("Fazer Devolução");
        JMenuItem listar = new JMenuItem("Listar Livros");
        opcoes.add(emp);
        opcoes.add(devolucao);
        opcoes.add(listar);
        barraMenu.add(cadastro);
        barraMenu.add(opcoes);
        cadastro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                  //String texto = .getText();
                  //JOptionPane.showMessageDialog(null,texto);
                new Livro();
            }
        });
    }
    private void createUIComponents() {

    }

}
