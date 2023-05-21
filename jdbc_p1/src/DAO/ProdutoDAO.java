package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import entities.Produto;

public class ProdutoDAO {

    public void adicionarProduto(Produto produto) {
        try {
        	Connection conn = DB.getConnection();
            String sql = "INSERT INTO Produto (nome, preco) VALUES (?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, produto.getNome());
            stmt.setDouble(2, produto.getPreco());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerProduto(int id) {
        try {
        	Connection conn = DB.getConnection();
            String sql = "DELETE FROM Produto WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Produto obterProduto(int id) {
        try {
        	Connection conn = DB.getConnection();
            String sql = "SELECT * FROM Produto WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                int produtoId = resultado.getInt("id");
                String nome = resultado.getString("nome");
                double preco = resultado.getDouble("preco");
                String descricao = resultado.getString("descricao");

                Produto produto = new Produto(produtoId, nome, preco, descricao);
                return produto;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Produto> obterTodosProdutos() {
        List<Produto> produtos = new ArrayList<>();

        try {
        	Connection conn = DB.getConnection();
            String sql = "SELECT * FROM Produto";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                int produtoId = resultado.getInt("id");
                String nome = resultado.getString("nome");
                double preco = resultado.getDouble("preco");
                String descricao = resultado.getString("descricao");

                Produto produto = new Produto(produtoId, nome, preco, descricao);
                produtos.add(produto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return produtos;
    }
}
