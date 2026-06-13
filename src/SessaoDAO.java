package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoMySQL;
import model.Cliente;
import model.Equipamento;
import model.Promocao;
import model.Sessao;

/*
 * Nexus Gaming System
 *
 * Baseado no livro:
 * FURGERI, Sérgio.
 *
 * Capítulo 12
 * JDBC
 */

public class SessaoDAO {

    public boolean inserir(Sessao sessao) {

        String sql =
                "INSERT INTO sessoes "
                + "(cliente_id, equipamento_id, promocao_id, "
                + "horario_inicio, horario_fim, "
                + "tempo_contratado, valor_total, ativa) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (
            Connection conn =
                    ConexaoMySQL.conectar();

            PreparedStatement stmt =
                    conn.prepareStatement(sql)
        ) {

            stmt.setInt(
                    1,
                    sessao.getCliente().getId()
            );

            stmt.setInt(
                    2,
                    sessao.getEquipamento().getId()
            );

            if (sessao.getPromocao() != null) {

                stmt.setInt(
                        3,
                        sessao.getPromocao().getId()
                );

            } else {

                stmt.setNull(
                        3,
                        java.sql.Types.INTEGER
                );
            }

            stmt.setTimestamp(
                    4,
                    Timestamp.valueOf(
                            sessao.getHorarioInicio()
                    )
            );

            if (sessao.getHorarioFim() != null) {

                stmt.setTimestamp(
                        5,
                        Timestamp.valueOf(
                                sessao.getHorarioFim()
                        )
                );

            } else {

                stmt.setNull(
                        5,
                        java.sql.Types.TIMESTAMP
                );
            }

            stmt.setInt(
                    6,
                    sessao.getTempoContratado()
            );

            stmt.setDouble(
                    7,
                    sessao.getValorTotal()
            );

            stmt.setBoolean(
                    8,
                    sessao.isAtiva()
            );

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }
    }

    public List<Sessao> listarTodos() {

        List<Sessao> lista =
                new ArrayList<>();

        String sql =
                "SELECT * FROM sessoes";

        try (
            Connection conn =
                    ConexaoMySQL.conectar();

            PreparedStatement stmt =
                    conn.prepareStatement(sql);

            ResultSet rs =
                    stmt.executeQuery()
        ) {

            ClienteDAO clienteDAO =
                    new ClienteDAO();

            EquipamentoDAO equipamentoDAO =
                    new EquipamentoDAO();

            PromocaoDAO promocaoDAO =
                    new PromocaoDAO();

            while (rs.next()) {

                Sessao sessao =
                        new Sessao();

                sessao.setId(
                        rs.getInt("id")
                );

                Cliente cliente =
                        clienteDAO.buscarPorId(
                                rs.getInt(
                                        "cliente_id"
                                )
                        );

                sessao.setCliente(cliente);

                /*
                 * EquipamentoDAO ainda precisa
                 * do método buscarPorId()
                 */

                Equipamento equipamento =
                        equipamentoDAO.buscarPorId(
                                rs.getInt(
                                        "equipamento_id"
                                )
                        );

                sessao.setEquipamento(
                        equipamento
                );

                int promocaoId =
                        rs.getInt(
                                "promocao_id"
                        );

                if (!rs.wasNull()) {

                    Promocao promocao =
                            promocaoDAO
                                    .buscarPorId(
                                            promocaoId
                                    );

                    sessao.setPromocao(
                            promocao
                    );
                }

                sessao.setHorarioInicio(
                        rs.getTimestamp(
                                "horario_inicio"
                        ).toLocalDateTime()
                );

                if (rs.getTimestamp(
                        "horario_fim") != null) {

                    sessao.setHorarioFim(
                            rs.getTimestamp(
                                    "horario_fim"
                            ).toLocalDateTime()
                    );
                }

                sessao.setTempoContratado(
                        rs.getInt(
                                "tempo_contratado"
                        )
                );

                sessao.setValorTotal(
                        rs.getDouble(
                                "valor_total"
                        )
                );

                sessao.setAtiva(
                        rs.getBoolean(
                                "ativa"
                        )
                );

                lista.add(sessao);
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return lista;
    }

    public boolean encerrarSessao(
            int id,
            double valorFinal) {

        String sql =
                "UPDATE sessoes SET "
                + "horario_fim=?, "
                + "valor_total=?, "
                + "ativa=false "
                + "WHERE id=?";

        try (
            Connection conn =
                    ConexaoMySQL.conectar();

            PreparedStatement stmt =
                    conn.prepareStatement(sql)
        ) {

            stmt.setTimestamp(
                    1,
                    Timestamp.valueOf(
                            java.time.LocalDateTime.now()
                    )
            );

            stmt.setDouble(
                    2,
                    valorFinal
            );

            stmt.setInt(
                    3,
                    id
            );

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }
    }
}
