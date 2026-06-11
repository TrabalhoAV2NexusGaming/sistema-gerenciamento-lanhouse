package view;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/*
 * Nexus Gaming System
 *
 * Baseado no livro:
 * FURGERI, Sérgio.
 *
 * Capítulo 8 - Interface Gráfica Swing
 * Componentes:
 * JFrame
 * JLabel
 * JTextField
 * JPasswordField
 * JButton
 *
 * Capítulo 9 - Eventos
 */

public class TelaLogin extends JFrame {

    private JTextField txtUsuario;
    private JPasswordField txtSenha;

    private JButton btnEntrar;

    public TelaLogin() {

        setTitle("Nexus Gaming System - Login");

        setSize(400, 200);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new GridLayout(3, 2));

        add(new JLabel("Usuário:"));

        txtUsuario = new JTextField();

        add(txtUsuario);

        add(new JLabel("Senha:"));

        txtSenha = new JPasswordField();

        add(txtSenha);

        add(new JLabel());

        btnEntrar = new JButton("Entrar");

        add(btnEntrar);

        setVisible(true);
    }

    public JButton getBtnEntrar() {
        return btnEntrar;
    }

    public JTextField getTxtUsuario() {
        return txtUsuario;
    }

    public JPasswordField getTxtSenha() {
        return txtSenha;
    }
}