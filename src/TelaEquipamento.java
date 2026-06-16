package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

/*
 * Baseado no livro:
 * FURGERI, Sérgio.
 *
 * Capítulo 8 - Swing
 */

public class TelaEquipamento extends JFrame {

    private JTextField txtNome;
    private JTextField txtNumero;
    private JTextField txtValorHora;

    private JComboBox<String> cbTipo;

    private JButton btnSalvar;

    private JTable tabela;
    
    public JTextField getTxtNome() {
        return txtNome;
    }

    public JTextField getTxtNumero() {
        return txtNumero;
    }

    public JTextField getTxtValorHora() {
        return txtValorHora;
    }

    public JComboBox<String> getCbTipo() {
        return cbTipo;
    }

    public JButton getBtnSalvar() {
        return btnSalvar;
    }

    public TelaEquipamento() {

        setTitle("Equipamentos");

        setSize(800, 500);

        setLocationRelativeTo(null);

        setLayout(new BorderLayout());

        JPanel painel =
                new JPanel(new GridLayout(4,2));

        painel.add(new JLabel("Nome"));

        txtNome = new JTextField();

        painel.add(txtNome);

        painel.add(new JLabel("Número"));

        txtNumero = new JTextField();

        painel.add(txtNumero);

        painel.add(new JLabel("Valor Hora"));

        txtValorHora = new JTextField();

        painel.add(txtValorHora);

        painel.add(new JLabel("Tipo"));

        cbTipo =
                new JComboBox<>();

        cbTipo.addItem("COMPUTADOR");
        cbTipo.addItem("CONSOLE");

        painel.add(cbTipo);

        add(painel, BorderLayout.NORTH);

        tabela = new JTable();

        add(tabela, BorderLayout.CENTER);

        btnSalvar =
                new JButton("Salvar");

        add(btnSalvar, BorderLayout.SOUTH);
        
        
    }
}
