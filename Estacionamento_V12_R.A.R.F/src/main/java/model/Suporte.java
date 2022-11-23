package model;

public class Suporte {
	private String chamado;
	private String nome;
	private String email;
	private String descricao;
	private String arquivo;
	
	
	public Suporte() {
		super();
		
	}
	
	
	public Suporte(String chamado, String nome, String email, String descricao, String arquivo) {
		this.chamado = chamado;
		this.nome = nome;
		this.email = email;
		this.descricao = descricao;
		this.arquivo = arquivo;
		
	}
	
	public String getChamado() {
		return chamado;
	}


	public void setChamado(String chamado) {
		this.chamado = chamado;
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


	public String getDescricao() {
		return descricao;
	}


	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}


	public String getArquivo() {
		return arquivo;
	}


	public void setArquivo(String arquivo) {
		this.arquivo = arquivo;
	}
	
	

}
