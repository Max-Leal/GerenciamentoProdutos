package entities;

import enums.TipoProduto;

public class Roupa extends Product {

    private String tamanho;
    private String material;

    public Roupa(Integer id, String name, double price, TipoProduto tipo, String tamanho, String material) {
        super(id, name, price, tipo);
        this.tamanho = tamanho;
        this.material = material;
    }

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

    @Override
    public void exibir_informacoes() {
        super.exibir_informacoes();
        System.out.println("Tamanho: " + getTamanho());
        System.out.println("Material: " + getMaterial());

    }
}
