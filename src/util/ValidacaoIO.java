package util;

import java.text.ParseException;
import java.util.Calendar;

import exceptionsClass.DataNascimentoException;

public class ValidacaoIO {

	public static boolean validaCpf(String cpf) {
		Boolean var = true;
		String verifyCpf = cpf.replaceAll(" ", "");
		verifyCpf = verifyCpf.trim();

		if (cpf.length() == 11) {
			for (int i = 0; i < verifyCpf.length(); i++) {
				char c = verifyCpf.charAt(i);
				if (Character.isDigit(c)) {
					var = true;
				} else {
					var = false;
					break;
				}
			}
		} else {
			var = false;
		}

		return var;
	}

	public static Boolean verificacaoStringVazia(String str) {
		boolean var = true;
		str = str.replaceAll(" ", "");
		if (str.isEmpty()) {
			var = true;
		} else {
			var = false;
		}
		return var;
	}

	public static Boolean verificacaoStringNula(String str) {
		boolean var = true;
		if (str == null) {
			var = true;
		} else {
			var = false;
		}
		return var;
	}

	public static boolean validarData(int dia, int mes, int ano) throws ParseException {
		boolean var = true;

		Calendar cal = Calendar.getInstance();
		int anoC = cal.get(Calendar.YEAR);

		if (dia >= 1 && dia <= 31) {
			if (mes >= 1 && mes <= 12) {
				if (ano >= 1900 && ano <= anoC) {
					var = true;
				} else {
					var = false;
				}
			} else {
				var = false;
			}
		} else {
			var = false;
		}

		return var;
	}

	public static Boolean validacaoTelefoneException(String num) {
		Boolean var = true;
		String verifyTel = num.replaceAll(" ", "");
		verifyTel = verifyTel.trim();

		if (verifyTel.length() == 2 || verifyTel.length() == 9) {
			for (int i = 0; i < verifyTel.length(); i++) {
				char c = verifyTel.charAt(i);
				if (Character.isDigit(c)) {
					var = true;
				} else {
					var = false;
					break;
				}
			}
		} else {
			var = false;
		}

		return var;
	}

}
