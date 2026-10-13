# Help Desk API - Gerenciamento de Chamados Técnicos

API RESTful desenvolvida com **Java 21** e **Spring Boot 3** para gerenciar e acompanhar o ciclo de vida de chamados de suporte técnico dentro de uma organização.

---

## Sobre o Projeto

A **Help Desk API** foi projetada para resolver o fluxo de atendimento a incidentes de TI, desde a identificação de uma falha por um usuário até a resolução e encerramento do chamado por um técnico responsável.

### Fluxo de Funcionamento

1. **Abertura:** O funcionário identifica um problema (ex: *sem acesso à internet*) e abre um chamado no sistema.
2. **Atendimento:** O técnico visualiza o chamado e inicia o atendimento.
3. **Registro:** Durante o processo, o técnico registra o histórico das ações realizadas.
4. **Encerramento:** O chamado é marcado como resolvido e concluído.

---

## Arquitetura e Tecnologias

### Stack de Tecnologias

- **Java 21** (LTS)
- **Spring Boot 4.x**
- **Spring Security** + **JWT (JSON Web Token)** (Autenticação e Autorização Stateless)
- **Spring Data JPA / Hibernate**
- **H2 Database** (Banco de dados em memória)
- **Bean Validation / @Valid** (Validação de entrada de dados)
- **Lombok** (Produtividade e redução de código boilerplate)
- **SpringDoc OpenAPI / Swagger** (Documentação interativa da API)
- **Apache Maven** (Gerenciamento de dependências)

---

##  Segurança e Autenticação (JWT & RBAC)

O projeto adota uma arquitetura de segurança **Stateless** usando **Spring Security** e **JWT**:
1. **Security Filter Chain:** Intercepta as requisições HTTP antes de chegarem aos *Controllers*.
2. **Autenticação:** O mecanismo valida a assinatura, expiração e *claims* do JWT, estabelecendo a autenticação no `SecurityContext`.
3. **Autorização (RBAC):** O Spring Security valida as permissões e papéis do usuário antes de liberar o acesso aos recursos protegidos.

---

## Organização da Aplicação

| Camada / Pacote | Responsabilidade |
| :--- | :--- |
| **`Controller`** | Recebe requisições HTTP, valida entradas com `@Valid` e retorna as respostas com os devidos status HTTP. |
| **`Service`** | Concentra e executa as regras de negócio e validações de acesso. |
| **`Repository`** | Realiza consultas e persistência no banco de dados utilizando o Spring Data JPA. |
| **`Entity`** | Representa as tabelas do banco de dados e os relacionamentos JPA. |
| **`DTO`** | Define os contratos de entrada e saída da API, protegendo o modelo de domínio. |
| **`Mapper`** | Converte objetos entre DTOs e Entidades. |
| **`Config`** | Centraliza configurações de infraestrutura e beans do Spring. |
| **`Security`** | Implementa filtros, provedores de autenticação, geração e validação do token JWT. |
| **`Exception`** | Define exceções customizadas e centraliza o tratamento global de erros HTTP (`@ControllerAdvice`). |
| **`Enums`** | Representa conjuntos de valores fixos (ex: Status e Prioridade dos Chamados). |

---

## Roteiro de Desenvolvimento

- [x] **Etapa 1:** Preparação e configuração do projeto com Spring Initializr
- [ ] **Etapa 2:** Criação das entidades JPA e relacionamentos
- [ ] **Etapa 3:** Criação dos Repositories
- [ ] **Etapa 4:** Criação dos DTOs e Mappers
- [ ] **Etapa 5:** Implementação das Regras de Negócio (Services)
- [ ] **Etapa 6:** Criação dos Controllers REST
- [ ] **Etapa 7:** Configuração básica de segurança com Spring Security
- [ ] **Etapa 8:** Implementação do JWT e Controle de Acesso Baseado em Perfis (RBAC)
- [ ] **Etapa 9:** Tratamento global de erros e documentação Swagger/OpenAPI
- [ ] **Etapa 10:** Testes de integração, unitários e entrega da avaliação

---

## Configuração e Execução

### Pré-requisitos

- **Java JDK 21**
- **Git**
- IDE de sua preferência (**IntelliJ IDEA**, VS Code, Eclipse, etc.)

### Como executar a aplicação

1. **Clone o repositório:**
   ```bash
   git clone [https://github.com/seu-usuario/helpdesk-api.git](https://github.com/seu-usuario/helpdesk-api.git)
   cd helpdesk-api
