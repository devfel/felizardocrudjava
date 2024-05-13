// ./src/TesteInsercaoProdutoAlimenticio.java

import model.ProdutoAlimenticio;
import model.Categoria;
import dao.ProdutoDAO;
import java.time.LocalDate;

public class TesteInsercaoProdutoAlimenticio {
    public static void main(String[] args) {
        // Criar uma categoria simples para teste
        Categoria categoriaAlimenticia = () -> "Alimentos";

        // Criar um produto alimentício
        ProdutoAlimenticio produto = new ProdutoAlimenticio(
            "Pão Integral",
            "Pão integral com grãos, 500g",
            2.50, // preço de custo
            4.50, // preço de venda
            100, // quantidade em estoque
            categoriaAlimenticia,
            LocalDate.of(2024, 12, 31) // data de validade
        );

        // DAO para inserir o produto
        ProdutoDAO produtoDao = new ProdutoDAO();
        produtoDao.inserirProduto(produto);
        System.out.println("Produto alimentício inserido com sucesso!");
    }
}
