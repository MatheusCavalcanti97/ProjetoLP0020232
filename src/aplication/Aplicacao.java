package aplication;
import java.text.ParseException;

import exceptionsClass.ApenasLetrasException;
import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.ClienteJaCadastradoException;
import exceptionsClass.CpfException;
import views.Main;

public class Aplicacao {

	public static void main(String[]args) throws CpfException, AtributosNaoNulosNaoVaziosException, ClienteJaCadastradoException, ApenasLetrasException, ParseException {
		new Main().run();
	}
}
