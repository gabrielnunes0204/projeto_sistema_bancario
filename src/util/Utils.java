package util;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;

public class Utils {
	static Scanner entrada = new Scanner(System.in);

	// LER A ENTRADA DE DADOS NO CONSOLE
	static public String lerEntrada(String texto) {
		System.out.print(texto);
		String textoDigitado = entrada.nextLine();
		return textoDigitado;
	}

	public void fechaConsole() {
		entrada.close();
	}

	// FORMATA PARA REAIS
	public static String converterParaReal(double valor) {
		Locale ptBr = new Locale("pt", "BR");
		return NumberFormat.getCurrencyInstance(ptBr).format(valor);
	}
	
	// LOADING
	public static void carregamento() {
		System.out.print("Carregando");
		for (int i = 0; i < 3; ++i) {
			System.out.print(".");

			try {
				Thread.sleep(700);
			} catch (InterruptedException ex) {
			}
		}
	}
}