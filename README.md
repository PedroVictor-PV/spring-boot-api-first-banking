# First API - Sistema Bancário

## 📝 Descrição

O **First API** é uma API RESTful desenvolvida em Spring Boot que simula operações bancárias básicas. O sistema permite a criação, consulta e exclusão de contas bancárias, além de operações de depósito e saque. Todos os dados são armazenados em memória durante a execução da aplicação.

## 🎯 Motivo da Criação

Este projeto foi desenvolvido como um estudo prático de APIs REST utilizando o framework Spring Boot. O objetivo principal é demonstrar a implementação de uma API completa seguindo as melhores práticas de desenvolvimento, incluindo:

- Implementação de operações CRUD
- Uso do padrão API-First com OpenAPI
- Validação de dados de entrada
- Tratamento de respostas HTTP adequadas
- Estruturação de projeto seguindo convenções do Spring Boot

## 🛠️ Tecnologias Utilizadas

- **Java 17** - Linguagem de programação
- **Spring Boot 3.5.0** - Framework principal
- **Spring Web** - Para criação de endpoints REST
- **Spring Boot Validation** - Para validação de dados
- **OpenAPI Generator** - Geração automática de código a partir da especificação OpenAPI
- **Swagger Annotations** - Documentação da API
- **Maven** - Gerenciamento de dependências e build
- **JUnit** - Testes unitários

## 📁 Estrutura do Projeto

```
first-api/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── br/com/pedro/first_api/
│   │   │       ├── FirstApiApplication.java
│   │   │       └── controller/
│   │   │           └── AccountController.java
│   │   └── resources/
│   │       ├── account_api_description.yaml
│   │       └── application.properties
│   └── test/
│       └── java/
│           └── br/com/pedro/first_api/
│               └── FirstApiApplicationTests.java
├── pom.xml
├── mvnw
├── mvnw.cmd
└── README.md
```

## ⚡ Funcionalidades

### 🏦 Operações de Conta
- **Criar Conta**: Cadastra uma nova conta bancária no sistema
- **Listar Contas**: Retorna todas as contas cadastradas
- **Deletar Conta**: Remove uma conta específica do sistema

### 💰 Operações Financeiras
- **Depósito**: Adiciona valor ao saldo de uma conta específica
- **Saque**: Remove valor do saldo de uma conta (com validação de saldo suficiente)

## 📋 Pré-requisitos

- **Java 17** ou superior instalado
- **Maven 3.6+** (ou usar o wrapper incluído no projeto)
- **IDE** de sua preferência (IntelliJ IDEA, Eclipse, VS Code)

## 🔧 Características Técnicas

### Arquitetura
- **API-First Design**: Especificação OpenAPI definida antes da implementação
- **RESTful**: Segue os princípios REST para design de APIs
- **Stateless**: Não mantém estado entre requisições
- **In-Memory Storage**: Dados armazenados em HashMap durante execução

### Validações
- Validação de dados de entrada usando Bean Validation
- Verificação de contas existentes antes de operações
- Validação de saldo suficiente para saques

### Tratamento de Erros
- Respostas HTTP apropriadas (200, 201, 400, 404)
- Mensagens de erro descritivas
- Tratamento de casos de negócio (conta não encontrada, saldo insuficiente)

## 🚀 Como Executar

### 1. Clone o repositório
```bash
git clone <url-do-repositorio>
cd first-api
```

### 2. Execute usando Maven Wrapper
```bash
# No Linux/Mac
./mvnw spring-boot:run

# No Windows
mvnw.cmd spring-boot:run
```

### 3. Acesse a aplicação
A API estará disponível em: `http://localhost:8080`

## 📖 Exemplos de Uso

### Criar uma nova conta
```bash
curl -X POST http://localhost:8080/account/create \
  -H "Content-Type: application/json" \
  -d '{
    "accountNumber": "12345",
    "balance": 1000
  }'
```

### Listar todas as contas
```bash
curl -X GET http://localhost:8080/account
```

### Realizar depósito
```bash
curl -X POST http://localhost:8080/account/deposit \
  -H "Content-Type: application/json" \
  -d '{
    "accountNumber": "12345",
    "depositAmount": 500
  }'
```

### Realizar saque
```bash
curl -X POST http://localhost:8080/account/withdraw \
  -H "Content-Type: application/json" \
  -d '{
    "accountNumber": "12345",
    "withdrawAmount": 200
  }'
```

### Deletar conta
```bash
curl -X DELETE http://localhost:8080/account/12345
```

## 🎓 Conceitos Demonstrados

### Spring Boot
- Configuração automática (Auto-configuration)
- Injeção de dependências
- Starter dependencies
- Embedded server

### API Design
- **RESTful principles**: Uso correto de métodos HTTP
- **OpenAPI Specification**: Documentação padronizada
- **Code Generation**: Geração automática de interfaces a partir da spec
- **Response Status Codes**: Uso apropriado de códigos HTTP

### Boas Práticas
- Separação de responsabilidades
- Validação de entrada
- Tratamento de erros consistente
- Nomenclatura clara e descritiva

### Padrões de Projeto
- **Controller Pattern**: Separação da lógica de apresentação
- **API-First Design**: Especificação antes da implementação
- **Repository Pattern**: Abstração do armazenamento de dados (simulado)

## 👨‍💻 Desenvolvedor

**Pedro Victor**
- 📧 Email: pedro.cavalcante0515@gmail.com
- 🐙 GitHub: PedroVictor-PV

---

*Projeto desenvolvido para fins educacionais e demonstração de conceitos de desenvolvimento de APIs REST com Spring Boot.*
