package repository;

import java.text.ParseException;
import java.util.List;

import exceptionsClass.ApenasLetrasException;
import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.ClienteJaCadastradoException;
import exceptionsClass.CpfException;
import exceptionsClass.EstoqueNaoCadastradoException;
import exceptionsClass.EstoqueUnicoException;
import exceptionsClass.ExclusaoNaoPermitidaProdutoException;
import exceptionsClass.ListaVaziaException;
import exceptionsClass.ProdutoNaoEncontradoCadastradoException;
import exceptionsClass.TelefoneException;

public interface CrudClass<T> {

	public void inserir() throws ClienteJaCadastradoException, CpfException, AtributosNaoNulosNaoVaziosException, ApenasLetrasException, ParseException, TelefoneException, EstoqueUnicoException, EstoqueNaoCadastradoException;

	public void atualizar() throws ListaVaziaException, ClienteJaCadastradoException, AtributosNaoNulosNaoVaziosException, EstoqueUnicoException;

	public void deletar() throws ListaVaziaException, ClienteJaCadastradoException, EstoqueUnicoException, ExclusaoNaoPermitidaProdutoException, ProdutoNaoEncontradoCadastradoException;

	public List<T> listarTodos() throws ListaVaziaException;


}
