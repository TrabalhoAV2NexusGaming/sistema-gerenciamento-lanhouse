package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.FuncionarioDAO;
import enums.CargoFuncionario;
import model.Funcionario;
import view.TelaFuncionario;

/*
 * Nexus Gaming System
 *
 * Baseado no livro:
 * FURGERI, Sérgio.
 *
 * Capítulo 9
 * Tratamento de Eventos com ActionListener
 *
 * Capítulo 12
 * Persistência de Dados com JDBC
 */

public class FuncionarioController {

    private TelaFuncionario tela;
    private FuncionarioDAO dao;

    public FuncionarioController(TelaFuncionario tela) {

        this.tela = tela;
        this.dao = new FuncionarioDAO();

        configurarEventos();
        carregarTabela();
    }

    private void configurarEventos() {

        tela.getBtnCadastrar().addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {

                cadastrarFuncionario();
            }
        });

        tela.getBtnAtualizar().addActionListener(
                e -> carregarTabela()
        );
    }

    private void cadastrarFuncionario() {

        try {

            Funcionario funcionario =
                    new Funcionario();

            funcionario.setNome(
                    tela.getTxtNome().getText()
            );

            funcionario.setUsuario(
                    tela.getTxtUsuario().getText()
            );

            funcionario.setSenha(
                    tela.getTxtSenha().getText()
            );

            funcionario.setCargo(
                    CargoFuncionario.valueOf(
                            tela.getCbCargo()
                            .getSelectedItem()
                            .toString()
                    )
            );

            dao.inserir(funcionario);

            JOptionPane.showMessageDialog(
                    tela,
                    "Funcionário cadastrado!"
            );

            carregarTabela();

        } catch (Exception ex) {

            JOptionPane.showMessageDialog(
                    tela,
                    ex.getMessage()
            );
        }
    }

    private void carregarTabela() {

        try {

            List<Funcionario> lista =
                    dao.listarTodos();

            DefaultTableModel modelo =
                    (DefaultTableModel)
                    tela.getTabelaFuncionarios()
                    .getModel();

            modelo.setRowCount(0);

            for (Funcionario f : lista) {

                modelo.addRow(
                        new Object[] {

                                f.getId(),
                                f.getNome(),
                                f.getUsuario(),
                                f.getCargo()
                        }
                );
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}