package model;

public class Cliente {
	private String cpf;
	private String nome;
	private String email;
	private String habilitacao;
	private String placa;
	private String nascimento;
	private String telefone;
	private String tipo_de_cliente;
	
	
	
	public Cliente() {
		super();
		
	}
	
	
	
	public Cliente(String cpf, String nome, String email, String habilitacao, String placa, String nascimento,
			String telefone, String tipo_de_cliente) {
		super();
		this.cpf = cpf;
		this.nome = nome;
		this.email = email;
		this.habilitacao = habilitacao;
		this.placa = placa;
		this.nascimento = nascimento;
		this.telefone = telefone;
		this.tipo_de_cliente = tipo_de_cliente;
	}



	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getHabilitacao() {
		return habilitacao;
	}
	public void setHabilitacao(String habilitacao) {
		this.habilitacao = habilitacao;
	}
	public String getPlaca() {
		return placa;
	}
	public void setPlaca(String placa) {
		this.placa = placa;
	}
	public String getNascimento() {
		return nascimento;
	}
	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public String getTipo_de_cliente() {
		return tipo_de_cliente;
	}
	public void setTipo_de_cliente(String tipo_de_cliente) {
		this.tipo_de_cliente = tipo_de_cliente;
	}
	
	

}
