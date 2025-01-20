package view;

import model.UsuarioModel;

import javax.swing.*;

public class UsuarioView {
    public UsuarioModel lerInfoUsuario(UsuarioModel usuario) {
        usuario.setNome(JOptionPane.showInputDialog("Digite o nome do usuario"));
        usuario.setEmail(JOptionPane.showInputDialog("Digite o email do usuario"));
        usuario.setIdUsuario(Integer.parseInt(JOptionPane.showInputDialog("Digite o id do usuario")));
        return usuario;
    }
}

/*
tela principal-
cadastro de usuario
editar usuario
deletar usuario

 */

