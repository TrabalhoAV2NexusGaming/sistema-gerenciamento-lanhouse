package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoMySQL;
import enums.CargoFuncionario;
import model.Funcionario;

/*
 * Baseado no livro:
 * FURGERI, Sérgio.
 *
 * Capítulo 12 - Manipulação de Banco de Dados com Java
 */

public class FuncionarioDAO {

    public boolean inserir(Funcionario funcionario) {

        String sql =
                "INSERT INTO funcionarios "
                + "(nome, usuario, senha, cargo) "
                + "VALUES (?, ?, ?, ?)";

        try (
            Connection conn = ConexaoMySQL.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getUsuario());
            stmt.setString(3, funcionario.getSenha());
            stmt.setString(4, funcionario.getCargo().name());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Funcionario buscarPorId(int id) {

        String sql = "SELECT * FROM funcionarios WHERE id = ?";

        try (
            Connection conn = ConexaoMySQL.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Funcionario funcionario = new Funcionario();

                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setUsuario(rs.getString("usuario"));
                funcionario.setSenha(rs.getString("senha"));

                funcionario.setCargo(
                        CargoFuncionario.valueOf(
                                rs.getString("cargo"))
                );

                return funcionario;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Funcionario> listarTodos() {

        List<Funcionario> lista = new ArrayList<>();

        String sql = "SELECT * FROM funcionarios";

        try (
            Connection conn = ConexaoMySQL.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ) {

            while (rs.next()) {

                Funcionario funcionario = new Funcionario();

                funcionario.setId(rs.getInt("id"));
                funcionario.setNome(rs.getString("nome"));
                funcionario.setUsuario(rs.getString("usuario"));
                funcionario.setSenha(rs.getString("senha"));

                funcionario.setCargo(
                        CargoFuncionario.valueOf(
                                rs.getString("cargo"))
                );

                lista.add(funcionario);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean atualizar(Funcionario funcionario) {

        String sql =
                "UPDATE funcionarios SET "
                + "nome=?, usuario=?, senha=?, cargo=? "
                + "WHERE id=?";

        try (
            Connection conn = ConexaoMySQL.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, funcionario.getNome());
            stmt.setString(2, funcionario.getUsuario());
            stmt.setString(3, funcionario.getSenha());
            stmt.setString(4, funcionario.getCargo().name());
            stmt.setInt(5, funcionario.getId());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(int id) {

        String sql =
                "DELETE FROM funcionarios WHERE id=?";

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
}
