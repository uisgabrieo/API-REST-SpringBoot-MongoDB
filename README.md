# API REST com Spring Boot e MongoDB

Este projeto foi desenvolvido como parte dos meus estudos em Spring Boot e MongoDB, com o objetivo de consolidar conhecimentos sobre desenvolvimento back-end e integração com banco de dados NoSQL. 

O sistema implementa um CRUD básico de usuários e postagens, utilizando o framework Spring para a construção de uma API RESTful e o MongoDB como banco de dados para armazenamento dos dados.

## Tecnologias Utilizadas

- **Java**: Linguagem principal do projeto.
- **Spring Framework**: Para facilitar a criação de aplicações robustas e escaláveis.
  - **Spring Boot**: Configurações simplificadas para inicialização do projeto.
  - **Spring Data MongoDB**: Integração com o MongoDB para manipulação de dados.
  - **Spring Web**: Para criação de APIs REST.
- **Banco de Dados**:
  - **MongoDB**: Banco de dados NoSQL utilizado para persistência.
- **Maven**: Gerenciador de dependências.

## Funcionalidades

- Criação, leitura, atualização e exclusão (CRUD) de usuários e postagens.
- Relacionamento entre usuários e postagens.
- Endpoints RESTful para interação com o sistema.

## Estrutura do Projeto

O projeto segue uma estrutura organizada para facilitar a manutenção e a escalabilidade:

````
src/main/java/
 ├── com.springboot.mongoDB
    ├── config/           # Configurações do MongoDB
    ├── resource/         # Controladores REST (PostResource, UserResource)
    ├── entities/         # Modelos das entidades (Post, User)
    ├── repository/       # Interfaces para acesso aos dados (MongoDB Repositories)
    ├── service/          # Lógica de negócios (PostService, UserService)
````

## Endpoints Principais

### **Usuários**

- **GET /users**: Retorna todos os usuários cadastrados.  
- **GET /users/{id}**: Retorna os detalhes de um usuário específico.  
- **POST /users**: Cria um novo usuário com base nos dados enviados no corpo da requisição.  
- **PUT /users/{id}**: Atualiza os dados de um usuário existente com base no `id` informado.  
- **DELETE /users/{id}**: Remove um usuário com base no `id` informado.  
- **GET /users/{id}/posts**: Retorna todos os posts associados a um usuário específico.  

---

### **Postagens**

- **GET /posts/{id}**: Retorna os detalhes de uma postagem específica com base no `id`.  
- **GET /posts/titlesearch?text={text}**: Retorna uma lista de postagens cujo título contém o texto especificado no parâmetro `text`.  
- **GET /posts/fullsearch?text={text}&minDate={minDate}&maxDate={maxDate}**: Realiza uma busca completa de postagens baseando-se em um texto específico no parâmetro `text` e nas datas mínimas (`minDate`) e máximas (`maxDate`) fornecidas.  


## Aprendizados

Durante o desenvolvimento deste projeto, aprendi e pratiquei os seguintes conceitos:

- Configuração e inicialização de projetos Spring Boot.
- Integração com o MongoDB utilizando Spring Data MongoDB.
- Criação e exposição de APIs RESTful.
- Organização de projetos seguindo boas práticas, como a separação de responsabilidades entre controladores, serviços e repositórios.

## Considerações

Este projeto foi uma oportunidade enriquecedora para explorar o ecossistema Spring e sua integração com bancos de dados NoSQL, como o MongoDB. Ele forneceu uma base sólida para o desenvolvimento de sistemas escaláveis e orientados a APIs. Este aprendizado será essencial para projetos futuros que demandem soluções modernas e flexíveis.
