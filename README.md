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
- ``REST``
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

