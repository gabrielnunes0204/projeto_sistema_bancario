package util;

public class Menus {

	public static void menuPrincipal() {
		System.out.println("1 - Logar");
		System.out.println("2 - Cadastrar");
		System.out.println("3 - Encerrar");
	}
	
	public static void menuLogado() {
		System.out.println("1 - Sacar");
		System.out.println("2 - Depositar");
		System.out.println("3 - Transferir");
		System.out.println("4 - Consultar Saldo");
		System.out.println("5 - Cartões");
		System.out.println("6 - Área PIX");
		System.out.println("7 - Sair e voltar ao Menu Anterior");
	}
	
	public static void menuCartoes() {
		System.out.println("1 - Cartão de Débito");
		System.out.println("2 - Cartão de Crédito");
		System.out.println("3 - Voltar ao menu anterior");
	}
	
	public static void menuCartaoDebito() {
		System.out.println("1 - Inserir Cartão");
		System.out.println("2 - Consultar Cartão");
		System.out.println("3 - Excluír Cartão");
		System.out.println("4 - Efetuar Compras");
		System.out.println("5 - Consultar Compras");
		System.out.println("6 - Voltar ao menu anterior");
	}

	public static void menuCartaoCredito() {
		System.out.println("1 - Inserir Cartão");
		System.out.println("2 - Consultar Cartão");
		System.out.println("3 - Excluír Cartão");
		System.out.println("4 - Efetuar Compras");
		System.out.println("5 - Consultar Compras");
		System.out.println("6 - Consultar Fatura");
		System.out.println("7 - Pagar Fatura");
		System.out.println("8 - Seguro");
		System.out.println("9 - Voltar ao menu anterior");
	}
	
	public static void menuSeguros() {
		System.out.println("1 - Contratar Seguro");
		System.out.println("2 - Acionar Seguro");
		System.out.println("3 - Visualizar Apólice");
		System.out.println("4 - Cancelar Seguro");
		System.out.println("5 - Voltar ao menu anterior");
	}
	
	public static void menuPix() {
		System.out.println("1 - Cadastrar Chave");
		System.out.println("2 - Excluír Chave");
		System.out.println("3 - Consultar Chaves");
		System.out.println("4 - Transferir Via Pix");
		System.out.println("5 - Voltar ao menu anteior");
	}
}
