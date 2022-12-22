# avaliacao

avaliação - Projeto de estudos e conceito prova sobre programação back-end;

## DEFINIÇÃO

Visando um CRUD simples de cadastro de clientes com descrição de objetos do tipo: 
- Endereço;
- Telefones;
- E-mails;
- Perfis de acesso aos módulos contidos no Front End [ React ];

A seção Repository conta com objetos caracteristicos do JPA bem como template para manuseio de objeto JDBC, visando a demonstração de ambas as tecnicas;

## >>>>>>>>> DOCKER SECTION

## Opening network [ specific database ]
docker network create avaliacao-mysql

## Operable facts image Docker MYSQL
docker container run --name mysqldb --network avaliacao-mysql -e MYSQL_ROOT_PASSWORD=novaSenha -e MYSQL_DATABASE=avaliacaodb -d mysql:8

## Enabled Spect bash, Logging database created
docker container exec -it ae bash 
mysql -uroot -pnovaSenha

## Build image Docker 
DOCKER_BUILDKIT=1 docker build -t juniorots/avaliacao .

## Running image Docker
docker run --name avaliacao --network avaliacao-mysql -p 8081:8081 juniorots/avaliacao:latest

## When we are interested using docker compose
docker-compose up


## Insert data with post method, in bash section
curl --header "Content-Type: application/json"   --request POST   --data '{"login":"usuario01","senha":"novaSenha", "perfilList":[{"nomePerfil":"admin"}]}'   http://localhost:8081/api/usuario

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














