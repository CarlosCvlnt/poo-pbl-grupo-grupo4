package main.java.org.example;

import application.CadastrarUsuario;
import application.CadastrarItem;
import application.ProporTroca;
import application.RealizarVenda;
import domain.negotiation.PropostaTroca;
import domain.item.Categoria;
import domain.item.Item;
import domain.user.User;
import infrastructure.ItemRepositorio;
import infrastructure.NegociacaoRepositorio;
import infrastructure.UsuarioRepositorio;

import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner scanner = new Scanner(System.in);
    static UsuarioRepositorio usuarioRepo = new UsuarioRepositorio();
    static ItemRepositorio itemRepo = new ItemRepositorio();
    static NegociacaoRepositorio negociacaoRepo = new NegociacaoRepositorio();
    static CadastrarUsuario cadastrarUsuario = new CadastrarUsuario(usuarioRepo);
    static CadastrarItem cadastrarItem = new CadastrarItem(itemRepo);
    static ProporTroca proporTroca = new ProporTroca(negociacaoRepo);
    static RealizarVenda realizarVenda = new RealizarVenda();

    public static void main(String[] args) {
        System.out.println("╔══════════════════════════════════════╗");
        System.out.println("║   MARKETPLACE DE ECONOMIA CIRCULAR   ║");
        System.out.println("╚══════════════════════════════════════╝");

        int opcao = -1;
        while (opcao != 0) {
            System.out.println("\n[ MENU PRINCIPAL ]");
            System.out.println("1 - Cadastrar usuário");
            System.out.println("2 - Cadastrar item");
            System.out.println("3 - Listar itens disponíveis");
            System.out.println("4 - Propor troca");
            System.out.println("5 - Realizar venda");
            System.out.println("6 - Listar usuários");
            System.out.println("0 - Sair");
            System.out.print("\nEscolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine().trim());
            } catch (NumberFormatException e) {
                System.out.println("Opção inválida!");
                continue;
            }

            switch (opcao) {
                case 1 -> cadastrarUsuario();
                case 2 -> cadastrarItem();
                case 3 -> listarItens();
                case 4 -> proporTroca();
                case 5 -> realizarVenda();
                case 6 -> listarUsuarios();
                case 0 -> System.out.println("\nAté logo!");
                default -> System.out.println("Opção inválida!");
            }
        }
    }

    static void cadastrarUsuario() {
        System.out.println("\n[ CADASTRAR USUÁRIO ]");
        System.out.print("Nome: ");
        String nome = scanner.nextLine().trim();
        System.out.print("Email: ");
        String email = scanner.nextLine().trim();

        try {
            User user = cadastrarUsuario.executar(nome, email);
            System.out.println("✓ Usuário cadastrado com sucesso!");
            System.out.println("  Nome: " + user.getName());
            System.out.println("  Créditos iniciais: " + user.getCredits());
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    static void cadastrarItem() {
        System.out.println("\n[ CADASTRAR ITEM ]");

        List<User> usuarios = usuarioRepo.listarTodos();
        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado. Cadastre um usuário primeiro.");
            return;
        }

        System.out.println("Usuários disponíveis:");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.printf("%d - %s%n", i + 1, usuarios.get(i).getName());
        }
        System.out.print("Escolha o dono do item: ");

        int indice;
        try {
            indice = Integer.parseInt(scanner.nextLine().trim()) - 1;
            if (indice < 0 || indice >= usuarios.size()) {
                System.out.println("Opção inválida!");
                return;
            }
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida!");
            return;
        }

        User dono = usuarios.get(indice);

        System.out.print("Nome do item: ");
        String nome = scanner.nextLine().trim();

        System.out.print("Descrição: ");
        String descricao = scanner.nextLine().trim();

        System.out.println("Categorias: 1-LIVRO  2-ELETRONICO  3-BRINQUEDO  4-ROUPA  5-OUTRO");
        System.out.print("Escolha a categoria: ");

        Categoria categoria;
        try {
            int cat = Integer.parseInt(scanner.nextLine().trim());
            categoria = switch (cat) {
                case 1 -> Categoria.LIVRO;
                case 2 -> Categoria.ELETRONICO;
                case 3 -> Categoria.BRINQUEDO;
                case 4 -> Categoria.ROUPA;
                default -> Categoria.OUTRO;
            };
        } catch (NumberFormatException e) {
            System.out.println("Opção inválida!");
            return;
        }

        System.out.print("Valor em créditos: ");
        int valor;
        try {
            valor = Integer.parseInt(scanner.nextLine().trim());
        } catch (NumberFormatException e) {
            System.out.println("Valor inválido!");
            return;
        }

        try {
            Item item = cadastrarItem.executar(nome, descricao, categoria, dono.getId(), valor);
            System.out.println("✓ Item cadastrado com sucesso!");
            System.out.println("  " + item);
        } catch (IllegalArgumentException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    static void listarItens() {
        System.out.println("\n[ ITENS DISPONÍVEIS ]");
        List<Item> itens = itemRepo.listarDisponiveis();

        if (itens.isEmpty()) {
            System.out.println("Nenhum item disponível.");
            return;
        }

        for (int i = 0; i < itens.size(); i++) {
            System.out.printf("%d - %s%n", i + 1, itens.get(i));
        }
    }

    static void proporTroca() {
        System.out.println("\n[ PROPOR TROCA ]");

        List<User> usuarios = usuarioRepo.listarTodos();
        if (usuarios.size() < 2) {
            System.out.println("É necessário pelo menos 2 usuários cadastrados.");
            return;
        }

        System.out.println("Usuários disponíveis:");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.printf("%d - %s%n", i + 1, usuarios.get(i).getName());
        }

        try {
            System.out.print("Escolha o proponente: ");
            int p = Integer.parseInt(scanner.nextLine().trim()) - 1;

            System.out.print("Escolha o destinatário: ");
            int d = Integer.parseInt(scanner.nextLine().trim()) - 1;

            if (p == d || p < 0 || d < 0 || p >= usuarios.size() || d >= usuarios.size()) {
                System.out.println("Seleção inválida!");
                return;
            }

            User proponente = usuarios.get(p);
            User destinatario = usuarios.get(d);

            PropostaTroca proposta = proporTroca.executar(proponente, destinatario);
            System.out.println("✓ Proposta criada! Status: " + proposta.getStatus());

            System.out.print(destinatario.getName() + ", deseja aceitar a proposta? (s/n): ");
            String resposta = scanner.nextLine().trim().toLowerCase();

            if (resposta.equals("s")) {
                proposta.aceitar();
                System.out.println("✓ Proposta aceita! Status: " + proposta.getStatus());
            } else {
                proposta.recusar();
                System.out.println("✗ Proposta recusada. Status: " + proposta.getStatus());
            }

        } catch (NumberFormatException e) {
            System.out.println("Opção inválida!");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    static void realizarVenda() {
        System.out.println("\n[ REALIZAR VENDA ]");

        List<User> usuarios = usuarioRepo.listarTodos();
        if (usuarios.size() < 2) {
            System.out.println("É necessário pelo menos 2 usuários cadastrados.");
            return;
        }

        System.out.println("Usuários disponíveis:");
        for (int i = 0; i < usuarios.size(); i++) {
            System.out.printf("%d - %s | Saldo: %s%n",
                    i + 1, usuarios.get(i).getName(), usuarios.get(i).getCredits());
        }

        try {
            System.out.print("Escolha o comprador: ");
            int c = Integer.parseInt(scanner.nextLine().trim()) - 1;

            System.out.print("Escolha o vendedor: ");
            int v = Integer.parseInt(scanner.nextLine().trim()) - 1;

            if (c == v || c < 0 || v < 0 || c >= usuarios.size() || v >= usuarios.size()) {
                System.out.println("Seleção inválida!");
                return;
            }

            System.out.print("Valor em créditos: ");
            int valor = Integer.parseInt(scanner.nextLine().trim());

            User comprador = usuarios.get(c);
            User vendedor = usuarios.get(v);

            realizarVenda.executar(comprador, vendedor, valor);
            System.out.println("✓ Venda realizada com sucesso!");
            System.out.printf("  %s → novo saldo: %s%n", comprador.getName(), comprador.getCredits());
            System.out.printf("  %s → novo saldo: %s%n", vendedor.getName(), vendedor.getCredits());

        } catch (NumberFormatException e) {
            System.out.println("Valor inválido!");
        } catch (IllegalArgumentException | IllegalStateException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    static void listarUsuarios() {
        System.out.println("\n[ USUÁRIOS CADASTRADOS ]");
        List<User> usuarios = usuarioRepo.listarTodos();

        if (usuarios.isEmpty()) {
            System.out.println("Nenhum usuário cadastrado.");
            return;
        }

        for (User u : usuarios) {
            System.out.printf("Nome: %-15s | Saldo: %s%n", u.getName(), u.getCredits());
        }
    }
}