package controller;

import model.LivroModel;
import model.UsuarioModel;
import repository.UsuarioRepository;
import view.TelaPrincipal;

import java.sql.SQLException;
import java.util.List;

public class UsuarioController {
    UsuarioRepository usuarioR = new UsuarioRepository();

 /*   public void iniciaApUsuario(){
        UsuarioModel usuario = new UsuarioModel();

        TelaPrincipal usuarioM = new TelaPrincipal();
        usuarioM.criarMenu();
    }*/
 public String Salvar(UsuarioModel usuario) throws SQLException
 {
     return usuarioR.Salvar(usuario);
 }

    public List<UsuarioModel> buscarUsuario () throws SQLException {
        return UsuarioRepository.buscarUsuario();
    }
   public static String removerUsuario(Long idUsuario) throws SQLException {
       UsuarioModel usuario = UsuarioRepository.buscarUsuario(idUsuario);
       return UsuarioRepository.getInstance().removerUsuario(usuario);
   }

}
