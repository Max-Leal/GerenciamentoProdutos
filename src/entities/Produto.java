package entities;

import enums.TipoProduto;

// Classe abstrata para não ser declarado um produto do tipo produto
public abstract class Produto {

    // Definindo propriedades da classe
    private Integer id;          // Identificador único do produto
    private String name;         // Nome do produto
    private double price;        // Preço do produto
    private TipoProduto tipo;    // Tipo do produto (enum)

    // Construtor padrão
    public Produto() {
    }

    // Construtor com parâmetros
    public Produto(Integer id, String name, double price, TipoProduto tipo) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.tipo = tipo;
    }

    // Getters e Setters
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public TipoProduto getTipo() {
        return tipo;
    }

    public void setTipo(TipoProduto tipo) {
        this.tipo = tipo;
    }


    // Exibe as informações básicas do produto
    public void exibir_informacoes() {
        System.out.println("ㄴId: " + getId());
        System.out.println("ㄴNome: " + getName());
        System.out.println("ㄴPreço: " + getPrice());
        System.out.println("ㄴTipo: " + getTipo());
    }


    // Retorna uma representação em String do produto
    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", tipo=" + tipo +
                '}';
    }
}