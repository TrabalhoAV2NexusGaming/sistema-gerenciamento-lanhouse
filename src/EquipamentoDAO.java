package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import connection.ConexaoMySQL;
import enums.StatusEquipamento;
import model.Computador;
import model.Console;
import model.Equipamento;

/*
 * Nexus Gaming System
 *
 * Baseado no livro:
 * FURGERI, Sérgio.
 * Java 8 - Ensino Didático.
 *
 * Capítulo 12
 * JDBC
 */

public class EquipamentoDAO {

    public boolean inserir(Equipamento equipamento) {

        String sql =
                "INSERT INTO equipamentos "
                + "(nome, numero, tipo, valor_hora, status, "
                + "processador, memoria_ram, placa_video, "
                + "marca_console, geracao_console) "
                + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try (
            Connection conn = ConexaoMySQL.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setString(1, equipamento.getNome());
            stmt.setInt(2, equipamento.getNumero());

            if (equipamento instanceof Computador) {

                Computador pc =
                        (Computador) equipamento;

                stmt.setString(3, "COMPUTADOR");
                stmt.setDouble(4, pc.getValorHora());
                stmt.setString(5, pc.getStatus().name());

                stmt.setString(6, pc.getProcessador());
                stmt.setInt(7, pc.getMemoriaRAM());
                stmt.setString(8, pc.getPlacaVideo());

                stmt.setString(9, null);
                stmt.setString(10, null);

            } else {

                Console console =
                        (Console) equipamento;

                stmt.setString(3, "CONSOLE");
                stmt.setDouble(4, console.getValorHora());
                stmt.setString(5, console.getStatus().name());

                stmt.setString(6, null);
                stmt.setInt(7, 0);
                stmt.setString(8, null);

                stmt.setString(9, console.getMarca());
                stmt.setString(10, console.getGeracao());
            }

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }
    }
    
    public boolean atualizar(Equipamento equipamento) {

        String sql =
                "UPDATE equipamentos SET "
                + "nome=?, "
                + "numero=?, "
                + "tipo=?, "
                + "valor_hora=?, "
                + "status=?, "
                + "processador=?, "
                + "memoria_ram=?, "
                + "placa_video=?, "
                + "marca_console=?, "
                + "geracao_console=? "
                + "WHERE id=?";

        try (
            Connection conn =
                    ConexaoMySQL.conectar();

            PreparedStatement stmt =
                    conn.prepareStatement(sql)
        ) {

            stmt.setString(
                    1,
                    equipamento.getNome()
            );

            stmt.setInt(
                    2,
                    equipamento.getNumero()
            );

            if (equipamento instanceof Computador) {

                Computador pc =
                        (Computador) equipamento;

                stmt.setString(
                        3,
                        "COMPUTADOR"
                );

                stmt.setDouble(
                        4,
                        pc.getValorHora()
                );

                stmt.setString(
                        5,
                        pc.getStatus().name()
                );

                stmt.setString(
                        6,
                        pc.getProcessador()
                );

                stmt.setInt(
                        7,
                        pc.getMemoriaRAM()
                );

                stmt.setString(
                        8,
                        pc.getPlacaVideo()
                );

                stmt.setNull(
                        9,
                        java.sql.Types.VARCHAR
                );

                stmt.setNull(
                        10,
                        java.sql.Types.VARCHAR
                );

            } else {

                Console console =
                        (Console) equipamento;

                stmt.setString(
                        3,
                        "CONSOLE"
                );

                stmt.setDouble(
                        4,
                        console.getValorHora()
                );

                stmt.setString(
                        5,
                        console.getStatus().name()
                );

                stmt.setNull(
                        6,
                        java.sql.Types.VARCHAR
                );

                stmt.setNull(
                        7,
                        java.sql.Types.INTEGER
                );

                stmt.setNull(
                        8,
                        java.sql.Types.VARCHAR
                );

                stmt.setString(
                        9,
                        console.getMarca()
                );

                stmt.setString(
                        10,
                        console.getGeracao()
                );
            }

            stmt.setInt(
                    11,
                    equipamento.getId()
            );

            return stmt.executeUpdate() > 0;

        } catch (Exception e) {

            e.printStackTrace();
            return false;

        }
    }
    
    public boolean excluir(int id) {

        String sql =
                "DELETE FROM equipamentos "
                + "WHERE id=?";

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
    
    public Equipamento buscarPorId(int id) {

        String sql =
                "SELECT * FROM equipamentos WHERE id = ?";

        try (
            Connection conn = ConexaoMySQL.conectar();
            PreparedStatement stmt = conn.prepareStatement(sql)
        ) {

            stmt.setInt(1, id);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {

                String tipo =
                        rs.getString("tipo");

                if ("COMPUTADOR".equals(tipo)) {

                    Computador pc =
                            new Computador();

                    pc.setId(
                            rs.getInt("id")
                    );

                    pc.setNome(
                            rs.getString("nome")
                    );

                    pc.setNumero(
                            rs.getInt("numero")
                    );

                    pc.setValorHora(
                            rs.getDouble("valor_hora")
                    );

                    pc.setStatus(
                            StatusEquipamento.valueOf(
                                    rs.getString("status")
                            )
                    );

                    pc.setProcessador(
                            rs.getString("processador")
                    );

                    pc.setMemoriaRAM(
                            rs.getInt("memoria_ram")
                    );

                    pc.setPlacaVideo(
                            rs.getString("placa_video")
                    );

                    return pc;

                } else {

                    Console console =
                            new Console();

                    console.setId(
                            rs.getInt("id")
                    );

                    console.setNome(
                            rs.getString("nome")
                    );

                    console.setNumero(
                            rs.getInt("numero")
                    );

                    console.setValorHora(
                            rs.getDouble("valor_hora")
                    );

                    console.setStatus(
                            StatusEquipamento.valueOf(
                                    rs.getString("status")
                            )
                    );

                    console.setMarca(
                            rs.getString("marca_console")
                    );

                    console.setGeracao(
                            rs.getString("geracao_console")
                    );

                    return console;
                }
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return null;
    }

    public List<Equipamento> listarTodos() {

        List<Equipamento> lista =
                new ArrayList<>();

        String sql =
                "SELECT * FROM equipamentos";

        try (
            Connection conn = ConexaoMySQL.conectar();
            PreparedStatement stmt =
                    conn.prepareStatement(sql);
            ResultSet rs =
                    stmt.executeQuery()
        ) {

            while (rs.next()) {

                String tipo =
                        rs.getString("tipo");

                if ("COMPUTADOR".equals(tipo)) {

                    Computador pc =
                            new Computador();

                    pc.setId(rs.getInt("id"));
                    pc.setNome(rs.getString("nome"));
                    pc.setNumero(rs.getInt("numero"));
                    pc.setValorHora(
                            rs.getDouble("valor_hora")
                    );

                    pc.setStatus(
                            StatusEquipamento.valueOf(
                                    rs.getString("status")
                            )
                    );

                    pc.setProcessador(
                            rs.getString("processador")
                    );

                    pc.setMemoriaRAM(
                            rs.getInt("memoria_ram")
                    );

                    pc.setPlacaVideo(
                            rs.getString("placa_video")
                    );

                    lista.add(pc);

                } else {

                    Console console =
                            new Console();

                    console.setId(rs.getInt("id"));
                    console.setNome(rs.getString("nome"));
                    console.setNumero(rs.getInt("numero"));
                    console.setValorHora(
                            rs.getDouble("valor_hora")
                    );

                    console.setStatus(
                            StatusEquipamento.valueOf(
                                    rs.getString("status")
                            )
                    );

                    console.setMarca(
                            rs.getString("marca_console")
                    );

                    console.setGeracao(
                            rs.getString("geracao_console")
                    );

                    lista.add(console);
                }
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

        return lista;
    }
}
