package entidades;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Objects;

public class Cliente extends Pessoa {

	private Date dataDeCadastro;

	public Cliente() {
	}

	public Cliente(String cpfPessoa, String nome, Date dataNascimento, String email, Endereco endereco,
			List<Telefone> telefone, Date dataDeCadastro) {
		super(cpfPessoa, nome, dataNascimento, email, endereco, telefone);
		this.dataDeCadastro = dataDeCadastro;
	}

	@Override
	public String toString() {
		DateFormat dF = new SimpleDateFormat("dd/MM/yyyy");
		String dataNasc1 = dF.format(this.dataNascimento);
		String dataCadastro2 = dF.format(this.dataDeCadastro);

		String returnInfo = "CPF: " + this.cpfPessoa
				+ "\nNome: " + this.nome + "\nData de Nascimento: " + dataNasc1 + "\nE-mail: " + this.email
				+ "\n\n------ INFO ENDEREÇO ------" + "\nRua: " + this.getEndereco().getNomeRua()
				+ "\nNúmero Imovél: " + this.getEndereco().getNumeroImovel() + "\nCidade: "
				+ this.getEndereco().getCidade() + "\nEstado: " + this.getEndereco().getEstado()
				+ "\nData de Cadastro: " + dataCadastro2 + "\n";

		return returnInfo;

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