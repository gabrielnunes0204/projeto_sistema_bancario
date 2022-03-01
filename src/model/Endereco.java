package model;

public class Endereco {
	
	private static Long id = 1L;
	private String logradouro;
	private String numero;
	private String cep;
	private String bairro;
	private String cidade;

	// CONSTRUTORES
	public Endereco() {}

	public Endereco(String rua, String num, String cep, String bairro, String cidade) {
		id = iterarId();
		this.logradouro = rua;
		this.numero = num;
		this.cep = cep;
		this.bairro = bairro;
		this.cidade = cidade;
	}

	//GETTERS E SETTERS
	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	
	// ITERAR ID
	public Long iterarId() {
		return id++;
	}
}
