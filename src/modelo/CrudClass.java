package modelo;

import java.util.List;

import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.ClienteJaCadastradoException;
import exceptionsClass.CpfException;
import exceptionsClass.EnderecoException;
import exceptionsClass.EstoqueUnicoException;
import exceptionsClass.ListaVaziaException;
import exceptionsClass.TelefoneException;

public interface CrudClass<T> {

	public void inserir(T obj) throws TelefoneException, EnderecoException, CpfException, AtributosNaoNulosNaoVaziosException, ClienteJaCadastradoException, ListaVaziaException, NullPointerException, EstoqueUnicoException;

	public void atualizar(T obj);

	public void deletar(T obj) throws ListaVaziaException;

	public List<T> listarTodos() throws ListaVaziaException;

}
