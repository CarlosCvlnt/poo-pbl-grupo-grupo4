## Marketplace de Economia Circular

Projeto Prático Integrador — Orientação a Objetos  
Tema 4: Marketplace de Troca de Objetos e Livros  
Curso de Ciências da Computação

---
## Descrição

Plataforma onde usuários cadastram itens que não utilizam mais e realizam trocas ou vendas com outros usuários através de um sistema de créditos. Ao se cadastrar, cada usuário recebe 100 créditos iniciais. Os créditos circulam entre os usuários conforme as vendas são realizadas, promovendo uma economia circular real.

---

## Tecnologias

- Java 25
- Maven
- JUnit 5
- GitHub Actions (CI)

---

## Estrutura do Projeto

```
├── .github/
│   └── workflows/
│       └── ci.yml
├── src/
│   ├── domain/
│   │   ├── user/
│   │   │   ├── User.java
│   │   │   ├── UserId.java
│   │   │   ├── Email.java
│   │   │   └── Creditos.java
│   │   ├── item/
│   │   │   ├── Item.java
│   │   │   ├── ItemId.java
│   │   │   └── Categoria.java
│   │   └── negotiation/
│   │       ├── PropostaTroca.java
│   │       ├── StatusProposta.java
│   │       └── Venda.java
│   └── main/java/org/example/
│       └── Main.java
├── application/
│   ├── CadastrarUsuario.java
│   ├── CadastrarItem.java
│   ├── ProporTroca.java
│   └── RealizarVenda.java
├── infrastructure/
│   ├── UsuarioRepositorio.java
│   ├── ItemRepositorio.java
│   └── NegociacaoRepositorio.java
├── tests/
│   └── domain/
│       ├── user/
│       │   ├── UserTest.java
│       │   ├── UserIdTest.java
│       │   ├── EmailTest.java
│       │   └── CreditosTest.java
│       ├── item/
│       │   ├── ItemTest.java
│       │   └── ItemIdTest.java
│       └── negotiation/
│           ├── PropostaTrocaTest.java
│           └── VendaTest.java
├── project-meta.json
├── pom.xml
└── README.md
```

---

## Arquitetura

O projeto segue os princípios de **Domain-Driven Design (DDD)**:

**Domain** — núcleo do sistema com entidades, value objects e regras de negócio. Dividido em três contextos:

| Contexto      | Responsabilidade |
|---------------|---|
| `user`        | Gerencia usuários e o sistema de créditos |
| `item`        | Gerencia o inventário de itens disponíveis para troca |
| `negotiation` | Gerencia propostas de troca e vendas entre usuários |

**Application** — casos de uso que orquestram o domínio para executar ações do sistema.

**Infrastructure** — repositórios em memória para persistência dos dados durante a execução.

**Presentation** — interface interativa pelo terminal onde o usuário realiza todas as ações do sistema.

---

## Fluxo do Sistema

```
1. Usuário se cadastra        → recebe 100 créditos de bônus
2. Usuário cadastra um item   → item fica disponível no marketplace
3. Outro usuário compra       → créditos transferidos entre usuários
4. Usuário propõe troca       → destinatário aceita ou recusa
5. Economia circular          → créditos circulam entre os usuários
```

---

## Como Executar os Testes

```bash
mvn clean test
```

---

## Como Executar o Sistema

```bash
mvn clean compile exec:java -Dexec.mainClass="org.example.Main"
```

---

## Menu do Sistema

```
╔══════════════════════════════════════╗
║   MARKETPLACE DE ECONOMIA CIRCULAR   ║
╚══════════════════════════════════════╝

[ MENU PRINCIPAL ]
1 - Cadastrar usuário
2 - Cadastrar item
3 - Listar itens disponíveis
4 - Propor troca
5 - Realizar venda
6 - Listar usuários
0 - Sair
```

---

## Testes

O projeto foi desenvolvido seguindo TDD — os testes foram escritos antes do código, garantindo cobertura de cenários de sucesso e falha para todas as classes do domínio.

| Classe | Testes |
|---|---|
| EmailTest | 4 |
| CreditosTest | 12 |
| UserTest | 7 |
| UserIdTest | 5 |
| ItemTest | 10 |
| ItemIdTest | 5 |
| PropostaTrocaTest | 7 |
| VendaTest | 4 |
| **Total** | **54** |

---

## CI/CD

A cada Push ou Pull Request na branch `main`, o GitHub Actions executa automaticamente o build e todos os testes unitários. O merge só é liberado com o pipeline verde.

---

## Equipe

| Nome | GitHub |
|------|--------|
| Carlos Cavalcante Felix Carnauba Moura | [@CarlosCvlnt](https://github.com/CarlosCvlnt) |
| Josué dos Santos Lourenço | [@JosueLourenco](https://github.com/JosueLourenco) |
| Pedro Henrique Campos de Andrade | [@peuhx](https://github.com/peuhx) |
| Ruan Guilherme Silva Acioly | [@Ruan-GS](https://github.com/Ruan-GS) |
