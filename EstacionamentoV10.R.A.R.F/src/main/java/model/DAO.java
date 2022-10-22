package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;



public class DAO {
	/** Módulo de conexão **/
	// Parâmetros de conexão
	private String server = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://127.0.0.1:3306/estacionamento?useTimezone=true&serverTimezone=UTC";
	private String user = "root";
	private String password = "root";

	// Métodos de conexão

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

	/**
	 * public void testeConexao() { try { Connection con = conectar();
	 * System.out.println(con); con.close(); } catch (Exception e) {
	 * System.out.println(e); } S }
	 **/

	/* CRUD INSERÇÃO NO BANCO */

	public void inserirCliente(Cliente cliente) {
		String dados = "insert into tb_cliente(CPF,NOME,EMAIL,HABILITACAO,PLACA,NASCIMENTO,TELEFONE,TIPO_DE_CLIENTE) values"
				+ "(?,?,?,?,?,?,?,?)";

		try {
			
			// Abrir a conexão com o banco
			Connection con = conectar();
			
			// Preparar a query para execução no banco de dados			
			PreparedStatement pst = con.prepareStatement(dados);
			
            // Substitur os parâmetros (?) pelo conteúdo das variáveis da classe Cliente
			
			pst.setString(1, cliente.getCpf());
			pst.setString(2, cliente.getNome());
			pst.setString(3, cliente.getEmail());
			pst.setString(4, cliente.getHabilitacao());
			pst.setString(5, cliente.getPlaca());
			pst.setString(6, cliente.getNascimento());
			pst.setString(7, cliente.getTelefone());
			pst.setString(8, cliente.getTipo_de_cliente());
			
			// Executar a query
			
			pst.executeUpdate();
			
			// Encerrar a conexão com o banco de dados
			
			con.close();
			
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	/* CRUD LISTAR*/
	
	public ArrayList<Cliente> listarClientes(){
		
		// Criando um objeto para acessar a classe cliente
		
		ArrayList<Cliente> cliente = new ArrayList<>();
		
		String listar = "select * from tb_cliente order by NOME";
		
		try {
			
			// Abrir a conexão com o banco
			Connection con = conectar();
			
			// Preparar a query para execução no banco de dados	
			PreparedStatement pst = con.prepareStatement(listar);
			ResultSet res = pst.executeQuery();	
			// O laço será executado enquanto houver cliente cadastrado
			while(res.next()) {
				
				 // variáveis que apoiam o que é recebido do banco
				
				String cpf = res.getString(1);
				String nome = res.getString(2);
				String email = res.getString(3);
				String habilitacao = res.getString(4);
				String placa = res.getString(5);
				String nascimento = res.getString(6);
				String telefone = res.getString(7);
				String tipo_de_cliente = res.getString(8);
				
				//Armazenamento de tudo que esta chegando do banco no vetor dinamico. Populando o ArrayList
				
				cliente.add(new Cliente(cpf,nome,email,habilitacao,placa,nascimento,telefone,tipo_de_cliente));
			}
			con.close();
			return cliente;
			
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}
		
	}

}
