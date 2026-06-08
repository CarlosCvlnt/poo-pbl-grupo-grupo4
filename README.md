# Marketplace de Economia Circular

Projeto Prático Integrador — Orientação a Objetos  
Tema 4: Marketplace de Troca de Objetos e Livros  
Curso de Ciências da Computação

---

## Sobre o Projeto

Sistema de Marketplace de Economia Circular onde usuários cadastram itens que não utilizam mais e propõem trocas com base em um sistema de créditos. O projeto implementa o Núcleo de Domínio (Core Domain) da aplicação utilizando conceitos de DDD, OO Avançada e TDD.

---

## Integrantes

| Nome | GitHub |
|------|--------|
| Carlos Cavalcante Felix Carnauba Moura | [@CarlosCvlnt](https://github.com/CarlosCvlnt) |
| Josué dos Santos Lourenço | [@JosueLourenco](https://github.com/JosueLourenco) |
| Pedro Henrique Campos de Andrade | [@peuhx](https://github.com/peuhx) |
| Ruan Guilherme Silva Acioly | [@Ruan-GS](https://github.com/Ruan-GS) |

---

## Arquitetura e Estrutura de Pastas

```
poo-pbl-grupo-grupo4/
├── .github/
│   └── workflows/
│       └── ci.yml                  <- Pipeline CI/CD (GitHub Actions)
├── src/
│   ├── domain/                     <- Núcleo de domínio (DDD)
│   │   ├── negotiation/            <- Contexto: Negociação / Matchmaking
│   │   │   ├── PropostaTroca.java
│   │   │   ├── StatusProposta.java
│   │   │   └── Venda.java
│   │   ├── system/                 <- Contexto: Inventário de Itens
│   │   │   ├── Categoria.java
│   │   │   ├── ItemId.java
│   │   │   └── Objeto.java
│   │   └── user/                   <- Contexto: Usuários e Créditos
│   │       ├── Creditos.java
│   │       ├── Email.java
│   │       ├── User.java
│   │       └── UserId.java
│   └── main/
│       └── java/org/example/
│           └── Main.java           <- Ponto de entrada da aplicação
├── tests/
│   └── domain/
│       ├── negotiation/
│       │   ├── PropostaTrocaTest.java
│       │   └── VendaTest.java
│       └── user/
│           ├── CreditosTest.java
│           ├── EmailTest.java
│           ├── UserIdTest.java
│           └── UserTest.java
├── project-meta.json
└── pom.xml
```

---

## Domain-Driven Design (DDD)

O projeto é dividido em 3 contextos de domínio, seguindo o tema do Marketplace de Economia Circular:

### Contexto 1 — Inventário de Itens (`domain/system`)
Gerencia os itens cadastrados pelos usuários na plataforma.

| Classe | Tipo DDD | Responsabilidade |
|--------|----------|-----------------|
| `Objeto` | Entidade | Representa um item cadastrado (livro, brinquedo, eletrônico) |
| `Categoria` | Entidade | Define o tipo do item e seu valor em créditos |
| `ItemId` | Value Object | Identificador único e imutável de um item |

### Contexto 2 — Sistema de Créditos (`domain/user`)
Controla os usuários e o sistema de pontuação por créditos.

| Classe | Tipo DDD | Responsabilidade |
|--------|----------|-----------------|
| `User` | Entidade (Aggregate Root) | Usuário da plataforma com saldo de créditos |
| `Creditos` | Value Object | Saldo imutável de créditos do usuário |
| `Email` | Value Object | E-mail validado e imutável |
| `UserId` | Value Object | Identificador único e imutável do usuário |

### Contexto 3 — Negociação / Matchmaking (`domain/negotiation`)
Gerencia as propostas de troca e vendas entre usuários.

| Classe | Tipo DDD | Responsabilidade |
|--------|----------|-----------------|
| `PropostaTroca` | Entidade | Proposta de troca entre dois usuários |
| `Venda` | Entidade | Transação de compra e venda com créditos |
| `StatusProposta` | Enum | Estados da proposta: PENDENTE, ACEITA, RECUSADA |

---

## Regras de Negócio

- Créditos são imutáveis — toda operação retorna um novo objeto `Creditos`
- Um usuário não pode gastar mais créditos do que possui
- Uma proposta de troca já finalizada (aceita ou recusada) não pode ser alterada
- Categorias de itens possuem valores de crédito predefinidos:
  - Livro: 250 créditos
  - Brinquedo: 150 créditos
  - Eletronico: 500 créditos
- E-mails são validados por expressão regular na criação
- Nomes de usuário não podem ser vazios ou nulos

---

## Testes (TDD)

O projeto segue o ciclo Red -> Green -> Refactor do TDD. Os testes cobrem cenários de sucesso e falha para todas as classes do domínio.

### Executar os testes

```bash
mvn test
```

### Cobertura de testes

| Classe | Cenários testados |
|--------|------------------|
| `Creditos` | Criar válido/inválido/zero, somar, subtrair, créditos insuficientes |
| `Email` | Aceitar válido, rejeitar inválido/vazio/nulo |
| `UserId` | Criar válido, rejeitar vazio/nulo, gerar único, igualdade |
| `User` | Criar válido, rejeitar nome/email inválido, ganhar/gastar créditos, desativar |
| `PropostaTroca` | Criar pendente, aceitar, recusar |
| `Venda` | Realizar venda com transferência correta de créditos |

---

## Como Executar

### Pré-requisitos

- Java 17+
- Maven 3.8+

### Clonar o repositório

```bash
git clone https://github.com/CarlosCvlnt/poo-pbl-grupo-grupo4.git
cd poo-pbl-grupo-grupo4
```

### Compilar e rodar

```bash
mvn compile
mvn exec:java -Dexec.mainClass="org.example.Main"
```

### Rodar os testes

```bash
mvn test
```

---

## CI/CD — GitHub Actions

A cada push ou Pull Request na branch main, o pipeline executa automaticamente:

1. Checkout do código
2. Setup do Java 17
3. Build com Maven (`mvn compile`)
4. Execução de todos os testes (`mvn test`)

O build só passa se todos os testes estiverem verdes.

---

## Tecnologias

| Tecnologia | Versão | Uso |
|------------|--------|-----|
| Java | 17 | Linguagem principal |
| Maven | 3.8+ | Gerenciamento de dependências |
| JUnit 5 | 5.x | Testes unitários |
| GitHub Actions | — | CI/CD |

---

## Licença

Projeto acadêmico desenvolvido para a disciplina de Orientação a Objetos.
