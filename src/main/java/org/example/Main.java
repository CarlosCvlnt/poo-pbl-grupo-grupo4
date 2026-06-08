package org.example;

import domain.negotiation.PropostaTroca;
import domain.negotiation.StatusProposta;
import domain.negotiation.Venda;
import domain.system.Objeto;
import domain.user.Email;
import domain.user.User;

public class Main {

    public static void main(String[] args) {

        // ─────────────────────────────────────────────
        // CONTEXTO 1: Inventário de Itens
        // Usuários cadastram itens que não usam mais
        // ─────────────────────────────────────────────
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║   MARKETPLACE DE ECONOMIA CIRCULAR   ║");
        System.out.println("╚══════════════════════════════════════╝\n");

        User pedro = new User("Pedro", Email.of("pedro@marketplace.com"));
        User maria = new User("Maria", Email.of("maria@marketplace.com"));
        User joao  = new User("Joao",  Email.of("joao@marketplace.com"));

        // Créditos iniciais (bônus de cadastro)
        pedro.ganharCreditos(500);
        maria.ganharCreditos(500);
        joao.ganharCreditos(600);

        // Itens cadastrados por cada usuário
        Objeto livro      = new Objeto("livro",      pedro, "Dom Casmurro");
        Objeto eletronico = new Objeto("eletronico", pedro, "Fone Bluetooth");
        Objeto brinquedo  = new Objeto("brinquedo",  maria, "Lego City");
        Objeto livro2     = new Objeto("livro",      joao,  "O Alquimista");

        System.out.println("[ INVENTÁRIO DE ITENS CADASTRADOS ]");
        System.out.println(livro.mostrarDetalhes());
        System.out.println(eletronico.mostrarDetalhes());
        System.out.println(brinquedo.mostrarDetalhes());
        System.out.println(livro2.mostrarDetalhes());

        // ─────────────────────────────────────────────
        // CONTEXTO 2: Sistema de Créditos (Pontuação)
        // Créditos gerados por categoria do item vendido
        // ─────────────────────────────────────────────
        System.out.println("\n[ SISTEMA DE CRÉDITOS ]");
        System.out.printf("%-10s saldo inicial: %s%n", pedro.getName(), pedro.getCredits());
        System.out.printf("%-10s saldo inicial: %s%n", maria.getName(), maria.getCredits());
        System.out.printf("%-10s saldo inicial: %s%n", joao.getName(),  joao.getCredits());

        // Pedro vende o eletrônico para João (500 créditos)
        Venda venda1 = new Venda(joao, pedro, 500);
        venda1.realizarVenda();
        System.out.println("\nJoão comprou 'Fone Bluetooth' de Pedro por 500 créditos.");
        System.out.printf("%-10s novo saldo: %s%n", pedro.getName(), pedro.getCredits());
        System.out.printf("%-10s novo saldo: %s%n", joao.getName(),  joao.getCredits());

        // Maria compra livro de João (250 créditos)
        Venda venda2 = new Venda(maria, joao, 250);
        venda2.realizarVenda();
        System.out.println("\nMaria comprou 'O Alquimista' de João por 250 créditos.");
        System.out.printf("%-10s novo saldo: %s%n", maria.getName(), maria.getCredits());
        System.out.printf("%-10s novo saldo: %s%n", joao.getName(),  joao.getCredits());

        // ─────────────────────────────────────────────
        // CONTEXTO 3: Matchmaking / Negociação
        // Propostas de troca entre usuários (estilo Tinder de objetos)
        // ─────────────────────────────────────────────
        System.out.println("\n[ MATCHMAKING — PROPOSTAS DE TROCA ]");

        // Pedro propõe troca do livro com Maria (brinquedo)
        PropostaTroca match1 = new PropostaTroca(pedro, maria);
        System.out.println("Pedro propôs troca com Maria... status: " + match1.getStatus());
        match1.aceitar();
        System.out.println("Maria aceitou!                  status: " + match1.getStatus());

        // João propõe troca com Pedro, mas Pedro recusa
        PropostaTroca match2 = new PropostaTroca(joao, pedro);
        System.out.println("\nJoão propôs troca com Pedro...  status: " + match2.getStatus());
        match2.recusar();
        System.out.println("Pedro recusou.                  status: " + match2.getStatus());

        // Garantia de imutabilidade: proposta finalizada não pode ser alterada
        System.out.println("\n[ REGRA DE NEGÓCIO: proposta já finalizada não pode ser reaberta ]");
        try {
            match1.recusar();
        } catch (IllegalStateException e) {
            System.out.println("Bloqueado corretamente → " + e.getMessage());
        }

        // ─────────────────────────────────────────────
        // Resumo final
        // ─────────────────────────────────────────────
        System.out.println("\n[ SALDOS FINAIS ]");
        System.out.printf("%-10s %s%n", pedro.getName(), pedro.getCredits());
        System.out.printf("%-10s %s%n", maria.getName(), maria.getCredits());
        System.out.printf("%-10s %s%n", joao.getName(),  joao.getCredits());

        System.out.println("\n[ STATUS DAS PROPOSTAS ]");
        System.out.printf("Pedro → Maria : %s%n", match1.getStatus());
        System.out.printf("João  → Pedro : %s%n", match2.getStatus());
    }
}
