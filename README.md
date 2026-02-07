# Projeto JPA com Spring Boot

Este projeto foi desenvolvido como parte do **Curso Java Completo**, com o objetivo principal de **treinar e consolidar conceitos de JPA/Hibernate**, mapeamento objeto-relacional e arquitetura em camadas utilizando **Spring Boot**.

O sistema simula um **mini e-commerce**, contendo usuários, pedidos, produtos, categorias e pagamentos, seguindo boas práticas de modelagem e organização de código.

---

## 🎯 Objetivos do Projeto

* Praticar **JPA e Hibernate** na prática
* Trabalhar com **relacionamentos entre entidades** (OneToMany, ManyToMany, OneToOne)
* Aplicar **arquitetura em camadas** (Resource, Service, Repository)
* Utilizar **Spring Boot** para configuração e execução do projeto
* Criar um ambiente de testes com **perfil `test`** e carga automática de dados

---

## 🧩 Modelo de Domínio

O projeto é baseado em um modelo clássico de pedidos:

* **User**: representa o cliente do sistema
* **Order**: representa um pedido realizado por um usuário
* **OrderItem**: item intermediário entre pedido e produto (com quantidade e preço)
* **Product**: produtos disponíveis
* **Category**: categorias dos produtos
* **Payment**: pagamento associado a um pedido
* **OrderStatus (enum)**: status do pedido

Principais relacionamentos:

* Um **User** pode ter vários **Orders**
* Um **Order** possui vários **OrderItems**
* Um **Product** pode pertencer a várias **Categories** (ManyToMany)
* Um **Order** pode ter **um Payment** (OneToOne)

---

## 🏗️ Arquitetura do Projeto

O projeto segue uma arquitetura em camadas bem definida:

* **Resource Layer (Controllers)**
  Responsável por expor os endpoints REST

* **Service Layer**
  Contém a lógica de negócio e regras da aplicação

* **Data Access Layer (Repositories)**
  Interfaces JPA responsáveis pela comunicação com o banco de dados

* **Entities**
  Classes de domínio mapeadas com JPA

Essa separação facilita manutenção, testes e evolução do sistema.

---

## ⚙️ Classe de Configuração (TestConfig)

A classe `TestConfig` é utilizada **exclusivamente no perfil `test`** e implementa `CommandLineRunner`, permitindo que dados sejam inseridos automaticamente no banco assim que a aplicação é iniciada.

### Principais responsabilidades:

* Criar categorias, usuários, produtos e pedidos
* Persistir dados utilizando os **Repositories**
* Configurar relacionamentos entre entidades
* Criar itens de pedido (`OrderItem`)
* Associar pagamento a um pedido

Isso permite testar rapidamente o sistema sem necessidade de inserção manual de dados.

---

## 🧪 Perfil de Teste

O uso da anotação:

```java
@Profile("test")
```

garante que essa configuração seja carregada **apenas quando o perfil `test` estiver ativo**, evitando impacto em ambientes de produção.

---

## 🚀 Tecnologias Utilizadas

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* Banco de dados H2 (ambiente de testes)
* Maven

---

## ▶️ Como Executar o Projeto

1. Clone o repositório
2. Importe o projeto em sua IDE (Eclipse, IntelliJ, VS Code)
3. Execute a aplicação com o perfil `test`
4. A aplicação iniciará já com dados carregados no banco

---

## 📌 Considerações Finais

Este projeto tem foco **didático**, servindo como base sólida para entender como funciona o JPA em aplicações reais com Spring Boot. Ele pode ser facilmente expandido com autenticação, DTOs, validações e novos endpoints.

Projeto desenvolvido para **aprendizado e prática**, reforçando conceitos fundamentais de backend Java.

---

✍️ Desenvolvido por **Gabriel Salermo**
