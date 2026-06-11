package model;

import enums.CargoFuncionario;
import interfaces.Autenticavel;

/*
 * Baseado no livro:
 * FURGERI, Sérgio.
 *
 * Capítulo 7:
 * - Interfaces
 * - Orientação a Objetos
 */

public class Funcionario implements Autenticavel {

    private int id;
    private String nome;
    private String usuario;
    private String senha;
    private CargoFuncionario cargo;

    public Funcionario() {
    }

    public Funcionario(int id, String nome,
            String usuario,
            String senha,
            CargoFuncionario cargo) {

        this.id = id;
        this.nome = nome;
        this.usuario = usuario;
        this.senha = senha;
        this.cargo = cargo;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getUsuario() { return usuario; }
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() { return senha; }
    public void setSenha(String senha) {
        this.senha = senha;
    }

    public CargoFuncionario getCargo() {
        return cargo;
    }

    public void setCargo(CargoFuncionario cargo) {
        this.cargo = cargo;
    }

    public void abrirCaixa() {
        System.out.println("Caixa aberto.");
    }

    @Override
    public boolean login(String usuario, String senha) {
        return this.usuario.equals(usuario)
                && this.senha.equals(senha);
    }
}