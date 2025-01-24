package controller;

import model.UsuarioModel;
import repository.UsuarioRepository;
import view.TelaPrincipal;

import java.sql.SQLException;
import java.util.List;

public class UsuarioController {
    UsuarioRepository usuarioR = new UsuarioRepository();

    public void iniciaApUsuario(){
        UsuarioModel usuario = new UsuarioModel();

        TelaPrincipal usuarioM = new TelaPrincipal();
        usuarioM.criarMenu();
    }
    public String salvar(UsuarioModel usuario) throws SQLException {
        String retornoRepositoryUsuario = usuarioR.salvar(usuario);
        return retornoRepositoryUsuario;
    }

    public List<UsuarioModel> buscarUsuario () throws SQLException {
        return UsuarioRepository.buscarUsuario();
    }


}
