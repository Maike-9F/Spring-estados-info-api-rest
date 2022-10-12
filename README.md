# (API Rest com Spring) informações sobre os estados brasileiros

## Sobre

API Rest contruida com Spring Boot, JPA Hibernate e PostgreSQL.
Essa API tem como objetivo somente fornecer informações dos estados brasileiros, como o Pib, população e governador do ano de 2019.

## Tecnologias utilizadas

1. Java 17

2. Spring Boot 2.7.3

3. Maven 4.0.0

4. PostgreSQL

## Como usar

1. Clone esse repositório

```bash
git clone https://github.com/Maike-9F/Spring-estados-info-api-rest.git
```
2. Crie um banco de dados no PostgreSQL com o nome `info-estados`

3. Execute o script localizado no arquivo `src/sql.txt`

4. Execute a aplicação usando o Maven

```bash
mvn spring-boot:run
```
A aplicação estará rodando em `http://localhost:8080`

## Funcionalidades

| Verbo HTTP | URI | Parâmetros | Descrição | Exemplo |
| ---------- | --- | ---------- | --------- | ------- |
| GET        | /estados | page=0 a 3 | realiza uma busca paginada de todos os estados | /estados?page=0 |
| GET        | /estados/id/{id} | nenhum | realiza a busca de um estado pelo ID | /estados/id/7 |
| GET        | /estados/uf/{uf} | nenhum | realiza a busca de um estado pelo seu respectivo UF | /estados/uf/SP |
| GET        | /estados/nome/{nome} | page=0 a 3 | realiza a busca paginada pelo nome do estado | /estados/nome/parana |
| GET        | /estados/capital/{capital} | page=0 a 3 | realiza a busca paginada de estados através da capital | /estados/capital/manaus |
| GET        | /estados/pib | order=maior ou menor e page=0 a 3 | faz uma busca paginada de estados ordenando pelo PIB de acordo com o parâmetro order | /estados/pib?order=maior&page=1 |
| GET        | /estados/populacao | order=maior ou menor e page=0 a 3 | faz uma busca paginada de estados ordenando pelo número da população de acordo com o parâmetro order | /estados/populacao?order=menor&page=0 |