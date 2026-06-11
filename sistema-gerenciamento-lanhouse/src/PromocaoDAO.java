package controller;

import java.util.List;

import javax.swing.table.DefaultTableModel;

import dao.PagamentoDAO;
import model.Pagamento;
import view.TelaPagamento;

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

public class PagamentoController {

    private TelaPagamento tela;
    private PagamentoDAO dao;

    public PagamentoController(
            TelaPagamento tela) {

        this.tela = tela;
        this.dao = new PagamentoDAO();

        carregarTabela();
    }

    private void carregarTabela() {

        try {

            List<Pagamento> lista =
                    dao.listarTodos();

            DefaultTableModel modelo =
                    (DefaultTableModel)
                    tela.getTabelaPagamentos()
                    .getModel();

            modelo.setRowCount(0);

            for (Pagamento p : lista) {

                modelo.addRow(
                        new Object[] {

                                p.getId(),

                                p.getSessao() != null
                                        ? p.getSessao().getId()
                                        : "",

                                p.getValor(),

                                p.getDataPagamento(),

                                p.getTipo()
                        }
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}