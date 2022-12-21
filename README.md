# avaliacao

avaliação - Projeto de estudos e conceito prova sobre programação back-end;

## DEFINIÇÃO

Visando um CRUD simples de cadastro de clientes com descrição de objetos do tipo: 
- Endereço;
- Telefones;
- E-mails;
- Perfis de acesso aos módulos contidos no Front End [ React ];

A seção Repository conta com objetos caracteristicos do JPA bem como template para manuseio de objeto JDBC, visando a demonstração de ambas as tecnicas;

## DOCKER SECTION
DOCKER_BUILDKIT=1 docker build -t juniorots/avaliacao .
docker run --name avaliacao -p 8081:8081 juniorots/avaliacao:latest

## Permition denied [ DOCKER ], TO DO:
chmod 766 /var/run/docker.sock

## Tag definition
docker tag juniorots/avaliacao juniorots/projetos

## PUSH Image
docker push juniorots/projetos

## Builder project
mvn spring-boot:build-image

## Launch Project - Maven config IDE
spring-boot:run





