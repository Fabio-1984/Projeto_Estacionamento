package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import model.Cliente;
import model.DAO;
import model.Pagar;
import model.Suporte;
import model.Usuario;
import model.Veiculo;

@WebServlet(urlPatterns = { "/Controller", "/principal", "/insertC", "/insertV", "/insertU", "/insertS", "/insertPg",
		"/listarC", "/listarV", "/listarU", "/listarS", "/listarP", "/editarC", "/editarV", "/editarU", "/editarS",
		"/atualizarC", "/atualizarV", "/atualizarU", "/deleteC", "/deleteV", "/deleteU", "/documento", "/documentoV",
		"/documentoU", "/documentoP", "/deslogar" })

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	DAO dao = new DAO();
	Cliente cliente = new Cliente();
	Veiculo veiculo = new Veiculo();
	Usuario usuario = new Usuario();
	Pagar pagar = new Pagar();
	Suporte suporte = new Suporte();

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

		} else if (action.equals("/insertS")) {
			suporteUsuario(request, response);

		} else if (action.equals("/insertPg")) {
			pagamentoEstacionar(request, response);

		} else if (action.equals("/listarC")) {
			listaCliente(request, response);

		} else if (action.equals("/listarV")) {
			listaVeiculo(request, response);

		} else if (action.equals("/listarS")) {
			listaChamado(request, response);

		} else if (action.equals("/listarU")) {
			listaUsuario(request, response);

		} else if (action.equals("/listarP")) {
			listaPagamento(request, response);

		} else if (action.equals("/editarC")) {
			selecCliente(request, response);

		} else if (action.equals("/editarV")) {
			selecVeiculo(request, response);

		} else if (action.equals("/editarU")) {
			selecUsuario(request, response);

		} else if (action.equals("/editarS")) {
			selecChamado(request, response);

		} else if (action.equals("/atualizarC")) {
			editarCliente(request, response);

		} else if (action.equals("/atualizarV")) {
			editarVeiculo(request, response);

		} else if (action.equals("/atualizarU")) {
			editarUsuario(request, response);

		} else if (action.equals("/deleteC")) {
			removerCliente(request, response);

		} else if (action.equals("/deleteV")) {
			removerVeiculo(request, response);

		} else if (action.equals("/deleteU")) {
			removerUsuario(request, response);

		} else if (action.equals("/documento")) {
			gerarRelatorio(request, response);

		} else if (action.equals("/documentoV")) {
			gerarRelatorioV(request, response);

		} else if (action.equals("/documentoU")) {
			gerarRelatorioU(request, response);

		} else if (action.equals("/documentoP")) {
			gerarRelatorioP(request, response);

		} else if (action.equals("/deslogar")) {
			sair(request, response);

		}
	}

	// Acesso a página principal

	protected void paginaPrincipal(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		usuario.setUsuario(request.getParameter("login"));
		usuario.setSenha(request.getParameter("pwd"));

		try {
			if (dao.acessoSistema(usuario)) {

				request.getSession().setAttribute("usuario", usuario.getUsuario());

				request.setAttribute("tb_usuario", usuario);
				// RequestDispatcher: É uma classe trabalha requisições e respostas no servlet
				RequestDispatcher rdi = request.getRequestDispatcher("Principal.html");
				rdi.forward(request, response);

			} else {

				// response.setContentType("text/html;charset=UTF-8");
				// PrintWriter out = response.getWriter();
				// out.println("Usuário e ou senha inválidos");
				// RequestDispatcher: É uma classe trabalha requisições e respostas no servlet
				System.out.println("Login ou senha inválidos");
				RequestDispatcher rdi = request.getRequestDispatcher("TelaLogin.html");
				rdi.forward(request, response);

			}

		} catch (Exception e) {
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

	// Chamado enviado ao suporte

	protected void suporteUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		suporte.setNome(request.getParameter("fname"));
		suporte.setEmail(request.getParameter("email"));
		suporte.setDescricao(request.getParameter("info"));
		suporte.setArquivo(request.getParameter("arquivos"));

		dao.inserirFalha(suporte);

		response.sendRedirect("Suporte.html");

	}

	// Registrar pagamento

	protected void pagamentoEstacionar(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		pagar.setCpf(request.getParameter("cpf"));
		pagar.setPeriodo(request.getParameter("periodo"));
		pagar.setData(request.getParameter("data"));
		pagar.setValor(request.getParameter("valor"));

		dao.inserirPagamento(pagar);

		response.sendRedirect("Finalizar_Servico.html");

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
		// Criando um objeto que ira receber os dados do usuário

		ArrayList<Usuario> lista = dao.listarUsuario();

		request.setAttribute("tb_usuario", lista);

		RequestDispatcher rdi = request.getRequestDispatcher("ListarUsuario.jsp");
		rdi.forward(request, response);

	}

	protected void listaChamado(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que ira receber os dados do veículo
		ArrayList<Suporte> lista = dao.listarChamado();

		// Teste de recebimento da lista

		// Encaminhar a lista ao documento Backlog.jsp
		request.setAttribute("tb_suporte", lista);
		// RequestDispatcher: É uma classe trabalha requisições e respostas no servlet
		RequestDispatcher rdi = request.getRequestDispatcher("Backlog.jsp");
		rdi.forward(request, response);

	}

	protected void listaPagamento(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Criando um objeto que ira receber os dados do usuário

		ArrayList<Pagar> lista = dao.listarPagamento();

		request.setAttribute("tb_finalizarservico", lista);

		RequestDispatcher rdi = request.getRequestDispatcher("FinalizarServico.jsp");
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

	protected void selecChamado(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// vai receber o numero do nome(NOME) do chamado que será editado
		String nome = request.getParameter("nome");
		
        suporte.setChamado(nome);
		

		// Executar o método selecinarChamado da classe DAO
		dao.selecionarChamado(suporte);
		// Setar os atributos do formulário com o conteúdo da classe Suporte
		
		request.setAttribute("chamado", suporte.getChamado());
		request.setAttribute("fname", suporte.getNome());
		request.setAttribute("email", suporte.getEmail());
		request.setAttribute("info", suporte.getDescricao());
		request.setAttribute("arquivos", suporte.getArquivo());

		// Encaminhar ao documento Backlog.jsp

		RequestDispatcher rdi = request.getRequestDispatcher("Backlog.jsp");
		rdi.forward(request, response);

	}

	// Excluir o cliente
	protected void removerCliente(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recebimento do cpf do cliente a ser excluido(validador.jsd)
		String cpf = request.getParameter("cpf");
		// Setar a variável cpf Cliente
		cliente.setCpf(cpf);
		// Executar o método deletarCliente
		dao.deletarCliente(cliente);

		// Redirecionar para o documento ListarCliente.jsp(Com os dados atualizados)

		response.sendRedirect("listarC");

	}

	// Excluir o veículo
	protected void removerVeiculo(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recebimento do cpf do cliente a ser excluido(validador.jsd)
		String placa = request.getParameter("numeroPlaca");
		// Setar a variável numero da placa Veiculo
		veiculo.setNumeroPlaca(placa);
		// Executar o método deletarVeiculo
		dao.deletarVeiculo(veiculo);

		// Redirecionar para o documento ListarCliente.jsp(Com os dados atualizados)

		response.sendRedirect("listarV");

	}

	// Excluir o usuário
	protected void removerUsuario(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// Recebimento do cpf do cliente a ser excluido(validador.jsd)
		String user = request.getParameter("usuarios");
		// Setar a variável numero da placa Veiculo
		usuario.setUsuario(user);
		// Executar o método deletarVeiculo
		dao.deletarUsuario(usuario);

		// Redirecionar para o documento ListarCliente.jsp(Com os dados atualizados)

		response.sendRedirect("listarU");

	}

	// Gerar relatório PDF dos clientes
	protected void gerarRelatorio(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Document documento = new Document();

		try {
			// Conteúdo
			response.setContentType("apllicatio/pdf");
			// Nome do documento
			response.addHeader("Content-Disposition", "inline; filename=" + "clientes.pdf");
			// Criar o documento
			PdfWriter.getInstance(documento, response.getOutputStream());
			// Abrir o documento para gerar o conteúdo
			documento.open();
			documento.add(new Paragraph("Dados dos clientes: "));
			documento.add(new Paragraph(" "));
			// Criar uma tabela
			PdfPTable tabela = new PdfPTable(7);
			// Cabeçalho
			PdfPCell col1 = new PdfPCell(new Paragraph("CPF"));
			PdfPCell col2 = new PdfPCell(new Paragraph("NOME"));
			PdfPCell col3 = new PdfPCell(new Paragraph("EMAIL"));
			PdfPCell col4 = new PdfPCell(new Paragraph("HABILITAÇÃO"));
			PdfPCell col5 = new PdfPCell(new Paragraph("NASCIMENTO"));
			PdfPCell col6 = new PdfPCell(new Paragraph("TELEFONE"));
			PdfPCell col7 = new PdfPCell(new Paragraph("TIPO DE CLIENTE"));
			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);
			tabela.addCell(col6);
			tabela.addCell(col7);
			// Popular a tabela com os dados dos clientes

			ArrayList<Cliente> lista = dao.listarClientes();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getCpf());
				tabela.addCell(lista.get(i).getNome());
				tabela.addCell(lista.get(i).getEmail());
				tabela.addCell(lista.get(i).getHabilitacao());
				tabela.addCell(lista.get(i).getNascimento());
				tabela.addCell(lista.get(i).getTelefone());
				tabela.addCell(lista.get(i).getTipo_de_cliente());

			}

			documento.add(tabela);
			documento.close();

		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}

	}

	// Gerar relatório PDF dos veículos
	protected void gerarRelatorioV(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Document documento = new Document();

		try {
			// Conteúdo
			response.setContentType("apllicatio/pdf");
			// Nome do documento
			response.addHeader("Content-Disposition", "inline; filename=" + "Veículos.pdf");
			// Criar o documento
			PdfWriter.getInstance(documento, response.getOutputStream());
			// Abrir o documento para gerar o conteúdo
			documento.open();
			documento.add(new Paragraph("Dados dos veículos: "));
			documento.add(new Paragraph(" "));
			// Criar uma tabela
			PdfPTable tabela = new PdfPTable(5);
			// Cabeçalho
			PdfPCell col1 = new PdfPCell(new Paragraph("NUMERO DA PLACA	"));
			PdfPCell col2 = new PdfPCell(new Paragraph("MARCA"));
			PdfPCell col3 = new PdfPCell(new Paragraph("MODELO"));
			PdfPCell col4 = new PdfPCell(new Paragraph("TIPO DE VEÍCULO	"));
			PdfPCell col5 = new PdfPCell(new Paragraph("CPF"));

			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);
			tabela.addCell(col5);

			// Popular a tabela com os dados dos veículos

			ArrayList<Veiculo> lista = dao.listarVeiculo();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getNumeroPlaca());
				tabela.addCell(lista.get(i).getMarca());
				tabela.addCell(lista.get(i).getModelo());
				tabela.addCell(lista.get(i).getTipoVeiculo());
				tabela.addCell(lista.get(i).getCpf());

			}

			documento.add(tabela);
			documento.close();

		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}

	}

	// Gerar relatório PDF dos veículos
	protected void gerarRelatorioU(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Document documento = new Document();

		try {
			// Conteúdo
			response.setContentType("apllicatio/pdf");
			// Nome do documento
			response.addHeader("Content-Disposition", "inline; filename=" + "Usuários.pdf");
			// Criar o documento
			PdfWriter.getInstance(documento, response.getOutputStream());
			// Abrir o documento para gerar o conteúdo
			documento.open();
			documento.add(new Paragraph("Dados dos usuários: "));
			documento.add(new Paragraph(" "));
			// Criar uma tabela
			PdfPTable tabela = new PdfPTable(3);
			// Cabeçalho
			PdfPCell col1 = new PdfPCell(new Paragraph("USUARIO	"));
			PdfPCell col2 = new PdfPCell(new Paragraph("SENHA"));
			PdfPCell col3 = new PdfPCell(new Paragraph("FUNÇAO"));

			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);

			// Popular a tabela com os dados dos veículos

			ArrayList<Usuario> lista = dao.listarUsuario();
			for (int i = 0; i < lista.size(); i++) {
				tabela.addCell(lista.get(i).getUsuario());
				tabela.addCell(lista.get(i).getSenha());
				tabela.addCell(lista.get(i).getFuncao());

			}

			documento.add(tabela);
			documento.close();

		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}

	}

	// Gerar relatório PDF dos pagamentos
	protected void gerarRelatorioP(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		Document documento = new Document();

		try {
			// Conteúdo
			response.setContentType("apllicatio/pdf");
			// Nome do documento
			response.addHeader("Content-Disposition", "inline; filename=" + "NFE.pdf");
			// Criar o documento
			PdfWriter.getInstance(documento, response.getOutputStream());
			// Abrir o documento para gerar o conteúdo
			documento.open();
			documento.add(new Paragraph("Dados para pagamento: "));
			documento.add(new Paragraph(" "));
			// Criar uma tabela
			PdfPTable tabela = new PdfPTable(4);
			// Cabeçalho
			PdfPCell col1 = new PdfPCell(new Paragraph("CPF	"));
			PdfPCell col2 = new PdfPCell(new Paragraph("PERIODO"));
			PdfPCell col3 = new PdfPCell(new Paragraph("DATA"));
			PdfPCell col4 = new PdfPCell(new Paragraph("VALOR"));

			tabela.addCell(col1);
			tabela.addCell(col2);
			tabela.addCell(col3);
			tabela.addCell(col4);

			// Popular a tabela com os dados dos pagamentos

			ArrayList<Pagar> lista = dao.listarPagamento();
			for (int i = 0; i < lista.size(); i++) {

				tabela.addCell(lista.get(i).getCpf());
				tabela.addCell(lista.get(i).getCpf());
				tabela.addCell(lista.get(i).getCpf());
				tabela.addCell(lista.get(i).getValor());

			}

			documento.add(tabela);
			documento.close();

		} catch (Exception e) {
			System.out.println(e);
			documento.close();
		}

	}

	protected void sair(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.sendRedirect("TelaLogin.html");
	}

}
