package entities;

import enums.TipoProduto;

public class Roupa extends Produto {

    // Definindo propriedades da classe
    private String tamanho;
    private String material;

    // Construtor para Roupa
    public Roupa(String id, String name, double price, TipoProduto tipo, String tamanho, String material) {
        super(id, name, price, tipo);
        this.tamanho = tamanho;
        this.material = material;
    }

    // Getters e Setters
    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }
    // Exibe as informações básicas do produto
    @Override
    public void exibir_informacoes() {
        super.exibir_informacoes();
        System.out.println("ㄴTamanho: " + getTamanho());
        System.out.println("ㄴMaterial: " + getMaterial());

    }
    // toString
    @Override
    public String toString() {
        return super.toString() + "Roupa{" +
                "tamanho='" + tamanho + '\'' +
                ", material='" + material + '\'' +
                '}';
    }
}
