package model;

public class Pagar {
	private String cpf;
	private String periodo;
	private String data;
	private String valor;
	
	public Pagar() {
		super();
		
	}
	
	public Pagar(String cpf, String periodo, String data, String valor) {
		super();
		
		this.cpf = cpf;
		this.periodo = periodo;
		this.data = data;
		this.valor = valor;
			
		
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getPeriodo() {
		return periodo;
	}

	public void setPeriodo(String periodo) {
		this.periodo = periodo;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}
	
	
	

}
