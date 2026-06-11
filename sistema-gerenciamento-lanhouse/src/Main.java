package interfaces;

/*
 * Nexus Gaming System
 *
 * Baseado no livro:
 * FURGERI, Sérgio.
 * Java 8 - Ensino Didático: Desenvolvimento e Implementação de Aplicações.
 *
 * Capítulo 7 - Orientação a Objetos
 * Seção 7.15 - Interfaces
 *
 * Esta interface define o contrato de autenticação
 * que deverá ser implementado por qualquer classe
 * que possua acesso ao sistema.
 */

public interface Autenticavel {

    /**
     * Realiza a autenticação de um usuário.
     *
     * @param usuario Nome de usuário informado.
     * @param senha Senha informada.
     * @return true se o login for válido; false caso contrário.
     */
    boolean login(String usuario, String senha);

}