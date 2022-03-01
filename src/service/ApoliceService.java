package service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import enums.TipoSeguro;
import model.Apolice;
import model.Conta;
import util.Utils;

public class ApoliceService {
	
	public static String definirDataAtual() {
		Date data = new Date();
		Calendar d = Calendar.getInstance();
		d.setTime(data);
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		data = d.getTime();
		return formato.format(data);
	}
	
	static public String definirDataFutura() {
		Date data = new Date();
		Calendar d = Calendar.getInstance();
		d.setTime(data);
		d.add(Calendar.DATE, 15);
		
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		data = d.getTime();
		return formato.format(data);
	}

	public static String exibirApoliceProvisoria(int opcao, Calendar dataA, Calendar dataC, Conta conta) {
		if (opcao == 1) {
			return "----------------------------- APÓLICE PROVISÓRIA -----------------------------" + "\n" +
				   "Nome: Apólice Desemprego" + "\n" +
				   "Data assinatura: " + definirDataAtual() + "\n" +
				   "Data carência: " + definirDataFutura() + "\n" +
				   "Valor: " + Utils.converterParaReal(25000) + "\n" +
				   "------------------------------------- | | -------------------------------------" + "\n" +
				   "Tipo seguro: " + TipoSeguro.MORTE + "\n" +
				   "Regras: " + TipoSeguro.REGRA_MORTE + "\n" +
				   "Taxa anual: " + Utils.converterParaReal(TipoSeguro.TAXA_MORTE) + "\n" +
				   "Eu, " + conta.getCliente().getNome() + ", aceito todos os termos descritos acima" + "\n" +
				   "-------------------------------------------------------------------------------";
		} else if (opcao == 2) {
			return "----------------------------- APÓLICE PROVISÓRIA -----------------------------" + "\n" +
				   "Nome: Apólice Desemprego" + "\n" +
				   "Data assinatura: " + definirDataAtual() + "\n" +
				   "Data carência: " + definirDataFutura() + "\n" +
				   "Valor: " + Utils.converterParaReal(15000) + "\n" +
				   "------------------------------------- | | -------------------------------------" + "\n" +
				   "Tipo seguro: " + TipoSeguro.INVALIDEZ + "\n" +
				   "Regras: " + TipoSeguro.REGRA_INVALIDEZ + "\n" +
				   "Taxa anual: " + Utils.converterParaReal(TipoSeguro.TAXA_INVALIDEZ) + "\n" +
				   "Eu, " + conta.getCliente().getNome() + ", aceito todos os termos descritos acima" + "\n" +
				   "-------------------------------------------------------------------------------";
		} else if (opcao == 3) {
			return "----------------------------- APÓLICE PROVISÓRIA -----------------------------" + "\n" +
					"Nome: Apólice Desemprego" + "\n" +
					"Data assinatura: " + definirDataAtual() + "\n" +
					"Data carência: " + definirDataFutura() + "\n" +
					"Valor: " + Utils.converterParaReal(5000) + "\n" +
					"------------------------------------- | | -------------------------------------" + "\n" +
					"Tipo seguro: " + TipoSeguro.DESEMPREGO + "\n" +
					"Regras: " + TipoSeguro.REGRA_DESEMPREGO + "\n" +
					"Taxa anual: " + Utils.converterParaReal(TipoSeguro.TAXA_DESEMPREGO) + "\n" +
					"Eu, " + conta.getCliente().getNome() + ", aceito todos os termos descritos acima" + "\n" +
					"-------------------------------------------------------------------------------";
		} else {
			return null;
		}
	}
	
	public static Apolice contratarSeguro(Apolice apolice, int opcao) {
		if (opcao == 1) {
			apolice.setDescricao("Morte");
			apolice.setDataAssinatura(definirDataAtual());
			apolice.setDataCarencia(definirDataFutura());
			apolice.setValor(25000.0);
			apolice.getSeguro().setTipo(TipoSeguro.MORTE);
			apolice.getSeguro().setRegras(TipoSeguro.REGRA_MORTE);
			apolice.getSeguro().setTaxa(TipoSeguro.TAXA_MORTE);
			apolice.getSeguro().setIsAtivo(true);
			return new Apolice(apolice.getDescricao(), apolice.getDataAssinatura(), apolice.getDataCarencia(), apolice.getValor());
		} else if (opcao == 2) {
			apolice.setDescricao("Invalidez");
			apolice.setDataAssinatura(definirDataAtual());
			apolice.setDataCarencia(definirDataFutura());
			apolice.setValor(15000.0);
			apolice.getSeguro().setTipo(TipoSeguro.INVALIDEZ);
			apolice.getSeguro().setRegras(TipoSeguro.REGRA_INVALIDEZ);
			apolice.getSeguro().setTaxa(TipoSeguro.TAXA_INVALIDEZ);
			apolice.getSeguro().setIsAtivo(true);
			return new Apolice(apolice.getDescricao(), apolice.getDataAssinatura(), apolice.getDataCarencia(), apolice.getValor());
		} else if (opcao == 3) {
			apolice.setDescricao("Desemprego");
			apolice.setDataAssinatura(definirDataAtual());
			apolice.setDataCarencia(definirDataFutura());
			apolice.setValor(5000.0);
			apolice.getSeguro().setTipo(TipoSeguro.DESEMPREGO);
			apolice.getSeguro().setRegras(TipoSeguro.REGRA_DESEMPREGO);
			apolice.getSeguro().setTaxa(TipoSeguro.TAXA_DESEMPREGO);
			apolice.getSeguro().setIsAtivo(true);
			return new Apolice(apolice.getDescricao(), apolice.getDataAssinatura(), apolice.getDataCarencia(), apolice.getValor());
		} else {
			return null;
		}
	}
	
	public static Double definirValorSeguro(int tipo, Apolice apolice) {
		if (tipo == 1) {
			apolice.getSeguro().setTaxa(36.0);
			return apolice.getSeguro().getTaxa();
		} else if (tipo == 2) {
			apolice.getSeguro().setTaxa(26.0);
			return apolice.getSeguro().getTaxa();
		} else if (tipo == 3) {
			apolice.getSeguro().setTaxa(16.0);
			return apolice.getSeguro().getTaxa();
		} else {
			return null;
		}
	}
}
