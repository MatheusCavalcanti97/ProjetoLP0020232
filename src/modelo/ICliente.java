package modelo;

import entidades.Cliente;
import exceptionsClass.ClienteJaCadastradoException;
import exceptionsClass.ListaVaziaException;

public interface ICliente {
	
	public Cliente buscarPorDataDeCadastro(String dataCadastro);
	Cliente buscarPorCpf(String cpf) throws ClienteJaCadastradoException, ListaVaziaException;

}
