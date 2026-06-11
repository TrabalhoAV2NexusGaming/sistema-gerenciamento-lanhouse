package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoMySQL;
import model.Cliente;

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
 * - Connection
 * - PreparedStatement
 * - ResultSet
 * - CRUD
 */

public class ClienteDAO {

    /**
     * Insere um cliente no banco.
     */
    public boolean inserir(Cliente cliente) {

        String sql =
                "INSERT INTO clientes "
                + "(nome, cpf, telefone, nickname, pontos, saldo_horas) "
                + "VALUES (?, ?, ?, ?, ?, ?)";

        try (
            Connection conn = ConexaoMySQL.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getNickname());
            stmt.setInt(5, cliente.getPontos());
            stmt.setDouble(6, cliente.getSaldoHoras());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }
    }

    /**
     * Atualiza um cliente existente.
     */
    public boolean atualizar(Cliente cliente) {

        String sql =
                "UPDATE clientes SET "
                + "nome = ?, "
                + "cpf = ?, "
                + "telefone = ?, "
                + "nickname = ?, "
                + "pontos = ?, "
                + "saldo_horas = ? "
                + "WHERE id = ?";

        try (
            Connection conn = ConexaoMySQL.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getCpf());
            stmt.setString(3, cliente.getTelefone());
            stmt.setString(4, cliente.getNickname());
            stmt.setInt(5, cliente.getPontos());
            stmt.setDouble(6, cliente.getSaldoHoras());

            stmt.setInt(7, cliente.getId());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }
    }

    /**
     * Remove cliente pelo ID.
     */
    public boolean excluir(int id) {

        String sql =
                "DELETE FROM clientes WHERE id = ?";

        try (
            Connection conn = ConexaoMySQL.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, id);

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }
    }

    /**
     * Busca cliente pelo ID.
     */
    public Cliente buscarPorId(int id) {

        String sql =
                "SELECT * FROM clientes WHERE id = ?";

        try (
            Connection conn = ConexaoMySQL.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Cliente cliente = new Cliente();

                cliente.setId(
                        rs.getInt("id"));

                cliente.setNome(
                        rs.getString("nome"));

                cliente.setCpf(
                        rs.getString("cpf"));

                cliente.setTelefone(
                        rs.getString("telefone"));

                cliente.setNickname(
                        rs.getString("nickname"));

                cliente.setPontos(
                        rs.getInt("pontos"));

                cliente.setSaldoHoras(
                        rs.getDouble("saldo_horas"));

                return cliente;
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;
    }

    /**
     * Retorna todos os clientes cadastrados.
     */
    public List<Cliente> listarTodos() {

        List<Cliente> lista =
                new ArrayList<>();

        String sql =
                "SELECT * FROM clientes";

        try (
            Connection conn = ConexaoMySQL.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ) {

            while (rs.next()) {

                Cliente cliente =
                        new Cliente();

                cliente.setId(
                        rs.getInt("id"));

                cliente.setNome(
                        rs.getString("nome"));

                cliente.setCpf(
                        rs.getString("cpf"));

                cliente.setTelefone(
                        rs.getString("telefone"));

                cliente.setNickname(
                        rs.getString("nickname"));

                cliente.setPontos(
                        rs.getInt("pontos"));

                cliente.setSaldoHoras(
                        rs.getDouble("saldo_horas"));

                lista.add(cliente);
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return lista;
    }

}