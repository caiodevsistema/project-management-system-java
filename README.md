# Project Management System - Java

A console-based project management system developed in Java as part of my Java learning journey.


## About the Project

This project was developed as a practical exercise to apply Object-Oriented Programming concepts through a project management system.

The system allows users to register an enterprise, developers, projects, and tasks, as well as manage task statuses and calculate estimated project costs.


## Features

- Register an enterprise
- Register a developer
- Register projects
- Associate a developer with a project
- Register programming and testing tasks
- Associate tasks with projects
- Manage task statuses
- Validate task status transitions
- Search projects by ID
- Search tasks by ID
- Validate duplicate IDs
- Remove tasks from a project
- Calculate the estimated cost of each task
- Calculate the total estimated project cost
- Display project summaries
- Display projects registered in the enterprise
- Handle exceptions and validate data


## Technologies

- Java 17
- Eclipse IDE


## Concepts Practiced

- Object-Oriented Programming (OOP)
- Classes and objects
- Encapsulation
- Association
- Composition
- Inheritance
- Polymorphism
- Abstract classes
- Enumerations
- Object collections
- Streams
- Lambda expressions
- Exception handling
- Custom exceptions
- Data validation


## Project Structure

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

### Main Entities

- `Enterprise` — represents the enterprise and maintains the list of projects.
- `Project` — represents a project, its developer, and its tasks.
- `Developer` — represents the developer responsible for the project.
- `Task` — abstract class that represents a task.
- `TaskProgramming` — represents a programming task.
- `TaskTesting` — represents a testing task.
- `TaskStatus` — enum that represents the status of a task.
- `DomainException` — custom exception used to handle business rule violations.


## Object Relationships

The project also demonstrates relationships between objects:

- `Enterprise` has a collection of `Project` objects.
- `Project` has an association with a `Developer`.
- `Project` contains a collection of `Task` objects.
- `TaskProgramming` and `TaskTesting` inherit from the abstract `Task` class.


## Example of Execution

The following example demonstrates the main operations of the system, including:

- Registering an enterprise
- Registering a developer
- Creating a project
- Adding programming and testing tasks
- Changing task status
- Removing a task
- Calculating task and project costs

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

## Next Steps

Continue studying Java and apply new concepts through increasingly complex projects.

Future topics include:

- File handling
- Interfaces
- Generics
- Set and Map
- Functional programming
- Lambda expressions
- Git and GitHub
- Spring Boot
- REST APIs
- Databases
- Automated testing

## Author

**Caio Ferreira**

GitHub: https://github.com/caiodevsistema