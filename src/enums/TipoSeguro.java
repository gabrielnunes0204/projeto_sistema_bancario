package enums;

public enum TipoSeguro {
	
	MORTE, INVALIDEZ, DESEMPREGO;

	public static final Double TAXA_MORTE = 36.0;
	public static final Double TAXA_INVALIDEZ = 26.0;
	public static final Double TAXA_DESEMPREGO = 16.0;

	
	
	public static final String REGRA_MORTE = "(i) Indenização por despesas médico-hospitalares, ou por perda parcial ou" + "\n" + "total do funcionamento dos membros ou órgãos;" + "\n" +
										 	 "(ii) Reembolso de custos em diagnóstico de doenças graves, como infarto, acidente" + "\n" + "vascular cerebral e câncer;" + "\n" +
										 	 "(iii) Assistência funeral, para você e a sua família." + "\n" +
										 	 "(iv) O valor do seguro individual é de R$36,00 ao ano.";
	
	public static final String REGRA_INVALIDEZ = "(i) Invalidez parcial: ocorre quando há uma perda parcial das funções." + "\n" + "Por exemplo, uma pessoa que sofre um acidente e perda a visão em um só dos olhos." + "\n" +
												 "(ii) Invalidez total: ocorre quando há uma perda total das funções. Intuitivamente," + "\n" + "um bom exemplo seria o caso onde a pessoa sofre um acidente e perde a visão em ambos os olhos." + "\n" +
												 "(iii) O valor do seguro individual é de R$26,00 ao ano.";
	
	public static final String REGRA_DESEMPREGO = "(i) Necessário trabalhar com registro CLT, com o tempo mínimo de estabilidade de 12 meses." + "\n" +
			  									  "(ii)Válido apenas para desligamento involuntários e sem justa causa." + "\n" +
			  									  "(iii)Não é valido em caso de demissão em massa (10% ou mais de demissões simultâneas) ou falência/encerramento das atividades." + "\n" +
			  									  "(iv) O valor do seguro individual é de R$16,00 ao ano";
}
