package view;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Livro extends JFrame {
    private JPanel cadastroLivro;
    private JLabel cad;
    private JTextField titulo;
    private JTextField autor;
    private JTextField isbn;
    private JTextField quantidade;
    private JTextField tema;
    private JButton ENVIAR;
    private JFormattedTextField formattedData;

    public Livro() {
        this.setTitle("Cadastro de Livro");
        this.setContentPane(cadastroLivro);
        this.setSize(640, 480);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        ENVIAR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String texto = titulo.getText();
                JOptionPane.showInputDialog(null, texto);

                texto = autor.getText();
                JOptionPane.showInputDialog(null, texto);

                texto = isbn.getText();
                JOptionPane.showInputDialog(null, texto);

                texto = quantidade.getText();
                JOptionPane.showInputDialog(null, texto);

                texto = tema.getText();
                JOptionPane.showInputDialog(null, texto);

                texto = formattedData.getText();
                JOptionPane.showInputDialog(null, texto);
            }

        });
    }
    private void createUIComponents(){

    }
}
