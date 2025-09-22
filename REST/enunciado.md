# INDIVIDUAL #
## Atividade JPA - Roteiro de Estudo ##
<b> Objetivo: </b> compreender os conceitos de JPA. Fazer os testes iniciais com JPA.

### Roteiro de atividades: ### 
1) Leia o artigo https://www.devmedia.com.br/introducao-a-jpa-java-persistenceapi/28173 para se aprofundar um pouco mais nos conceitos
2) Execute o tutorial disponível em: https://blog.algaworks.com/tutorial-jpa/ para compreender e testar na prática o uso do JPA. Observe que este tutorial utiliza um projeto Maven. Com o Maven você não precisa baixar as bibliotecas manualmente. Caso prefira baixar as bibliotecas manualmente, faça este tutorial: https://www.caelum.com.br/apostila-java-web/uma-introducao-pratica-ao-jpacom-hibernate#exercicios-gravando-e-carregando-objetos

3) Após executar o tutorial, crie um projeto de seu interesse para testar o
funcionamento do JPA

Próximos passos: JPA com Spring

## Atividade Spring Boot - Roteiro de Estudo ##
<b> Objetivo: </b> compreender os conceitos de Spring, Spring Boot e Spring Security.

### Roteiro de atividades: ### 
1) Somente LEIA os artigos: 

API: https://youtu.be/tPbK3eOJLXQ (Assistir)

REST: https://youtu.be/S7MduKwvVGk (Assistir)

Especificações - https://www.infoq.com/br/articles/rest-introduction/

Sobre serviços e boas práticas - https://www.alura.com.br/artigos/rest-principios-e-boas-praticas?utm_term=&campaign_id=11384329873_164240702375_703853654617&hsa_kw=&hsa_mt=&gad_campaignid=11384329873

Spring Boot: https://spring.io/projects/spring-boot

Spring Security: https://spring.io/guides/gs/securing-web

2) Execute os tutoriais:
https://dev.to/iamjose/como-iniciar-um-aplicativo-spring-boot-jpa-mysql-2nl4 (simples)
https://spring.io/guides/gs/accessing-data-jpa (oficial Spring)

OU

Utilize uma IA para gerar um projeto com SpringBoot, acesso a tabelas de banco de dados com JPA e integração de token com JWT. Faça o tutorial fornecido pela IA.

Observe as configurações para utilização do MariaDB em:
https://springframework.guru/configuring-spring-boot-for-mariadb/
https://isonusingh.medium.com/spring-boot-mariadb-integration-72ee97ced3de


Lembre-se: ao importar o projeto no Eclipse gerado pelo Spring Initializer, importar
como um Maven Project, clicar no arquivo Pom.XML, Run As, Maven Build para
importar as dependências


# EM GRUPO #
## Enunciado ##
Tendo como base os conceitos de WebService REST e os demais assuntos estudados, desenvolva um servidor REST conforme especificado:

a) (1,0) o servidor deve possuir conexão com o banco de dados

b) (1,0) deve haver pelo menos 2 tabelas que se relacionam, de modo que o
relacionamento entre elas seja N-N, gerando assim uma terceira tabela de
normalização de dados

c) (1,0) o projeto deve ser desenvolvido utilizando o padrão Data Access Object (DAO) e a arquitetura M(V)C

d) (3,0) para cada objeto deve-se fornecer os seguintes serviços em formato JSON: insert, delete, update, select by id, select all os quais devem ser implementados
utilizando framework de persistência de dados e devem ser validados, lançando
exceções conforme os possíveis erros previstos (lançar exceção com os códigos de
erro HTTP)

e) (1,0) para cada objeto deve-se fornecer no mínimo 2 selects extras, além dos
definidos na letra anterior

f) (1,0) além dos objetos já definidos, deve-se implementar serviços para gerenciar o
usuário do sistema

g) (2,0) os serviços de insert e update só podem ser requisitados se o usuário tiver
permissão e estiver autenticado no sistema, para isso, deve-se implementar uma
camada de segurança/autenticação

### Observações: ###
- o tema é livre
- a linguagem de programação e o banco de dados a ser utilizado é de sua escolha
