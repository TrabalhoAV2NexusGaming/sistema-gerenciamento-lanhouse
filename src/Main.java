package main;

import controller.LoginController;
import view.TelaLogin;

/*
 * Baseado no livro:
 * FURGERI, Sérgio.
 *
 * Capítulos 8 e 9
 * Swing + Eventos
 */

public class Main {

    public static void main(String[] args) {

        TelaLogin tela =
                new TelaLogin();

        new LoginController(tela);

        tela.setVisible(true);
    }
}
