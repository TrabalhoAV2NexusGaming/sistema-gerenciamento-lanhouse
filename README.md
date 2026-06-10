NEXUS GAMING SYSTEM
DOCUMENTAÇÃO DO PROJETO

Disciplina: Programação Orientada a Objetos

Integrantes:

- Eduardo Reichel Vieira
- Rafael Alves Gubetti
- Luiz Henrique Altini

1. OBJETIVO DO SISTEMA

O Nexus Gaming System foi desenvolvido com o objetivo de auxiliar
o gerenciamento de uma Lan House/Gaming Lab.

O sistema permite controlar:

- Clientes
- Equipamentos
- Sessões
- Funcionários
- Promoções
- Pagamentos

utilizando interface gráfica Java Swing e persistência em banco de
dados MySQL.

O projeto foi desenvolvido aplicando os conceitos de Programação
Orientada a Objetos, Interface Gráfica, Eventos, JDBC,
Herança, Interfaces, Enumerações e Banco de Dados Relacional.

=========================================================
2. TECNOLOGIAS UTILIZADAS
=========================================================

Linguagem:
- Java

IDE:
- Eclipse IDE

Banco de Dados:
- MySQL

Controle de Versão:
- GitHub

Modelagem:
- Draw.io

Bibliotecas:
- JDBC
- Swing

=========================================================
3. REFERÊNCIAS UTILIZADAS
=========================================================

Base principal:

FURGERI, Sérgio.
Java 8 - Ensino Didático:
Desenvolvimento e Implementação de Aplicações.
Editora Érica, 2015.

Capítulo 7:
Classes e Objetos

Capítulo 8:
Interfaces Gráficas Swing

Capítulo 9:
Eventos e ActionListener

Capítulo 10:
Herança, Interfaces e Enumerações

Capítulo 12:
JDBC e Persistência em Banco de Dados

Disponível em:
https://app.minhabiblioteca.com.br/

=========================================================
4. ESTRUTURA DO PROJETO
=========================================================

src

├── connection
│   └── ConexaoMySQL
│
├── controller
│   ├── ClienteController
│   ├── EquipamentoController
│   ├── FuncionarioController
│   ├── LoginController
│   ├── PagamentoController
│   ├── PromocaoController
│   └── SessaoController
│
├── dao
│   ├── ClienteDAO
│   ├── EquipamentoDAO
│   ├── FuncionarioDAO
│   ├── PagamentoDAO
│   ├── PromocaoDAO
│   └── SessaoDAO
│
├── enums
│   ├── CargoFuncionario
│   ├── StatusEquipamento
│   └── TipoPagamento
│
├── interfaces
│   └── Autenticavel
│
├── model
│   ├── Cliente
│   ├── Equipamento
│   ├── Computador
│   ├── Console
│   ├── Funcionario
│   ├── Pagamento
│   ├── Promocao
│   └── Sessao
│
├── view
│   ├── TelaLogin
│   ├── TelaPrincipal
│   ├── TelaCliente
│   ├── TelaEquipamento
│   ├── TelaFuncionario
│   ├── TelaPagamento
│   ├── TelaPromocao
│   └── TelaSessao
│
└── main
    └── Main

=========================================================
5. DIAGRAMA UML
=========================================================

O relacionamento completo das classes está descrito
no arquivo:

NexusGamingSystem-UML.drawio

e também exportado em PDF.

O UML apresenta:

✔ Classes
✔ Herança
✔ Interfaces
✔ Enumerações
✔ Associações
✔ Multiplicidades

Principais relacionamentos:

- Computador herda de Equipamento
- Console herda de Equipamento
- Funcionario implementa Autenticavel
- Cliente possui Sessões
- Sessão utiliza Equipamento
- Sessão possui Pagamento
- Sessão pode utilizar Promoção

=========================================================
6. BANCO DE DADOS
=========================================================

Banco utilizado:

nexus_gaming_system

Tabelas:

- clientes
- equipamentos
- funcionarios
- promocoes
- sessoes
- pagamentos

Arquivos SQL:

- criar_banco.sql
- popular_banco.sql

O banco de dados é acessado através da classe
ConexaoMySQL e das classes DAO utilizando JDBC.

=========================================================
7. FUNCIONALIDADES IMPLEMENTADAS
=========================================================

✔ Login do sistema

✔ Cadastro de Clientes

✔ Cadastro de Equipamentos

✔ Cadastro de Funcionários

✔ Cadastro de Promoções

✔ Controle de Sessões

✔ Registro de Pagamentos

✔ Persistência em Banco de Dados MySQL

✔ Interface Gráfica Swing

✔ Integração JDBC

✔ Herança

✔ Interfaces

✔ Enumerações

✔ Organização em Camadas (MVC + DAO)

=========================================================
8. ARQUITETURA DO SISTEMA
=========================================================

O projeto foi organizado utilizando separação em camadas.

VIEW
↓
CONTROLLER
↓
DAO
↓
MYSQL

Fluxo de exemplo:

TelaCliente
↓
ClienteController
↓
ClienteDAO
↓
Banco MySQL

TelaEquipamento
↓
EquipamentoController
↓
EquipamentoDAO
↓
Banco MySQL

TelaSessao
↓
SessaoController
↓
SessaoDAO
↓
Banco MySQL

=========================================================
9. DIVISÃO DAS ATIVIDADES
=========================================================

Eduardo Reichel Vieira

Responsável por:

- Modelagem e criação do Banco de Dados
- Scripts SQL
- Classe ConexaoMySQL
- Implementação das classes DAO
- Integração JDBC com MySQL
- Testes de persistência de dados

---------------------------------------------------------

Rafael Alves Gubetti

Responsável por:

- Classes Model
- Herança entre Equipamento, Computador e Console
- Interface Autenticavel
- Enumerações do sistema
- Regras de negócio das entidades

---------------------------------------------------------

Luiz Henrique Altini

Responsável por:

- Interfaces gráficas Swing
- Controllers
- Navegação do sistema
- Eventos ActionListener
- Modelagem UML
- Organização visual do projeto

=========================================================
10. MELHORIAS FUTURAS
=========================================================

As próximas versões do sistema poderão incluir:

- Login utilizando autenticação em banco de dados
- Controle financeiro completo
- Relatórios gerenciais
- Dashboard administrativo
- Estatísticas de utilização
- Ranking de clientes
- Sistema de fidelidade avançado
- Controle de caixa
- Emissão de comprovantes

=========================================================
11. GITHUB
=========================================================

Repositório do Projeto:

https://github.com/TrabalhoAV2NexusGaming/sistema-gerenciamento-lanhouse.git

Branches:

- main
- branch-eduardo
- branch-rafael
- branch-luiz

O desenvolvimento foi realizado utilizando GitHub,
permitindo o versionamento do código e o trabalho
colaborativo entre os integrantes da equipe.

=========================================================
12. CONCLUSÃO
=========================================================

O Nexus Gaming System atingiu os objetivos propostos
para a disciplina, aplicando conceitos de Programação
Orientada a Objetos, Interface Gráfica, Persistência
de Dados e Banco de Dados Relacional.

O sistema apresenta uma estrutura organizada em camadas,
com separação entre Model, View, Controller e DAO,
utilizando Java, Swing e MySQL.

Além de atender aos requisitos do trabalho, o projeto
foi desenvolvido visando futura expansão e manutenção,
permitindo a adição de novas funcionalidades sem
impactar significativamente sua arquitetura.

=========================================================
FIM DA DOCUMENTAÇÃO
=========================================================
