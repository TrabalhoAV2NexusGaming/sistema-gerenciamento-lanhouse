package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

/*
 * Nexus Gaming System
 *
 * Baseado no livro:
 * FURGERI, Sérgio.
 *
 * Capítulo 8
 * Interfaces gráficas com Swing
 */

public class TelaPagamento extends JFrame {

    private JTextField txtValor;

    private JComboBox<String> cbTipoPagamento;

    private JButton btnRegistrar;
    private JButton btnAtualizar;

    private JTable tabelaPagamentos;

    public TelaPagamento() {

        setTitle("Pagamentos");

        setSize(900, 600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE);

        inicializarComponentes();
    }

    private void inicializarComponentes() {

        JPanel formulario =
                new JPanel(
                        new GridLayout(2,2,10,10));

        formulario.add(
                new JLabel("Valor:")
        );

        txtValor =
                new JTextField();

        formulario.add(
                txtValor
        );

        formulario.add(
                new JLabel("Tipo:")
        );

        cbTipoPagamento =
                new JComboBox<>();

        cbTipoPagamento.addItem("PIX");
        cbTipoPagamento.addItem("DINHEIRO");
        cbTipoPagamento.addItem("CARTAO");

        formulario.add(
                cbTipoPagamento
        );

        JPanel botoes =
                new JPanel();

        btnRegistrar =
                new JButton(
                        "Registrar Pagamento"
                );

        btnAtualizar =
                new JButton(
                        "Atualizar"
                );

        botoes.add(btnRegistrar);
        botoes.add(btnAtualizar);

        tabelaPagamentos =
                new JTable(
                        new javax.swing.table.DefaultTableModel(
                                null,
                                new String[] {
                                        "ID",
                                        "Sessão",
                                        "Valor",
                                        "Data",
                                        "Tipo"
                                }
                        )
                );

        JScrollPane scroll =
                new JScrollPane(
                        tabelaPagamentos
                );

        add(formulario,
                BorderLayout.NORTH);

        add(scroll,
                BorderLayout.CENTER);

        add(botoes,
                BorderLayout.SOUTH);
    }

    public JTable getTabelaPagamentos() {
        return tabelaPagamentos;
    }

    public JTextField getTxtValor() {
        return txtValor;
    }

    public JComboBox<String> getCbTipoPagamento() {
        return cbTipoPagamento;
    }

    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    public JButton getBtnAtualizar() {
        return btnAtualizar;
    }
}
