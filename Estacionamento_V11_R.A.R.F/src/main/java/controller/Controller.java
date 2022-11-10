package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.DAO;
import model.Usuario;
import model.Veiculo;
import model.Cliente;

@WebServlet(urlPatterns = { "/Controller", "/principal", "/insertC", "/insertV", "/insertU", "/listarC", "/listarV", "/listarU",
		"/editarC","/editarV", "/editarU", "/atualizarC", "/atualizarV", "/atualizarU", "/deleteC", "/deleteV", "/deleteU", "/deslogar" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	Cliente cliente = new Cliente();
	Veiculo veiculo = new Veiculo();
	Usuario usuario = new Usuario();
	
	

	public Controller() {
		super();

	}
	

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/principal")) {
			paginaPrincipal(request, response);
		} else if (action.equals("/insertC")) {
			novoCliente(request, response);

		} else if (action.equals("/insertV")) {
			novoVeiculo(request, response);

		} else if (action.equals("/insertU")) {
			novoUsuario(request, response);

		} else if (action.equals("/listarC")) {
			listaCliente(request, response);

		} else if (action.equals("/listarV")) {
			listaVeiculo(request, response);
			
		}else if (action.equals("/listarU")) {
			listaUsuario(request, response);	

		} else if (action.equals("/editarC")) {
			selecCliente(request, response);
		
		}else if (action.equals("/editarV")) {
				selecVeiculo(request, response);
		}else if (action.equals("/editarU")) {
			selecUsuario(request, response);				
		}  else if (action.equals("/atualizarC")) {
			editarCliente(request, response);
			
		}else if (action.equals("/atualizarV")) {
			editarVeiculo(request, response);	
		}else if (action.equals("/atualizarU")) {
			editarUsuario(request, response);	

		} else if (action.equals("/deleteC")) {
			removerCliente(request, response);

		}else if (action.equals("/deleteV")) {
			removerVeiculo(request, response);

		}else if (action.equals("/deleteU")) {
			removerUsuario(request, response);
			
		}else if(action.equals("/deslogar")){
			sair(request, response);
		   
		}
	}

	// Acesso a página principal

	protected void paginaPrincipal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		    
		
			usuario.setUsuario(request.getParameter("login"));
	        usuario.setSenha(request.getParameter("pwd"));
	       
	        try {
	        if(dao.acessoSistema(usuario)) {
	        	
	        	request.getSession().setAttribute("usuario", usuario.getUsuario());
	        	
	        	request.setAttribute("tb_usuario", usuario);
	    		// RequestDispatcher: É uma classe trabalha requisições e respostas no servlet
	    		RequestDispatcher rdi = request.getRequestDispatcher("Principal.html");
	    		rdi.forward(request, response);
	    		
	        	
	        	
	        }else {
	        	
	        	request.setAttribute("Mensagem:", "Login ou senha inválidos");
	    		// RequestDispatcher: É uma classe trabalha requisições e respostas no servlet
	    		RequestDispatcher rdi = request.getRequestDispatcher("TelaLogin.html");	    		
	    		rdi.forward(request, response);
	        	
	        }
	        
	        }catch (Exception e) {
				System.out.println(e);
			}
	        	
	        }
	        
	        
					
			
		
        
	

	// Cadastrar Novo cliente	
	protected void novoCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// teste de inserção

		/*
		 * System.out.println(request.getParameter("cpf"));
		 * System.out.println(request.getParameter("nome"));
		 * System.out.println(request.getParameter("email"));
		 * System.out.println(request.getParameter("habilitacao"));
		 * System.out.println(request.getParameter("placa"));
		 * System.out.println(request.getParameter("dataNascimento"));
		 * System.out.println(request.getParameter("telefone"));
		 * System.out.println(request.getParameter("tipoCliente"));
		 */

		// setar as variáveis na classe cliente

		cliente.setCpf(request.getParameter("cpf"));
		cliente.setNome(request.getParameter("nome"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setHabilitacao(request.getParameter("habilitacao"));
		// cliente.setPlaca(request.getParameter("placa"));
		cliente.setNascimento(request.getParameter("dataNascimento"));
		cliente.setTelefone(request.getParameter("telefone"));
		cliente.setTipo_de_cliente(request.getParameter("tipoCliente"));

		// Invocar o método inserirCliente passando o objeto contato

		dao.inserirCliente(cliente);

		// Redirecionar para a página cadastro de cliente depois do envio dos dados.

		response.sendRedirect("Cadastrar_Cliente.html");

	}

	// Cadastrar Novo veiculo

	protected void novoVeiculo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * System.out.println(request.getParameter("numeroPlaca"));
		 * System.out.println(request.getParameter("marca"));
		 * System.out.println(request.getParameter("modelo"));
		 * System.out.println(request.getParameter("tipoVeiculo"));
		 * System.out.println(request.getParameter("cpf"));
		 */

		veiculo.setNumeroPlaca(request.getParameter("numeroPlaca"));
		veiculo.setMarca(request.getParameter("marca"));
		veiculo.setModelo(request.getParameter("modelo"));
		veiculo.setTipoVeiculo(request.getParameter("tipoVeiculo"));
		veiculo.setCpf(request.getParameter("cpf"));

		dao.inserirVeiculo(veiculo);

		response.sendRedirect("Cadastrar_Veiculo.html");

	}

	// Cadastrar Usuario

	protected void novoUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		/*
		 * System.out.println(request.getParameter("usuario"));
		 * System.out.println(request.getParameter("senha"));
		 * System.out.println(request.getParameter("funcao"));
		 */

		usuario.setUsuario(request.getParameter("usuario"));
		usuario.setSenha(request.getParameter("senha"));
		usuario.setFuncao(request.getParameter("funcao"));

		dao.inserirUsuario(usuario);

		response.sendRedirect("CriarUsuario.html");

	}

	// Listar os clientes cadastrados
	protected void listaCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que ira receber os dados do cliente
		ArrayList<Cliente> lista = dao.listarClientes();

		// Teste de recebimento da lista

		/*
		 * for (int i = 0; i < lista.size(); i++) {
		 * System.out.println(lista.get(i).getCpf());
		 * System.out.println(lista.get(i).getNome());
		 * System.out.println(lista.get(i).getEmail());
		 * System.out.println(lista.get(i).getHabilitacao());
		 * System.out.println(lista.get(i).getPlaca());
		 * System.out.println(lista.get(i).getNascimento());
		 * System.out.println(lista.get(i).getTelefone());
		 * System.out.println(lista.get(i).getTipo_de_cliente()); }
		 */

		// Encaminhar a lista ao documento ListarCliente.jsp
		request.setAttribute("tb_cliente", lista);
		// RequestDispatcher: É uma classe trabalha requisições e respostas no servlet
		RequestDispatcher rdi = request.getRequestDispatcher("ListarCliente.jsp");
		rdi.forward(request, response);

	}

	protected void listaVeiculo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que ira receber os dados do veículo
		ArrayList<Veiculo> lista = dao.listarVeiculo();

		// Teste de recebimento da lista

		// Encaminhar a lista ao documento ListarVeiculo.jsp
		request.setAttribute("tb_veiculo", lista);
		// RequestDispatcher: É uma classe trabalha requisições e respostas no servlet
		RequestDispatcher rdi = request.getRequestDispatcher("ListarVeiculo.jsp");
		rdi.forward(request, response);

	}
	
	
	protected void listaUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//  Criando um objeto que ira receber os dados do usuário
		
		ArrayList<Usuario> lista = dao.listarUsuario();
		
		request.setAttribute("tb_usuario", lista);
		
		RequestDispatcher rdi = request.getRequestDispatcher("ListarUsuario.jsp");
		rdi.forward(request, response);
		
		
	}

	// Seleciona o cliente a ser editado
	protected void selecCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// vai receber o id(CPF) do cliente que será editado
		String cpf = request.getParameter("cpf");
		// Teste de saida: System.out.println(cpf);
		// Setar a classe Cliente
		cliente.setCpf(cpf);
		// Executar o método selecinarCliente da classe DAO
		dao.selecionarCliente(cliente);
		// Setar os atributos do formulário com o conteúdo da classe Cliente
		request.setAttribute("cpf", cliente.getCpf());
		request.setAttribute("nome", cliente.getNome());
		request.setAttribute("email", cliente.getEmail());
		request.setAttribute("habilitacao", cliente.getHabilitacao());
		request.setAttribute("dataNascimento", cliente.getNascimento());
		request.setAttribute("telefone", cliente.getTelefone());
		request.setAttribute("tipoCliente", cliente.getTipo_de_cliente());
		// Encaminhar ao documento EditarCliente.jsp

		RequestDispatcher rdi = request.getRequestDispatcher("EditarCliente.jsp");
		rdi.forward(request, response);

	}

	// Editar o cliente
	protected void editarCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Setar as variáveis da classe Cliente

		cliente.setCpf(request.getParameter("cpf"));
		cliente.setNome(request.getParameter("nome"));
		cliente.setEmail(request.getParameter("email"));
		cliente.setHabilitacao(request.getParameter("habilitacao"));
		cliente.setNascimento(request.getParameter("dataNascimento"));
		cliente.setTelefone(request.getParameter("telefone"));
		cliente.setTipo_de_cliente(request.getParameter("tipoCliente"));
		

		// Executar o método alterarCliente

		dao.alterarCliente(cliente);

		// Redirecionar para o documento ListarCliente.jsp(Com os dados atualizados)

		response.sendRedirect("listarC");
	}
	
	
	// Seleciona o veículo a ser editado
	protected void selecVeiculo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// vai receber o numero da placa(NUMERO_DA_PLACA) do veículoe que será editado
		String placa = request.getParameter("numeroPlaca");
		// Teste de saida: System.out.println(numeroPlaca);
		// Setar a classe Veiculo
		
		veiculo.setNumeroPlaca(placa);
		
		// Executar o método selecinarCliente da classe DAO
		dao.selecionarVeiculo(veiculo);
		// Setar os atributos do formulário com o conteúdo da classe Cliente
		request.setAttribute("numeroPlaca", veiculo.getNumeroPlaca());
		request.setAttribute("marca", veiculo.getMarca());
		request.setAttribute("modelo", veiculo.getModelo());
		request.setAttribute("tipoVeiculo", veiculo.getTipoVeiculo());
		request.setAttribute("cpf", veiculo.getCpf());
		
		// Encaminhar ao documento EditarVeiculo.jsp

		RequestDispatcher rdi = request.getRequestDispatcher("EditarVeiculo.jsp");
		rdi.forward(request, response);

	}

	// Editar o veículo
	protected void editarVeiculo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Setar as variáveis da classe Veiculo
		veiculo.setNumeroPlaca(request.getParameter("numeroPlaca"));
        veiculo.setMarca(request.getParameter("marca"));
        veiculo.setModelo(request.getParameter("modelo"));
        veiculo.setTipoVeiculo(request.getParameter("tipoVeiculo"));
        veiculo.setCpf(request.getParameter("cpf"));
        
		
		

		// Executar o método alterarVeiculo

		dao.alterarVeiculo(veiculo);

		// Redirecionar para o documento ListarVeiculo.jsp(Com os dados atualizados)

		response.sendRedirect("listarV");
	}
	
	// Seleciona o usuário a ser editado
		protected void selecUsuario(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// vai receber o numero da placa(NUMERO_DA_PLACA) do veículoe que será editado
			String user = request.getParameter("usuarios");
			// Teste de saida: System.out.println(numeroPlaca);
			// Setar a classe Usuario
			
			usuario.setUsuario(user);
			
			// Executar o método selecinarUsuario da classe DAO
			dao.selecionarUsuario(usuario);
			// Setar os atributos do formulário com o conteúdo da classe Usuario
			request.setAttribute("usuarios", usuario.getUsuario());
			request.setAttribute("senha", usuario.getSenha());
			request.setAttribute("funcao ", usuario.getFuncao());
			
			
			// Encaminhar ao documento EditarVeiculo.jsp

			RequestDispatcher rdi = request.getRequestDispatcher("EditarUsuario.jsp");
			rdi.forward(request, response);

		}
		
		
		// Editar o Usuario
		protected void editarUsuario(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			// Setar as variáveis da classe Usuario
			
			usuario.setUsuario(request.getParameter("usuarios"));
			usuario.setSenha(request.getParameter("senha"));
			usuario.setFuncao(request.getParameter("funcao"));
	        
			// Executar o método alterarUsuario

			dao.alterarUsuario(usuario);

			// Redirecionar para o documento ListarUsuario.jsp(Com os dados atualizados)

			response.sendRedirect("listarU");
		}
	
	// Excluir o cliente
		protected void removerCliente(HttpServletRequest request, HttpServletResponse response)
				throws ServletException, IOException {
			
			// Recebimento do cpf do cliente a ser excluido(validador.jsd)
			String cpf = request.getParameter("cpf");
			//Setar a variável cpf Cliente
			cliente.setCpf(cpf);
			//Executar o método deletarCliente
			dao.deletarCliente(cliente);
			

			// Redirecionar para o documento ListarCliente.jsp(Com os dados atualizados)

			response.sendRedirect("listarC");
			
		}
		
		// Excluir o veículo
				protected void removerVeiculo(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
					
					// Recebimento do cpf do cliente a ser excluido(validador.jsd)
					String placa = request.getParameter("numeroPlaca");
					//Setar a variável numero da placa Veiculo
					veiculo.setNumeroPlaca(placa);
					//Executar o método deletarVeiculo
					dao.deletarVeiculo(veiculo);
					

					// Redirecionar para o documento ListarCliente.jsp(Com os dados atualizados)

					response.sendRedirect("listarV");
					
				}
				
				// Excluir o usuário
				protected void removerUsuario(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
					
					// Recebimento do cpf do cliente a ser excluido(validador.jsd)
					String user = request.getParameter("usuarios");
					//Setar a variável numero da placa Veiculo
					usuario.setUsuario(user);
					//Executar o método deletarVeiculo
					dao.deletarUsuario(usuario);
					

					// Redirecionar para o documento ListarCliente.jsp(Com os dados atualizados)

					response.sendRedirect("listarU");
					
				}
				
				protected void sair(HttpServletRequest request, HttpServletResponse response)
						throws ServletException, IOException {
					
					
			          response.sendRedirect("TelaLogin.html");
				}

}
