package model;

/*
 * Baseado no livro:
 * FURGERI, Sérgio.
 *
 * Capítulo 7:
 * - Herança
 */

public class Computador extends Equipamento {

    private String processador;
    private int memoriaRAM;
    private String placaVideo;

    public Computador() {
    }

    public Computador(int id, String nome, int numero,
            double valorHora,
            enums.StatusEquipamento status,
            String processador,
            int memoriaRAM,
            String placaVideo) {

        super(id, nome, numero, valorHora, status);

        this.processador = processador;
        this.memoriaRAM = memoriaRAM;
        this.placaVideo = placaVideo;
    }

    public String getProcessador() {
        return processador;
    }

    public void setProcessador(String processador) {
        this.processador = processador;
    }

    public int getMemoriaRAM() {
        return memoriaRAM;
    }

    public void setMemoriaRAM(int memoriaRAM) {
        this.memoriaRAM = memoriaRAM;
    }

    public String getPlacaVideo() {
        return placaVideo;
    }

    public void setPlacaVideo(String placaVideo) {
        this.placaVideo = placaVideo;
    }

    public void abrirJogo() {
        System.out.println("Jogo iniciado.");
    }
}
