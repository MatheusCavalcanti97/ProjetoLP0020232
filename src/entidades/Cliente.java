package entidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.CpfException;
import exceptionsClass.EnderecoException;
import exceptionsClass.TelefoneException;
import modelo.CrudClass;
import modelo.ICliente;
import util.ValidacaoIO;

public class Cliente extends Pessoa implements CrudClass<Cliente>, ICliente {

	private Date dataDeCadastro;
	private List<Cliente> listaCliente = new ArrayList<>();
	private static Cliente c;

	public Cliente() { }

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

	public void inserir(Cliente c)
			throws TelefoneException, EnderecoException, CpfException, AtributosNaoNulosNaoVaziosException {

		if (c != null) {
			if (ValidacaoIO.validaCpf(c.getCpfPessoa()) == true) {
				if (ValidacaoIO.verificacaoStringVazia(c.getNome()) == false
						&& ValidacaoIO.verificacaoStringNula(c.getNome()) == false) {
					if (c.getEndereco() != null) {
						if (c.getTelefone().size() != 0) {
							Cliente.getInstance().listaCliente.add(c);
						} else {
							throw new TelefoneException(
									"É necessário ser inserir todas as informações do Endereço do Cliente. Tente Novamente.\n");
						}
					} else {
						throw new EnderecoException(
								"É necessário ser inserir todas as informações do Endereço do Cliente. Tente Novamente.\n");
					}
				} else {
					throw new AtributosNaoNulosNaoVaziosException(
							"Nenhum Campo poderá estar Vazio ou Nulo no momento do preenchimento das Informações. Tente Novamente.\n");
				}
			} else {
				throw new CpfException("Cpf Inserido INCORRETAMENTE. Tente Novamente.");
			}
		} else {
			throw new NullPointerException(
					"É necessário ser inserida todas as informações do Cliente. Tente Novamente.\n");
		}
	}

	@Override
	public void atualizar(Cliente obj) {

	}

	@Override
	public void deletar(Cliente obj) {

	}

	@Override
	public Cliente buscarPorDataDeCadastro(String dataCadastro) {
		return null;
	}

	@Override
	public List<Cliente> listarTodos() {
		List<Cliente> c = Cliente.getInstance().listaCliente;
		return c;
	}

	@Override
	public Cliente buscarPorCpf(String cpf) {
		return null;
	}

	public List<Cliente> getListaCliente() {
		return listaCliente;
	}

	public void setListaCliente(List<Cliente> listaCliente) {
		this.listaCliente = listaCliente;
	}

	public Date getDataDeCadastro() {
		return dataDeCadastro;
	}

	public void setDataDeCadastro(Date dataDeCadastro) {
		this.dataDeCadastro = dataDeCadastro;
	}

	@Override
	public String toString() {
		Date a = new Date();
		DateFormat dF = new SimpleDateFormat("dd/MM/yyyy");
		String dataNasc1 = dF.format(this.dataNascimento);
		String dataCadastro2 = dF.format(this.dataDeCadastro);

		String returnInfo = "CPF: " + this.cpfPessoa + "\nNome: " + this.nome + "\nData de Nascimento: " + dataNasc1
				+ "\nE-mail: " + this.email + "\n---------- INFO ENDEREÇO ----------\n" + "\nRua: "
				+ this.getEndereco().getNomeRua() + "\nNúmero Imovél: " + this.getEndereco().getNumeroImovel()
				+ "\nCidade: " + this.getEndereco().getCidade() + "\nEstado: " + this.getEndereco().getEstado()
				+ "\nData de Cadastro: " + dataCadastro2;

		return returnInfo;

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
