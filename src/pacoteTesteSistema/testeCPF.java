package pacoteTesteSistema;

import java.text.ParseException;
import java.util.Scanner;

import util.ValidacaoIO;

public class testeCPF {
	public static void main(String[] args) throws ParseException {
		Scanner ler5 = new Scanner(System.in);
		String dddTelefone = null, numeroTelefone = null;
//		String a = "", b = null;
//		System.out.println(a.replaceAll(" ", ""));
//
//		System.out.println(ValidacaoIO.verificacaoStringVazia(a));
//		System.out.println(ValidacaoIO.verificacaoStringNula(b));
//		
//		System.out.println(a.isEmpty());
		
		System.out.printf("\nInforme o DDD do seu Número de Telefone (Composto 2 digitos - DIGITE APENAS NÚMEROS): ");
		dddTelefone = ler5.nextLine();
		
		System.out.println(dddTelefone);

		System.out.printf(
				"\nInforme o Número do Telefone (Composto pelo número 9 na frente e mais 8 digitos - DIGITE APENAS NÚMEROS): ");
		numeroTelefone = ler5.nextLine();
		
		System.out.println(numeroTelefone);

		if (ValidacaoIO.validacaoTelefoneException(dddTelefone) == true
				&& ValidacaoIO.validacaoTelefoneException(numeroTelefone)) {
			String telPhone = dddTelefone + "" + numeroTelefone;
		}
		
		System.out.println(ValidacaoIO.validacaoTelefoneException(numeroTelefone));
		System.out.println(ValidacaoIO.validacaoTelefoneException(numeroTelefone));

//		Date data = new Date();
//    	Calendar cal = Calendar.getInstance();
//    	cal.setTime(data);
//    
//    	SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
//    	
//    	int dia = cal.get(Calendar.DAY_OF_MONTH);
//    	int mes = cal.get(Calendar.MONTH);
//    	int ano = cal.get(Calendar.YEAR);
//
//    	String dataStr = dia + "/" + mes + "/" + ano;
//    	dataStr = dataStr.replaceAll(" ", "");
//    	data = sdf.parse(dataStr);
//    	
//    	System.out.println(dataStr);
		

	}
}
