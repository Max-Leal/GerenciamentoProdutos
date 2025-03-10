package application;

import entities.Alimento;
import entities.Eletronico;
import entities.Product;
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
        List<Product> products = new ArrayList<Product>();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        System.out.println("Escolha a operação: \n1 - Adicionar Produto\n2 - Alterar Produto\n3 - Excluir Produto\n4 - Listar Produto\n5 - Sair");
        int opc = sc.nextInt();
        switch (opc) {
            case 1:
                Product prod = adicionarProduto(products, sc, dtf);

                if (prod != null) {
                    products.add(prod);
                    System.out.println(prod.getTipo() + " adicionado com sucesso!");
                } else {
                    System.out.println("Erro ao adicionar produto!");
                }
                break;
            case 2:
                System.out.println(" ");

        }
        sc.close();
    }

    public static Product adicionarProduto(List<Product> list, Scanner sc, DateTimeFormatter dtf) {
        System.out.println("Digite o tipo do produto (ALIMENTO, ROUPA, ELETRONICO): ");
        String tipo = sc.next().toUpperCase();

        while (!tipo.equals("ELETRONICO") && !tipo.equals("ALIMENTO") && !tipo.equals("ROUPA")) {
            System.out.print("Insira novamente: ");
            tipo = sc.next().toUpperCase();
        }

        System.out.println("Digite o id do produto: ");
        int id = sc.nextInt();
        System.out.println("Digite o nome do produto: ");
        String nome = sc.nextLine();
        System.out.println("Digite o preço do produto: ");
        double preco = sc.nextDouble();

        if (tipo.equals("ALIMENTO")) {
            System.out.print("Digite a data de validade (dd/MM/yyyy): ");
            String dataValidade = sc.nextLine();
            System.out.print("Digite a categoria do produto: ");
            String categoria = sc.nextLine();
            return new Alimento(id, nome, preco, TipoProduto.valueOf(tipo), LocalDate.parse(dataValidade, dtf), categoria);

        }
        if (tipo.equals("ROUPA")) {
            System.out.println("Digite o tamanho da roupa: ");
            String tamanho = sc.nextLine();
            System.out.print("Digite o material do produto: ");
            String material = sc.nextLine();
            return new Roupa(id, nome, preco, TipoProduto.valueOf(tipo), tamanho, material);
        }

        if (tipo.equals("ELETRONICO")) {
            System.out.print("Digite a marca do eletronico: ");
            String marca = sc.nextLine();
            System.out.print("Digite a garantia do produto: ");
            int garantia = sc.nextInt();
            return new Eletronico(id, nome, preco, TipoProduto.valueOf(tipo), marca, garantia);
        }
        return null;
    }
}

