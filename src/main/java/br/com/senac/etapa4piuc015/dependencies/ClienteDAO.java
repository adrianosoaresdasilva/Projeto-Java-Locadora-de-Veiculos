
package br.com.senac.etapa4piuc015.dependencies;


// Declaração da classe ClienteDAO, que estende GenericDAO e trabalha com a entidade Cliente
public class ClienteDAO extends GenericDAO<Cliente>{
    /**
 * ClienteDAO é responsável por gerenciar operações de acesso a dados (CRUD) 
 * para a entidade Cliente, utilizando a estrutura genérica de GenericDAO.
 */
    
    // Construtor da classe ClienteDAO
    public ClienteDAO() {
        
        // Chama o construtor da superclasse (GenericDAO) passando a classe Cliente como parâmetro
        super(Cliente.class);
    }
}
