package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import entities.ItemPedido;

public class ItemPedidoDAO {

    public void adicionarItemPedido(ItemPedido itemPedido) {
        try {
            Connection conn = DB.getConnection();
        	String sql = "INSERT INTO ItemPedido (pedidoId, produtoId, quantidade) VALUES (?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, itemPedido.getId());
            stmt.setInt(2, itemPedido.getProduto().getId());
            stmt.setInt(3, itemPedido.getQuantidade());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void removerItemPedido(int id) {
        try {
        	Connection conn = DB.getConnection();
        	String sql = "DELETE FROM ItemPedido WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public ItemPedido obterItemPedido(int id) {
        try {
        	Connection conn = DB.getConnection();
        	String sql = "SELECT * FROM ItemPedido WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                int itemPedidoId = resultado.getInt("id");
                // int pedidoId = resultado.getInt("pedidoId");
                // int produtoId = resultado.getInt("produtoId");
                int quantidade = resultado.getInt("quantidade");

                ItemPedido itemPedido = new ItemPedido(itemPedidoId, null, null, quantidade);
                return itemPedido;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<ItemPedido> obterItensPedidoPorPedido(int pedidoId) {
        List<ItemPedido> itensPedido = new ArrayList<>();

        try {
        	Connection conn = DB.getConnection();
        	String sql = "SELECT * FROM ItemPedido WHERE pedidoId = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, pedidoId);

            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                int itemPedidoId = resultado.getInt("id");
                // int produtoId = resultado.getInt("produtoId");
                int quantidade = resultado.getInt("quantidade");

                ItemPedido itemPedido = new ItemPedido(itemPedidoId, null, null, quantidade);
                itensPedido.add(itemPedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return itensPedido;
    }
}
