package modelo;

import java.util.List;

import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.CpfException;
import exceptionsClass.EnderecoException;
import exceptionsClass.TelefoneException;

public interface CrudClass<T> {

	public void inserir(T obj) throws TelefoneException, EnderecoException, CpfException, AtributosNaoNulosNaoVaziosException;

	public void atualizar(T obj);

	public void deletar(T obj);

	public List<T> listarTodos();

	T buscarPorCpf(String cpf);
}
