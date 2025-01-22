package controller;

import model.UsuarioModel;
import repository.UsuarioRepository;
import view.MenuPrincipalView;

import java.sql.SQLException;

public class UsuarioController {
    UsuarioRepository usuarioR = new UsuarioRepository();

 /*   public void iniciaApUsuario(){
        UsuarioModel usuario = new UsuarioModel();

        MenuPrincipalView usuarioM = new MenuPrincipalView();
        usuarioM.menuPrincipal();
    }*/
    public String salvar(UsuarioModel usuario) throws SQLException {
        String retornoRepositoryUsuario = usuarioR.salvar(usuario);
        return retornoRepositoryUsuario;
    }
}
