package entidades;

import java.util.Date;
import java.util.List;

import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.CpfException;
import exceptionsClass.EnderecoException;
import exceptionsClass.TelefoneException;
import modelo.CrudClass;
import modelo.IFuncionario;
import util.ValidacaoIO;

public class Funcionario extends Pessoa implements CrudClass<Funcionario>, IFuncionario {

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

	@Override
	public void inserir(Funcionario f) {
			
	}
	

	@Override
	public void atualizar(Funcionario obj) {

	}

	@Override
	public void deletar(Funcionario obj) {

	}

	@Override
	public double calcularSalarioLiquido(Double comissao) {

		return (this.salario + comissao);
	}

	@Override
	public List<Funcionario> listarTodos() {
		return null;
	}

	@Override
	public Funcionario buscarPorCpf(String cpf) {
		return null;
	}
	public String toString() {
		return this.nome + " " + this.matriculaFunc;
	}

}
