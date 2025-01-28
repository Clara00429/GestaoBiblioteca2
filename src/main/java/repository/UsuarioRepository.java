package repository;

import model.LivroModel;
import model.UsuarioModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.ArrayList;
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

    public String Salvar(UsuarioModel usuario) throws SQLException
    {

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();

            return "Usuário salvo com sucesso!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public static List<UsuarioModel>buscarUsuario(Long idUsuario) {

        try {
            List<UsuarioModel> usuarios = entityManager.createQuery("from UsuarioModel ,UsuarioModel.class").getResultList();
            return usuarios;
        }catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
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