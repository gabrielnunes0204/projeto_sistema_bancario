package model;

import enums.TipoCliente;

public class Cliente {
	
	private static Long id = 1L;
	private String nome;
	private String cpf;
	private String email;
	private String telefone;
	private String senha;
	private TipoCliente tipo;
	private Endereco endereco;
	
	//CONSTRUTORES
	public Cliente() {}
	
	public Cliente(String nome, String cpf, String email, String telefone, String senha, Endereco endereco) {
		id = iterarId();
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
		this.endereco = endereco;
		this.tipo = TipoCliente.COMUM;
	}
	
	//GETTERS E SETTERS
	public Long getId() {
		return id;
	}

	public void setCodCliente(Long idCliente) {
		id = idCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public TipoCliente getTipo() {
		return tipo;
	}

	public void setTipo(TipoCliente tipo) {
		this.tipo = tipo;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	
	//ITERAR ID
	public Long iterarId() {
		return id++;
	}
}
