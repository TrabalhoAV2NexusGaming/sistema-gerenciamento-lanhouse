package model;

/*
 * Nexus Gaming System
 *
 * Baseado no livro:
 * FURGERI, Sérgio.
 * Java 8 - Ensino Didático: Desenvolvimento e Implementação de Aplicações.
 *
 * Capítulo 7 - Orientação a Objetos
 * Seções utilizadas:
 * - Encapsulamento
 * - Métodos construtores
 * - Classes e objetos
 * - Pacotes
 */

public class Cliente {

    private int id;
    private String nome;
    private String cpf;
    private String telefone;
    private String nickname;
    private int pontos;
    private double saldoHoras;

    // Construtor padrão
    public Cliente() {
    }

    // Construtor completo
    public Cliente(int id, String nome, String cpf, String telefone,
                   String nickname, int pontos, double saldoHoras) {

        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.telefone = telefone;
        this.nickname = nickname;
        this.pontos = pontos;
        this.saldoHoras = saldoHoras;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public int getPontos() {
        return pontos;
    }

    public void setPontos(int pontos) {
        this.pontos = pontos;
    }

    public double getSaldoHoras() {
        return saldoHoras;
    }

    public void setSaldoHoras(double saldoHoras) {
        this.saldoHoras = saldoHoras;
    }

    // Métodos do UML

    public void cadastrar() {
        System.out.println("Cliente cadastrado.");
    }

    public void editar() {
        System.out.println("Cliente editado.");
    }

    public void excluir() {
        System.out.println("Cliente excluído.");
    }

    public void consultarHistorico() {
        System.out.println("Consultando histórico do cliente...");
    }

    @Override
    public String toString() {
        return "Cliente [id=" + id +
                ", nome=" + nome +
                ", cpf=" + cpf +
                ", telefone=" + telefone +
                ", nickname=" + nickname +
                ", pontos=" + pontos +
                ", saldoHoras=" + saldoHoras + "]";
    }
}
