package repository;

import java.util.List;

import entidades.Funcionario;
import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.ClienteJaCadastradoException;
import exceptionsClass.CpfException;
import exceptionsClass.EnderecoException;
import exceptionsClass.ListaVaziaException;
import exceptionsClass.TelefoneException;

public class FuncionarioRepository implements CrudRepository<Funcionario>{
	
	private static FuncionarioRepository instance; 
	
	private List<Funcionario> listFuncionario;
	
	private FuncionarioRepository (List<Funcionario> listFuncionario) {
		
		this.listFuncionario = listFuncionario;
		
	}
	
	public static synchronized FuncionarioRepository getInstance(List<Funcionario> listFuncionario) {
		
		if(instance == null) {
			instance = new FuncionarioRepository(listFuncionario);
		}
		return instance;
	}

	@Override
	public void inserir(Funcionario obj) throws TelefoneException, EnderecoException, CpfException,
			AtributosNaoNulosNaoVaziosException, ClienteJaCadastradoException, ListaVaziaException {
		
	}

	@Override
	public void atualizar(Funcionario obj) {
		listFuncionario.add(obj);
		
	}

	@Override
	public void deletar(Funcionario obj) {
		
	}

	@Override
	public List<Funcionario> listarTodos() throws ListaVaziaException {
		for(Funcionario funcionario : listFuncionario) {
			System.out.println(funcionario.toString());
		}
		return null;
	}

	@Override
	public Funcionario buscarPorCpf(String cpf) throws ClienteJaCadastradoException, ListaVaziaException {
		for(Funcionario funcionario : listFuncionario) {
			if(funcionario.cpfPessoa.equals(cpf)) {
				return funcionario;
			}
		}
		return null;
	}

	public List<Funcionario> getListFuncionario() {
		return listFuncionario;
	}

}
