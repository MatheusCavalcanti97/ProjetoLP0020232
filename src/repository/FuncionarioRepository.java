package repository;

import java.util.List;

import entidades.Funcionario;
import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.ClienteJaCadastradoException;
import exceptionsClass.CpfException;
import exceptionsClass.EnderecoException;
import exceptionsClass.ListaVaziaException;
import exceptionsClass.TelefoneException;
import modelo.CrudClass;

public class FuncionarioRepository implements CrudClass<Funcionario>{
	
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
	public void inserir(Funcionario obj)  {
		
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

	public List<Funcionario> getListFuncionario() {
		return listFuncionario;
	}

}
