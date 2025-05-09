# 🐾 Sistema de Pet Shop

Este é um projeto desenvolvido para a disciplina de Programação Orientada a Objetos. O sistema simula um pet shop com funcionalidades de cadastro de clientes, pets e agendamento de serviços como banho, tosa e consulta veterinária.

## 🎯 Objetivo do Projeto

Implementar um software completo utilizando os principais conceitos de orientação a objetos:

- Classes e Objetos
- Construtores, Atributos e Métodos
- Herança
- Polimorfismo
- Classes Abstratas
- Interface
- Associação e Delegação
- Coleções (`List`)
- Tratamento de Exceções

## 🛠️ Funcionalidades Implementadas

- Cadastro de **clientes**, com nome, CPF, telefone e lista de pets.
- Cadastro de **pets**, com subclasses como `Cachorro` e `Gato`.
- Associação de pets ao cliente dono.
- Listagem de pets por cliente.
- Polimorfismo aplicado para mostrar a descrição de cada pet via método sobrescrito.
- Preparado para futuras extensões: agendamento de serviços e uso de exceções.

## 🔍 Estrutura de Classes

- `Cliente`: representa o cliente do pet shop. Contém lista de pets associados.
- `Pet` *(classe abstrata)*: representa um animal genérico. Contém atributos comuns como nome, idade, porte e dono.
- `Cachorro` e `Gato`: subclasses de `Pet`, cada uma sobrescreve o método `getDescricao()` para descrever o pet adequadamente.

## 📌 Requisitos

- Java JDK 8 ou superior
- IDE de sua preferência (Eclipse, IntelliJ, VS Code, etc.)

## 👥 Equipe

* Lucas Rosendo – [GitHub](https://github.com/LucaRosendo)
* Karleandro Silva – [GitHub](https://github.com/karleandrosilva)

---
