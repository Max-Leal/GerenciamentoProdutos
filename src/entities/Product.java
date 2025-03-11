package entities;

import enums.TipoProduto;

public abstract class Product {

    private Integer id;
    private String name;
    private double price;
    private TipoProduto tipo;

    public Product() {
    }

    public Product(Integer id, String name, double price, TipoProduto tipo) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.tipo = tipo;
    }

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

    public void exibir_informacoes() {
        System.out.println("Id: " + getId());
        System.out.println("Nome: " + getName());
        System.out.println("Preço: " + getPrice());
        System.out.println("Tipo: " + getTipo());
    }

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
