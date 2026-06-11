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

public class TelaFuncionario extends JFrame {

    private JTextField txtNome;
    private JTextField txtUsuario;
    private JTextField txtSenha;

    private JComboBox<String> cbCargo;

    private JButton btnCadastrar;
    private JButton btnEditar;
    private JButton btnExcluir;
    private JButton btnAtualizar;

    private JTable tabelaFuncionarios;

    public TelaFuncionario() {

        setTitle("Funcionários");

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
                new JLabel("Usuário:")
        );

        txtUsuario = new JTextField();

        formulario.add(txtUsuario);

        formulario.add(
                new JLabel("Senha:")
        );

        txtSenha = new JTextField();

        formulario.add(txtSenha);

        formulario.add(
                new JLabel("Cargo:")
        );

        cbCargo = new JComboBox<>();

        cbCargo.addItem("ADMIN");
        cbCargo.addItem("ATENDENTE");
        cbCargo.addItem("TECNICO");

        formulario.add(cbCargo);

        JPanel painelBotoes =
                new JPanel();

        btnCadastrar =
                new JButton("Cadastrar");

        btnEditar =
                new JButton("Editar");

        btnExcluir =
                new JButton("Excluir");

        btnAtualizar =
                new JButton("Atualizar");

        painelBotoes.add(btnCadastrar);
        painelBotoes.add(btnEditar);
        painelBotoes.add(btnExcluir);
        painelBotoes.add(btnAtualizar);

        tabelaFuncionarios =
                new JTable(
                        new javax.swing.table.DefaultTableModel(
                                null,
                                new String[] {
                                        "ID",
                                        "Nome",
                                        "Usuário",
                                        "Cargo"
                                }
                        )
                );

        JScrollPane scroll =
                new JScrollPane(
                        tabelaFuncionarios
                );

        add(formulario,
                BorderLayout.NORTH);

        add(scroll,
                BorderLayout.CENTER);

        add(painelBotoes,
                BorderLayout.SOUTH);
    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public JTextField getTxtSenha() {
        return txtSenha;
    }

    public JComboBox<String> getCbCargo() {
        return cbCargo;
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

    public JTable getTabelaFuncionarios() {
        return tabelaFuncionarios;
    }
}
