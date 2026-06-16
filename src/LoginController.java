package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import model.Funcionario;
import view.TelaLogin;
import view.TelaPrincipal;

/*
 * Nexus Gaming System
 *
 * Baseado no livro:
 * FURGERI, Sérgio.
 *
 * Capítulo 9
 * Tratamento de Eventos
 * ActionListener
 */

public class LoginController {

    private TelaLogin tela;

    public LoginController(TelaLogin tela) {

        this.tela = tela;

        configurarEventos();
    }

    private void configurarEventos() {

        tela.getBtnEntrar()
            .addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(
                    ActionEvent e) {

                realizarLogin();
            }
        });
    }

    private void realizarLogin() {

        String usuario =
                tela.getTxtUsuario().getText();

        String senha =
                new String(
                        tela.getTxtSenha()
                            .getPassword()
                );

        /*
         * Temporário.
         * Futuramente será consultado no banco.
         */

        Funcionario funcionario =
                new Funcionario();

        funcionario.setUsuario("admin");
        funcionario.setSenha("123");

        if (funcionario.login(
                usuario,
                senha)) {

            JOptionPane.showMessageDialog(
                    tela,
                    "Login realizado!"
            );

            tela.dispose();

            TelaPrincipal principal =
                    new TelaPrincipal();

            principal.setVisible(true);

        } else {

            JOptionPane.showMessageDialog(
                    tela,
                    "Usuário ou senha inválidos."
            );
        }
    }
}
