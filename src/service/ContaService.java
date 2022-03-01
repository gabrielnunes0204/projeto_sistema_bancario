package service;

import enums.TipoCliente;
import model.Conta;
import util.Utils;

public class ContaService {
	
	public static boolean depositar(Conta conta, double valor) {
		if (valor > 1) {
			conta.setSaldo(conta.getSaldo() + valor);
			return true;
		} else {
			return false;
		}
	}
	
	static public boolean sacar(Conta conta, double valor) {
		if (conta.getSaldo() > valor && valor > 1) {
			conta.setSaldo(conta.getSaldo() - valor);
			return true;
		} else {
			return false;
		}
	}
	
	public static boolean transferir(Conta contaOrigem, Conta contaDestino, double valor) {
		if (contaOrigem.getSaldo() > valor && valor > 0 && contaDestino != null) {
			if (contaOrigem.getTipoConta() != contaDestino.getTipoConta()) {
				contaOrigem.setSaldo((contaOrigem.getSaldo() - valor)-5.60);
				contaDestino.setSaldo(contaDestino.getSaldo() + valor);
				return true;
			} else {
				contaOrigem.setSaldo(contaOrigem.getSaldo() - valor);
				contaDestino.setSaldo(contaDestino.getSaldo() + valor);
				return true;
			}
		} else {
			return false;
		}
	}
	
	public static String consultar(Conta conta, String nome, String cpf, String numeroConta) {
		return "Número Conta: " + conta.getNumeroConta() + "\n" +
			   "Nome: " + nome.toUpperCase() + "\n" +
			   "CPF Vínculado: " + cpf + "\n" +
			   "Saldo: " + Utils.converterParaReal(conta.getSaldo()) + "\n" +
			   "Tipo Conta: " + conta.getTipoConta() + "\n" +
			   "Tipo Cliente: " + conta.getCliente().getTipo();
	}
	
	public static TipoCliente definirTipoCliente(Conta conta) {
		if (conta.getSaldo() < 5000) {
			conta.getCliente().setTipo(TipoCliente.COMUM);
			return conta.getCliente().getTipo();
		} else if (conta.getSaldo() >= 5000 && conta.getSaldo() < 15000) {
			conta.getCliente().setTipo(TipoCliente.SUPER);
			return conta.getCliente().getTipo();
		} else if (conta.getSaldo() > 15000) {
			conta.getCliente().setTipo(TipoCliente.PREMIUM);
			return conta.getCliente().getTipo();
		} else {
			return null;
		}
	}
}
