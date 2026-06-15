package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalTime;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.PromocaoDAO;
import model.Promocao;
import view.TelaPromocao;

/*
 * Baseado no livro:
 * FURGERI, Sérgio.
 *
 * Capítulo 9
 * Eventos Swing
 *
 * Capítulo 12
 * JDBC
 */

public class PromocaoController {

    private TelaPromocao tela;
    private PromocaoDAO dao;

    public PromocaoController(TelaPromocao tela) {

        this.tela = tela;
        this.dao = new PromocaoDAO();

        configurarEventos();
        carregarTabela();
    }

    private void configurarEventos() {

        tela.getBtnCadastrar().addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                cadastrarPromocao();
            }
        });

        tela.getBtnAtualizar().addActionListener(
                e -> carregarTabela()
        );
    }

    private void cadastrarPromocao() {

        try {

            Promocao promocao =
                    new Promocao();

            promocao.setNome(
                    tela.getTxtNome().getText()
            );

            promocao.setHorarioInicio(
                    LocalTime.parse(
                            tela.getTxtHorarioInicio()
                            .getText()
                    )
            );

            promocao.setHorarioFim(
                    LocalTime.parse(
                            tela.getTxtHorarioFim()
                            .getText()
                    )
            );

            promocao.setValorFixo(
                    Double.parseDouble(
                            tela.getTxtValorFixo()
                            .getText()
                    )
            );

            dao.inserir(promocao);

            JOptionPane.showMessageDialog(
                    tela,
                    "Promoção cadastrada!"
            );

            carregarTabela();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    tela,
                    e.getMessage()
            );
        }
    }

    private void carregarTabela() {

        try {

            List<Promocao> lista =
                    dao.listarTodos();

            DefaultTableModel modelo =
                    (DefaultTableModel)
                    tela.getTabelaPromocoes()
                    .getModel();

            modelo.setRowCount(0);

            for (Promocao p : lista) {

                modelo.addRow(
                        new Object[] {

                                p.getId(),
                                p.getNome(),
                                p.getHorarioInicio(),
                                p.getHorarioFim(),
                                p.getValorFixo()
                        }
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}