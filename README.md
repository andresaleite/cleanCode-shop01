# cleanCode-shop01
Cenário

Vamos implementar um sistema de vendas online com a possibilidade de realizar pedidos com múltiplos itens, cada um deles com uma quantidade variável, calculando o frete, os impostos, aplicando um cupom de desconto e ainda interagindo com o estoque. Além disso teremos ainda fluxos de pagamento e cancelamento do pedido realizado.

Para começar, faremos um projeto estruturado de forma simples, faça do jeito que você souber, depois vamos ir refatorando juntos.


Testes
1 - Deve criar um pedido com 3 produtos (com descrição, preço e quantidade) e calcular o valor total
2 - Deve criar um pedido com 3 produtos, associar um cupom de desconto e calcular o total (percentual sobre o total do pedido)
3 - Não deve criar um pedido com cpf inválido (lançar algum tipo de erro)


Considere


Utilizar e refatorar o algoritmo de validação de cpf: https://github.com/rodrigobranas/cccat7_refactoring/blob/master/src/example2/cpfBefore.ts

Sugestões


Faça a modelagem da forma que desejar e não se preocupe por enquanto, vamos implementar juntos na aula seguinte com influências de DDD e Clean Architecture
Utilize a sua linguagem e biblioteca de teste de sua preferência
Devem existir no mínimo 2 arquivos, um de teste e outro que é a aplicação
Como mecanismo de persistência você pode utilizar um banco de dados, um array em memória, um arquivo, qualquer coisa que desejar
Como entrada você pode utilizar uma API HTTP, um CLI ou qualquer outro mecanismo que permita a entrada dos dados
Tente seguir com disciplina, criando primeiro um teste que falha, depois fazendo e teste passar e refatorando

<big><b>Para executar no Postman</big></b>
<pre>
{
	"info": {
		"_postman_id": "017bfd41-ba3f-4c6f-9f4c-314f222d2adc",
		"name": "aula_branas.io",
		"schema": "https://schema.getpostman.com/json/collection/v2.1.0/collection.json",
		"_exporter_id": "3755147"
	},
	"item": [
		{
			"name": "Inserir pedido",
			"request": {
				"method": "POST",
				"header": [],
				"body": {
					"mode": "raw",
					"raw": "{\n\t\"cpf\": \"697.801.812-02\",\n\t\"products\": [{\n\t\t\"id\": 1,\n\t\t\"name\": \"Clean Code\",\n        \"description\": \"Livro para arquiteto de desenvolvimento.\",\n        \"imgUrl\": \"https://raw.githubusercontent.com/devsuperior/dscatalog-resources/master/backend/img/1-big.jpg\",\n\t\t\"price\": 88,\n\t\t\"quantity\": 2\n\t}],\n\t\"cupom\": \"COMPRA10\"\n}",
					"options": {
						"raw": {
							"language": "json"
						}
					}
				},
				"url": {
					"raw": "{{host}}/orders",
					"host": [
						"{{host}}"
					],
					"path": [
						"orders"
					]
				}
			},
			"response": []
		}
	]
}
</pre>
