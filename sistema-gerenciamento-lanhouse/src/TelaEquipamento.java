package model;

import java.time.LocalTime;

/*
 * Baseado no livro:
 * FURGERI, Sérgio.
 *
 * Capítulo 7:
 * Classes e Objetos
 *
 * Capítulo 10:
 * Manipulação de Data e Hora
 */

public class Promocao {

    private int id;
    private String nome;
    private LocalTime horarioInicio;
    private LocalTime horarioFim;
    private double valorFixo;

    public Promocao() {
    }

    public Promocao(int id, String nome,
            LocalTime horarioInicio,
            LocalTime horarioFim,
            double valorFixo) {

        this.id = id;
        this.nome = nome;
        this.horarioInicio = horarioInicio;
        this.horarioFim = horarioFim;
        this.valorFixo = valorFixo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public LocalTime getHorarioInicio() { return horarioInicio; }
    public void setHorarioInicio(LocalTime horarioInicio) {
        this.horarioInicio = horarioInicio;
    }

    public LocalTime getHorarioFim() { return horarioFim; }
    public void setHorarioFim(LocalTime horarioFim) {
        this.horarioFim = horarioFim;
    }

    public double getValorFixo() { return valorFixo; }
    public void setValorFixo(double valorFixo) {
        this.valorFixo = valorFixo;
    }

    public void aplicarPromocao() {
        System.out.println("Promoção aplicada.");
    }
}