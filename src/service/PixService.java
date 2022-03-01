package service;

import java.util.List;
import java.util.UUID;
import enums.TipoChavePix;
import model.Conta;
import model.Pix;

public class PixService {
	
	public static List<Pix> cadastrar(Conta conta, int opcaoPix, double valorPix) {
		if (opcaoPix == 1) {
			conta.getListaPix().add(new Pix(conta.getCliente().getCpf(), valorPix, TipoChavePix.CPF));
			return conta.getListaPix();
			
		} else if (opcaoPix == 2) {
			conta.getListaPix().add(new Pix(conta.getCliente().getEmail(), valorPix, TipoChavePix.EMAIL));
			return conta.getListaPix();
			
		} else if (opcaoPix == 3) {
			conta.getListaPix().add(new Pix(conta.getCliente().getTelefone(), valorPix, TipoChavePix.TELEFONE));
			return conta.getListaPix();
			
		} else if (opcaoPix == 4) {
			conta.getListaPix().add(new Pix(gerarChaveAleatoria(), valorPix, TipoChavePix.ALEATORIO));
			return conta.getListaPix();
			
		} else {
			return null;
		}
	}
	
	public static Double transferir(Conta contaOrigem, Conta contaDestino, double valor) {
		if (contaOrigem.getSaldo() > valor && valor > 0 && contaDestino != null) {
			contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
			contaDestino.setSaldo(contaDestino.getSaldo() + valor);
			
			return contaOrigem.getSaldo();
		} else {
			return contaOrigem.getSaldo();
		}
	}
	
	public static String consultar(Conta conta, int i) {
		return "Tipo Chave: " + conta.getListaPix().get(i).getTipoChave() + "\n" +
			   "Conteúdo Chave: " + conta.getListaPix().get(i).getConteudo() + "\n" +
			   "Ativo: " + conta.getListaPix().get(i).getEstaAtivo();
	}
	
	public static String gerarChaveAleatoria() {
		return UUID.randomUUID().toString();
	}
}
