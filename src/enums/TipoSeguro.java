package enums;

public enum TipoSeguro {
	
	MORTE, INVALIDEZ, DESEMPREGO;

	public static final Double TAXA_MORTE = 36.0;
	public static final Double TAXA_INVALIDEZ = 26.0;
	public static final Double TAXA_DESEMPREGO = 16.0;

	
	
	public static final String REGRA_MORTE = "(i) Indeniza��o por despesas m�dico-hospitalares, ou por perda parcial ou" + "\n" + "total do funcionamento dos membros ou �rg�os;" + "\n" +
										 	 "(ii) Reembolso de custos em diagn�stico de doen�as graves, como infarto, acidente" + "\n" + "vascular cerebral e c�ncer;" + "\n" +
										 	 "(iii) Assist�ncia funeral, para voc� e a sua fam�lia." + "\n" +
										 	 "(iv) O valor do seguro individual � de R$36,00 ao ano.";
	
	public static final String REGRA_INVALIDEZ = "(i) Invalidez parcial: ocorre quando h� uma perda parcial das fun��es." + "\n" + "Por exemplo, uma pessoa que sofre um acidente e perda a vis�o em um s� dos olhos." + "\n" +
												 "(ii) Invalidez total: ocorre quando h� uma perda total das fun��es. Intuitivamente," + "\n" + "um bom exemplo seria o caso onde a pessoa sofre um acidente e perde a vis�o em ambos os olhos." + "\n" +
												 "(iii) O valor do seguro individual � de R$26,00 ao ano.";
	
	public static final String REGRA_DESEMPREGO = "(i) Necess�rio trabalhar com registro CLT, com o tempo m�nimo de estabilidade de 12 meses." + "\n" +
			  									  "(ii)V�lido apenas para desligamento involunt�rios e sem justa causa." + "\n" +
			  									  "(iii)N�o � valido em caso de demiss�o em massa (10% ou mais de demiss�es simult�neas) ou fal�ncia/encerramento das atividades." + "\n" +
			  									  "(iv) O valor do seguro individual � de R$16,00 ao ano";
}
