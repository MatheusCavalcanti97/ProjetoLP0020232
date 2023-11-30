package repository;

import java.util.List;

import entidades.Funcionario;
import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.ClienteJaCadastradoException;
import exceptionsClass.CpfException;
import exceptionsClass.EnderecoException;
import exceptionsClass.ListaVaziaException;
import exceptionsClass.TelefoneException;

public class FuncionarioRepository implements CrudClass<Funcionario>{
	
	private static FuncionarioRepository instance; 
	
	private List<Funcionario> listFuncionario;
	
	public static synchronized FuncionarioRepository getInstance() {
		
		if(instance == null) {
			instance = new FuncionarioRepository();
		}
		return instance;
	}

	@Override
	public void inserir()  {
		
	}

	@Override
	public void atualizar() {
//		listFuncionario.add(obj);
		
	}

	@Override
	public void deletar() {
		
	}

	@Override
	public List<Funcionario> listarTodos(){
		for(Funcionario funcionario : listFuncionario) {
			System.out.println(funcionario.toString());
		}
		return null;
	}

	public List<Funcionario> getListFuncionario() {
		return listFuncionario;
	}
	public void buscarMatricula() {
		
	}

}
