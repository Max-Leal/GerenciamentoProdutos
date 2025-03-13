package application;

import entities.Alimento;
import entities.Eletronico;
import entities.Produto;
import entities.Roupa;
import enums.TipoProduto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        // Criando um scanner, uma lista de produtos e um formatador para LocalDate
        Scanner sc = new Scanner(System.in);
        List<Produto> produtos = new ArrayList<Produto>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        produtos.add(new Alimento(123,"leite",12,TipoProduto.ALIMENTO, null, "leite"));
        produtos.add(new Alimento(123,"leite",12,TipoProduto.ALIMENTO, null, "leite"));
        produtos.add(new Alimento(123,"leite",12,TipoProduto.ALIMENTO, null, "leite"));


        // Loop while simples, para controle do programa
        char end = 'N';
        while (end == 'N') {

            // Menu inicial para solicitar uma operação
            System.out.println("Escolha a operação: \n1 - Adicionar Produto\n2 - Alterar Produto\n3 - Excluir Produto\n4 - Listar Produto\n5 - Sair");
            int opc = sc.nextInt();
            // Switch para a escolha entre as operações
            switch (opc) {
                // Caso 1: Adicionar um novo produto
                case 1:
                    Produto prod = modificarProduto(produtos, sc, dtf);

                    // Verifica se o produto é nulo, caso for, dispara um erro, caso não for, registra na lista
                    if (prod != null) {
                        produtos.add(prod);
                        System.out.println(prod.getTipo() + " adicionado com sucesso!");
                    } else {
                        System.out.println("Erro ao adicionar produto!");
                    }
                    break;

                // Caso 2: Alterar um produto existente com o mesmo metodo utilizado ao adicionar produto
                case 2:
                    System.out.print("Insira o index do produto a ser alterado: ");
                    int idAlterar = sc.nextInt();
                    produtos.set(idAlterar - 1, modificarProduto(produtos, sc, dtf));
                    break;

                // Caso 3: Excluir um produto existente
                case 3:
                    System.out.print("Insira o index do produto a ser excluido: ");
                    int idExcluir = sc.nextInt();
                    produtos.remove(idExcluir - 1);
                    break;

                // Caso 4: Listar todos os produtos
                case 4:
                    System.out.println("Insira o tipo do produto a ser listado: \n1 - Todos\n2 - Alimento\n3 - Roupa\n4 - Eletronico");
                    int listEsc = sc.nextInt();
                    TipoProduto tipo = null;

                    // switch para escolha do produto a ser listado
                    switch (listEsc) {
                        case 1:
                            break;
                        case 2:
                            tipo = TipoProduto.ALIMENTO;
                            break;
                        case 3:
                            tipo = TipoProduto.ROUPA;
                            break;
                        case 4:
                            tipo = TipoProduto.ELETRONICO;
                            break;
                    }
                    System.out.println("Produtos da lista:");
                    int i = 0;
                    for (Produto p : produtos) {
                        i++;
                        // Se o tipo do produto for igual ao escolhido, printa
                        if (p.getTipo() == tipo) {
                            System.out.println("*.*.*.*.*. Produto " + i + " .*.*.*.*.*");
                            p.exibir_informacoes();
                        }
                        // Se o tipo escolhido for nulo, printa todos
                        if (tipo == null) {
                            System.out.println("*.*.*.*.*. Produto " + i + " .*.*.*.*.*");
                            p.exibir_informacoes();
                        }
                    }
                    break;

                // Caso 5: Sair do programa
                case 5:
                    end = 'S';
                    break;
            }
        }
        System.out.println("Operações registradas!");
        sc.close();
    }

    // metodo para devolver um tipo de produto
    public static Produto modificarProduto(List<Produto> list, Scanner sc, DateTimeFormatter dtf) {
        System.out.println("Digite o tipo do produto (ALIMENTO, ROUPA, ELETRONICO): ");
        String tipo = sc.next().toUpperCase();

        // Validação do tipo de produto
        while (!tipo.equals("ELETRONICO") && !tipo.equals("ALIMENTO") && !tipo.equals("ROUPA")) {
            System.out.print("Insira novamente: ");
            tipo = sc.next().toUpperCase();
        }

        // Solicitação dos dados básicos do produto
        System.out.print("Digite o id do produto: ");
        int id = sc.nextInt();
        System.out.print("Digite o nome do produto: ");
        sc.nextLine();
        String nome = sc.nextLine();
        System.out.print("Digite o preço do produto: ");
        double preco = sc.nextDouble();

        // Criação de um produto do tipo Alimento
        if (tipo.equals("ALIMENTO")) {
            System.out.print("Digite a data de validade (dd/MM/yyyy): ");
            sc.nextLine();
            String dataValidade = sc.nextLine();
            System.out.print("Digite a categoria do produto: ");
            String categoria = sc.nextLine();
            return new Alimento(id, nome, preco, TipoProduto.valueOf(tipo), LocalDate.parse(dataValidade, dtf), categoria);
        }

        // Criação de um produto do tipo Roupa
        if (tipo.equals("ROUPA")) {
            System.out.print("Digite o tamanho da roupa: ");
            sc.nextLine();
            String tamanho = sc.nextLine();
            System.out.print("Digite o material do produto: ");
            String material = sc.nextLine();
            return new Roupa(id, nome, preco, TipoProduto.valueOf(tipo), tamanho, material);
        }

        // Criação de um produto do tipo Eletronico
        if (tipo.equals("ELETRONICO")) {
            System.out.print("Digite a marca do eletronico: ");
            sc.nextLine();
            String marca = sc.nextLine();
            System.out.print("Digite a garantia do produto: ");
            int garantia = sc.nextInt();
            return new Eletronico(id, nome, preco, TipoProduto.valueOf(tipo), marca, garantia);
        }

        // Retorno nulo em caso de erro
        return null;
    }
}