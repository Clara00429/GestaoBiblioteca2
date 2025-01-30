package controller;

import model.UsuarioModel;
import repository.UsuarioRepository;

import java.sql.SQLException;
import java.util.List;

public class UsuarioController {
    private UsuarioRepository usuarioR = new UsuarioRepository();

    public String Salvar(UsuarioModel usuario) throws SQLException {
        return usuarioR.salvarUsuario(usuario);
    }

    public List<UsuarioModel> buscarUsuarios() throws SQLException {
        return usuarioR.buscarTodosUsuarios();
    }

    public UsuarioModel buscarUsuarioPorId(Long idUsuario) throws SQLException {
        return usuarioR.buscarUsuario(idUsuario);
    }

    public String removerUsuario(Long idUsuario) throws SQLException {
        return usuarioR.removerUsuario(idUsuario);
    }
}
