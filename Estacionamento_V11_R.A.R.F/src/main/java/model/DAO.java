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
	
	
	
	/*Acessar o sistema através do login*/
	
	public boolean acessoSistema(Usuario usuario) throws Exception {
		String login = "select * from tb_usuario where USUARIO=? and SENHA=?";
		
		
			
			Connection con = conectar();

			// Preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(login);
			
			pst.setString(1, usuario.getUsuario());
			pst.setString(2, usuario.getSenha());
			
			ResultSet res = pst.executeQuery();
			
			if(res.next()) {
				return true;
				
			}else {
				
				return false;
			}
			
	}
	

			
				
		 
		


	/* CRUD INSERÇÃO NO BANCO */

	/* Inserção do cliente */

	public void inserirCliente(Cliente cliente) {
		String dados = "insert into tb_cliente(CPF,NOME,EMAIL,HABILITACAO,NASCIMENTO,TELEFONE,TIPO_DE_CLIENTE) values"
				+ "(?,?,?,?,?,?,?)";

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
			// pst.setString(5, cliente.getPlaca());
			pst.setString(5, cliente.getNascimento());
			pst.setString(6, cliente.getTelefone());
			pst.setString(7, cliente.getTipo_de_cliente());

			// Executar a query

			pst.executeUpdate();

			// Encerrar a conexão com o banco de dados

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/* Inserção do veículo */

	public void inserirVeiculo(Veiculo veiculo) {
		String dados = "insert into tb_veiculo(NUMERO_DA_PLACA,MARCA,MODELO,TIPO_DE_VEICULO,CPF) value" + "(?,?,?,?,?)";
		try {

			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(dados);

			pst.setString(1, veiculo.getNumeroPlaca());
			pst.setString(2, veiculo.getMarca());
			pst.setString(3, veiculo.getModelo());
			pst.setString(4, veiculo.getTipoVeiculo());
			pst.setString(5, veiculo.getCpf());

			pst.executeUpdate();

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/* Inserção do usuario */

	public void inserirUsuario(Usuario usuario) {
		String dados = "insert into tb_usuario(USUARIO,SENHA,FUNCAO) value " + "(?,?,?)";
		try {

			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(dados);

			pst.setString(1, usuario.getUsuario());
			pst.setString(2, usuario.getSenha());
			pst.setString(3, usuario.getFuncao());

			pst.executeUpdate();

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	/* CRUD LISTAR */

	// Listando os clientes

	public ArrayList<Cliente> listarClientes() {

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
			while (res.next()) {

				// variáveis que apoiam o que é recebido do banco

				String cpf = res.getString(1);
				String nome = res.getString(2);
				String email = res.getString(3);
				String habilitacao = res.getString(4);
				String nascimento = res.getString(5);
				String telefone = res.getString(6);
				String tipo_de_cliente = res.getString(7);

				// Armazenamento de tudo que esta chegando do banco no vetor dinamico. Populando
				// o ArrayList

				cliente.add(new Cliente(cpf, nome, email, habilitacao, nascimento, telefone, tipo_de_cliente));
			}
			con.close();
			return cliente;

		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	// Listando os veículos

	public ArrayList<Veiculo> listarVeiculo() {
		// Criando um objeto para acessar a classe veiculo

		ArrayList<Veiculo> veiculo = new ArrayList<>();

		String listar = "select * from tb_veiculo";

		try {

			// Abrindo a conexão com o banco
			Connection con = conectar();

			// Preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(listar);
			ResultSet res = pst.executeQuery();

			while (res.next()) {

				// variáveis que apoiam o que é recebido do banco

				String numeroPlaca = res.getString(1);
				String marca = res.getString(2);
				String modelo = res.getString(3);
				String tipoVeiculo = res.getString(4);
				String cpf = res.getString(5);

				// Armazenamento de tudo que esta chegando do banco no vetor dinamico. Populando
				// o ArrayList

				veiculo.add(new Veiculo(numeroPlaca, marca, modelo, tipoVeiculo, cpf));
			}

			con.close();
			return veiculo;

		} catch (Exception e) {
			return null;
		}

	}
	
	// Listando os usuários

		public ArrayList<Usuario> listarUsuario() {
			// Criando um objeto para acessar a classe veiculo

			ArrayList<Usuario> user = new ArrayList<>();

			String listar = "select * from tb_usuario";

			try {

				// Abrindo a conexão com o banco
				Connection con = conectar();

				// Preparar a query para execução no banco de dados
				PreparedStatement pst = con.prepareStatement(listar);
				ResultSet res = pst.executeQuery();

				while (res.next()) {

					// variáveis que apoiam o que é recebido do banco

					String usuario = res.getString(1);
					String senha = res.getString(2);
					String funcao = res.getString(3);
					

					// Armazenamento de tudo que esta chegando do banco no vetor dinamico. Populando
					// o ArrayList

					user.add(new Usuario(usuario, senha, funcao));
				}

				con.close();
				return user;

			} catch (Exception e) {
				return null;
			}

		}

	/* CRUD UPDATE */

	// Selecionar o cliente a ser alterado

	public void selecionarCliente(Cliente cliente) {
		String rest2 = "select * from tb_cliente where CPF=?";
		try {

			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(rest2);
			pst.setString(1, cliente.getCpf());
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				// Setar as variáveis da classe Cliente
				cliente.setCpf(res.getString(1));
				cliente.setNome(res.getString(2));
				cliente.setEmail(res.getString(3));
				cliente.setHabilitacao(res.getString(4));
				cliente.setNascimento(res.getString(5));
				cliente.setTelefone(res.getString(6));
				cliente.setTipo_de_cliente(res.getString(7));
			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

	// Editar o contato
	public void alterarCliente(Cliente cliente) {

		String criar = "update tb_cliente set NOME=?,EMAIL=?,HABILITACAO=?,NASCIMENTO=?,TELEFONE=?,TIPO_DE_CLIENTE=? where CPF=?";

		try {
			// Abrir a conexão com o banco
			Connection con = conectar();

			// Preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(criar);

			// Substitur os parâmetros (?) pelo conteúdo das variáveis da classe Cliente

			pst.setString(7, cliente.getCpf());
			pst.setString(1, cliente.getNome());
			pst.setString(2, cliente.getEmail());
			pst.setString(3, cliente.getHabilitacao());
			pst.setString(4, cliente.getNascimento());
			pst.setString(5, cliente.getTelefone());
			pst.setString(6, cliente.getTipo_de_cliente());

			// Executar a query

			pst.executeUpdate();

			// Encerrar a conexão com o banco de dados

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	// Selecionar o veículo a ser alterado

	public void selecionarVeiculo(Veiculo veiculo) {
		String rest2 = "select * from tb_veiculo where NUMERO_DA_PLACA=?";
		try {

			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(rest2);
			pst.setString(1, veiculo.getNumeroPlaca());
			ResultSet res = pst.executeQuery();
			while (res.next()) {
				// Setar as variáveis da classe Veiculo

				veiculo.setNumeroPlaca(res.getString(1));
				veiculo.setMarca(res.getString(2));
				veiculo.setModelo(res.getString(3));
				veiculo.setTipoVeiculo(res.getString(4));
				veiculo.setCpf(res.getString(5));

			}

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	// Editar o veículo
		public void alterarVeiculo(Veiculo veiculo) {

			String criar = "update tb_veiculo set MARCA=?,MODELO=?,TIPO_DE_VEICULO=?,CPF=? where NUMERO_DA_PLACA=?";

			try {
				// Abrir a conexão com o banco
				Connection con = conectar();

				// Preparar a query para execução no banco de dados
				PreparedStatement pst = con.prepareStatement(criar);

				// Substitur os parâmetros (?) pelo conteúdo das variáveis da classe Veiculo
				pst.setString(5, veiculo.getNumeroPlaca());
				pst.setString(1, veiculo.getMarca());
				pst.setString(2, veiculo.getModelo());
				pst.setString(3, veiculo.getTipoVeiculo());
				pst.setString(4, veiculo.getCpf());

				// Executar a query

				pst.executeUpdate();

				// Encerrar a conexão com o banco de dados

				con.close();

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	
	// Selecionar o usuario a ser alterado

		public void selecionarUsuario(Usuario usuario) {
			String rest2 = "select * from tb_usuario where USUARIO=?";
			try {

				Connection con = conectar();
				PreparedStatement pst = con.prepareStatement(rest2);
				pst.setString(1, usuario.getUsuario());
				ResultSet res = pst.executeQuery();
				while (res.next()) {
					// Setar as variáveis da classe Usuario
					
					usuario.setUsuario(res.getString(1));
                    usuario.setSenha(res.getString(2));
                    usuario.setFuncao(res.getString(3));
				

				}

				con.close();

			} catch (Exception e) {
				System.out.println(e);
			}

		}

	// Editar o veículo
	public void alterarUsuario(Usuario usuario) {

		String criar = "update tb_usuario set SENHA=?,FUNCAO=? where USUARIO=?";

		try {
			// Abrir a conexão com o banco
			Connection con = conectar();

			// Preparar a query para execução no banco de dados
			PreparedStatement pst = con.prepareStatement(criar);

			// Substitur os parâmetros (?) pelo conteúdo das variáveis da classe Usuario
			
			pst.setString(3, usuario.getUsuario());
			pst.setString(1, usuario.getSenha());
			pst.setString(2, usuario.getFuncao());
		

			// Executar a query

			pst.executeUpdate();

			// Encerrar a conexão com o banco de dados

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/* CRUD DELETE - Deletar o cliente */

	public void deletarCliente(Cliente cliente) {
		String delete = "delete from tb_cliente where cpf=?";
		try {
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, cliente.getCpf());

			pst.executeUpdate();

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	/* Deletar o veículo */

	public void deletarVeiculo(Veiculo veiculo) {
		String delete = "delete from tb_veiculo where NUMERO_DA_PLACA=?";
		try {
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, veiculo.getNumeroPlaca());

			pst.executeUpdate();

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}
	
	/* Deletar o usuario */

	public void deletarUsuario(Usuario usuario) {
		String delete = "delete from tb_usuario where USUARIO=?";
		try {
			Connection con = conectar();

			PreparedStatement pst = con.prepareStatement(delete);
			pst.setString(1, usuario.getUsuario());

			pst.executeUpdate();

			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
