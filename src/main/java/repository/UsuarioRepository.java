package repository;

import model.UsuarioModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.List;

public class UsuarioRepository {
    private static UsuarioRepository instance;
    protected static EntityManager entityManager;

    public UsuarioRepository() {
        entityManager = getEntityManager();
    }

    public static List<UsuarioModel> buscarUsuario() {
        return List.of();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public static UsuarioRepository getInstance() {
        if (instance == null) {
            instance = new UsuarioRepository();
        }
        return instance;
    }

    public String salvar(UsuarioModel usuario) throws SQLException {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();

            return "Usuario salvo com sucesso!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static UsuarioModel buscarUsuario(Long id) throws SQLException {
        UsuarioModel usuario = new UsuarioModel();
        try {
            usuario = entityManager.find(UsuarioModel.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return usuario;
    }

    public String removerUsuario(UsuarioModel usuario)throws SQLException {
        try {
            entityManager.getTransaction().begin();
            entityManager.remove(usuario);
            entityManager.getTransaction().commit();
            return "Usuário removido com sucesso!";
        } catch (Exception e) {
            return e.getMessage();
        }

    }
}