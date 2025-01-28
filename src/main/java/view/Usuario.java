package view;

import controller.UsuarioController;
import model.UsuarioModel;

import javax.swing.*;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

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
    private JTextField celular;
    private JButton buscarButton;
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



    }
    private void createUIComponents(){

    }
}