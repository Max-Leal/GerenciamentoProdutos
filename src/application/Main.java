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

        Scanner sc = new Scanner(System.in);
        List<Produto> produtos = new ArrayList<Produto>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        char end = 'N';
        while (end == 'N') {


            System.out.println("Escolha a operação: \n1 - Adicionar Produto\n2 - Alterar Produto\n3 - Excluir Produto\n4 - Listar Produto\n5 - Sair");
            int opc = sc.nextInt();
            switch (opc) {
                case 1:
                    Produto prod = modificarProduto(produtos, sc, dtf);

                    if (prod != null) {
                        produtos.add(prod);
                        System.out.println(prod.getTipo() + " adicionado com sucesso!");
                    } else {
                        System.out.println("Erro ao adicionar produto!");
                    }
                    break;
                case 2:
                    System.out.print("Insira o index do produto a ser alterado: ");
                    int idAlterar = sc.nextInt();
                    produtos.set(idAlterar - 1, modificarProduto(produtos, sc, dtf));
                    break;
                case 3:
                    System.out.print("Insira o index do produto a ser excluido: ");
                    int idExcluir = sc.nextInt();
                    produtos.remove(idExcluir - 1);
                    break;
                case 4:
                    System.out.println("Produtos da lista:");
                    int i = 0;
                    for (Produto p : produtos) {
                        i++;
                        System.out.println("*.*.*.*.*. Produto " + i + " .*.*.*.*.*");
                        p.exibir_informacoes();
                        System.out.println("*.*.*.*.*.*.*.*.*.*.*.*.*.*.*.*");
                    }
                    break;
                case 5:
                    end = 'S';
                    break;

            }
        }
        System.out.println("Operações registradas!");
        sc.close();
    }

    public static Produto modificarProduto(List<Produto> list, Scanner sc, DateTimeFormatter dtf) {
        System.out.println("Digite o tipo do produto (ALIMENTO, ROUPA, ELETRONICO): ");
        String tipo = sc.next().toUpperCase();

        while (!tipo.equals("ELETRONICO") && !tipo.equals("ALIMENTO") && !tipo.equals("ROUPA")) {
            System.out.print("Insira novamente: ");
            tipo = sc.next().toUpperCase();
        }

        System.out.print("Digite o id do produto: ");
        int id = sc.nextInt();
        System.out.print("Digite o nome do produto: ");
        sc.nextLine();
        String nome = sc.nextLine();
        System.out.print("Digite o preço do produto: ");
        double preco = sc.nextDouble();

        if (tipo.equals("ALIMENTO")) {
            System.out.print("Digite a data de validade (dd/MM/yyyy): ");
            sc.nextLine();
            String dataValidade = sc.nextLine();
            System.out.print("Digite a categoria do produto: ");
            String categoria = sc.nextLine();
            return new Alimento(id, nome, preco, TipoProduto.valueOf(tipo), LocalDate.parse(dataValidade, dtf), categoria);

        }
        if (tipo.equals("ROUPA")) {
            System.out.print("Digite o tamanho da roupa: ");
            sc.nextLine();
            String tamanho = sc.nextLine();
            System.out.print("Digite o material do produto: ");
            String material = sc.nextLine();
            return new Roupa(id, nome, preco, TipoProduto.valueOf(tipo), tamanho, material);
        }

        if (tipo.equals("ELETRONICO")) {
            System.out.print("Digite a marca do eletronico: ");
            sc.nextLine();
            String marca = sc.nextLine();
            System.out.print("Digite a garantia do produto: ");
            int garantia = sc.nextInt();
            return new Eletronico(id, nome, preco, TipoProduto.valueOf(tipo), marca, garantia);
        }
        return null;
    }
}

