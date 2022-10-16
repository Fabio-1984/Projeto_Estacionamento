package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class DAO {
	/** Módulo de conexão **/
	//Parâmetros de conexão
	private String server = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/estacionamento?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "root";
	
	
	//Métodos de conexão
	
	private Connection conectar() {
		
		Connection con = null;
		try {
			Class.forName(server);
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			
			System.out.println(e);
			return null;
		}
		
	}
	
	// teste de conexão
	
	/**public void testeConexao() {
		try {
			Connection con = conectar();
			System.out.println(con);
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		S
	}**/

}