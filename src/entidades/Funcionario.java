package entidades;

import java.util.Date;
import java.util.List;

public class Funcionario extends Pessoa {

	private String matriculaFunc;
	private String cargo;
	private double salario;
	private Date dataDeAdmissao;
	private double comissao;

	public Funcionario(String cpfPessoa, String nome, Date dataNascimento, String email, Endereco endereco,
			List<Telefone> telefone, String matriculaFunc, String cargo, double salario, Date dataDeAdmissao,
			double comissao) {
		super(cpfPessoa, nome, dataNascimento, email, endereco, telefone);
		this.matriculaFunc = matriculaFunc;
		this.cargo = cargo;
		this.salario = salario;
		this.dataDeAdmissao = dataDeAdmissao;
		this.comissao = comissao;
	}

	public String getMatriculaFunc() {
		return matriculaFunc;
	}

	public void setMatriculaFunc(String matriculaFunc) {
		this.matriculaFunc = matriculaFunc;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Date getDataDeAdmissao() {
		return dataDeAdmissao;
	}

	public void setDataDeAdmissao(Date dataDeAdmissao) {
		this.dataDeAdmissao = dataDeAdmissao;
	}

	public double getComissao() {
		return comissao;
	}

	public void setComissao(double comissao) {
		this.comissao = comissao;
	}

	public String toString() {
		return "Nome: " + this.nome + " Matrícula: " + this.matriculaFunc;
	}

}
