# Gerenciamento de Produtos

## Descrição

Este projeto é uma aplicação Java para gerenciamento de produtos de diferentes tipos: Alimentos, Roupas e Eletrônicos. Ele permite adicionar, alterar, excluir e listar produtos, garantindo um controle organizado e eficiente.

## Funcionalidades

- **Adicionar Produto**: Permite cadastrar um novo produto na lista.
- **Alterar Produto**: Modifica as informações de um produto existente.
- **Excluir Produto**: Remove um produto da lista.
- **Listar Produtos**: Exibe os produtos cadastrados, podendo filtrar por tipo.

## Tecnologias Utilizadas

- **Java**
- **Collections (ArrayList)**
- **Manipulação de Datas (LocalDate, DateTimeFormatter)**
- **Enumerações (Enum)**

## Demonstração

Ao executar o programa, o usuário interage por meio do terminal. Exemplo de funcionamento:

```
Escolha a operação: 
1 - Adicionar Produto
2 - Alterar Produto
3 - Excluir Produto
4 - Listar Produto
5 - Sair

> 1  
Digite o tipo do produto (ALIMENTO, ROUPA, ELETRONICO): ALIMENTO  
Digite o id do produto: 101  
Digite o nome do produto: Maçã  
Digite o preço do produto: 2.50  
Digite a data de validade (dd/MM/yyyy): 20/04/2025  
Digite a categoria do produto: Fruta  

ALIMENTO adicionado com sucesso!
```

O programa continua rodando até que o usuário escolha a opção **5 - Sair**.

## Estrutura do Projeto

```
|-- application/
|   |-- Main.java  # Classe principal
|-- entities/
|   |-- Produto.java
|   |-- Alimento.java
|   |-- Roupa.java
|   |-- Eletronico.java
|-- enums/
|   |-- TipoProduto.java
```

## Autor

Desenvolvido por [Max-leal]([https://github.com/seu-usuario](https://github.com/Max-Leal)).

