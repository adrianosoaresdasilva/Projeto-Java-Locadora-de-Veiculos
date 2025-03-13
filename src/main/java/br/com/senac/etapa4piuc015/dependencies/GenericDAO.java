package br.com.senac.etapa4piuc015.dependencies;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe CadastroDAO - Responsável por gerenciar as operações de persistência
 * relacionadas à entidade Cadastro.
 */
public class GenericDAO<T> {

    private final Class<T> entidade;

    public GenericDAO(Class<T> entidade) {
        this.entidade = entidade;
    }

    public void cadastrar(T objeto) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(objeto);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public List<T> listar(String filtro) {
        EntityManager em = JPAUtil.getEntityManager();
        List<T> resultados = new ArrayList<>();

        try {
            String jpql = "SELECT c FROM Cliente c"; // Certifique-se de que "Cliente" corresponde à sua entidade

            if (filtro != null && !filtro.trim().isEmpty()) {
                jpql += " WHERE LOWER(c.nome) LIKE LOWER(:nome)";
            }

            TypedQuery<T> query = em.createQuery(jpql, entidade);

            if (filtro != null && !filtro.trim().isEmpty()) {
                query.setParameter("nome", "%" + filtro + "%");
            }

            resultados = query.getResultList();
            System.out.println("Clientes encontrados: " + resultados.size()); // Debug
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return resultados;
    }

    public List<Veiculo> listarVeiculos(String filtro) {
       EntityManager em = JPAUtil.getEntityManager();
    List<Veiculo> resultados = new ArrayList<>();

    try {
        String jpql = "SELECT v FROM Veiculo v";

        if (filtro != null && !filtro.trim().isEmpty()) {
            jpql += " WHERE LOWER(v.placa) LIKE LOWER(:filtro) OR LOWER(v.marcamodelo) LIKE LOWER(:filtro) OR LOWER(v.status) LIKE LOWER(:filtro)";
            System.out.println("JPQL: " + jpql + ", Filtro: " + filtro); // Log para verificar a consulta e o filtro
        }

        TypedQuery<Veiculo> query = em.createQuery(jpql, Veiculo.class);

        if (filtro != null && !filtro.trim().isEmpty()) {
            query.setParameter("filtro", "%" + filtro + "%");
        }

        resultados = query.getResultList();
        System.out.println("Veículos encontrados: " + resultados.size());
    } catch (Exception e) {
        e.printStackTrace();
    } finally {
        em.close();
    }
    return resultados;
}
    
    public void excluir(T objeto) {
        EntityManager em = JPAUtil.getEntityManager();
        try {
            em.getTransaction().begin();
            T entityToRemove = em.merge(objeto);  // Garante que a entidade está gerenciada
            em.remove(entityToRemove);  // Remove a entidade do banco de dados
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            e.printStackTrace();
            throw e;
        } finally {
            if (em.isOpen()) {
                em.close();
            }
        }
    }

    public T buscarPorId(Object id) {
        EntityManager em = JPAUtil.getEntityManager();
        T resultado = null;
        try {
            resultado = em.find(entidade, id);  // A função find busca o objeto pelo ID.
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return resultado;
    }
}
