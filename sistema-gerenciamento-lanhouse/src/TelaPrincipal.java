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
 * Baseado no livro:
 * FURGERI, Sérgio.
 *
 * Capítulo 8 - Swing
 */

public class TelaCliente extends JFrame {

    private JTextField txtNome;
    private JTextField txtCpf;
    private JTextField txtTelefone;
    private JTextField txtNickname;

    private JButton btnSalvar;
    private JButton btnExcluir;

    private JTable tabela;

    public TelaCliente() {

        setTitle("Cadastro de Clientes");

        setSize(800, 500);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel painelCampos =
                new JPanel(new GridLayout(4,2));

        painelCampos.add(new JLabel("Nome"));
        txtNome = new JTextField();
        painelCampos.add(txtNome);

        painelCampos.add(new JLabel("CPF"));
        txtCpf = new JTextField();
        painelCampos.add(txtCpf);

        painelCampos.add(new JLabel("Telefone"));
        txtTelefone = new JTextField();
        painelCampos.add(txtTelefone);

        painelCampos.add(new JLabel("Nickname"));
        txtNickname = new JTextField();
        painelCampos.add(txtNickname);

        add(painelCampos, BorderLayout.NORTH);

        tabela = new JTable();

        add(
            new JScrollPane(tabela),
            BorderLayout.CENTER
        );

        JPanel painelBotoes =
                new JPanel();

        btnSalvar =
                new JButton("Salvar");

        btnExcluir =
                new JButton("Excluir");

        painelBotoes.add(btnSalvar);
        painelBotoes.add(btnExcluir);

        add(
            painelBotoes,
            BorderLayout.SOUTH
        );
    }

    public JButton getBtnSalvar() {
        return btnSalvar;
    }

    public JButton getBtnExcluir() {
        return btnExcluir;
    }

    public JTable getTabela() {
        return tabela;
    }

    public JTextField getTxtNome() {
        return txtNome;
    }

    public JTextField getTxtCpf() {
        return txtCpf;
    }

    public JTextField getTxtTelefone() {
        return txtTelefone;
    }

    public JTextField getTxtNickname() {
        return txtNickname;
    }
}