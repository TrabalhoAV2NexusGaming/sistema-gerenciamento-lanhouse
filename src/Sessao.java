package model;

import java.time.LocalDateTime;

/*
 * Baseado no livro:
 * FURGERI, Sérgio.
 *
 * Capítulo 7
 * Capítulo 10
 */

public class Sessao {

    private int id;

    private Cliente cliente;
    private Equipamento equipamento;
    private Promocao promocao;
    private Pagamento pagamento;

    private LocalDateTime horarioInicio;
    private LocalDateTime horarioFim;

    private int tempoContratado;
    private double valorTotal;
    private boolean ativa;

    public Sessao() {
    }

    public Sessao(int id,
            Cliente cliente,
            Equipamento equipamento,
            Promocao promocao,
            LocalDateTime horarioInicio,
            LocalDateTime horarioFim,
            int tempoContratado,
            double valorTotal,
            boolean ativa) {

        this.id = id;
        this.cliente = cliente;
        this.equipamento = equipamento;
        this.promocao = promocao;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.tempoContratado = tempoContratado;
        this.valorTotal = valorTotal;
        this.ativa = ativa;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }

    public Equipamento getEquipamento() { return equipamento; }
    public void setEquipamento(Equipamento equipamento) {
        this.equipamento = equipamento;
    }

    public Promocao getPromocao() { return promocao; }
    public void setPromocao(Promocao promocao) {
        this.promocao = promocao;
    }

    public Pagamento getPagamento() { return pagamento; }
    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public LocalDateTime getHorarioInicio() {
        return horarioInicio;
    }

    public void setHorarioInicio(LocalDateTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalDateTime getHorarioFim() {
        return horarioFim;
    }

    public void setHorarioFim(LocalDateTime horarioFim) {
        this.horarioFim = horarioFim;
    }

    public int getTempoContratado() {
        return tempoContratado;
    }

    public void setTempoContratado(int tempoContratado) {
        this.tempoContratado = tempoContratado;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public boolean isAtiva() {
        return ativa;
    }

    public void setAtiva(boolean ativa) {
        this.ativa = ativa;
    }

    public void iniciarSessao() {
        ativa = true;
    }

    public void encerrarSessao() {
        ativa = false;
    }

    public double calcularValor() {
        return valorTotal;
    }
}
