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

	public void inserir();

	public void atualizar();

	public void deletar();

	public List<T> listarTodos();

}
