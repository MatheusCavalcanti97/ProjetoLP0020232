package entidades;

import java.util.Date;
import java.util.List;
import java.util.Objects;

public abstract class Pessoa {

	public String cpfPessoa;
	public String nome;
	public Date dataNascimento;
	public String email;
	public Endereco endereco;
	public List<Telefone> telefone;

	public Pessoa() { }

	public Pessoa(String cpfPessoa, String nome, Date dataNascimento, String email, Endereco endereco,
			List<Telefone> telefone) {
		super();
		this.cpfPessoa = cpfPessoa;
		this.nome = nome;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
	}

	public String getCpfPessoa() {
		return cpfPessoa;
	}

	public void setCpfPessoa(String cpfPessoa) {
		this.cpfPessoa = cpfPessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public List<Telefone> getTelefone() {
		return telefone;
	}

	public void setTelefone(List<Telefone> telefone) {
		this.telefone = telefone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpfPessoa, dataNascimento, email, endereco, nome, telefone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(cpfPessoa, other.cpfPessoa) && Objects.equals(dataNascimento, other.dataNascimento)
				&& Objects.equals(email, other.email) && Objects.equals(endereco, other.endereco)
				&& Objects.equals(nome, other.nome) && Objects.equals(telefone, other.telefone);
	}

}
