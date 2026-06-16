package model;

/*
 * Baseado no livro:
 * FURGERI, Sérgio.
 *
 * Capítulo 7:
 * - Herança
 */

public class Console extends Equipamento {

    private String marca;
    private String geracao;

    public Console() {
    }

    public Console(int id, String nome, int numero,
            double valorHora,
            enums.StatusEquipamento status,
            String marca,
            String geracao) {

        super(id, nome, numero, valorHora, status);

        this.marca = marca;
        this.geracao = geracao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getGeracao() {
        return geracao;
    }

    public void setGeracao(String geracao) {
        this.geracao = geracao;
    }

    public void iniciarConsole() {
        System.out.println("Console iniciado.");
    }
}
