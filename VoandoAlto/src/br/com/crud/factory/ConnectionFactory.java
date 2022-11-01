package br.com.crud.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;


/**
 *
 * @author Adriana
 */

    public class ConnectionFactory {
	private static final String USERNAME = "root";
	private static final String PASSWORD = "Bia300911**";
	private static final String DATABASE_URL = 
			"jdbc:mysql://localhost:3306/crud";
	private static final String DRIVER_NAME = 
			"com.mysql.cj.jdbc.Driver";
	
	public static Connection createConnectionToMySQL() throws Exception
	{
		Class.forName(DRIVER_NAME);
		Connection conn = DriverManager.getConnection(
						                DATABASE_URL,USERNAME,PASSWORD);
		return conn;
	}
	
	public static void main(String[] args) throws Exception {
		System.out.println("Apenas um teste");
		Connection conn = createConnectionToMySQL();
		if(conn!=null) {
			System.out.println("Conexao OK");
			Statement st = conn.createStatement();
			ResultSet resultado =  st.executeQuery(
					                  "SELECT * FROM Cliente");
			while(resultado.next()) {
				System.out.println(resultado.getString("NOME")+" :: "+
						           resultado.getInt("IDADE")+" :: "
						         +" :: "+ resultado.getString("Destino")+" :: " + resultado.getString("Email"));
			}
			st.close();
			conn.close();
		}
	}

}

