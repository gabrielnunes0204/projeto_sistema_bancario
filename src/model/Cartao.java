package model;

import enums.BandeiraCartao;

public abstract class Cartao {
	
	private Long id;
	private String numero;
	private BandeiraCartao bandeira;
	private String senha;
	private boolean isAtivo;
	private Conta conta;
	
	//CONSTRUTORES
	public Cartao() {
		
	}
	
	public Cartao(String numero, BandeiraCartao bandeira, String senha, boolean isAtivo) {
		this.numero = numero;
		this.bandeira = bandeira;
		this.senha = senha;
		this.isAtivo = isAtivo;
	}
	
	//GETTERS E SETTERS
	
	public String getNumero() {
		return numero;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long idCartao) {
		this.id = idCartao;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public BandeiraCartao getBandeira() {
		return bandeira;
	}

	public void setBandeira(BandeiraCartao bandeira) {
		this.bandeira = bandeira;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public boolean getisAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(boolean isAtivo) {
		this.isAtivo = isAtivo;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}
}
