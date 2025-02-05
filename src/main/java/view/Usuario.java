package view;

import controller.UsuarioController;
import model.UsuarioModel;

import javax.swing.*;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private JFormattedTextField celular;
    private JTextField email;
    private JButton botaoVoltar;
    private UsuarioController usuarioC = new UsuarioController();


    public Usuario() {
        this.setTitle("Cadastro de Usuário");
        this.setContentPane(cadastro);
        this.setSize(640, 480);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setVisible(true);

        //para permitir que não selecione os dois ao mesmo tempo
        ButtonGroup sexoGroup = new ButtonGroup();
        sexoGroup.add(femininoRadioButton);
        sexoGroup.add(masculinoRadioButton);

        try{
            MaskFormatter mask = null;

            mask = new MaskFormatter("(##) #####-####");

            mask.setPlaceholderCharacter('_');

            celular.setFormatterFactory(new DefaultFormatterFactory(mask));
        }catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Formato inválido! Use o formato (##) ####-####.");
            return; 
        }

        ENVIAR.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String sexo = "masculino";
                if (femininoRadioButton.isSelected()){
                    sexo = "feminino";
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

        botaoVoltar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });



    }
    private void createUIComponents(){

    }
}