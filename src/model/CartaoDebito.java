package model;

import java.util.ArrayList;
import enums.BandeiraCartao;

public class CartaoDebito extends Cartao {

	private Double limitePorTransacao;
	private ArrayList<Compra> listaCompras = new ArrayList<Compra>();
	
	public CartaoDebito() {}
	
	public CartaoDebito(String numero, BandeiraCartao bandeira, String senha, boolean isAtivo, Double limite) {
		super(numero, bandeira, senha, isAtivo);
		this.limitePorTransacao = limite;
	}

	public Double getLimitePorTransacao() {
		return limitePorTransacao;
	}

	public void setLimitePorTransacao(Double limitePorTransacao) {
		this.limitePorTransacao = limitePorTransacao;
	}

	public ArrayList<Compra> getListaCompras() {
		return listaCompras;
	}

	public void setListaCompras(ArrayList<Compra> listaCompras) {
		this.listaCompras = listaCompras;
	}
}
