package br.com.senac.etapa4piuc015.dependencies;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Classe responsável por realizar operações de banco de dados relacionadas à
 * entidade Usuário.
 *
 * Essa classe fornece um método para validar o login de um usuário no sistema.
 *
 * * @author [Adriano]
 * @version JDK 22.0
 */
public class UsuarioBD {

    /**
     * Valida o login de um usuário no sistema.
     *
     * O método verifica se o login e senha fornecidos pelo usuário correspondem
     * a um registro válido na tabela `usuario` do banco de dados.
     */

    public static Usuario validarUsuario(Usuario usuario) {
        // Criando consulta parametrizada
        String sql = "SELECT * FROM usuario WHERE login = ? AND senha = ?";
        Usuario usuarioEncontrado = null;
     
        try {
            Connection conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/locadora", "root", "*#1908Ad");
            PreparedStatement statement = conexao.prepareStatement(sql);

            // Atribuindo os valores na consulta
            statement.setString(1, usuario.getLogin());
            statement.setString(2, usuario.getSenha());
            // Executa a consulta e obtém o resultado
            ResultSet rs = statement.executeQuery();

            // Verifica se há resultado (usuário encontrado)
            while (rs.next()) {
                usuarioEncontrado = new Usuario();
                usuarioEncontrado.setId(rs.getInt("id"));
                usuarioEncontrado.setNome(rs.getString("nome"));
                usuarioEncontrado.setLogin(rs.getString("login"));
                usuarioEncontrado.setSenha(rs.getString("senha"));
                usuarioEncontrado.setTipo(rs.getString("tipo"));
            }
        } catch (SQLException ex) {
            System.out.println("Sintaxe de comando invalida");
        }

        return usuarioEncontrado;
    }
}
