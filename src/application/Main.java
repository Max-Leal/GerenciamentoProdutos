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
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        // Criando um scanner, uma lista de produtos e um formatador para LocalDate
        Scanner sc = new Scanner(System.in);
        List<Produto> produtos = new ArrayList<>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        // loop while simples, para controle do programa
        char end = 'N';
        while (end == 'N') {

            // Menu inicial para solicitar uma operação
            System.out.println("\n*----------------------------------*");
            System.out.println("| Escolha a operação:              |\n" +
                    "| 1 - Adicionar Produto            |\n" +
                    "| 2 - Alterar Produto              |\n" +
                    "| 3 - Excluir Produto              |\n" +
                    "| 4 - Listar Produto               |\n" +
                    "| 5 - Sair                         |");
            System.out.println("*----------------------------------*\n");
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
                    System.out.print("Insira o código do produto a ser alterado: ");
                    String idProd = sc.next();

                    boolean produtoEncontrado = false;
                    for (int i = 0; i < produtos.size(); i++) {
                        if (produtos.get(i).getId().equals(idProd)) {
                            produtoEncontrado = true;
                            produtos.set(i, alterarProduto(sc, dtf, produtos.get(i)));
                            break;
                        }
                    }

                    if (produtoEncontrado) {
                        System.out.println("Produto alterado com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                // Caso 3: Excluir um produto existente
                case 3:
                    System.out.print("Insira o código do produto a ser excluído: ");
                    String idExcluir = sc.next();

                    boolean idEncontrado = false;
                    // utilização de lambda para excluir caso esteja com o id
                    for (int i = 0; i < produtos.size(); i++) {
                        if (produtos.get(i).getId().equals(idExcluir)) {
                            idEncontrado = true;
                            produtos.remove(i);
                            break;
                        }
                    }
                    if (idEncontrado) {
                        System.out.println("Produto excluido com sucesso!");
                    } else {
                        System.out.println("Produto não encontrado.");
                    }

                    break;

                // Caso 4: Listar todos os produtos
                case 4:
                    System.out.println("Insira o tipo do produto a ser listado: \n1 - Todos\n2 - Alimento\n3 - Roupa\n4 - Eletronico");
                    int listEsc = sc.nextInt();
                    TipoProduto tipo = null;

                    // switch para escolha do produto a ser listado
                    switch (listEsc) {
                        case 2 -> tipo = TipoProduto.ALIMENTO;
                        case 3 -> tipo = TipoProduto.ROUPA;
                        case 4 -> tipo = TipoProduto.ELETRONICO;

                    }
                    // Mostrando a lista
                    System.out.println("\nProdutos da lista:");
                    int i = 0;
                    for (Produto p : produtos) {
                        i++;
                        // Se o tipo do produto for igual ao escolhido, printa
                        if (p.getTipo() == tipo) {
                            System.out.println("*----------- Produto " + i + " -----------*");
                            p.exibir_informacoes();
                            System.out.println();
                        }
                        // Se o tipo escolhido for nulo, printa todos
                        if (tipo == null) {
                            System.out.println("*----------- Produto " + i + " -----------*");
                            p.exibir_informacoes();
                            System.out.println();
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

        // Verificação de ID único com loop
        String id;
        boolean idExistente = false;

        do {
            // Solicitação dos dados básicos do produto
            System.out.print("Digite o id do produto: ");
            id = sc.next();

            // Verifica se o ID já existe na lista
            idExistente = false;
            for (Produto p : list) {
                if (p.getId().equals(id)) {
                    idExistente = true;
                    System.out.println("ID já cadastrado! Por favor, digite um ID diferente.");
                    break;
                }
            }
        }
        while (idExistente);

        System.out.println("Digite o tipo do produto: \n1 - ALIMENTO\n2 - ROUPA\n3 - ELETRONICO ");
        int escTipo = sc.nextInt();

        while (escTipo < 1 || escTipo > 3) {
            System.out.print("Insira um valor valido: ");
            escTipo = sc.nextInt();
        }

        System.out.print("Digite o nome do produto: ");
        sc.nextLine();
        String nome = sc.nextLine();
        System.out.print("Digite o preço do produto: ");
        double preco = sc.nextDouble();


        // Criação de um produto do tipo Alimento
        switch (escTipo) {
            case 1 -> {
                System.out.print("Digite a data de validade (dd/MM/yyyy): ");
                sc.nextLine();
                String dataValidade = sc.nextLine();
                System.out.print("Digite a categoria do produto: ");
                String categoria = sc.nextLine();
                return new Alimento(id, nome, preco, TipoProduto.valueOf("ALIMENTO"), LocalDate.parse(dataValidade, dtf), categoria);
            }


            // Criação de um produto do tipo Roupa
            case 2 -> {
                System.out.print("Digite o tamanho da roupa: ");
                sc.nextLine();
                String tamanho = sc.nextLine();
                System.out.print("Digite o material do produto: ");
                String material = sc.nextLine();
                return new Roupa(id, nome, preco, TipoProduto.valueOf("ROUPA"), tamanho, material);
            }


            // Criação de um produto do tipo Eletronico
            case 3 -> {
                System.out.print("Digite a marca do eletronico: ");
                sc.nextLine();
                String marca = sc.nextLine();
                System.out.print("Digite a garantia do produto: ");
                int garantia = sc.nextInt();
                return new Eletronico(id, nome, preco, TipoProduto.valueOf("ELETRONICO"), marca, garantia);
            }
        }

        // Retorno nulo em caso de erro
        return null;
    }

    // Criação de um segundo metodo para alterar produto
    public static Produto alterarProduto(Scanner sc, DateTimeFormatter dtf, Produto produto) {

        // Pedindo as informações do produto que vai ser alterado
        System.out.println("Digite o tipo do produto: \n1 - ALIMENTO\n2 - ROUPA\n3 - ELETRONICO ");
        int escTipo = sc.nextInt();

        while (escTipo < 1 || escTipo > 3) {
            System.out.print("Insira um valor valido: ");
            escTipo = sc.nextInt();
        }

        System.out.print("Digite o nome do produto: ");
        sc.nextLine();

        String nome = sc.nextLine();
        System.out.print("Digite o preço do produto: ");
        double preco = sc.nextDouble();



        // Criação de um produto do tipo Alimento
        switch (escTipo) {
            case 1 -> {
                System.out.print("Digite a data de validade (dd/MM/yyyy): ");
                sc.nextLine();
                String dataValidade = sc.nextLine();
                System.out.print("Digite a categoria do produto: ");
                String categoria = sc.nextLine();
                return new Alimento(produto.getId(), nome, preco, TipoProduto.valueOf("ALIMENTO"), LocalDate.parse(dataValidade, dtf), categoria);
            }


            // Criação de um produto do tipo Roupa
            case 2 -> {
                System.out.print("Digite o tamanho da roupa: ");
                sc.nextLine();
                String tamanho = sc.nextLine();
                System.out.print("Digite o material do produto: ");
                String material = sc.nextLine();
                return new Roupa(produto.getId(), nome, preco, TipoProduto.valueOf("ROUPA"), tamanho, material);
            }


            // Criação de um produto do tipo Eletronico
            case 3 -> {
                System.out.print("Digite a marca do eletronico: ");
                sc.nextLine();
                String marca = sc.nextLine();
                System.out.print("Digite a garantia do produto: ");
                int garantia = sc.nextInt();
                return new Eletronico(produto.getId(), nome, preco, TipoProduto.valueOf("ELETRONICO"), marca, garantia);
            }
        }
        return null;
    }
}