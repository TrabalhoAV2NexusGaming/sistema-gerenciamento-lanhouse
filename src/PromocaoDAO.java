package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoMySQL;
import model.Promocao;

/*
 * Baseado no livro:
 * FURGERI, Sérgio.
 *
 * Capítulo 12 - JDBC
 */

public class PromocaoDAO {

    public boolean inserir(Promocao promocao) {

        String sql =
                "INSERT INTO promocoes "
                + "(nome, horario_inicio, horario_fim, valor_fixo) "
                + "VALUES (?, ?, ?, ?)";

        try (
            Connection conn = ConexaoMySQL.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, promocao.getNome());

            stmt.setTime(
                    2,
                    java.sql.Time.valueOf(
                            promocao.getHorarioInicio()
                    )
            );

            stmt.setTime(
                    3,
                    java.sql.Time.valueOf(
                            promocao.getHorarioFim()
                    )
            );

            stmt.setDouble(4, promocao.getValorFixo());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }
    }

    public Promocao buscarPorId(int id) {

        String sql =
                "SELECT * FROM promocoes WHERE id=?";

        try (
            Connection conn = ConexaoMySQL.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                Promocao promocao = new Promocao();

                promocao.setId(rs.getInt("id"));
                promocao.setNome(rs.getString("nome"));

                promocao.setHorarioInicio(
                        rs.getTime("horario_inicio")
                                .toLocalTime()
                );

                promocao.setHorarioFim(
                        rs.getTime("horario_fim")
                                .toLocalTime()
                );

                promocao.setValorFixo(
                        rs.getDouble("valor_fixo")
                );

                return promocao;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Promocao> listarTodos() {

        List<Promocao> lista = new ArrayList<>();

        String sql = "SELECT * FROM promocoes";

        try (
            Connection conn = ConexaoMySQL.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery()
        ) {

            while (rs.next()) {

                Promocao promocao = new Promocao();

                promocao.setId(rs.getInt("id"));
                promocao.setNome(rs.getString("nome"));

                promocao.setHorarioInicio(
                        rs.getTime("horario_inicio")
                                .toLocalTime()
                );

                promocao.setHorarioFim(
                        rs.getTime("horario_fim")
                                .toLocalTime()
                );

                promocao.setValorFixo(
                        rs.getDouble("valor_fixo")
                );

                lista.add(promocao);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return lista;
    }

    public boolean atualizar(Promocao promocao) {

        String sql =
                "UPDATE promocoes SET "
                + "nome=?, horario_inicio=?, horario_fim=?, valor_fixo=? "
                + "WHERE id=?";

        try (
            Connection conn = ConexaoMySQL.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, promocao.getNome());

            stmt.setTime(
                    2,
                    java.sql.Time.valueOf(
                            promocao.getHorarioInicio()
                    )
            );

            stmt.setTime(
                    3,
                    java.sql.Time.valueOf(
                            promocao.getHorarioFim()
                    )
            );

            stmt.setDouble(4, promocao.getValorFixo());

            stmt.setInt(5, promocao.getId());

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(int id) {

        String sql =
                "DELETE FROM promocoes WHERE id=?";

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
