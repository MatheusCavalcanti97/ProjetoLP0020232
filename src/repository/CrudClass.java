package repository;

import java.text.ParseException;
import java.util.List;

import exceptionsClass.ApenasLetrasException;
import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.ClienteJaCadastradoException;
import exceptionsClass.CpfException;
import exceptionsClass.ListaVaziaException;
import exceptionsClass.TelefoneException;

public interface CrudClass<T> {

	public void inserir() throws ClienteJaCadastradoException, CpfException, AtributosNaoNulosNaoVaziosException, ApenasLetrasException, ParseException, TelefoneException;

	public void atualizar();

	public void deletar();

	public List<T> listarTodos() throws ListaVaziaException;


}
