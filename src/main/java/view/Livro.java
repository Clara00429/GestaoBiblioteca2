package view;

import controller.LivroController;
import model.LivroModel;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
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
    private JFormattedTextField formattedTextFieldData;
    private LivroController livroController = new LivroController();

    public Livro() {
        this.setTitle("Cadastro de Livro");
        this.setContentPane(cadastroLivro);
        this.setSize(640, 480);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        try {
            MaskFormatter datatipo = null;

            datatipo = new MaskFormatter("##/##/####");

            datatipo.setPlaceholderCharacter('_');

            formattedTextFieldData.setFormatterFactory(new DefaultFormatterFactory(datatipo));
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data inválida! Use o formato dd/MM/yyyy.");
            return;
        }

        ENVIAR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                LivroModel livro = new LivroModel();
                livro.setTitulo(titulo.getText());
                livro.setAutor(autor.getText());
                livro.setIsbn(Integer.parseInt(isbn.getText()));
                livro.setQuantidade(Integer.parseInt(quantidade.getText()));
                livro.setTema(tema.getText());
                livro.setDataPublicacao(formattedTextFieldData.getText());
                try{
                    JOptionPane.showMessageDialog(null, livroController.Salvar(livro));

                }catch (Exception ex)
                {
                  throw new RuntimeException(ex);
                }

            }

        });
    }

}
