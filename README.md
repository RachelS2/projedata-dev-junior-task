# 💻 Desafio Técnico – Desenvolvedora Júnior

Este repositório contém a minha solução para o desafio técnico proposto para a vaga de Desenvolvedora Júnior da área Fiscal/Contábil da empresa Projedata.

## 🚀 Tecnologias utilizadas

* Java
* API de datas (`LocalDate`, `Period`)
* `BigDecimal` para cálculos financeiros
* Streams e Collections

---

## 📋 Funcionalidades implementadas

O projeto realiza operações sobre uma lista de funcionários, incluindo:

* Inserção de funcionários (seguindo a tabela de dados enviada no desafio)
* Remoção de funcionário específico (João)
* Impressão de dados com formatação:
  * Datas no formato `dd/MM/yyyy`
  * Valores monetários no padrão brasileiro
* Aplicação de aumento salarial de 10%
* Agrupamento de funcionários por função
* Filtro de funcionários por mês de aniversário (outubro e dezembro)
* Identificação do funcionário com maior idade
* Ordenação alfabética da lista
* Cálculo do total dos salários
* Cálculo de quantos salários mínimos cada funcionário recebe

---

## 🧠 Decisões técnicas

* Uso de Programação Orientada a Objetos (POO) na solução (classes, métodos, atributos, modificadores de acesso, segregação de responsabilidades) 
* Uso de `BigDecimal` para evitar problemas de precisão em cálculos financeiros
* Utilização de `enum` para representar cargos dos funcionários, garantindo segurança de tipo
* Uso de Streams para operações de filtragem, ordenação e agrupamento
* Sobrescrita do método `toString()` para facilitar a exibição dos dados
* Métodos para formatação de moeda e data nas classes Funcionário e Pessoa, utilizando sobrecarga.

---

## ▶️ Como executar

1. Clone o repositório:

```
git clone https://github.com/RachelS2/projedata-dev-junior-task.git
```

2. Abra o projeto em sua IDE (utilizado: IntelliJ)

3. Execute a classe `Principal`

---

## 📌 Observações

Este projeto foi desenvolvido como parte de um teste técnico, com foco em demonstrar:

* organização de código
* boas práticas em Java
* clareza na implementação

---

## 👩‍💻 Autora e Desenvolvedora

Rachel Barino Silva
