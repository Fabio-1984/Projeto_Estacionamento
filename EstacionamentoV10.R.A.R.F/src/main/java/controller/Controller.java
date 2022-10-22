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
import model.Cliente;

@WebServlet(urlPatterns = { "/Controller", "/principal", "/insert", "/listar" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	Cliente cliente = new Cliente();

	public Controller() {
		super();

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();
		System.out.println(action);
		if (action.equals("/principal")) {
			principal(request, response);
		} else if (action.equals("/insert")) {
			novoCliente(request, response);

		} else if(action.equals("/listar")) {
			listaCliente(request, response);
			
		}

	}

	// Acesso a página principal

	protected void principal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
          response.sendRedirect("Principal.html");
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
		cliente.setPlaca(request.getParameter("placa"));
		cliente.setNascimento(request.getParameter("dataNascimento"));
		cliente.setTelefone(request.getParameter("telefone"));
		cliente.setTipo_de_cliente(request.getParameter("tipoCliente"));

		// Invocar o método inserirCliente passando o objeto contato

		dao.inserirCliente(cliente);

		// Redirecionar para a página cadastro de cliente depois do envio dos dados.

		response.sendRedirect("Cadastrar_Cliente.html");

	}


         //Listar os clientes cadastrados
	protected void listaCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que ira receber os dados do cliente
		ArrayList<Cliente> lista = dao.listarClientes();
		
		// Teste de recebimento da lista

		/*for (int i = 0; i < lista.size(); i++) {
			System.out.println(lista.get(i).getCpf());
			System.out.println(lista.get(i).getNome());
			System.out.println(lista.get(i).getEmail());
			System.out.println(lista.get(i).getHabilitacao());
			System.out.println(lista.get(i).getPlaca());
			System.out.println(lista.get(i).getNascimento());
			System.out.println(lista.get(i).getTelefone());
			System.out.println(lista.get(i).getTipo_de_cliente());			
		}*/
		
		 // Encaminhar a lista ao documento Listar_Contato.jsp
		 request.setAttribute("tb_cliente", lista);
		 // RequestDispatcher: É uma classe trabalha requisições e respostas no servelet
		 RequestDispatcher rdi = request.getRequestDispatcher("ListarCliente.jsp");
		 rdi.forward(request, response);

	}

}
