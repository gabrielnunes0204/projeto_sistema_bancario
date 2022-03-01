package model;

import java.util.ArrayList;
import enums.BandeiraCartao;

public class CartaoCredito extends Cartao {

	private Double limite;
	private Double valorFatura;
	private Apolice apolice = new Apolice();
	private ArrayList<Compra> listaCompras  = new ArrayList<Compra>();
	
	public CartaoCredito() {}
	
	public CartaoCredito(String numero, BandeiraCartao bandeira, String senha, boolean isAtivo, Double limite, Double valor) {
		super(numero, bandeira, senha, isAtivo);
		this.limite = limite;
		this.valorFatura = valor;
		this.listaCompras  = new ArrayList<Compra>();
	}

	public Double getLimite() {
		return this.limite;
	}

	public void setLimite(Double limite) {
		this.limite = limite;
	}

	public Double getValorFatura() {
		return valorFatura;
	}

	public void setValorFatura(Double valorFatura) {
		this.valorFatura = valorFatura;
	}

	public Apolice getApolice() {
		return apolice;
	}

	public void setApolice(Apolice apolice) {
		this.apolice = apolice;
	}

	public ArrayList<Compra> getListaCompras() {
		return listaCompras;
	}

	public void setListaCompras(ArrayList<Compra> listaCompras) {
		this.listaCompras = listaCompras;
	}
}
