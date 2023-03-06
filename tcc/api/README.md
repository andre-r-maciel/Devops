# Assombrados API

Assombrados é uma rede social para compartilhar experiências, causos e provas de fenômenos sobrenaturais.

Os funcionalidade da API são:

- Cadastro de usuário
- Login de usuário
- logout de usuário
- Editar informações de usuário
- Mostrar informações de usuários
- Pesquisar por usuários
- Enviar solicitação de amizade
- Aceitar amizade
- Desfazer amizade
- Listar solicitações de amizade
- Listar amigos
- Publicar post
- Listar feed de usuário
- Listar todos posts de um usuário
- Listar apenas posts públicos de usuário
- Curtir post
- Descurtir post
- Contar curtidas de um post
- Comentar um post
- Listar todos comentários de um post

Informações para acessar o banco de dados
- url: jdbc:postgresql://localhost:5432/Assombrados
- username: assombrados
- password: 123456

Na pasta data
- Arquivo schema para popular banco de dados
- Arquivo Insomnia_Collection para testes de endpoints

Configuraçoes da Api
- Project: Maven
- Language: Java
- Spring Boot: 2.7.9
- Project Metadata:
  
Project Metadata
- Group: br.com.cwi.crescer
- Packaging: Jar
- Java: 11

Dependencies
- Spring Web
- Spring Data JPA
- PostgreSQL Driver
- Validation
- Spring Boot Actuator
- Lombok
- Spring Security