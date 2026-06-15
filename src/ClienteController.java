package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.ClienteDAO;
import model.Cliente;
import view.TelaCliente;

/*
 * Baseado no livro:
 * FURGERI, Sérgio.
 *
 * Capítulo 9
 * ActionListener
 */

public class ClienteController {

    private TelaCliente tela;

    private ClienteDAO dao;

    public ClienteController(
            TelaCliente tela) {

        this.tela = tela;

        dao = new ClienteDAO();

        configurarEventos();
    }

    private void configurarEventos() {

        tela.getBtnSalvar()
            .addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(
                    ActionEvent e) {

                salvarCliente();
            }
        });

        tela.getBtnExcluir()
            .addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(
                    ActionEvent e) {

                excluirCliente();
            }
        });
    }

    private void salvarCliente() {

        try {

            Cliente cliente =
                    new Cliente();

            cliente.setNome(
                    tela.getTxtNome()
                            .getText());

            cliente.setCpf(
                    tela.getTxtCpf()
                            .getText());

            cliente.setTelefone(
                    tela.getTxtTelefone()
                            .getText());

            cliente.setNickname(
                    tela.getTxtNickname()
                            .getText());

            cliente.setPontos(0);

            cliente.setSaldoHoras(0);

            boolean sucesso =
                    dao.inserir(cliente);

            if (sucesso) {

                JOptionPane.showMessageDialog(
                        tela,
                        "Cliente cadastrado!"
                );

            } else {

                JOptionPane.showMessageDialog(
                        tela,
                        "Erro ao cadastrar."
                );
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                    tela,
                    e.getMessage()
            );
        }
    }

    private void excluirCliente() {

        JOptionPane.showMessageDialog(
                tela,
                "Seleção da tabela será implementada posteriormente."
        );
    }
}
