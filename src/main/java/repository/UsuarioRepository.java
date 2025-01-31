package repository;

import model.UsuarioModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class UsuarioRepository {
    private EntityManager entityManager;

    public UsuarioRepository() {
        this.entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
        return factory.createEntityManager();
    }

    public String salvarUsuario(UsuarioModel usuario) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(usuario);
            entityManager.getTransaction().commit();
            return "Usuário salvo com sucesso!";
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            return "Erro ao salvar usuário: " + e.getMessage();
        }
    }

    public List<UsuarioModel> buscarTodosUsuarios() {
        try {
            return entityManager.createQuery("SELECT u FROM UsuarioModel u", UsuarioModel.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public UsuarioModel buscarUsuario(Long idUsuario) {
        try {
            return entityManager.createQuery("SELECT u FROM UsuarioModel u WHERE u.idUsuario = :id", UsuarioModel.class)
                    .setParameter("id", idUsuario)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public String removerUsuario(Long idUsuario) {
        try {
            UsuarioModel usuario = buscarUsuario(idUsuario);
            if (usuario != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(usuario);
                entityManager.getTransaction().commit();
                return "Usuário removido com sucesso!";
            } else {
                return "Usuário não encontrado!";
            }
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            return "Erro ao remover usuário: " + e.getMessage();
        }
    }
}
