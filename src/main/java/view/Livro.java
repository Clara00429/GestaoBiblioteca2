package view;

import model.LivroModel;

import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

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
                LivroModel livro = new LivroModel();
                livro.setTitulo(titulo.getText());
                livro.setAutor(autor.getText());
                livro.setIsbn(Integer.parseInt(isbn.getText()));
                livro.setQuantidade(Integer.parseInt(quantidade.getText()));
                livro.setTema(tema.getText());

                try {
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                    LocalDate data = LocalDate.parse(formattedData.getText(), formatter);
                    livro.setDataPublicacao(data);
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Data inválida! Use o formato dd/MM/yyyy.");
                    return;
                }
            }

        });
    }
    private void createUIComponents(){
        try {
            MaskFormatter maskFormatter = new MaskFormatter("##/##/####");
            maskFormatter.setPlaceholderCharacter('_');
            formattedData = new JFormattedTextField(maskFormatter);
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }
}
