package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.ClienteDAO;
import dao.EquipamentoDAO;
import dao.PromocaoDAO;
import dao.SessaoDAO;

import model.Cliente;
import model.Equipamento;
import model.Promocao;
import model.Sessao;

import view.TelaSessao;

/*
 * Nexus Gaming System
 *
 * Baseado no livro:
 * FURGERI, Sérgio.
 *
 * Capítulo 9
 * Eventos e ActionListener
 */

public class SessaoController {

    private TelaSessao tela;

    private SessaoDAO sessaoDAO;
    private ClienteDAO clienteDAO;
    private EquipamentoDAO equipamentoDAO;
    private PromocaoDAO promocaoDAO;

    private List<Cliente> clientes;
    private List<Equipamento> equipamentos;
    private List<Promocao> promocoes;

    public SessaoController(TelaSessao tela) {

        this.tela = tela;

        sessaoDAO = new SessaoDAO();
        clienteDAO = new ClienteDAO();
        equipamentoDAO = new EquipamentoDAO();
        promocaoDAO = new PromocaoDAO();

        carregarCombos();
        carregarTabela();
        configurarEventos();
    }

    private void configurarEventos() {

        tela.getBtnIniciarSessao()
                .addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        iniciarSessao();
                    }
                });

        tela.getBtnEncerrarSessao()
                .addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        encerrarSessao();
                    }
                });

        tela.getBtnAtualizar()
                .addActionListener(new ActionListener() {

                    @Override
                    public void actionPerformed(ActionEvent e) {

                        carregarTabela();
                    }
                });
    }

    private void carregarCombos() {

        try {

            clientes = clienteDAO.listarTodos();
            equipamentos = equipamentoDAO.listarTodos();
            promocoes = promocaoDAO.listarTodos();

            tela.getCbCliente().removeAllItems();
            tela.getCbEquipamento().removeAllItems();
            tela.getCbPromocao().removeAllItems();

            for (Cliente c : clientes) {

                tela.getCbCliente()
                        .addItem(c.getNome());
            }

            for (Equipamento e : equipamentos) {

                tela.getCbEquipamento()
                        .addItem(
                                e.getNome()
                                + " #" + e.getNumero()
                        );
            }

            tela.getCbPromocao()
                    .addItem("Sem Promoção");

            for (Promocao p : promocoes) {

                tela.getCbPromocao()
                        .addItem(p.getNome());
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    tela,
                    e.getMessage()
            );
        }
    }

    private void iniciarSessao() {

        try {

            int indiceCliente =
                    tela.getCbCliente()
                            .getSelectedIndex();

            int indiceEquipamento =
                    tela.getCbEquipamento()
                            .getSelectedIndex();

            Cliente cliente =
                    clientes.get(indiceCliente);

            Equipamento equipamento =
                    equipamentos.get(indiceEquipamento);

            Promocao promocao = null;

            int indicePromo =
                    tela.getCbPromocao()
                            .getSelectedIndex();

            if (indicePromo > 0) {

                promocao =
                        promocoes.get(
                                indicePromo - 1
                        );
            }

            Sessao sessao =
                    new Sessao();

            sessao.setCliente(cliente);

            sessao.setEquipamento(
                    equipamento
            );

            sessao.setPromocao(
                    promocao
            );

            sessao.setHorarioInicio(
                    LocalDateTime.now()
            );

            sessao.setTempoContratado(
                    Integer.parseInt(
                            tela
                            .getTxtTempoContratado()
                            .getText()
                    )
            );

            sessao.setValorTotal(0);

            sessao.setAtiva(true);

            boolean sucesso =
                    sessaoDAO.inserir(
                            sessao
                    );

            if (sucesso) {

                JOptionPane.showMessageDialog(
                        tela,
                        "Sessão iniciada!"
                );

                carregarTabela();

            } else {

                JOptionPane.showMessageDialog(
                        tela,
                        "Erro ao iniciar sessão."
                );
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    tela,
                    e.getMessage()
            );
        }
    }

    private void encerrarSessao() {

        int linha =
                tela.getTabelaSessoes()
                        .getSelectedRow();

        if (linha < 0) {

            JOptionPane.showMessageDialog(
                    tela,
                    "Selecione uma sessão."
            );

            return;
        }

        int id =
                Integer.parseInt(
                        tela.getTabelaSessoes()
                                .getValueAt(
                                        linha,
                                        0
                                )
                                .toString()
                );

        boolean sucesso =
                sessaoDAO.encerrarSessao(
                        id,
                        0
                );

        if (sucesso) {

            JOptionPane.showMessageDialog(
                    tela,
                    "Sessão encerrada!"
            );

            carregarTabela();
        }
    }

    private void carregarTabela() {

        try {

            List<Sessao> lista =
                    sessaoDAO.listarTodos();

            DefaultTableModel modelo =
                    (DefaultTableModel)
                    tela.getTabelaSessoes()
                            .getModel();

            modelo.setRowCount(0);

            for (Sessao s : lista) {

                modelo.addRow(
                        new Object[] {

                            s.getId(),

                            s.getCliente()
                             .getNome(),

                            s.getEquipamento()
                             .getNome(),

                            s.getPromocao() != null
                                    ? s.getPromocao()
                                       .getNome()
                                    : "-",

                            s.getHorarioInicio(),

                            s.getHorarioFim(),

                            s.getTempoContratado(),

                            s.getValorTotal(),

                            s.isAtiva()
                        }
                );
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    tela,
                    e.getMessage()
            );
        }
    }
}