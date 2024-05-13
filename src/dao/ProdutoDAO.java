// ./src/dao/ProdutoDAO.java
package dao;

import model.Produto;
import model.ProdutoAlimenticio;
import util.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;



public class ProdutoDAO {
    public void inserirProduto(Produto produto) {
        String sql = "INSERT INTO Produtos (nome, descricao, preco_custo, preco_venda, quantidade_estoque, categoria, data_validade) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, produto.getNome());
            stmt.setString(2, produto.getDescricao());
            stmt.setDouble(3, produto.getPrecoCusto());
            stmt.setDouble(4, produto.getPrecoVenda());
            stmt.setInt(5, produto.getQuantidadeEstoque());
            stmt.setString(6, produto.getCategoria().getCategoriaNome());

            if (produto instanceof ProdutoAlimenticio) {
                // Formata a data para inserir no banco de dados
                LocalDate dataValidade = ((ProdutoAlimenticio) produto).getDataValidade();
                stmt.setString(7, dataValidade.format(DateTimeFormatter.ISO_LOCAL_DATE));
            } else {
                stmt.setNull(7, java.sql.Types.DATE);
            }
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}