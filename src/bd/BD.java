package bd;

import java.util.ArrayList;
import java.util.List;
import model.Cliente;
import model.Conta;

public class BD {
	static List<Conta> listaContas = new ArrayList<>();
	static List<Cliente> listaClientes = new ArrayList<>();

	static public List<Conta> listaContas() {
		return listaContas;
	}
	
	static public List<Cliente> listaClientes() {
		return listaClientes;
	}
}
