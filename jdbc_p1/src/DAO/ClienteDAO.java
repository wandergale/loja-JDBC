package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.sql.ResultSet;
import java.util.ArrayList;

import db.DB;
import entities.Cliente;

public class ClienteDAO {
    
    // Método para adicionar um cliente no banco de dados
    public void adicionarCliente(Cliente cliente) {
    	try {
    		Connection conn = DB.getConnection();
    		
            String sql = "INSERT INTO Cliente (nome, endereco, email, tipoCliente) VALUES (?, ?, ?, ?)";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setString(1, cliente.getNome());
            stmt.setString(2, cliente.getEndereco());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getTipoCliente());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para remover um cliente do banco de dados
    public void removerCliente(int id) {
    	try {
    		Connection conn = DB.getConnection();
    		
            String sql = "DELETE FROM Cliente WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    // Método para obter um cliente pelo seu ID
    public Cliente obterCliente(int id) {
    	try {
    		Connection conn = DB.getConnection();
            String sql = "SELECT * FROM Cliente WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            ResultSet resultado = stmt.executeQuery();

            if (resultado.next()) {
                int clienteId = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String endereco = resultado.getString("endereco");
                String email = resultado.getString("email");
                String tipoCliente = resultado.getString("tipoCliente");

                Cliente cliente = new Cliente(clienteId, nome, endereco, email, tipoCliente);
                return cliente;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    // Método para obter todos os clientes do banco de dados
    public List<Cliente> obterTodosClientes() {
    	List<Cliente> clientes = new ArrayList<>();

        try {
        	Connection conn = DB.getConnection();
            String sql = "SELECT * FROM Cliente";
            PreparedStatement stmt = conn.prepareStatement(sql);

            ResultSet resultado = stmt.executeQuery();

            while (resultado.next()) {
                int clienteId = resultado.getInt("id");
                String nome = resultado.getString("nome");
                String endereco = resultado.getString("endereco");
                String email = resultado.getString("email");
                String tipoCliente = resultado.getString("tipoCliente");

                Cliente cliente = new Cliente(clienteId, nome, endereco, email, tipoCliente);
                clientes.add(cliente);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return clientes;
    }
}
