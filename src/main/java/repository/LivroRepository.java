package repository;
import model.EmprestimoModel;
import model.LivroModel;
import model.UsuarioModel;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class LivroRepository {
    private static LivroRepository instance;
    protected EntityManager entityManager;

    public LivroRepository() {
        entityManager = getEntityManager();
    }

    private EntityManager getEntityManager() {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("crudHibernatePU");
        if (entityManager == null) {
            entityManager = factory.createEntityManager();
        }
        return entityManager;
    }

    public static LivroRepository getInstance() {
        if (instance == null) {
            instance = new LivroRepository();
        }
        return instance;
    }

    public String Salvar(LivroModel livro)
    {
        System.out.println(livro.getDataPublicacao());
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(livro);
            entityManager.getTransaction().commit();

            return "Livro salvo com sucesso!";
        } catch (Exception e) {
            return e.getMessage();
        }
    }
    public List<LivroModel> listarTodos() {
        try {
            List<LivroModel> livros = entityManager.createQuery("from LivroModel ").getResultList();
            return livros;
        }catch (Exception e){
            return new ArrayList<>();
        }
    }
    public String emprestarLivro(LivroModel livro, String nomeUsuario) {
        try {
            UsuarioModel usuario = entityManager.createQuery(
                            "SELECT u FROM UsuarioModel u WHERE u.nome = :nome", UsuarioModel.class)
                    .setParameter("nome", nomeUsuario)
                    .getSingleResult();

            if (usuario == null) {
                System.out.println("Usuário não encontrado!");
                return "Usuário não encontrado!";
            }

            // verificando se o usuario nao tem 5 livros ja emprestados, caso tenha ja retorna o erro tratado
            Long qtdEmprestimos = entityManager.createQuery(
                            "SELECT COUNT(e) FROM EmprestimoModel e WHERE e.usuario.id = :usuarioId", Long.class)
                    .setParameter("usuarioId", usuario.getIdUsuario())
                    .getSingleResult();

            if (qtdEmprestimos >= 5) {
                return "Usuário possui 5 emprestimos ativos!";
            }

            //os livros com quantidade igual ou menor a 0 nao aparecem na relacao de livros para emprestimos, porem o banco pode ser alterado e a tela nao atualizar
            //esse tratamento evita bugs
            if (livro.getQuantidade() <= 0) {
                System.out.println("Livro indisponível!");
                return "Livro indisponível!";
            }

            entityManager.getTransaction().begin();

            // atualiza a quantidade do livro
            livro.setQuantidade(livro.getQuantidade() - 1);
            entityManager.merge(livro);

            // cria e salva o emprestimo
            EmprestimoModel emprestimo = new EmprestimoModel();
            emprestimo.setLivro(livro);
            emprestimo.setUsuario(usuario);

            //this(System.currentTimeMillis()) metodo que pega a data do pc
            emprestimo.setDataInicio(new Date());
            //setando uma instancia de uma data
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(new Date());   //definindo a data do pc para essa instancia
            calendar.add(Calendar.DAY_OF_MONTH, 14); //salvando a data maxima para devolucao para daqui 14 dias
            emprestimo.setDataFim(calendar.getTime());      //passando a  data para o objeto

            entityManager.persist(emprestimo);

            entityManager.getTransaction().commit();
            return "Emprestimo Realizado!";
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            e.printStackTrace();
            return "Usuario nao encontrado!";
        }
    }


    public List<LivroModel> listarDisponiveis() {
        try {
            return entityManager.createQuery("from LivroModel l where l.quantidade > 0", LivroModel.class).getResultList();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
    /*public String removerLivro(Long idLivro) {
        try {
            LivroModel livro = listarTodos(idLivro);
            if (livro != null) {
                entityManager.getTransaction().begin();
                entityManager.remove(livro);
                entityManager.getTransaction().commit();
                return "Livro removido com sucesso!";
            } else {
                //por ser por click e a lista vem direto do bd ent nao eh pra entrar aq, mas precisa existir
                return "Livro não encontrado!";
            }
        } catch (Exception e) {
            entityManager.getTransaction().rollback();
            //possiveis erros no banco de dados
            return "Erro ao remover livro: " + e.getMessage();
        }
    }*/

}
