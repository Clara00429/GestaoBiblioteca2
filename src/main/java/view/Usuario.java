package view;

import controller.UsuarioController;
import model.UsuarioModel;

import javax.swing.*;
import javax.swing.table.TableModel;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Usuario extends JFrame{
    private JTable tabela;
    private JLabel titulo;
    private JTextField nome;
    private JLabel emailLabel;
    private JLabel celularLabel;
    private JRadioButton femininoRadioButton;
    private JRadioButton masculinoRadioButton;
    private JButton ENVIAR;
    private JButton Remover;
    private JPanel cadastro;
    private JLabel nomeLabel;
    private JTextField email;
    private JFormattedTextField celular;
    private JButton buscarButton;
    private UsuarioController usuarioC = new UsuarioController();


    public Usuario() {
        this.setTitle("Cadastro de Usuário");
        this.setContentPane(cadastro);
        this.setSize(640, 480);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);


        try {
            MaskFormatter cel = null;

            cel = new MaskFormatter("(##)#####-####");

            cel.setPlaceholderCharacter('_');

            celular.setFormatterFactory(new DefaultFormatterFactory(cel));
        }
        catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Formato de celular inválido, use o formato (##)#####-####");
            return;
        }

        email.setText("usuario@email.com");
        email.setForeground(java.awt.Color.GRAY);

        email.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusGained(java.awt.event.FocusEvent e) {
                if (email.getText().equals("usuario@email.com")) {
                    email.setText("");
                    email.setForeground(java.awt.Color.BLACK);
                }
            }
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                if (email.getText().isEmpty()) {
                    email.setForeground(java.awt.Color.GRAY);
                    email.setText("usuario@email.com");
                }
            }
        });

        //para permitir que não selecione os dois ao mesmo tempo
        ButtonGroup sexoGroup = new ButtonGroup();
        sexoGroup.add(femininoRadioButton);
        sexoGroup.add(masculinoRadioButton);

        ENVIAR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sexo = "masculino";
                if (femininoRadioButton.isSelected()){
                    sexo = "feminino";
                }

                String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
                Pattern pattern = Pattern.compile(emailRegex);
                Matcher matcher = pattern.matcher(email.getText());

                if (!matcher.matches()) {
                    JOptionPane.showMessageDialog(null, "E-mail inválido. Por favor, insira um e-mail válido.");
                    return;
                }

                UsuarioModel usuario = new UsuarioModel();
                usuario.setNome(nome.getText());
                usuario.setEmail(email.getText());
                usuario.setNum_celular(celular.getText());
                usuario.setSexo(sexo);

                try{
                    JOptionPane.showMessageDialog(null, usuarioC.Salvar(usuario));

                }catch (Exception ex)
                {
                    throw new RuntimeException(ex);
                }
            }
        });



    }
    private void createUIComponents(){

    }
}