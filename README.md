# crudSpringBootJpaThymeleaf

CRUD completo de usuários com Spring Boot, JPA e páginas renderizadas no servidor com Thymeleaf.

> Projeto de estudo (março/2022) para praticar o ciclo clássico de uma aplicação web MVC: formulário, persistência, listagem, edição e exclusão.

## Stack

- Java 11
- Spring Boot 2.6.4 (Web, Data JPA, Thymeleaf, DevTools)
- Bootstrap 4.3.1 via WebJars
- MySQL

## Modelo

`Usuario`

| Campo       | Tipo     |
|-------------|----------|
| `usuarioID` | `Long`   |
| `nome`      | `String` |
| `email`     | `String` |
| `cpf`       | `String` |

## Rotas

| Método | Rota                          | Descrição                        |
|--------|-------------------------------|----------------------------------|
| `GET`  | `/`                           | Página inicial                   |
| `GET`  | `/usuarios`                   | Lista os usuários                |
| `GET`  | `/usuarios/novo`              | Formulário de cadastro           |
| `POST` | `/usuario/salvar`             | Salva um usuário (novo ou edição)|
| `GET`  | `/usuarios/editar/{id}`       | Formulário preenchido para edição|
| `GET`  | `/usuarios/deletar/{id}`      | Remove o usuário                 |

Quando o id informado não existe, o serviço lança `UserNotFoundException`.

## Como rodar

Crie o schema no MySQL:

```sql
CREATE DATABASE projetospring;
```

O `application.properties` aponta para `jdbc:mysql://localhost:3306/projetospring` com usuário `root` e senha vazia — ajuste conforme o seu ambiente. As tabelas são criadas pelo Hibernate (`ddl-auto=update`).

```bash
./mvnw spring-boot:run
```

Acesse <http://localhost:8080>.

## Limitações

As credenciais do banco estão no `application.properties` em vez de variáveis de ambiente. A exclusão acontece via `GET`, o que não é o verbo correto para uma operação destrutiva. Não há validação dos campos nem máscara de CPF.
