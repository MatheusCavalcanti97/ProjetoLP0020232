package entidades;

import java.util.Date;
import java.util.List;

import modelo.CrudClass;
import modelo.IFuncionario;

public class Funcionario extends Pessoa implements CrudClass<Funcionario>, IFuncionario {

	private String matriculaFunc;
	private String cargo;
	private double salarioBruto;
	private Date dataDeAdmissao;
	private double comissao;

	public Funcionario(String cpfPessoa, String nome, Date dataNascimento, String email, Endereco endereco,
			List<Telefone> telefone, String matriculaFunc, String cargo, double salarioBruto, Date dataDeAdmissao,
			double comissao) {
		super(cpfPessoa, nome, dataNascimento, email, endereco, telefone);
		this.matriculaFunc = matriculaFunc;
		this.cargo = cargo;
		this.salarioBruto = salarioBruto;
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

	public double getSalarioBruto() {
		return salarioBruto;
	}

	public void setSalarioBruto(double salarioBruto) {
		this.salarioBruto = salarioBruto;
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
	public void inserir(Funcionario obj) {

	}

	@Override
	public void atualizar(Funcionario obj) {

	}

	@Override
	public void deletar(Funcionario obj) {

	}

	@Override
	public double calcularSalarioLiquido(Double comissao) {
		
		return 0;
	}

	@Override
	public List<Funcionario> listarTodos() {
		return null;
	}

	@Override
	public Funcionario buscarPorCpf(String cpf) {
		return null;
	}

}
