package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
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

public class TelaPromocao extends JFrame {

    private JTextField txtNome;
    private JTextField txtHorarioInicio;
    private JTextField txtHorarioFim;
    private JTextField txtValorFixo;

    private JButton btnCadastrar;
    private JButton btnEditar;
    private JButton btnExcluir;
    private JButton btnAtualizar;

    private JTable tabelaPromocoes;

    public TelaPromocao() {

        setTitle("Promoções");

        setSize(900, 600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.DISPOSE_ON_CLOSE);

        inicializarComponentes();
    }

    private void inicializarComponentes() {

        JPanel formulario =
                new JPanel(
                        new GridLayout(4,2,10,10));

        formulario.add(
                new JLabel("Nome:")
        );

        txtNome = new JTextField();

        formulario.add(txtNome);

        formulario.add(
                new JLabel("Horário Início:")
        );

        txtHorarioInicio =
                new JTextField();

        formulario.add(
                txtHorarioInicio
        );

        formulario.add(
                new JLabel("Horário Fim:")
        );

        txtHorarioFim =
                new JTextField();

        formulario.add(
                txtHorarioFim
        );

        formulario.add(
                new JLabel("Valor Fixo:")
        );

        txtValorFixo =
                new JTextField();

        formulario.add(
                txtValorFixo
        );

        JPanel botoes =
                new JPanel();

        btnCadastrar =
                new JButton("Cadastrar");

        btnEditar =
                new JButton("Editar");

        btnExcluir =
                new JButton("Excluir");

        btnAtualizar =
                new JButton("Atualizar");

        botoes.add(btnCadastrar);
        botoes.add(btnEditar);
        botoes.add(btnExcluir);
        botoes.add(btnAtualizar);

        tabelaPromocoes =
                new JTable(
                        new javax.swing.table.DefaultTableModel(
                                null,
                                new String[] {
                                        "ID",
                                        "Nome",
                                        "Início",
                                        "Fim",
                                        "Valor"
                                }
                        )
                );

        JScrollPane scroll =
                new JScrollPane(
                        tabelaPromocoes
                );

        add(formulario,
                BorderLayout.NORTH);

        add(scroll,
                BorderLayout.CENTER);

        add(botoes,
                BorderLayout.SOUTH);
    }

    public JTable getTabelaPromocoes() {
        return tabelaPromocoes;
    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    public JTextField getTxtHorarioInicio() {
        return txtHorarioInicio;
    }

    public JTextField getTxtHorarioFim() {
        return txtHorarioFim;
    }

    public JTextField getTxtValorFixo() {
        return txtValorFixo;
    }

    public JButton getBtnCadastrar() {
        return btnCadastrar;
    }

    public JButton getBtnEditar() {
        return btnEditar;
    }

    public JButton getBtnExcluir() {
        return btnExcluir;
    }

    public JButton getBtnAtualizar() {
        return btnAtualizar;
    }
}