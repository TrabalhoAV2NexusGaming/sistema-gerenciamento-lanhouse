package model;

import java.time.LocalDate;

import enums.TipoPagamento;

/*
 * Nexus Gaming System
 *
 * Baseado no livro:
 * FURGERI, Sérgio.
 *
 * Capítulo 7
 * Classes e Objetos
 *
 * Capítulo 10
 * Relacionamento entre Classes
 */

public class Pagamento {

    private int id;

    private Sessao sessao;

    private double valor;

    private LocalDate dataPagamento;

    private TipoPagamento tipo;

    public Pagamento() {
    }

    public Pagamento(
            int id,
            Sessao sessao,
            double valor,
            LocalDate dataPagamento,
            TipoPagamento tipo) {

        this.id = id;
        this.sessao = sessao;
        this.valor = valor;
        this.dataPagamento = dataPagamento;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Sessao getSessao() {
        return sessao;
    }

    public void setSessao(Sessao sessao) {
        this.sessao = sessao;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public LocalDate getDataPagamento() {
        return dataPagamento;
    }

    public void setDataPagamento(
            LocalDate dataPagamento) {

        this.dataPagamento =
                dataPagamento;
    }

    public TipoPagamento getTipo() {
        return tipo;
    }

    public void setTipo(
            TipoPagamento tipo) {

        this.tipo = tipo;
    }

    public void realizarPagamento() {

        System.out.println(
                "Pagamento realizado."
        );
    }
}