package model;

import java.util.ArrayList;
import java.util.List;
import enums.TipoConta;

public class Conta {
	
	private static Long id = 1L;
	private String numeroConta;
	private static Integer contasCriadas = 1;
	private Double saldo;
	private TipoConta tipoConta;
	private Cliente cliente;
	private CartaoDebito cartaoDebito;
	private CartaoCredito cartaoCredito;
	private List<Pix> listaPix;
	
	// CONSTRUTORES
	public Conta() {}

	public Conta(Cliente cliente, TipoConta tipo) {
		id = iterarId();
		this.numeroConta = iterarConta();
		this.cliente = cliente;
		this.tipoConta = tipo;
		this.saldo = 0.0;
		this.listaPix = new ArrayList<Pix>();
		this.cartaoDebito = new CartaoDebito();
		this.cartaoCredito = new CartaoCredito();
	}

	// GETTERS E SETTERS
	static public Long iterarId() {
		return id++;
	}
	
	public static Long getId() {
		return id;
	}

	public static void setId(Long id) {
		Conta.id = id;
	}

	public String getNumeroConta() {
		return numeroConta;
	}

	public void setNumeroConta(String numeroConta) {
		this.numeroConta = numeroConta;
	}

	public static Integer getContasCriadas() {
		return contasCriadas;
	}

	public static void setContasCriadas(Integer contasCriadas) {
		Conta.contasCriadas = contasCriadas;
	}

	public Double getSaldo() {
		return saldo;
	}

	public void setSaldo(Double saldo) {
		this.saldo = saldo;
	}

	public TipoConta getTipoConta() {
		return tipoConta;
	}

	public void setTipoConta(TipoConta tipoConta) {
		this.tipoConta = tipoConta;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Pix> getListaPix() {
		return listaPix;
	}

	public void setListaPix(List<Pix> listaPix) {
		this.listaPix = listaPix;
	}
	
	public CartaoDebito getCartaoDebito() {
		return cartaoDebito;
	}

	public void setCartaoDebito(CartaoDebito cartaoDebito) {
		this.cartaoDebito = cartaoDebito;
	}

	public CartaoCredito getCartaoCredito() {
		return cartaoCredito;
	}

	public void setCartaoCredito(CartaoCredito cartaoCredito) {
		this.cartaoCredito = cartaoCredito;
	}

	// ITERAR CONTA
	public String iterarConta() {
		return String.valueOf(contasCriadas++);
	}
}
