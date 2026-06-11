package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.ClienteController;
import controller.EquipamentoController;
import controller.FuncionarioController;
import controller.PagamentoController;
import controller.PromocaoController;
import controller.SessaoController;

/*
 * Nexus Gaming System
 *
 * Baseado no livro:
 * FURGERI, Sérgio.
 *
 * Capítulo 8
 * Menus e Interface Swing
 *
 * Capítulo 9
 * Eventos com ActionListener
 */

public class TelaPrincipal extends JFrame {

    public TelaPrincipal() {

        setTitle("Nexus Gaming System");

        setSize(900, 600);

        setLocationRelativeTo(null);

        setDefaultCloseOperation(
                JFrame.EXIT_ON_CLOSE
        );

        criarMenu();
    }

    private void criarMenu() {

        JMenuBar barra =
                new JMenuBar();

        /*
         * MENU CADASTROS
         */

        JMenu menuCadastros =
                new JMenu("Cadastros");

        JMenuItem itemClientes =
                new JMenuItem("Clientes");

        JMenuItem itemEquipamentos =
                new JMenuItem("Equipamentos");

        JMenuItem itemFuncionarios =
                new JMenuItem("Funcionários");

        JMenuItem itemPromocoes =
                new JMenuItem("Promoções");

        menuCadastros.add(itemClientes);
        menuCadastros.add(itemEquipamentos);
        menuCadastros.add(itemFuncionarios);
        menuCadastros.add(itemPromocoes);

        /*
         * MENU OPERAÇÕES
         */

        JMenu menuOperacoes =
                new JMenu("Operações");

        JMenuItem itemSessoes =
                new JMenuItem("Sessões");

        JMenuItem itemPagamentos =
                new JMenuItem("Pagamentos");

        menuOperacoes.add(itemSessoes);
        menuOperacoes.add(itemPagamentos);

        /*
         * ADICIONA MENUS
         */

        barra.add(menuCadastros);
        barra.add(menuOperacoes);

        setJMenuBar(barra);

        /*
         * EVENTO CLIENTES
         */

        itemClientes.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(
                    ActionEvent e) {

                TelaCliente tela =
                        new TelaCliente();

                new ClienteController(
                        tela
                );

                tela.setVisible(true);
            }
        });

        /*
         * EVENTO EQUIPAMENTOS
         */

        itemEquipamentos.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(
                    ActionEvent e) {

                TelaEquipamento tela =
                        new TelaEquipamento();

                new EquipamentoController(
                        tela
                );

                tela.setVisible(true);
            }
        });

        /*
         * EVENTO FUNCIONÁRIOS
         */

        itemFuncionarios.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(
                    ActionEvent e) {

                TelaFuncionario tela =
                        new TelaFuncionario();

                new FuncionarioController(
                        tela
                );

                tela.setVisible(true);
            }
        });

        /*
         * EVENTO PROMOÇÕES
         */

        itemPromocoes.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(
                    ActionEvent e) {

                TelaPromocao tela =
                        new TelaPromocao();

                new PromocaoController(
                        tela
                );

                tela.setVisible(true);
            }
        });

        /*
         * EVENTO SESSÕES
         */

        itemSessoes.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(
                    ActionEvent e) {

                TelaSessao tela =
                        new TelaSessao();

                new SessaoController(
                        tela
                );

                tela.setVisible(true);
            }
        });

        /*
         * EVENTO PAGAMENTOS
         */

        itemPagamentos.addActionListener(
                new ActionListener() {

            @Override
            public void actionPerformed(
                    ActionEvent e) {

                TelaPagamento tela =
                        new TelaPagamento();

                new PagamentoController(
                        tela
                );

                tela.setVisible(true);
            }
        });
    }
}