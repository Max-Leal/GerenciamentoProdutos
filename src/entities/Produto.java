package entities;

import enums.TipoProduto;

public abstract class Produto {

    private Integer id;
    private String name;
    private double price;
    private TipoProduto tipo;

    public Produto() {
    }

    public Produto(Integer id, String name, double price, TipoProduto tipo) {
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
        System.out.println("ㄴId: " + getId());
        System.out.println("ㄴNome: " + getName());
        System.out.println("ㄴPreço: " + getPrice());
        System.out.println("ㄴTipo: " + getTipo());
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
