package repository;

import java.text.ParseException;
import java.util.List;

import exceptionsClass.ApenasLetrasException;
import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.CategoriaProdutoException;
import exceptionsClass.ClienteJaCadastradoException;
import exceptionsClass.CpfException;
import exceptionsClass.EstoqueUnicoException;
import exceptionsClass.ListaVaziaException;
import exceptionsClass.TelefoneException;

public interface CrudClass<T> {

	public void inserir() throws ClienteJaCadastradoException, CpfException, AtributosNaoNulosNaoVaziosException, ApenasLetrasException, ParseException, TelefoneException, EstoqueUnicoException, CategoriaProdutoException;

	public void atualizar() throws ListaVaziaException, ClienteJaCadastradoException, AtributosNaoNulosNaoVaziosException, EstoqueUnicoException;

	public void deletar() throws ListaVaziaException, ClienteJaCadastradoException, EstoqueUnicoException;

	public List<T> listarTodos() throws ListaVaziaException;


}
