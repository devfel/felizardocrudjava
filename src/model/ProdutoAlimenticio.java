package model;

import java.time.LocalDate;

public class ProdutoAlimenticio extends Produto {
    private LocalDate dataValidade;

    // Construtor
    public ProdutoAlimenticio(String nome, String descricao, double precoCusto, double precoVenda, int quantidadeEstoque, Categoria categoria, LocalDate dataValidade) {
        super(nome, descricao, precoCusto, precoVenda, quantidadeEstoque, categoria);
        this.dataValidade = dataValidade;
    }

    // Getter e Setter
    public LocalDate getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(LocalDate dataValidade) {
        this.dataValidade = dataValidade;
    }
}
