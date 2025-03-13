package entities;

import enums.TipoProduto;

public class Eletronico extends Produto {

    // Definindo propriedades da classe
    private String marca;
    private int garantiaMeses;

    // Construtor para Eletronico
    public Eletronico(Integer id, String name, double price, TipoProduto tipo, String marca, int garantiaMeses) {
        super(id, name, price, tipo);
        this.marca = marca;
        this.garantiaMeses = garantiaMeses;
    }

    // Getters e Setters
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public int getGarantiaMeses() {
        return garantiaMeses;
    }

    public void setGarantiaMeses(int garantiaMeses) {
        this.garantiaMeses = garantiaMeses;
    }

    // Exibe as informações básicas do produto
    @Override
    public void exibir_informacoes() {
        super.exibir_informacoes();
        System.out.println("ㄴMarca: " + getMarca());
        System.out.println("ㄴGarantia Meses: " + getGarantiaMeses());

    }

    // toString
    @Override
    public String toString() {
        return super.toString() + "Eletronico{" +
                "marca='" + marca + '\'' +
                ", garantiaMeses=" + garantiaMeses +
                '}';
    }
}
