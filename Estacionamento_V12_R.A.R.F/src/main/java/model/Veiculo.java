package model;

public class Veiculo {
	private String numeroPlaca;
	private String marca;
	private String modelo;
	private String tipoVeiculo;
	private String cpf;
	
	public Veiculo(){
		
		super();
	}
	
	public Veiculo(String numeroPlaca, String marca, String modelo, String tipoVeiculo, String cpf) {
		super();
		
		this.numeroPlaca = numeroPlaca;
		this.marca = marca;
		this.modelo = modelo;
		this.tipoVeiculo = tipoVeiculo;
		this.cpf = cpf;
		
		
		
	}

	public String getNumeroPlaca() {
		return numeroPlaca;
	}

	public void setNumeroPlaca(String numeroPlaca) {
		this.numeroPlaca = numeroPlaca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getTipoVeiculo() {
		return tipoVeiculo;
	}

	public void setTipoVeiculo(String tipoVeiculo) {
		this.tipoVeiculo = tipoVeiculo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
