# Project Management System - Java

Sistema de gerenciamento de projetos desenvolvido em Java como projeto prático de estudos em Java

## Sobre o projeto

O sistema permite cadastrar uma empresa, desenvolvedores, projetos e tarefas, além de controlar o status das tarefas e calcular os custos estimados dos projetos.

## Tecnologias

- Java 17
- Eclipse IDE

## Como executar

1. Clone o repositório.
2. Abra o projeto em uma IDE compatível com Java.
3. Utilize o Java 17 ou superior.
4. Execute a classe `Program.java`.

## Conceitos praticados

- Java
- Programação Orientada a Objetos
- Classes e objetos
- Encapsulamento
- Associação
- Composição
- Herança
- Polimorfismo
- Classes abstratas
- Enumerações
- Listas de objetos
- Streams
- Lambda expressions
- Tratamento de exceções
- Exceções personalizadas
- Validação de dados

## Estrutura do projeto

```text
src
├── application
│   └── Program.java
│
└── model
    └── entities
        ├── Developer.java
        ├── DomainException.java
        ├── Enterprise.java
        ├── Project.java
        ├── Task.java
        ├── TaskProgramming.java
        ├── TaskTesting.java
        │
        └── enums
            └── TaskStatus.java
```

## Código Java

O projeto foi desenvolvido utilizando programação orientada a objetos, com separação das responsabilidades entre as entidades do sistema.

### Principais entidades

- `Enterprise` — representa a empresa e mantém a lista de projetos.
- `Project` — representa um projeto, seu desenvolvedor e suas tarefas.
- `Developer` — representa o desenvolvedor responsável pelo projeto.
- `Task` — classe abstrata que representa uma tarefa.
- `TaskProgramming` — representa uma tarefa de programação.
- `TaskTesting` — representa uma tarefa de testes.
- `TaskStatus` — enumeração que representa o status da tarefa.
- `DomainException` — exceção personalizada utilizada para validação das regras de negócio.

### Organização das responsabilidades

A classe `Program` é responsável pela interação com o usuário através do console, enquanto as classes do pacote `model.entities` concentram os dados e as regras de negócio do sistema.

O projeto utiliza:

- Encapsulamento;
- Associação entre objetos;
- Composição;
- Herança;
- Polimorfismo;
- Classes abstratas;
- Enumerações;
- Listas de objetos;
- Streams e expressões lambda;
- Tratamento de exceções;
- Exceções personalizadas;
- Validação de dados.

## Funcionalidades

- Cadastro de empresa.
- Cadastro de desenvolvedor.
- Cadastro de projetos.
- Associação de um desenvolvedor a um projeto.
- Cadastro de tarefas de programação e de testes.
- Associação de tarefas aos projetos.
- Controle do status das tarefas:
  - PENDING;
  - IN_PROGRESS;
  - COMPLETED.
- Validação das transições de status das tarefas.
- Busca de projetos por ID.
- Busca de tarefas por ID.
- Validação de IDs duplicados.
- Remoção de tarefas de um projeto.
- Cálculo do custo estimado de cada tarefa.
- Cálculo do custo total estimado do projeto.
- Exibição do resumo do projeto.
- Exibição dos projetos cadastrados na empresa.
- Tratamento de exceções e validação de dados.

## Exemplo de execução

Abaixo está um exemplo de execução do sistema, demonstrando o cadastro de uma empresa, desenvolvedor, projeto e tarefas, além da alteração de status, remoção de tarefa e cálculo dos custos.

```text
========== PROJECT MANAGEMENT SYSTEM ==========

Enterprise: MO VASCONCELOS

Enter Developer data:
ID: 1
Name: Carlos Silva
Hourly Rate: R$ 80.00

Enter Project data:
ID: 1
Name: Sistema de Vendas
Developer: Carlos Silva

How many tasks to add? 2

Enter Task #1:
ID: 1
Description: Implementação da API de Clientes
Programming task or testing task (p/t)?: p
Additional information: Java
Estimated hours: 10

Task added successfully!

Enter Task #2:
ID: 2
Description: Implementação de Testes
Programming task or testing task (p/t)?: t
Additional information: Integração de Testes
Estimated hours: 5

Task added successfully!

========== PROJECT SUMMARY ==========

Project: Sistema de Vendas
Developer: Carlos Silva
Hourly rate: R$ 80.00
Number of tasks: 2

#TASKS:

Id: 1
Description: Implementação da API de Clientes
Type: ProgrammingTask
Additional Information: Java
Estimated hours: 10
Status: PENDING
Estimated Cost Of Task: R$ 800.00

Id: 2
Description: Implementação de Testes
Type: TestingTask
Additional Information: Integração de Testes
Estimated hours: 5
Status: PENDING
Estimated Cost Of Task: R$ 400.00

PENDING: 2
IN_PROGRESS: 0
COMPLETED: 0

Total Estimated Cost: R$ 1200.00

Edit task status
Enter the ID task: 1

Id: 1
Description: Implementação da API de Clientes
Type: ProgrammingTask
Additional Information: Java
Estimated hours: 10
Status: PENDING

Enter the new Status: IN_PROGRESS

Task Status edited successfully!

Id: 1
Description: Implementação da API de Clientes
Type: ProgrammingTask
Additional Information: Java
Estimated hours: 10
Status: IN_PROGRESS

Do you want to continue editing (y/n)?: n

========== PROJECT SUMMARY ==========

Project: Sistema de Vendas
Developer: Carlos Silva
Hourly rate: R$ 80.00
Number of tasks: 2

#TASKS:

Id: 1
Description: Implementação da API de Clientes
Type: ProgrammingTask
Additional Information: Java
Estimated hours: 10
Status: IN_PROGRESS
Estimated Cost Of Task: R$ 800.00

Id: 2
Description: Implementação de Testes
Type: TestingTask
Additional Information: Integração de Testes
Estimated hours: 5
Status: PENDING
Estimated Cost Of Task: R$ 400.00

PENDING: 1
IN_PROGRESS: 1
COMPLETED: 0

Total Estimated Cost: R$ 1200.00

Task Remove:
Enter the ID: 2

Task removed successfully!

========== PROJECT SUMMARY ==========

Project: Sistema de Vendas
Developer: Carlos Silva
Hourly rate: R$ 80.00
Number of tasks: 1

#TASKS:

Id: 1
Description: Implementação da API de Clientes
Type: ProgrammingTask
Additional Information: Java
Estimated hours: 10
Status: IN_PROGRESS
Estimated Cost Of Task: R$ 800.00

PENDING: 0
IN_PROGRESS: 1
COMPLETED: 0

Total Estimated Cost: R$ 800.00

#STATUS DETAILS:
[1] Implementação da API de Clientes
Status: IN_PROGRESS

======== ENTERPRISE SUMMARY =========

ID: 1
Project: Sistema de Vendas
Developer: Carlos Silva
Hourly rate: R$ 80.00
Number of tasks: 1
Total Estimated Cost: R$ 800.00

Do you want to continue (y/n)?: 
```

## Próximos passos

- Adicionar persistência de dados em banco de dados.
- Criar uma API REST utilizando Spring Boot.
- Implementar testes automatizados.
- Melhorar o tratamento e a validação das entradas.
- Adicionar novas funcionalidades ao gerenciamento de projetos e tarefas.
                      