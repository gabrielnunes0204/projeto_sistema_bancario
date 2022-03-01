package model;

public class Apolice {

	private Long id;
	private String descricao;
	private String dataAssinatura;
	private String dataCarencia;
	private Double valor;
	private Seguro seguro = new Seguro();
	
	public Apolice() {}
	
	public Apolice(String descricao, String dataAssinatura, String dataCarencia, Double valor) {
		this.descricao = descricao;
		this.dataAssinatura = dataAssinatura;
		this.dataCarencia = dataCarencia;
		this.valor = valor;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDataAssinatura() {
		return dataAssinatura;
	}

	public void setDataAssinatura(String dataAssinatura) {
		this.dataAssinatura = dataAssinatura;
	}

	public String getDataCarencia() {
		return dataCarencia;
	}

	public void setDataCarencia(String dataCarencia) {
		this.dataCarencia = dataCarencia;
	}

	public Double getValor() {
		return valor;
	}

	public void setValor(Double valor) {
		this.valor = valor;
	}

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}
}
