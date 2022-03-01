package model;

import enums.TipoChavePix;

public class Pix {
	
	private String id;
	private static Integer pixCriados = 1; 
	private String conteudo;
	private boolean estaAtivo;
	private Double valor;
	private TipoChavePix tipoChave;
	
	// CONSTRUTORES
	public Pix() {}
	
	public Pix(String conteudo, double valor, TipoChavePix tipo) {
		this.id = iterarChave();
		this.conteudo = conteudo;
		this.estaAtivo = true;
		this.valor = valor;
		this.tipoChave = tipo;
	}
	
	// GETTERS E SETTERS
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudoChave) {
		this.conteudo = conteudoChave;
	}

	public boolean getEstaAtivo() {
		return estaAtivo;
	}

	public void setEstaAtivo(boolean estaAtivo) {
		this.estaAtivo = estaAtivo;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public TipoChavePix getTipoChave() {
		return tipoChave;
	}

	public void setTipoChave(TipoChavePix tipoChave) {
		this.tipoChave = tipoChave;
	}
	
	public static int getPixCriados() {
		return pixCriados;
	}

	public static void setPixCriados(int pixCriados) {
		Pix.pixCriados = pixCriados;
	}

	//ITERAR CHAVE
	public String iterarChave() {
		return String.valueOf(pixCriados++);
	}
}
