package entidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.ClienteJaCadastradoException;
import exceptionsClass.EnderecoException;
import exceptionsClass.ListaVaziaException;
import exceptionsClass.TelefoneException;
import modelo.CrudClass;
import modelo.ICliente;
import util.ValidacaoIO;

public class Cliente extends Pessoa implements CrudClass<Cliente>, ICliente {

	private Date dataDeCadastro;
	private List<Cliente> listaCliente = new ArrayList<>();
	private static Cliente c;

	public Cliente() {
	}

	public Cliente(String cpfPessoa, String nome, Date dataNascimento, String email, Endereco endereco,
			List<Telefone> telefone, Date dataDeCadastro) {
		super(cpfPessoa, nome, dataNascimento, email, endereco, telefone);
		this.dataDeCadastro = dataDeCadastro;
	}

	public static Cliente getInstance() {
		if (c == null) {
			c = new Cliente();
		}

		return c;
	}

	public void inserir(Cliente c) throws TelefoneException, EnderecoException, AtributosNaoNulosNaoVaziosException,
			ClienteJaCadastradoException, ListaVaziaException {

		if (c != null) {

			if (this.cpfJaExiste(c.getCpfPessoa()) == false) {
				if (ValidacaoIO.verificacaoStringVazia(c.getNome()) == false
						&& ValidacaoIO.verificacaoStringNula(c.getNome()) == false) {
					if (c.getEndereco() != null) {
						if (c.getTelefone().size() != 0) {
							Cliente.getInstance().listaCliente.add(c);
						} else {
							throw new TelefoneException("INSIRA CORRETAMENTE AS INFORMAÇÕES DO TELEFONE!\n");
						}
					} else {
						throw new EnderecoException(
								"TODOS OS CAMPOS DO ENDERECO DEVEM ESTAR DEVIDAMENTE PREENCHIDOS!\n");
					}
				} else {
					throw new AtributosNaoNulosNaoVaziosException("O CAMPO DE NOME DEVE ESTAR DEVIDAMENTE PREENCHIDO!");
				}
			} else {
				throw new ClienteJaCadastradoException("O CLIENTE JÁ SE ENCONTRA CADASTRADO!");
			}
		} else {
			throw new NullPointerException("É NECESSÁRIO QUE SE PREENCHA TODOS OS CAMPOS DO CADASTRO!\n");
		}
	}

	@Override
	public void atualizar(Cliente c) {
		List<Cliente> cList = Cliente.getInstance().listaCliente;
		for (int i = 0; i < Cliente.getInstance().listaCliente.size(); i++) {
			if (c.getCpfPessoa().equals(cList.get(i).getCpfPessoa())) {
				cList.get(i).setEndereco(c.getEndereco());
				;
			}
		}

	}

	@Override
	public void deletar(Cliente c) {

	}

	@Override
	public Cliente buscarPorDataDeCadastro(String dataCadastro) {
		return null;
	}

	@Override
	public List<Cliente> listarTodos() throws ListaVaziaException {
		List<Cliente> c = Cliente.getInstance().listaCliente;
		if (c.size() < 1) {
			throw new ListaVaziaException("Nenhum Cliente Cadastrado!");
		}
		return c;
	}

	@Override
	public Cliente buscarPorCpf(String cpf) throws ClienteJaCadastradoException, ListaVaziaException {
		Cliente c1 = null;
		List<Cliente> c = Cliente.getInstance().listaCliente;

		if (Cliente.getInstance().listaCliente.size() < 1) {
			c1 = null;
			throw new ListaVaziaException("NENHUM CLIENTE CADASTRADO!");
		}

		for (int i = 0; i < c.size(); i++) {
			if ((cpf.equals(c.get(i).getCpfPessoa()))) {
				c1 = c.get(i);
			} else {
				c1 = null;
				throw new ClienteJaCadastradoException("Cliente Não Cadastrado!");
			}

		}

		return c1;
	}

	public Boolean cpfJaExiste(String cpf) {
		Boolean b = false;
		List<Cliente> c = Cliente.getInstance().listaCliente;

		for (int i = 0; i < c.size(); i++) {
			if (cpf.equals(c.get(i).getCpfPessoa())) {
				b = true;
			} else {
				b = false;
			}
		}

		return b;
	}

	@Override
	public String toString() {
		DateFormat dF = new SimpleDateFormat("dd/MM/yyyy");
		String dataNasc1 = dF.format(this.dataNascimento);
		String dataCadastro2 = dF.format(this.dataDeCadastro);

		String returnInfo = "CPF: " + this.cpfPessoa + "\nNome: " + this.nome + "\nData de Nascimento: " + dataNasc1
				+ "\nE-mail: " + this.email + "\n\n---------- INFO ENDEREÇO ----------" + "\nRua: "
				+ this.getEndereco().getNomeRua() + "\nNúmero Imovél: " + this.getEndereco().getNumeroImovel()
				+ "\nCidade: " + this.getEndereco().getCidade() + "\nEstado: " + this.getEndereco().getEstado()
				+ "\nData de Cadastro: " + dataCadastro2;

		return returnInfo;

	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = Cliente.getInstance().listaCliente;
	}

	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(dataDeCadastro);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(dataDeCadastro, other.dataDeCadastro);
	}

}
