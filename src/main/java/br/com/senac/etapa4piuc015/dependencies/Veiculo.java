package br.com.senac.etapa4piuc015.dependencies;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Representa um cadastro de podcast no sistema.
 *
 * Essa classe mapeia a entidade `Cadastro` para a persistência de dados em um
 * banco de dados relacional utilizando o JPA (Java Persistence API).
 *
 * * @author [Adriano]
 * @version JDK 22.0
 */

@Entity
@Table(name = "veiculos")  // Certifique-se de que o nome da tabela corresponde ao seu banco de dados
public class Veiculo {

     @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String placa;
    private String ano;
    private String marcamodelo;
    private String cor;
    private double valordiaria;
    private String status;

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getMarcamodelo() {
        return marcamodelo;
    }

    public void setMarcamodelo(String marcamodelo) {
        this.marcamodelo = marcamodelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public double getValordiaria() {
        return valordiaria;
    }

    public void setValordiaria(double valordiaria) {
        this.valordiaria = valordiaria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
