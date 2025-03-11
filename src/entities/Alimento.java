package entities;

import enums.TipoProduto;

import java.time.LocalDate;

public class Alimento extends Produto {

    private LocalDate dataValidade;
    private String categoria;

    public Alimento(Integer id, String name, double price, TipoProduto tipo, LocalDate dataValidade, String categoria) {
        super(id, name, price, tipo);
        this.dataValidade = dataValidade;
        this.categoria = categoria;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public void exibir_informacoes() {
        super.exibir_informacoes();
        System.out.println("ㄴCategoria: " + getCategoria());
        System.out.println("ㄴData de Validade: " + getDataValidade());
    }

    @Override
    public String toString() {
        return super.toString() + "Alimento{" +
                "dataValidade=" + dataValidade +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
