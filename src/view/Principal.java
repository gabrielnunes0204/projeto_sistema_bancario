package view;

import java.util.Calendar;
import java.util.List;
import bd.BD;
import enums.TipoConta;
import model.*;
import service.*;
import util.Menus;
import util.Utils;

public class Principal {
	static Conta conta;
	static Apolice apolice = new Apolice();
	
	public static void main(String[] args) {
		//AUXILIARES
		String opcaoMenu = "", opcaoLogado = "", opcaoPix = "", opcaoCartao = "", opcaoDebito = "", opcaoCredito = "", opcaoSeguro = "";
		int bandeiraDebito = 0, bandeiraCredito = 0, opcaoConta = 0, opcaoTipoSeguro = 0, opcaoChave = 0, tempoSeguro = 0;
		double deposito = 0.0, saque = 0.0, transferencia = 0.0, valorPix = 0.0, valorFatura = 0.0, limiteCredito = 0.0, valorTotalTaxa = 0;
		boolean ativoDebito, ativoCredito;
		Calendar dataDebito = Calendar.getInstance(), dataCredito = Calendar.getInstance(), dataAssinatura = Calendar.getInstance(), dataCarencia = Calendar.getInstance();
		
		do {
			System.out.println("");
			System.out.println("========================== MENU PRINCIPAL ==========================");
			System.out.println("");
			Menus.menuPrincipal();
			opcaoMenu = Utils.lerEntrada("Informe uma das opções acima: ");
			while (opcaoMenu.equals("")) {
				System.out.println("Opção inválida, corrija-o.");
				opcaoMenu = Utils.lerEntrada("Informe uma das opções acima: ");
			}
			
			switch(opcaoMenu) {
				case "1":
					System.out.println("");
					System.out.println("========================== LOGIN ==========================");
					System.out.println("");
					String cpf = Utils.lerEntrada("Informe o seu CPF: ");
					while(cpf.equals("") || cpf.length() != 11 || !cpf.matches("[0-9]*")) {
						System.out.println("CPF inválido, corrija-o");
						cpf = Utils.lerEntrada("Informe o seu CPF: ");
					}
					
					String senha = Utils.lerEntrada("Informe a sua senha: ");
					while(senha.equals("") || senha.length() != 4 || !senha.matches("[0-9]*")) {
						System.out.println("Senha inválida, corrija-a");
						senha = Utils.lerEntrada("Informe a sua senha: ");
					}
					
					String numeroConta = Utils.lerEntrada("Informe o número da conta que deseja acessar: ");
					while(numeroConta.equals("") || !numeroConta.matches("[0-9]*")) {
						System.out.println("Número inválido, corrija-o");
						numeroConta = Utils.lerEntrada("Informe o número da conta que deseja acessar: ");
					}
					
					if (BD.listaClientes().size() > 0) {
						for(int i = 0; i < BD.listaContas().size(); i++) {
							if (BD.listaContas().get(i).getCliente().getCpf().equals(cpf) &&
								BD.listaContas().get(i).getCliente().getSenha().equals(senha) &&
								BD.listaContas().get(i).getNumeroConta().equals(numeroConta)) {
								conta = BD.listaContas().get(i);
									
								do {
									System.out.println("");
									System.out.println("========================== MENU LOGADO ==========================");
									System.out.println("Seja bem vindo, " + BD.listaContas().get(i).getCliente().getNome());
									System.out.println("");
									Menus.menuLogado();
									opcaoLogado = Utils.lerEntrada("Informe uma das opções acima: ");
									while (opcaoLogado.equals("")) {
										System.out.println("Opção inválida, corrija-o.");
										opcaoLogado = Utils.lerEntrada("Informe uma das opções acima: ");
									}
									
									switch(opcaoLogado) {
										case "1":
											System.out.println("");
											System.out.println("========================== SACAR ==========================");
											System.out.println("");
											saque = Double.parseDouble(Utils.lerEntrada("Informe o valor do saque: "));
											if (ContaService.sacar(conta, saque)) {
												System.out.println("");
												System.out.println("SAQUE REALIZADO COM SUCESSO");
											} else {
												System.out.println("Erro no saque");
											}
											break;
										case "2":
											System.out.println("");
											System.out.println("========================== DEPOSITAR ==========================");
											System.out.println("");
											deposito = Double.parseDouble(Utils.lerEntrada("Informe o valor do depósito: "));
											if (ContaService.depositar(conta, deposito)) {
												System.out.println("");
												System.out.println("DEPÓSITO REALIZADO COM SUCESSO");
											} else {
												System.out.println("Erro no depósito");
											}
											break;
										case "3":
											System.out.println("");
											System.out.println("========================== TRANSFERIR ==========================");
											System.out.println("");
											transferencia = Double.parseDouble(Utils.lerEntrada("Informe o valor da transferência: "));
											Integer contaDestino = Integer.parseInt(Utils.lerEntrada("Informe o número da conta de destino: "));
											
											if (ContaService.transferir(conta, BD.listaContas().get(contaDestino-1), transferencia)) {
												if (conta.getTipoConta() != BD.listaContas().get(contaDestino-1).getTipoConta()) {
													System.out.println("");
													System.out.println("TRANSFERÊNCIA REALIZADA COM SUCESSO");
													
													System.out.println("");
													System.out.println("Uma taxa de R$ 5,60 foi cobrada devidamente a transferência de contas diferentes");
												} else {
													System.out.println("");
													System.out.println("TRANSFERÊNCIA REALIZADA COM SUCESSO");
												}
											} else {
												System.out.println("Erro na transferência");
											}
											break;
										case "4":
											System.out.println("");
											System.out.println("========================== CONSULTAR SALDO ==========================");
											System.out.println("");
											ContaService.definirTipoCliente(conta);
											System.out.println(ContaService.consultar(conta, conta.getCliente().getNome(),
																		                     conta.getCliente().getCpf(),
																		                     conta.getNumeroConta()));
											break;
										case "5":
											do {
												System.out.println("");
												System.out.println("========================== ÁREA CARTÕES ==========================");
												System.out.println("");
												Menus.menuCartoes();
												opcaoCartao = Utils.lerEntrada("Informe uma das opções acima: ");
												while (opcaoCartao.equals("")) {
													System.out.println("Opção inválida, corrija-o.");
													opcaoCartao = Utils.lerEntrada("Informe uma das opções acima: ");
												}
												
												switch(opcaoCartao) {
													case "1":
														do {
															System.out.println("");
															System.out.println("========================== MENU DÉBITO ==========================");
															System.out.println("");
															Menus.menuCartaoDebito();
															opcaoDebito = Utils.lerEntrada("Informe uma das opções acima: ");
															while (opcaoDebito.equals("")) {
																System.out.println("Opção inválida, corrija-o.");
																opcaoDebito = Utils.lerEntrada("Informe uma das opções acima: ");
															}
															
															switch(opcaoDebito) {
																case "1":
																	System.out.println("");
																	System.out.println("========================== CRIAR CARTÃO ==========================");
																	System.out.println("");
																	//SE JÁ EXISTIR UM CARTÃO, UM SEGUNDO NÃO PODERÁ SER CRIADO
																	if (conta.getCartaoDebito().getisAtivo() == false) {
																		System.out.println("1 - Master");
																		System.out.println("2 - Visa");
																		System.out.println("3 - Elo");
																		bandeiraDebito = Integer.parseInt(Utils.lerEntrada("Escolha uma das bandeiras acima: "));
																		String senhaDebito = Utils.lerEntrada("Crie uma senha de 4 dígitos: ");
																		while(senhaDebito.equals("") || senhaDebito.length() != 4 || !senhaDebito.matches("[0-9]*")) {
																			System.out.println("Formato inválido, corrija-o");
																			senhaDebito = Utils.lerEntrada("Crie uma senha de 4 dígitos: ");
																		}
																		
																		Double limiteDebito = Double.parseDouble(Utils.lerEntrada("Defina o limite por transação: R$ "));
																		
																		ativoDebito = true;
																		CartaoService.criarDebito(conta, bandeiraDebito, senhaDebito, ativoDebito, limiteDebito);
																		
																		System.out.println("");
																		System.out.println("CARTÃO CADASTRADO COM SUCESSO");
																	} else {
																		System.out.println("Você já possui um cartão cadastrado");
																	}
																	break;
																case "2":
																	System.out.println("");
																	System.out.println("========================== CONSULTAR CARTÃO ==========================");
																	System.out.println("");
																	//VERIFICA SE O CARTÃO EXISTE ANTES DE CONSULTAR
																	if (conta.getCartaoDebito().getisAtivo() == true) {
																		System.out.println("Número Cartão: " + conta.getCartaoDebito().getNumero() + "\n" +
																						   "Bandeira: " + conta.getCartaoDebito().getBandeira() + "\n" +
																						   "Ativo: " +  conta.getCartaoDebito().getisAtivo());
																	} else {
																		System.out.println("Você não possui cartão");
																	}
																	break;
																case "3":
																	System.out.println("");
																	System.out.println("========================== EXCLUÍR CARTÃO ==========================");
																	System.out.println("");
																	//VERIFICA SE O CARTÃO EXISTE PARA ASSIM EXCLUÍ-LO
																	if (conta.getCartaoDebito().getisAtivo() == true) {
																		System.out.println("Número Cartão: " + conta.getCartaoDebito().getNumero() + "\n" +
																						   "Bandeira: " +  conta.getCartaoDebito().getBandeira() + "\n" +
																						   "Ativo: " +  conta.getCartaoDebito().getisAtivo());
																		System.out.println("");
																		
																		String confirmar = Utils.lerEntrada("Confirme se deseja excluir o cartão (S ou N): ");
																		while(confirmar.equals("")) {
																			System.out.println("Opção inválida, corrija-a");
																			confirmar = Utils.lerEntrada("Confirme se deseja excluir o cartão (S ou N): ");
																		}
																		
																		if (confirmar.equals("s") || confirmar.equals("S")) {
																			conta.getCartaoDebito().setIsAtivo(false);
																			
																			System.out.println("");
																			System.out.println("CARTÃO EXCLUÍDO COM SUCESSO");
																		}
																	} else {
																		System.out.println("Você não possui cartão");
																	}
																	break;
																case "4":
																	System.out.println("");
																	System.out.println("========================== EFETUAR COMPRAS ==========================");
																	System.out.println("");
																	String nomeItem = Utils.lerEntrada("Informe o nome do item que deseja comprar: ");
																	String descricaoItem = Utils.lerEntrada("Informe a descrição do item: ");
																	Double valor = Double.parseDouble(Utils.lerEntrada("Informe o valor do item: "));
																	String senhaCompra = Utils.lerEntrada("Informe a senha do cartão: ");
																	while(senhaCompra.equals("") || !senhaCompra.matches("[0-9]*")) {
																		System.out.println("Formato inválido, corrija-o");
																		senhaCompra = Utils.lerEntrada("Informe a senha do cartão: ");
																	}
																	
																	//VERIFICA SE O VALOR DA COMPRA É MAIOR QUE O SALDO
																	//VERIFICA SE O VALOR DA COMPRA É MAIOR QUE O LIMITE
																	//VERIFICA SE A SENHA DO CARTÃO ESTÁ CORRETA
																	//VERIFICA SE O USUÁRIO POSSUI UM CARTÃO
																	//VERIFICA SE O CARTÃO ESTÁ ATIVO
																	if (conta.getSaldo() > valor) {																																				
																		if (conta.getCartaoDebito().getLimitePorTransacao() < valor) {
																			System.out.println("Valor da compra é maior que o limite de transação");
																		} else if (conta.getCartaoDebito().getisAtivo() == false) {
																			System.out.println("O cartão está desativado");
																		} else if (!senhaCompra.equals(conta.getCartaoDebito().getSenha())) {
																			System.out.println("Senha inválida");
																		} else {
																			conta.getCartaoDebito().getListaCompras().add(new Compra(nomeItem, descricaoItem, valor, dataDebito.getTime()));
																			conta.setSaldo(conta.getSaldo()-valor);
																			
																			System.out.println("");
																			System.out.println("COMPRA EFETUADA COM SUCESSO");
																		}
																	} else {
																		System.out.println("Seu saldo não é suficiente");
																	}
																	break;
																case "5":
																	System.out.println("");
																	System.out.println("========================== CONSULTAR COMPRAS ==========================");
																	System.out.println("");
																	//VERIFICA SE EXISTEM COMPRAS FEITAS
																	if (conta.getCartaoDebito().getisAtivo() == true) {
																		if (conta.getCartaoDebito().getListaCompras().size() > 0) {
																			for(int z = 0; z < conta.getCartaoDebito().getListaCompras().size(); z++) {
																				System.out.println("Nome: " + conta.getCartaoDebito().getListaCompras().get(z).getNome() + "\n" +
																								   "Descrição: " + conta.getCartaoDebito().getListaCompras().get(z).getDescricao() + "\n" +
																								   "Valor: " + Utils.converterParaReal(conta.getCartaoDebito().getListaCompras().get(z).getValor()) + "\n" +
																								   "Data: " + CartaoService.definirDataCompra());
																				System.out.println("");
																			}
																		} else {
																			System.out.println("Você não possui compras");
																		}
																	} else {
																		System.out.println("Você não possui cartão");
																	}
																	break;
																case "6":
																	break;
																default:
																	System.out.println("Opção Inválida");
															}
														} while(!opcaoDebito.equals("6"));
														break;
													case "2":
														do {
															System.out.println("");
															System.out.println("========================== MENU CRÉDITO ==========================");
															System.out.println("");
															Menus.menuCartaoCredito();
															opcaoCredito = Utils.lerEntrada("Informe uma das opções acima: ");
															while (opcaoCredito.equals("")) {
																System.out.println("Opção inválida, corrija-o.");
																opcaoCredito = Utils.lerEntrada("Informe uma das opções acima: ");
															}
															
															switch(opcaoCredito) {
																case "1":
																	System.out.println("");
																	System.out.println("========================== CRIAR CARTÃO ==========================");
																	System.out.println("");
																	//SE JÁ EXISTIR UM CARTÃO, UM SEGUNDO NÃO PODERÁ SER CRIADO
																	if (conta.getCartaoCredito().getisAtivo() == false) {
																		System.out.println("1 - Master");
																		System.out.println("2 - Visa");
																		System.out.println("3 - Elo");
																		bandeiraCredito = Integer.parseInt(Utils.lerEntrada("Escolha uma das bandeiras acima: "));
																		String senhaCredito = Utils.lerEntrada("Crie uma senha de 4 dígitos: ");
																		while(senhaCredito.equals("") || senhaCredito.length() != 4 || !senhaCredito.matches("[0-9]*")) {
																			System.out.println("Formato inválido, corrija-o");
																			senhaCredito = Utils.lerEntrada("Crie uma senha de 4 dígitos: ");
																		}
																		
																		limiteCredito = CartaoService.definirLimiteCredito(conta);
																		
																		ativoCredito = true;
																		CartaoService.criarCredito(conta, bandeiraCredito, senhaCredito, ativoCredito, limiteCredito, 0.0);
																		
																		System.out.println("");
																		System.out.println("CARTÃO CADASTRADO COM SUCESSO");
																	} else {
																		System.out.println("Você já possui um cartão cadastrado");
																	}
																	break;
																case "2":
																	System.out.println("");
																	System.out.println("========================== CONSULTAR CARTÃO ==========================");
																	System.out.println("");
																	//VERIFICA SE O CARTÃO EXISTE ANTES DE CONSULTAR
																	if (conta.getCartaoCredito().getisAtivo() == true) {
																		System.out.println("Número Cartão: " + conta.getCartaoCredito().getNumero() + "\n" +
																						   "Bandeira: " + conta.getCartaoCredito().getBandeira() + "\n" +
																						   "Ativo: " +  conta.getCartaoCredito().getisAtivo() + "\n" +
																						   "Limite: " + Utils.converterParaReal(conta.getCartaoCredito().getLimite()));
																	} else {
																		System.out.println("Você não possui cartão");
																	}
																	break;
																case "3":
																	System.out.println("");
																	System.out.println("========================== EXCLUÍR CARTÃO ==========================");
																	System.out.println("");
																	//VERIFICA SE O CARTÃO EXISTE PARA ASSIM EXCLUÍ-LO
																	if (conta.getCartaoCredito().getisAtivo() == true) {
																		if (conta.getCartaoCredito().getListaCompras().size() > 1) {
																			System.out.println("Existem faturas em aberto. Não é possível excluír o cartão.");																			
																		} else if (apolice.getSeguro().getIsAtivo() == true) {
																			System.out.println("Você possui seguro ativo");
																		} else {
																			System.out.println("Número Cartão: " + conta.getCartaoCredito().getNumero() + "\n" +
																					   "Bandeira: " +  conta.getCartaoCredito().getBandeira() + "\n" +
																					   "Ativo: " +  conta.getCartaoCredito().getisAtivo() + "\n" +
																					   "Limite: " + Utils.converterParaReal(conta.getCartaoCredito().getLimite()));
																			System.out.println("");
																			String confirmar = Utils.lerEntrada("Confirme se deseja excluir o cartão (S ou N): ");
																			while(confirmar.equals("")) {
																				System.out.println("Opção inválida");
																				confirmar = Utils.lerEntrada("Confirme se deseja excluir o cartão (S ou N): ");
																			}
																			if (confirmar.equals("s") || confirmar.equals("S")) {
																				conta.getCartaoCredito().setIsAtivo(false);
																				
																				System.out.println("");
																				System.out.println("CARTÃO EXCLUÍDO COM SUCESSO");
																			}
																		}
																	} else {
																		System.out.println("Você ainda não possui cartão cadastrado");
																	}
																	break;
																case "4":
																	System.out.println("");
																	System.out.println("========================== EFETUAR COMPRAS ==========================");
																	System.out.println("");
																	String nomeItem = Utils.lerEntrada("Informe o nome do item que deseja comprar: ");
																	while(nomeItem.equals("")) {
																		System.out.println("Nome inválida, corrija-o");
																		nomeItem = Utils.lerEntrada("Informe o nome do item que deseja comprar: ");
																	}
																	
																	String descricaoItem = Utils.lerEntrada("Informe a descrição do item: ");
																	while(descricaoItem.equals("")) {
																		System.out.println("Descrição inválida, corrija-o");
																		descricaoItem = Utils.lerEntrada("Informe a descrição do item: ");
																	}
																	
																	Double valor = Double.parseDouble(Utils.lerEntrada("Informe o valor do item: "));
																	String senhaCompra = Utils.lerEntrada("Informe a senha do cartão: ");
																	while(senhaCompra.equals("")) {
																		System.out.println("Senha inválida, corrija-a");
																		senhaCompra = Utils.lerEntrada("Informe a senha do cartão: ");
																	}
																	
																	//VERIFICA SE O VALOR DA COMPRA É MAIOR QUE O SALDO
																	//VERIFICA SE O VALOR DA COMPRA É MAIOR QUE O LIMITE
																	//VERIFICA SE A SENHA DO CARTÃO ESTÁ CORRETA
																	//VERIFICA SE O USUÁRIO POSSUI UM CARTÃO
																	//VERIFICA SE O CARTÃO ESTÁ ATIVO
																	if (conta.getCartaoCredito().getLimite() < valor) {
																		System.out.println("Valor da compra é maior que o seu limite");
																	} else if (conta.getCartaoCredito().getisAtivo() == false) {
																		System.out.println("Você não possui cartão");
																	} else if (!senhaCompra.equals(conta.getCartaoCredito().getSenha())) {
																		System.out.println("Senha inválida");
																	} else {
																		conta.getCartaoCredito().getListaCompras().add(new Compra(nomeItem, descricaoItem, valor, dataCredito.getTime()));
																		
																		valorFatura += valor;
																		conta.getCartaoCredito().setValorFatura(valorFatura);
																		
																		System.out.println("");
																		System.out.println("COMPRA EFETUADA COM SUCESSO");
																	}
																	break;
																case "5":
																	System.out.println("");
																	System.out.println("========================== CONSULTAR COMPRAS ==========================");
																	System.out.println("");
																	//VERIFICA SE EXISTEM COMPRAS FEITAS
																	if (conta.getCartaoCredito().getisAtivo() == true) {
																		if (conta.getCartaoCredito().getListaCompras().size() > 0) {
																			for(int z = 0; z < conta.getCartaoCredito().getListaCompras().size(); z++) {
																				System.out.println("Nome: " + conta.getCartaoCredito().getListaCompras().get(z).getNome() + "\n" +
																								   "Descrição: " + conta.getCartaoCredito().getListaCompras().get(z).getDescricao() + "\n" +
																								   "Valor: " + Utils.converterParaReal(conta.getCartaoCredito().getListaCompras().get(z).getValor()) + "\n" +
																								   "Data Compra: " + CartaoService.definirDataCompra());
																				System.out.println("");
																			}
																		} else {
																			System.out.println("Você não possui compras");
																		}
																	} else {
																		System.out.println("Você não possui cartão");
																	}
																	break;
																case "6":
																	System.out.println("");
																	System.out.println("========================== CONSULTAR FATURA ==========================");
																	System.out.println("");
																	//VERIFICA SE EXISTE CARTÃO PARA CONSULTAR														
																	if (conta.getCartaoCredito().getListaCompras().size() > 0) {
																		System.out.println("Total de compras: " + conta.getCartaoCredito().getListaCompras().size() + "\n" +
																						   "Valor fatura: " + Utils.converterParaReal(conta.getCartaoCredito().getValorFatura()) + "\n" +
																						   "Data vencimento: " + CartaoService.definirVencimentoFatura());
																	} else {
																		System.out.println("Você não possui faturas em aberto");
																	}
																	break;
																case "7":
																	System.out.println("");
																	System.out.println("========================== PAGAR FATURA ==========================");
																	System.out.println("");
																	//VERIFICA SE EXISTE UM CARTÃO
																	//VERIFICA SE 
																	if (conta.getCartaoCredito().getisAtivo() == true) {
																		if (conta.getCartaoCredito().getListaCompras().size() < 1) {
																			System.out.println("Você não possui compras");																				
																		} else if (conta.getSaldo() < conta.getCartaoCredito().getValorFatura()) {
																			System.out.println("Você não possui saldo suficiente");
																		} else {
																			for(int z = 0; z < conta.getCartaoCredito().getListaCompras().size(); z++) {
																				System.out.println("Total de compras: " + conta.getCartaoCredito().getListaCompras().size() + "\n" +
																								   "Valor fatura: " + Utils.converterParaReal(conta.getCartaoCredito().getValorFatura()) + "\n" +
																								   "Data vencimento: " + CartaoService.definirVencimentoFatura());
																				
																				String confirmar = Utils.lerEntrada("Confirme se deseja pagar a fatura (S ou N): ");
																				while(confirmar.equals("")) {
																					System.out.println("Opção inválida");
																					confirmar = Utils.lerEntrada("Confirme se deseja acionar o seguro (S ou N): ");
																				}
																				
																				System.out.println("");
																				if (confirmar.equals("s") || confirmar.equals("S")) {																						
																					List<Compra> comprasAll = conta.getCartaoCredito().getListaCompras();
																					conta.getCartaoCredito().getListaCompras().removeAll(comprasAll);
																					conta.setSaldo(conta.getSaldo()-conta.getCartaoCredito().getValorFatura());
																					
																					System.out.println("FATURA PAGA COM SUCESSO");
																				}
																			}
																		}
																	} else {
																		System.out.println("Você não possui cartão");
																	}
																	break;
																case "8":
																	do {
																		System.out.println("");
																		System.out.println("========================== SEGURO ==========================");
																		System.out.println("");
																		Menus.menuSeguros();
																		opcaoSeguro = Utils.lerEntrada("Informe uma das opções acima: ");
																		while (opcaoSeguro.equals("")) {
																			System.out.println("Opção inválida, corrija-o.");
																			opcaoSeguro = Utils.lerEntrada("Informe uma das opções acima: ");
																		}
																		
																		switch(opcaoSeguro) {
																			case "1":
																				//VERIFICA SE POSSUI CARTÃO DE CRÉDITO
																				//VERIFICA SE EXISTE SEGURO PARA CONTRATAR
																				System.out.println("");
																				System.out.println("========================== CONTRATAR ==========================");
																				System.out.println("");
																				if (apolice.getSeguro().getIsAtivo() == false) {
																					if (conta.getCartaoCredito().getisAtivo() == true) {
																						if (conta.getCartaoCredito().getisAtivo() == true) {
																							System.out.println("1 - Seguro Morte");
																							System.out.println("2 - Seguro Invalidez");
																							System.out.println("3 - Seguro Desemprego");
																							opcaoTipoSeguro = Integer.parseInt(Utils.lerEntrada("Informe uma das opções acima: "));
																							
																							String apoliceProvisoria = ApoliceService.exibirApoliceProvisoria(opcaoTipoSeguro, dataAssinatura, dataCarencia, conta);
																							System.out.println(apoliceProvisoria);
																							
																							tempoSeguro = Integer.parseInt(Utils.lerEntrada("Informe por quanto tempo deseja contratar o seguro: "));
																							String confirmar = Utils.lerEntrada("Confirme se deseja contratar o seguro (S ou N): ");
																							while(confirmar.equals("")) {
																								System.out.println("Opção inválida");
																								confirmar = Utils.lerEntrada("Confirme se deseja acionar o seguro (S ou N): ");
																							}
																							
																							ApoliceService.definirValorSeguro(opcaoTipoSeguro, apolice);
																							
																							if (confirmar.equals("s") || confirmar.equals("S")) {
																								if (apolice.getSeguro().getTaxa() > conta.getSaldo()) {
																									apolice.getSeguro().setIsAtivo(false);
																									
																									System.out.println("");
																									System.out.println("Saldo insuficiente");
																								} else {
																									conta.getCartaoCredito().setApolice(ApoliceService.contratarSeguro(apolice, opcaoTipoSeguro));
																									
																									valorTotalTaxa = apolice.getSeguro().getTaxa() * tempoSeguro;
																									conta.setSaldo(conta.getSaldo() - valorTotalTaxa);
																									
																									System.out.println("");
																									System.out.println("SEGURO CONTRATADO COM SUCESSO");
																								}
																							}
																						} else {
																							System.out.println("O cartão está desativado");
																						}
																					} else {
																						System.out.println("Você não possui cartão");
																					}
																				} else {
																					System.out.println("Você já possui um seguro contratado");
																				}
																				break;
																			case "2":
																				System.out.println("");
																				System.out.println("========================== ACIONAR ==========================");
																				System.out.println("");
																				
																				//VERIFICA SE POSSUI SEGURO ATIVO PARA ACIONAR
																				//VERIFICA SE POSSUI APÓLICE
																				if (apolice.getSeguro().getIsAtivo() == true) {
																					if (apolice != null) {
																						System.out.println("Tipo: " + apolice.getDescricao() + "\n" +
																										   "Tempo Contratado: " + tempoSeguro + " anos \n" +
																										   "Valor Anual: " + Utils.converterParaReal(apolice.getSeguro().getTaxa()) + "\n" +
																										   "Valor Seguro Contratado: " + Utils.converterParaReal(valorTotalTaxa) + "\n" +
																										   "Valor Apólice: " + Utils.converterParaReal(apolice.getValor()) + "\n" +
																										   "Data Inicio: " +  apolice.getDataAssinatura() + "\n" +
																										   "Data Carência: " +  apolice.getDataCarencia() + "\n" +
																										   "Nome Segurado: " + conta.getCliente().getNome() + "\n" +
																										   "CPF Segurado: " + conta.getCliente().getCpf());
																						
																						String confirmar = Utils.lerEntrada("Confirme se deseja acionar o seguro (S ou N): ");
																						while(confirmar.equals("")) {
																							System.out.println("Opção inválida");
																							confirmar = Utils.lerEntrada("Confirme se deseja acionar o seguro (S ou N): ");
																						}
																						
																						if (confirmar.equals("s") || confirmar.equals("S")) {
																							apolice.getSeguro().setIsAtivo(false);
																							conta.setSaldo(conta.getSaldo() + apolice.getValor());
																							
																							System.out.println("");
																							System.out.println("SEGURO ACIONADO COM SUCESSO");
																						}	
																					} else {
																						System.out.println("Não há seguro contratado");
																					}
																				} else {
																					System.out.println("Não há seguro contratado");
																				}
																				break;
																			case "3":
																				System.out.println("");
																				System.out.println("========================== CONSULTAR ==========================");
																				System.out.println("");
																				
																				//VERIFICA SE POSSUI APÓLICE
																				//VERIFICA SE O SEGURO ESTÁ ATIVO
																				if (apolice.getSeguro().getIsAtivo() == true) {
																					if (apolice != null) {
																						System.out.println("Tipo: " + apolice.getDescricao() + "\n" +
																										   "Tempo Contratado: " + tempoSeguro + " anos \n" +
																										   "Valor Anual: " + Utils.converterParaReal(apolice.getSeguro().getTaxa()) + "\n" +
																										   "Valor Seguro Contratado: " + Utils.converterParaReal(valorTotalTaxa) + "\n" +
																										   "Valor Apólice: " + Utils.converterParaReal(apolice.getValor()) + "\n" +
																										   "Data Inicio: " +  apolice.getDataAssinatura() + "\n" +
																										   "Data Carência: " +  apolice.getDataCarencia() + "\n" +
																										   "Nome Segurado: " + conta.getCliente().getNome() + "\n" +
																										   "CPF Segurado: " + conta.getCliente().getCpf());
																					} else {
																						System.out.println("Não há seguro contratado");
																					}
																				} else {
																					System.out.println("Não há seguro contratado");
																				}
																				break;
																			case "4":
																				System.out.println("");
																				System.out.println("========================== CANCELAR ==========================");
																				System.out.println("");
																				
																				//VERIFICA SE POSSUI APÓLICE
																				//VERIFICA SE O SEGURO ESTÁ ATIVO
																				if (apolice.getSeguro().getIsAtivo() == true) {
																					if (apolice != null) {
																						System.out.println("Tipo: " + apolice.getDescricao() + "\n" +
																										   "Tempo Contratado: " + tempoSeguro + " anos \n" +
																										   "Valor Anual: " + Utils.converterParaReal(apolice.getSeguro().getTaxa()) + "\n" +
																										   "Valor Seguro Contratado: " + Utils.converterParaReal(valorTotalTaxa) + "\n" +
																										   "Valor Apólice: " + Utils.converterParaReal(apolice.getValor()) + "\n" +
																										   "Data Inicio: " +  apolice.getDataAssinatura() + "\n" +
																										   "Data Carência: " +  apolice.getDataCarencia() + "\n" +
																										   "Nome Segurado: " + conta.getCliente().getNome() + "\n" +
																										   "CPF Segurado: " + conta.getCliente().getCpf());
																						
																						String confirmar = Utils.lerEntrada("Confirme se deseja cancelar o seguro (S ou N): ");
																						
																						if (confirmar.equals("s") || confirmar.equals("S")) {
																							apolice.getSeguro().setIsAtivo(false);
																							conta.setSaldo(conta.getSaldo() + valorTotalTaxa);
																							
																							System.out.println("");
																							System.out.println("SEGURO CANCELADO COM SUCESSO");
																						}
																					} else {
																						System.out.println("Não há seguro contratado");
																					}
																				} else {
																					System.out.println("Não há seguro contratado");
																				}
																				break;
																			case "5":
																				//VOLTANDO
																				break;
																			default:
																				System.out.println("Opção Inválida");
																		}
																	} while(!opcaoSeguro.equals("5"));
																	break;
																case "9":
																	break;
																default:
																	System.out.println("Opção Inválida");
															}
														} while(!opcaoCredito.equals("9"));
														break;
													case "3":
														//VOLTANDO
														break;
													default:
														System.out.println("Opção Inválida");
												}
											} while(!opcaoCartao.equals("3"));
											break;
										case "6":
											do {
												System.out.println("");
												System.out.println("========================== ÁREA PIX ==========================");
												System.out.println("");
												Menus.menuPix();
												opcaoPix = Utils.lerEntrada("Informe uma das opções acima: ");
												while (opcaoPix.equals("")) {
													System.out.println("Opção inválida, corrija-o.");
													opcaoPix = Utils.lerEntrada("Informe uma das opções acima: ");
												}
												
												switch(opcaoPix) {
													case "1":
														System.out.println("");
														System.out.println("========================== CADASTRAR PIX ==========================");
														System.out.println("");
														
														if (conta.getListaPix().size() > 3) {
															System.out.println("Você chegou no seu limite de chaves PIX");
														} else {
															//CADASTRA PIX
															System.out.println("1 - CPF");
															System.out.println("2 - E-MAIL");
															System.out.println("3 - TELEFONE");
															System.out.println("4 - ALEATORIO");
															opcaoChave = Integer.parseInt(Utils.lerEntrada("Informe qual chave deseja cadastrar: "));
															PixService.cadastrar(conta, opcaoChave, valorPix);
															
															System.out.println("");
															System.out.println("PIX CADASTRADO COM SUCESSO");
														}
														break;
													case "2":
														System.out.println("");
														System.out.println("========================== EXCLUÍR PIX ==========================");
														System.out.println("");
														
														//EXCLUI PIX
														for(int x = 0; x < conta.getListaPix().size(); x++) {
															System.out.println(x + " - " + conta.getListaPix().get(x).getTipoChave() + ": " + 
																						   conta.getListaPix().get(x).getConteudo());
														}
														int opcaoApagar = Integer.parseInt(Utils.lerEntrada("Informe qual das chaves deseja apagar: "));
														
														System.out.println("");
														System.out.println("PIX EXCLUÍDO COM SUCESSO");
														
														conta.getListaPix().remove(opcaoApagar);
														break;
													case "3":
														System.out.println("");
														System.out.println("========================== CONSULTAR PIX ==========================");
														System.out.println("");
														
														//VERIFICA SE EXISTE PIX PARA CONSULTAR
														if (conta.getListaPix().size() > 0) {
															for(int x = 0; x < conta.getListaPix().size(); x++) {
																System.out.println(PixService.consultar(conta, x));
																System.out.println("");
															}
														} else {
															System.out.println("Não há chaves PIX cadastradas");
														}
														break;
													case "4":
														System.out.println("");
														System.out.println("========================== TRANSFERÊNCIA VIA PIX ==========================");
														System.out.println("");
														
														//TRANSFERE VIA PIX
														String conteudoOrigem = Utils.lerEntrada("Informe a sua chave PIX: ");
														while(conteudoOrigem.equals("")) {
															System.out.println("Conteudo inválido, corrija-o");
															conteudoOrigem = Utils.lerEntrada("Informe a sua chave PIX: ");
														}
														
														String conteudoDestino = Utils.lerEntrada("Informe a chave PIX de destino: ");
														while(conteudoDestino.equals("")) {
															System.out.println("Conteudo inválido, corrija-o");
															conteudoDestino = Utils.lerEntrada("Informe a chave PIX de destino: ");
														}
														
														double valor = Double.parseDouble(Utils.lerEntrada("Informe o valor da transferência: "));
														int contaDestinoPix = Integer.parseInt(Utils.lerEntrada("Informe a conta de destino: "));
														
														for(int x = 0; x < conta.getListaPix().size(); x++) {
															if (conta.getListaPix().get(x).getConteudo().equals(conteudoOrigem) &&
																BD.listaContas().get(contaDestinoPix-1).getListaPix().size() > 0) {
																if (BD.listaContas().get(contaDestinoPix-1).getListaPix().get(x).getConteudo().equals(conteudoDestino)) {
																	PixService.transferir(conta, BD.listaContas().get(contaDestinoPix-1), valor);
																	
																	System.out.println("");
																	System.out.println("TRANSFERÊNCIA REALIZADA COM SUCESSO");
																}
															} else {
																System.out.println("Uma das chaves é inexistente");
															}
														}											
														break;
													case "5":
														//VOLTANDO
														break;
													default:
														System.out.println("Opção Inválida");
												}
											} while(!opcaoPix.equals("5"));
										case "7":
											//VOLTANDO
											break;
										default:
											System.out.println("Opção Inválida");
									}
								} while(!opcaoLogado.equals("7"));
							} else {
								System.out.println("Dados inválidos");
						}
					}
				} else {
					System.out.println("Não há clientes cadastrados");
				}
					break;
				case "2":
					System.out.println("");
					System.out.println("========================== CADASTRO CLIENTE ==========================");
					System.out.println("");
					
					//INFORMAÇÕES PARA CADASTRO DO CLIENTE
					String nomeCadastro = Utils.lerEntrada("Informe o seu nome: ");
					while (nomeCadastro.equals("") || nomeCadastro.matches("[0-9]*")) {
						System.out.println("Nome inválido, corrija-o.");
						nomeCadastro = Utils.lerEntrada("Informe o seu nome: ");
					}
					
					String cpfCadastro = Utils.lerEntrada("Informe o seu CPF: ");
					while (cpfCadastro.length() != 11 || !cpfCadastro.matches("[0-9]*")) {
						System.out.println("CPF inválido, corrija-o.");
						cpfCadastro = Utils.lerEntrada("Informe o seu CPF: ");
					}
					
					//VERIFICANDO SE O CPF JÁ EXISTE, SE SIM, NÃO PERMITE O CADASTRO
					for(int i = 0; i < BD.listaContas().size(); i++) {
						while(BD.listaContas().get(i).getCliente().getCpf().equals(cpfCadastro)) {
							System.out.println("CPF já cadastrado");
							cpfCadastro = Utils.lerEntrada("Informe o seu CPF: ");
						}
					}
					
					String emailCadastro = Utils.lerEntrada("Informe o seu e-mail: ");
					while (emailCadastro.equals("") || !emailCadastro.contains("@") || !emailCadastro.contains(".com")) {
						System.out.println("E-mail inválido, corrija-o.");
						emailCadastro = Utils.lerEntrada("Informe o seu e-mail: ");
					}
					
					String telefoneCadastro = Utils.lerEntrada("Informe o seu telefone: ");
					while (telefoneCadastro.length() < 8 || !telefoneCadastro.matches("[0-9]*")) {
						System.out.println("Telefone inválido, corrija-o.");
						telefoneCadastro = Utils.lerEntrada("Informe o seu telefone: ");
					}
					
					String senhaCadastro = Utils.lerEntrada("Crie uma senha: ");
					while (senhaCadastro.length() != 4 || !senhaCadastro.matches("[0-9]*")) {
						System.out.println("Senha inválida, corrija-o.");
						senhaCadastro = Utils.lerEntrada("Crie uma senha: ");
					}
					
					System.out.println("");
					System.out.println("========================== CADASTRO ENDEREÇO ==========================");
					System.out.println("");
					String rua = Utils.lerEntrada("Informe o logradouro (Rua, Trav. Av.): ");
					while (rua.equals("") || rua.matches("[0-9]*")) {
						System.out.println("Rua inválida, corrija-o.");
						rua = Utils.lerEntrada("Informe o logradouro (Rua, Trav. Av.): ");
					}
					
					String numero = Utils.lerEntrada("Informe o número: ");
					while (numero.equals("") || !numero.matches("[0-9]*")) {
						System.out.println("Número inválido, corrija-o.");
						numero = Utils.lerEntrada("Informe o número: ");
					}
					
					String cep = Utils.lerEntrada("Informe o CEP: ");
					while (cep.length() != 8 || !cep.matches("[0-9]*")) {
						System.out.println("CEP inválido, corrija-o.");
						cep = Utils.lerEntrada("Informe o CEP: ");
					}
					
					String bairro = Utils.lerEntrada("Informe o bairro: ");
					while (bairro.equals("") || bairro.matches("[0-9]*")) {
						System.out.println("Bairro inválido, corrija-o.");
						bairro = Utils.lerEntrada("Informe o bairro: ");
					}
					
					String cidade = Utils.lerEntrada("Informe a cidade: ");
					while (cidade.equals("") || cidade.matches("[0-9]*")) {
						System.out.println("Cidade inválida, corrija-o.");
						cidade = Utils.lerEntrada("Informe a cidade: ");
					}
					
					System.out.println("");
					System.out.println("========================== TIPO DE CONTA ==========================");
					System.out.println("");
					System.out.println("1 - Corrente");
					System.out.println("2 - Poupança");
					System.out.println("3 - Corrente e Poupança");
					opcaoConta = Integer.parseInt(Utils.lerEntrada("Informe uma das opções acima: "));
					
					Endereco endereco = new Endereco(rua, numero, cep, bairro, cidade);
					Cliente cliente = new Cliente(nomeCadastro, cpfCadastro, emailCadastro, telefoneCadastro, senhaCadastro, endereco);
					
					if (opcaoConta == 1) {
						BD.listaContas().add(new Conta(cliente, TipoConta.CORRENTE));
					} else if (opcaoConta == 2) {
						BD.listaContas().add(new Conta(cliente, TipoConta.POUPANCA));
					} else if (opcaoConta == 3) {
						BD.listaContas().add(new Conta(cliente, TipoConta.CORRENTE));
						BD.listaContas().add(new Conta(cliente, TipoConta.POUPANCA));
					}
	
					System.out.println("");
					System.out.println("CLIENTE CADASTRADO COM SUCESSO");
					
					BD.listaClientes().add(cliente);
					break;
				case "3":
					System.out.println("Aplicação encerrada");
					System.exit(0);
					break;
				default:
					System.out.println("Opção Inválida");
			}
		} while(!opcaoMenu.equals("3"));
	}
}
