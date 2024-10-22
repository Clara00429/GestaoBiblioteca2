import controller.LivroController;
import controller.UsuarioController;
import repository.LivroRepository;
import repository.UsuarioRepository;

public class Main {
    public static void main(String[] args) {
        LivroRepository livroRepository = new LivroRepository();
        LivroController livroController = new LivroController();
        livroController.iniciaApLivro();

        UsuarioRepository usuarioRepository = new UsuarioRepository();
        UsuarioController usuarioController = new UsuarioController();
        usuarioController.iniciaApUsuario();
    }

}