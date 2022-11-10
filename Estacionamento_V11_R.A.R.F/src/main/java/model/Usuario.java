package model;

public class Usuario {
	
	private String usuario;
	private String senha;
	private String funcao;
	
	
	public Usuario() {
		
		super();
	}
	
	
	public Usuario(String usuario, String senha, String funcao) {
		 super();
		 this.usuario = usuario;
		 this.senha = senha;
		 this.funcao = funcao;
		
	}


	public String getUsuario() {
		return usuario;
	}


	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}


	public String getSenha() {
		return senha;
	}


	public void setSenha(String senha) {
		this.senha = senha;
	}


	public String getFuncao() {
		return funcao;
	}


	public void setFuncao(String funcao) {
		this.funcao = funcao;
	}
	
	
	
	

}
