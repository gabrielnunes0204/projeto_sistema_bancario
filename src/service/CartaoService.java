package service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;
import enums.BandeiraCartao;
import model.CartaoCredito;
import model.CartaoDebito;
import model.Conta;

public class CartaoService {
	static CartaoDebito  cartaoDebito = new CartaoDebito();
	static CartaoCredito  cartaoCredito = new CartaoCredito();
	
	public static String gerarNumeroDebito() {
		Random random = new Random();
        String novoNumero = "";
        for(int i = 0; i < 4; i++){
            novoNumero += String.valueOf(random.nextInt(10000));
            novoNumero += " ";
        }
        cartaoDebito.setNumero(novoNumero);
        return cartaoDebito.getNumero().strip();
	}
	
	public static String gerarNumeroCredito() {
		Random random = new Random();
        String novoNumero = "";
        for(int i = 0; i < 4; i++){
            novoNumero += String.valueOf(random.nextInt(10000));
            novoNumero += " ";
        }
        cartaoCredito.setNumero(novoNumero);
        return cartaoCredito.getNumero().strip();
	}
	
	public static void criarDebito(Conta conta, int bandeira, String senha, boolean ativo, Double limite) {
		if (bandeira == 1) {
			conta.setCartaoDebito(new CartaoDebito(gerarNumeroDebito(), BandeiraCartao.MASTER, senha, ativo, limite));
		} else if (bandeira == 2) {
			conta.setCartaoDebito(new CartaoDebito(gerarNumeroDebito(), BandeiraCartao.VISA, senha, ativo, limite));
		} else if (bandeira == 3) {
			conta.setCartaoDebito(new CartaoDebito(gerarNumeroDebito(), BandeiraCartao.ELO, senha, ativo, limite));
		}
	}
	
	public static void criarCredito(Conta conta, int bandeira, String senha, boolean ativo, Double limite, Double valor) {
		if (bandeira == 1) {
			conta.setCartaoCredito(new CartaoCredito(gerarNumeroCredito(), BandeiraCartao.MASTER, senha, ativo, limite, valor));
		} else if (bandeira == 2) {
			conta.setCartaoCredito(new CartaoCredito(gerarNumeroCredito(), BandeiraCartao.VISA, senha, ativo, limite, valor));
		} else if (bandeira == 3) {
			conta.setCartaoCredito(new CartaoCredito(gerarNumeroCredito(), BandeiraCartao.ELO, senha, ativo, limite, valor));
		}
	}
	
	public static Double definirLimiteCredito(Conta conta) {
		if (conta.getCliente().getTipo().ordinal() == 0) {
			cartaoCredito.setLimite(3000.0);
			return cartaoCredito.getLimite();
			
		} else if (conta.getCliente().getTipo().ordinal() == 1) {
			cartaoCredito.setLimite(6000.0);
			return cartaoCredito.getLimite();
			
		} else if (conta.getCliente().getTipo().ordinal() == 2) {
			cartaoCredito.setLimite(9000.0);
			return cartaoCredito.getLimite();
		} else {
			return null;
		}
	}
	
	public static String definirDataCompra() {
		Date data = new Date();
		Calendar d = Calendar.getInstance();
		d.setTime(data);
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		data = d.getTime();
		return formato.format(data);
	}
	
	public static String definirVencimentoFatura() {
		Date data = new Date();
		Calendar d = Calendar.getInstance();
		d.setTime(data);
		d.add(Calendar.DATE, 15);
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		data = d.getTime();
		return formato.format(data);
	}
}
