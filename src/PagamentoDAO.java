package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoMySQL;
import enums.TipoPagamento;
import model.Pagamento;
import model.Sessao;

/*
 * Nexus Gaming System
 *
 * Baseado no livro:
 * FURGERI, Sérgio.
 *
 * Capítulo 12
 * JDBC - Persistência de Dados
 */

public class PagamentoDAO {

    public boolean inserir(Pagamento pagamento) {

        String sql =
                "INSERT INTO pagamentos "
                + "(sessao_id, valor, data_pagamento, tipo_pagamento) "
                + "VALUES (?, ?, ?, ?)";

        try (
            Connection conn =
                    ConexaoMySQL.conectar();

            PreparedStatement stmt =
                    conn.prepareStatement(sql)
        ) {

            stmt.setInt(
                    1,
                    pagamento.getSessao().getId()
            );

            stmt.setDouble(
                    2,
                    pagamento.getValor()
            );

            stmt.setDate(
                    3,
                    java.sql.Date.valueOf(
                            pagamento.getDataPagamento()
                    )
            );

            stmt.setString(
                    4,
                    pagamento.getTipo().name()
            );

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    public List<Pagamento> listarTodos() {

        List<Pagamento> lista =
                new ArrayList<>();

        String sql =
                "SELECT * FROM pagamentos";

        try (
            Connection conn =
                    ConexaoMySQL.conectar();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    stmt.executeQuery()
        ) {

            while (rs.next()) {

                Pagamento pagamento =
                        new Pagamento();

                Sessao sessao =
                        new Sessao();

                sessao.setId(
                        rs.getInt("sessao_id")
                );

                pagamento.setId(
                        rs.getInt("id")
                );

                pagamento.setSessao(
                        sessao
                );

                pagamento.setValor(
                        rs.getDouble("valor")
                );

                pagamento.setDataPagamento(
                        rs.getDate(
                                "data_pagamento"
                        ).toLocalDate()
                );

                pagamento.setTipo(
                        TipoPagamento.valueOf(
                                rs.getString(
                                        "tipo_pagamento"
                                )
                        )
                );

                lista.add(
                        pagamento
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return lista;
    }

    public Pagamento buscarPorId(int id) {

        String sql =
                "SELECT * FROM pagamentos "
                + "WHERE id = ?";

        try (
            Connection conn =
                    ConexaoMySQL.conectar();

            PreparedStatement stmt =
                    conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, id);

            ResultSet rs =
                    stmt.executeQuery();

            if (rs.next()) {

                Pagamento pagamento =
                        new Pagamento();

                Sessao sessao =
                        new Sessao();

                sessao.setId(
                        rs.getInt("sessao_id")
                );

                pagamento.setId(
                        rs.getInt("id")
                );

                pagamento.setSessao(
                        sessao
                );

                pagamento.setValor(
                        rs.getDouble("valor")
                );

                pagamento.setDataPagamento(
                        rs.getDate(
                                "data_pagamento"
                        ).toLocalDate()
                );

                pagamento.setTipo(
                        TipoPagamento.valueOf(
                                rs.getString(
                                        "tipo_pagamento"
                                )
                        )
                );

                return pagamento;
            }

        } catch (Exception e) {

            e.printStackTrace();
        }

        return null;
    }

    public boolean atualizar(Pagamento pagamento) {

        String sql =
                "UPDATE pagamentos SET "
                + "sessao_id=?, "
                + "valor=?, "
                + "data_pagamento=?, "
                + "tipo_pagamento=? "
                + "WHERE id=?";

        try (
            Connection conn =
                    ConexaoMySQL.conectar();

            PreparedStatement stmt =
                    conn.prepareStatement(sql)
        ) {

            stmt.setInt(
                    1,
                    pagamento.getSessao().getId()
            );

            stmt.setDouble(
                    2,
                    pagamento.getValor()
            );

            stmt.setDate(
                    3,
                    java.sql.Date.valueOf(
                            pagamento.getDataPagamento()
                    )
            );

            stmt.setString(
                    4,
                    pagamento.getTipo().name()
            );

            stmt.setInt(
                    5,
                    pagamento.getId()
            );

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }

    public boolean excluir(int id) {

        String sql =
                "DELETE FROM pagamentos "
                + "WHERE id = ?";

        try (
            Connection conn =
                    ConexaoMySQL.conectar();

            PreparedStatement stmt =
                    conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, id);

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;
        }
    }
}
