package application;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.DB;

public class Program {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		
		try {
			conn = DB.getConnection();
			
			st = conn.createStatement();
			rs = st.executeQuery("SELECT * FROM evento");
			
			System.out.println("---EVENTOS---");
			while (rs.next()) {
				System.out.println("Evento: "+rs.getString("nome")+ ", data: "+rs.getString("data")+", local: "+rs.getString("local"));
			}
		}
		catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
