# api-mutant
<img src="http://img.shields.io/static/v1?label=Cobertura&message=EM%2082%&color=GREEN&style=for-the-badge"/>

Foi solicitado a criação de uma api com uma das linguagens (Java/Golang) dentro da nuvem de minha escolha, preferi utilizar Java utilizando Spring Framework, sobre infraestrutura utilizei AWS.
Abaixo fiz um desenho macro da arquitetura que desenvolvi.

![Desenho arquitetura api-mutant](https://user-images.githubusercontent.com/46197486/177390877-e69291cd-cd3a-40aa-9307-f42a48f19763.jpg)

## ✔️ Técnicas e tecnologias utilizadas

- ``Java 8``
- ``Spring Framework``
- ``Spring Data``
- ``JUnit``
- ``Maven``
- ``REST``
- ``Git``
- ``InteliJ IDEA``
- ``Paradigma de orientação a objetos``
- ``AWS EC2``
- ``Linux Ubuntu``
- ``AWS RDS``
- ``MySql``

## 📁 Acesso ao projeto
O ambiente de produção pode ser acessado pela url: http://34.231.32.165:8080/

<img width="867" alt="Captura de Tela 2022-07-05 às 15 38 30" src="https://user-images.githubusercontent.com/46197486/177393873-d88b245c-c656-4de0-909f-b1c680b6868b.png">

Para realizar a requisição em post segue cUrl de exemplo:

curl --location --request POST 'http://34.231.32.165:8080/mutant' \
--header 'Content-Type: application/json' \
--data-raw '{ "dna": ["ZGYGGA", "ZAGTGC", "ZTATGT", "ZAGYGG", "ZCYCTA", "BCACTG"] }

'

<img width="870" alt="Captura de Tela 2022-07-05 às 15 47 18" src="https://user-images.githubusercontent.com/46197486/177395522-b6110b89-8109-4d85-8321-49fa201c0bf4.png">

Para realizar a requisição em get segue cUrl de exemplo:

curl --location --request GET 'http://34.231.32.165:8080/stats' \
--header 'user: admin' \
--header 'senha: password' \
--header 'Content-Type: application/json' \

--data-raw '{ "dna": ["ZGYGGA", "ZAGTGC", "ZTATGT", "XAGYGG", "ZCYCTA", "BCACTG"] }

'

## :hammer: Executar o pacote

`Pré-requisitos`: instalação do Java 8 ou superior e instalação do maven, git.

`Passo um 1`: Realizar o clone no Git 

`Passo um 2`: Abrir o prompt de comando e realizar o mvn install -U para que realize o download das dependencias.

`Passo um 3`: Realizando o mvn install ele gera o pacote do .jar na pasta target.

`Passo um 4`: Crie uma pasta raiz onde copiara o pacote .jar e criar uma pasta config onde sera incluido a propertie.

`Passo um 5`: No prompt execute o comando java -jar api-mutante-0.0.1-SNAPSHOT.jar para executar no terminal aberto ou caso queira executar o comando
 nohup java -jar api-mutante-0.0.1-SNAPSHOT.jar & para que fique startado independente do terminal.

