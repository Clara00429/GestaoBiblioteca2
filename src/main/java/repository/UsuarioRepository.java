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
            return List.of(); // lista vazia em caso de erro no banco de dadaos
        }
    }

    public UsuarioModel buscarUsuario(Long idUsuario) {
        try {
            return entityManager.createQuery("SELECT u FROM UsuarioModel u WHERE u.idUsuario = :id", UsuarioModel.class)
                    .setParameter("id", idUsuario)
                    .getSingleResult(); // aq achou um usuario
        } catch (Exception e) {
            return null; // null se nao encontrar o usuario
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
                //por ser por click e a lista vem direto do bd ent nao eh pra entrar aq, mas precisa existir
                return "Usuário não encontrado!";
            }
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            //possiveis erros no banco de dados
            return "Erro ao remover usuário: " + e.getMessage();
        }
    }
}
