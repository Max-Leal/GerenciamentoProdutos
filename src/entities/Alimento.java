package entities;

import enums.TipoProduto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Alimento extends Produto {

    // Definindo propriedades da classe
    DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    private LocalDate dataValidade;
    private String categoria;

    // Construtor para Alimento
    public Alimento(Integer id, String name, double price, TipoProduto tipo, LocalDate dataValidade, String categoria) {
        super(id, name, price, tipo);
        this.dataValidade = dataValidade;
        this.categoria = categoria;
    }

    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    // Exibe as informações básicas do produto
    @Override
    public void exibir_informacoes() {
        super.exibir_informacoes();
        System.out.println("ㄴCategoria: " + getCategoria());
        System.out.println("ㄴData de Validade: " + getDataValidade().format(dtf));
    }

    // toString
    @Override
    public String toString() {
        return super.toString() + "Alimento{" +
                "dataValidade=" + dataValidade +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
