package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.DB;
import entities.Pedido;

public class PedidoDAO {

    public void adicionarPedido(Pedido pedido) {
    	 try {
             Connection conn = DB.getConnection();
    		 String sql = "INSERT INTO Pedido (clienteId, dataPedido, statusPedido) VALUES (?, ?, ?)";
             PreparedStatement stmt = conn.prepareStatement(sql);

             stmt.setInt(1, pedido.getId());
             stmt.setString(2, pedido.getDataPedido());
             stmt.setString(3, pedido.getStatusPedido());

             stmt.executeUpdate();
         } catch (SQLException e) {
             e.printStackTrace();
         }
    }
    public void removerPedido(int id) {
        try {
            Connection conn = DB.getConnection();
        	String sql = "DELETE FROM Pedido WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Pedido obterPedido(int id) {
        try {
            Connection conn = DB.getConnection();
        	String sql = "SELECT * FROM Pedido WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                int pedidoId = resultado.getInt("id");
                String dataPedido = resultado.getString("dataPedido");
                String statusPedido = resultado.getString("statusPedido");

                Pedido pedido = new Pedido(pedidoId, null, dataPedido, statusPedido);
                return pedido;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    public List<Pedido> obterTodosPedidos() {
        List<Pedido> pedidos = new ArrayList<>();

        try {
        	Connection conn = DB.getConnection();
        	String sql = "SELECT * FROM Pedido";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                int pedidoId = resultado.getInt("id");
                String dataPedido = resultado.getString("dataPedido");
                String statusPedido = resultado.getString("statusPedido");

                Pedido pedido = new Pedido(pedidoId, null, dataPedido, statusPedido);
                pedidos.add(pedido);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return pedidos;
    }
}