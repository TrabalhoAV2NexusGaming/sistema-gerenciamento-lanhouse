package connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Nexus Gaming System
 *
 * Baseado no livro:
 * FURGERI, Sérgio.
 * Java 8 - Ensino Didático: Desenvolvimento e Implementação de Aplicações.
 *
 * Capítulo 12 - Manipulação de Banco de Dados com Java
 *
 * Conceitos utilizados:
 * - Driver JDBC
 * - DriverManager
 * - Connection
 * - SQLException
 *
 * Esta classe centraliza a conexão com o banco MySQL
 * para utilização pelos DAOs do sistema.
 */

public class ConexaoMySQL {

    // Ajustar conforme o ambiente utilizado
    private static final String URL =
            "jdbc:mysql://localhost:3306/nexus_gaming_system";

    private static final String USUARIO =
            "root";

    private static final String SENHA =
            "";

    /**
     * Retorna uma conexão ativa com o banco.
     *
     * @return Connection
     * @throws SQLException
     */
    public static Connection conectar() throws SQLException {

        return DriverManager.getConnection(
                URL,
                USUARIO,
                SENHA
        );
    }

}
