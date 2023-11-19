package repository;

import java.util.List;

import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.ClienteJaCadastradoException;
import exceptionsClass.CpfException;
import exceptionsClass.EnderecoException;
import exceptionsClass.ListaVaziaException;
import exceptionsClass.TelefoneException;

public interface CrudRepository <T>{

	public void inserir(T obj) throws TelefoneException, EnderecoException, CpfException,
			AtributosNaoNulosNaoVaziosException, ClienteJaCadastradoException, ListaVaziaException;

	public void atualizar(T obj);

	public void deletar(T obj);

	public List<T> listarTodos() throws ListaVaziaException;

	T buscarPorCpf(String cpf) throws ClienteJaCadastradoException, ListaVaziaException;
}