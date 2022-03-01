package model;

import java.util.Date;

public class Compra {
	
	private Long id;
	private String nome;
	private String descricao;
	private Double valor;
	private Date data;

	public Compra() {}
	
	public Compra(String nome, String desc, Double valor, Date data) {
		this.nome = nome;
		this.descricao = desc;
		this.valor = valor;
		this.data = data;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
}
