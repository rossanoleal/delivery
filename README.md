#delivery

<h1 align="center">Projeto Delivery - Desafio everis</h1>

## Descrição do Projeto
<p align="center">FLORIANOPOLIS - 2021.1 Este Projeto é uma api simples sem autenticação, utilizamos Spring Boot como framework, IDE eclipse e H2 como banco de dados em memória.</p>

<h2 align="center"> 
	 Status: 🚀 Concluido 🚀
</h2>

<h3>Instruções iniciais</h3>

Após fazer o Download e extrair o arquivo para um local seguro, será necessário fazer algumas alteraçoes no arquivo.

#Conexao com banco

spring.datasource.url=jdbc:h2:mem:delivery

spring.datasource.username= Coloque o seu usuario do banco de dados.

spring.datasource.password= Coloque a senha do seu banco

spring.datasource.platform=h2

<h3> Pré-requisitos </h3>

Antes de começar, você vai precisar ter instalado em sua máquina as seguintes ferramentas:
[Java OpenJDK](http://jdk.java.net/archive/). 
Além disto é bom ter um editor para trabalhar com o código como [Eclipse](https://www.eclipse.org/downloads/)

<h3> Endpoint's </h3>

<h3> Clients </h3>

GET -> http://localhost:8080/clients

POST -> http://localhost:8080/clients

PUT -> http://localhost:8080/clients

DEL -> http://localhost:8080/clients/delete/        (selecionar o id do cliente no final da url, exemplo: http://localhost:8080/clients/delete/1)

<h3> Products </h3>

GET -> http://localhost:8080/products

POST -> http://localhost:8080/products

<h3> Orders </h3>

GET -> http://localhost:8080/orders

POST -> http://localhost:8080/orders

<h3> Payments </h3>

GET -> http://localhost:8080/payments

POST -> http://localhost:8080/payments

<h3> Exemplos de Json utilizados </h3>

<h3> Clients </h3>

{

	"name": "Rossano Leal",
	
	"cpf": "045.465.456-10",
	
	"phone": "(48) 9998-4433",
	
	"email": "rossano@gmail.com",
	
	"password": "123123",
	
	"address": {
	
		"street": "Rua velha",
		
		"number": 20
		
	}
	
}

<h3> Products </h3>

{

	"description": "Pizza",
	
	"price": 30
	
}


<h3> Orders </h3>

{

	"clientId": 1,
	
	"products": [
	
		{ "productId": 1, "quantity": 2},
		
		{ "productId": 2, "quantity": 1}
		
	]
	
}

<h3> Payments </h3>

{

	"type": "CREDIT",
	
	"orders": {
	
		"id": 1
		
	}
	
}

<h3> Autor </h3>

Rossano Leal

<h3> Contato </h3>

rossanoleal@gmail.com
