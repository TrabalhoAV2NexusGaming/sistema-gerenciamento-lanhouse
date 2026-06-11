package model;

import enums.StatusEquipamento;

/*
 * Baseado no livro:
 * FURGERI, Sérgio.
 * Java 8 - Ensino Didático.
 *
 * Capítulo 7:
 * - Herança
 * - Encapsulamento
 * - Classes e Objetos
 */

public class Equipamento {

    private int id;
    private String nome;
    private int numero;
    private double valorHora;
    private StatusEquipamento status;

    public Equipamento() {
    }

    public Equipamento(int id, String nome, int numero,
            double valorHora, StatusEquipamento status) {

        this.id = id;
        this.nome = nome;
        this.numero = numero;
        this.valorHora = valorHora;
        this.status = status;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getNumero() { return numero; }
    public void setNumero(int numero) { this.numero = numero; }

    public double getValorHora() { return valorHora; }
    public void setValorHora(double valorHora) { this.valorHora = valorHora; }

    public StatusEquipamento getStatus() { return status; }
    public void setStatus(StatusEquipamento status) { this.status = status; }

    public void ligar() {
        status = StatusEquipamento.OCUPADO;
    }

    public void desligar() {
        status = StatusEquipamento.LIVRE;
    }

    public void alterarStatus(StatusEquipamento status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return nome;
    }
}