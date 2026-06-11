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

public class TelaSessao extends JFrame {

    private JComboBox<String> cbCliente;
    private JComboBox<String> cbEquipamento;
    private JComboBox<String> cbPromocao;

    private JTextField txtTempoContratado;

    private JButton btnIniciarSessao;
    private JButton btnEncerrarSessao;
    private JButton btnAtualizar;

    private JTable tabelaSessoes;

    public TelaSessao() {

        setTitle("Gerenciamento de Sessões");
        setSize(900, 600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE);

        inicializarComponentes();
    }

    private void inicializarComponentes() {

        JPanel painelFormulario =
                new JPanel();

        painelFormulario.setLayout(
                new GridLayout(
                        5,
                        2,
                        10,
                        10
                )
        );

        painelFormulario.add(
                new JLabel("Cliente:")
        );

        cbCliente =
                new JComboBox<>();

        painelFormulario.add(
                cbCliente
        );

        painelFormulario.add(
                new JLabel("Equipamento:")
        );

        cbEquipamento =
                new JComboBox<>();

        painelFormulario.add(
                cbEquipamento
        );

        painelFormulario.add(
                new JLabel("Promoção:")
        );

        cbPromocao =
                new JComboBox<>();

        painelFormulario.add(
                cbPromocao
        );

        painelFormulario.add(
                new JLabel(
                        "Tempo Contratado (min):"
                )
        );

        txtTempoContratado =
                new JTextField();

        painelFormulario.add(
                txtTempoContratado
        );

        JPanel painelBotoes =
                new JPanel();

        btnIniciarSessao =
                new JButton(
                        "Iniciar Sessão"
                );

        btnEncerrarSessao =
                new JButton(
                        "Encerrar Sessão"
                );

        btnAtualizar =
                new JButton(
                        "Atualizar"
                );

        painelBotoes.add(
                btnIniciarSessao
        );

        painelBotoes.add(
                btnEncerrarSessao
        );

        painelBotoes.add(
                btnAtualizar
        );

        String[] colunas = {

                "ID",
                "Cliente",
                "Equipamento",
                "Promoção",
                "Início",
                "Fim",
                "Tempo",
                "Valor",
                "Ativa"
        };

        tabelaSessoes =
                new JTable(
                        new javax.swing.table.DefaultTableModel(
                                null,
                                colunas
                        )
                );

        JScrollPane scroll =
                new JScrollPane(
                        tabelaSessoes
                );

        add(
                painelFormulario,
                BorderLayout.NORTH
        );

        add(
                scroll,
                BorderLayout.CENTER
        );

        add(
                painelBotoes,
                BorderLayout.SOUTH
        );
    }

    /*
     * GETTERS
     */

    public JComboBox<String> getCbCliente() {
        return cbCliente;
    }

    public JComboBox<String> getCbEquipamento() {
        return cbEquipamento;
    }

    public JComboBox<String> getCbPromocao() {
        return cbPromocao;
    }

    public JTextField getTxtTempoContratado() {
        return txtTempoContratado;
    }

    public JButton getBtnIniciarSessao() {
        return btnIniciarSessao;
    }

    public JButton getBtnEncerrarSessao() {
        return btnEncerrarSessao;
    }

    public JButton getBtnAtualizar() {
        return btnAtualizar;
    }

    public JTable getTabelaSessoes() {
        return tabelaSessoes;
    }
}