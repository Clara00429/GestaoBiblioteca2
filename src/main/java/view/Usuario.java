package view;

import controller.UsuarioController;
import model.UsuarioModel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Usuario extends JFrame{
    private JLabel titulo;
    private JLabel nome;
    private JLabel email;
    private JLabel id;
    private JLabel celular;
    private JRadioButton femininoRadioButton;
    private JRadioButton masculinoRadioButton;
    private JButton ENVIAR;
    private JPanel cadastro;
    private UsuarioController usuarioC = new UsuarioController();


    public Usuario() {
        this.setTitle("Cadastro de Usuário");
        this.setContentPane(cadastro);
        this.setSize(640, 480);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

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
                    JOptionPane.showMessageDialog(null, usuarioC.salvar(usuario));
                }catch (SQLException ex){
                    throw new RuntimeException(ex);
                }
            }
        });
    }
    private void createUIComponents(){

    }
}