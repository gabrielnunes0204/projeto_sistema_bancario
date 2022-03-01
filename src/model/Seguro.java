package model;

import enums.TipoSeguro;

public class Seguro {

	private Long id;
	private TipoSeguro tipo;
	private String regras;
	private Double taxa;
	private boolean isAtivo;

	public Seguro() {}
	
	public Seguro(TipoSeguro tipo, String regras, Double taxa, boolean isAtivo) {
		this.tipo = tipo;
		this.regras = regras;
		this.taxa = taxa;
		this.isAtivo = isAtivo;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoSeguro getTipo() {
		return tipo;
	}

	public void setTipo(TipoSeguro tipo) {
		this.tipo = tipo;
	}

	public String getRegras() {
		return regras;
	}

	public void setRegras(String regras) {
		this.regras = regras;
	}

	public Double getTaxa() {
		return taxa;
	}

	public void setTaxa(Double taxa) {
		this.taxa = taxa;
	}

	public boolean getIsAtivo() {
		return isAtivo;
	}

	public void setIsAtivo(boolean isAtivo) {
		this.isAtivo = isAtivo;
	}
}
