package controller;

import model.UsuarioModel;
import repository.UsuarioRepository;
import view.MenuPrincipalView;

public class UsuarioController {
    UsuarioRepository usuarioR = new UsuarioRepository();

    public void iniciaApUsuario(){
        UsuarioModel usuario = new UsuarioModel();

        MenuPrincipalView usuarioM = new MenuPrincipalView();
        usuarioM.menuPrincipal();
    }
    public String salvarUsuario(UsuarioModel usuario){
        String retornoRepositoryUsuario = usuarioR.salvarUsuario(usuario);
        return retornoRepositoryUsuario;
    }
}
