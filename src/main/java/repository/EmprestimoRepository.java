package repository;

import model.EmprestimoModel;
import model.LivroModel;
import model.UsuarioModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class EmprestimoRepository {
    private EntityManager entityManager;

    public EmprestimoRepository() {
        this.entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
        return factory.createEntityManager();
    }

    public List<EmprestimoModel> buscarTodosEmprestimos() {
        try {
            return entityManager.createQuery("SELECT e FROM EmprestimoModel e", EmprestimoModel.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
            return List.of();
        }
    }

    public EmprestimoModel buscarEmprestimo(Date dataInicio) {
        //busca emprestimo por data inicio, eh base para as outras classes de emprestimos
        try {
            return entityManager.createQuery("SELECT e FROM EmprestimoModel e WHERE e.dataInicio = :dataInicio", EmprestimoModel.class)
                    .setParameter("dataInicio", dataInicio)
                    .getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }

    public String removerEmprestimo(Date dataInicio) {
        try {
            EmprestimoModel emprestimo = buscarEmprestimo(dataInicio);
            if (emprestimo != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(emprestimo);
                entityManager.getTransaction().commit();
                return "Empréstimo removido com sucesso!";
            } else {
                return "Empréstimo não encontrado!";
            }
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            return "Erro ao remover empréstimo: " + e.getMessage();
        }
    }
    public String devolverLivro(Long emprestimoId) {
        try {
            entityManager.getTransaction().begin();

            EmprestimoModel emprestimo = entityManager.find(EmprestimoModel.class, emprestimoId);
            if (emprestimo == null) {
                return "Empréstimo não encontrado!";
            }

            // aumentando a quantidade de livros disponíveis novamente
            LivroModel livro = emprestimo.getLivro();
            livro.setQuantidade(livro.getQuantidade() + 1);
            entityManager.merge(livro);

            // removendo o emprestimo do bd
            entityManager.remove(emprestimo);
            entityManager.getTransaction().commit();

            return "Livro devolvido com sucesso!";
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            return "Erro ao devolver livro: " + e.getMessage();
        }
    }

}