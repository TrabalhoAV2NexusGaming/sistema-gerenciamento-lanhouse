package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import dao.EquipamentoDAO;
import enums.StatusEquipamento;
import model.Computador;
import model.Console;
import model.Equipamento;
import view.TelaEquipamento;

/*
 * Nexus Gaming System
 *
 * Baseado no livro:
 * FURGERI, Sérgio.
 *
 * Capítulo 9
 * Eventos e ActionListener
 */

public class EquipamentoController {

    private TelaEquipamento tela;

    private EquipamentoDAO dao;

    public EquipamentoController(
            TelaEquipamento tela) {

        this.tela = tela;

        dao = new EquipamentoDAO();

        configurarEventos();
    }

    private void configurarEventos() {

        tela.getBtnSalvar()
            .addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(
                    ActionEvent e) {

                salvarEquipamento();
            }
        });
    }

    private void salvarEquipamento() {

        try {

            String tipo =
                    tela.getCbTipo()
                            .getSelectedItem()
                            .toString();

            Equipamento equipamento;

            if (tipo.equals(
                    "COMPUTADOR")) {

                equipamento =
                        new Computador();

            } else {

                equipamento =
                        new Console();
            }

            equipamento.setNome(
                    tela.getTxtNome()
                            .getText());

            equipamento.setNumero(
                    Integer.parseInt(
                            tela.getTxtNumero()
                                    .getText()
                    )
            );

            equipamento.setValorHora(
                    Double.parseDouble(
                            tela.getTxtValorHora()
                                    .getText()
                    )
            );

            equipamento.setStatus(
                    StatusEquipamento.LIVRE
            );

            boolean sucesso =
                    dao.inserir(
                            equipamento
                    );

            if (sucesso) {

                JOptionPane.showMessageDialog(
                        tela,
                        "Equipamento cadastrado!"
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
}