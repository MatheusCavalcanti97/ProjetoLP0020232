package repository;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entidades.Endereco;
import entidades.Funcionario;
import entidades.Telefone;
import exceptionsClass.ApenasLetrasException;
import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.ClienteJaCadastradoException;
import exceptionsClass.CpfException;
import util.ValidacaoIO;

public class FuncionarioRepository implements CrudClass<Funcionario> {

	Scanner sc = new Scanner(System.in);

	private static FuncionarioRepository instance;

	private List<Funcionario> listFuncionario = new ArrayList<>();;

	public static synchronized FuncionarioRepository getInstance() {

		if (instance == null) {
			instance = new FuncionarioRepository();
		}
		return instance;
	}

	@Override
	public void inserir() throws CpfException, AtributosNaoNulosNaoVaziosException, ClienteJaCadastradoException,
			ApenasLetrasException, ParseException {

		String nome = "";
		String cpf = "";
		String email = "";
		List<Telefone> telefones = new ArrayList<>();
		Date dataNascimenro = null;
		Date dataCadastro;
		String matriculaFunc = "";
		String cargo = "";
		Double salario = 0.0;
		Double comissao = 0.0;

		boolean validacaoCpf = false;
		boolean validacaoNome = false;
		boolean validacaoEmail = false;
		boolean ValidacaoNumero = false;
		boolean ValidacaoMatricula = false;
		boolean ValidacaoCargo = false;

		System.out.println("		Cadastrar Funcionário		");

		// NOME
		while (validacaoNome != true) {

			System.out.println("\n---------------------------\n");
			System.out.println("Digite o Nome: ");

			nome = sc.nextLine();
			System.out.println("\n---------------------------\n");

			if (ValidacaoIO.verificacaoStringNula(nome) == false && ValidacaoIO.verificacaoStringVazia(nome) == false) {
				if (ValidacaoIO.ApenasDeLetras(nome) == true) {
					validacaoNome = true;
				} else {
					System.out.println("O nome deve conter apenas letras!");
				}
			} else {
				System.out.println("Nome inválido!");

			}
		}

		// CPF
		while (validacaoCpf != true) {

			System.out.println("\n---------------------------\n");
			System.out.println("Digite o CPF: ");
			cpf = sc.nextLine();
			if (ValidacaoIO.validaCpf(cpf) == true && ValidacaoIO.verificacaoStringVazia(cpf) == false) {
				if (cpfDuplicado(cpf) == false) {
					validacaoCpf = true;
				} else {
					System.out.println("\n---------------------------\n");
					System.out.println("CPF já cadastrado!");
				}
			} else {
				System.out.println("\n---------------------------\n");
				System.out.println("Digite um CPF válido!");
			}
		}

		// EMAIL
		while (validacaoEmail != true) {

			System.out.println("\n---------------------------\n");
			System.out.println("Digite o email: ");
			email = sc.nextLine();
			if (ValidacaoIO.verificacaoStringNula(email) == false
					&& ValidacaoIO.verificacaoStringVazia(email) == false) {
				validacaoEmail = true;
			}
		}

		// ENDERECO
		System.out.println("\n---------------------------\n");
		System.out.println(" 		Endereço		");

		Endereco endereco = newEndereco();
		System.out.println("\n---------------------------\n");

		// NUMERO TELEFONE
		System.out.println("		Número de telefone		");
		while (ValidacaoNumero != true) {
			String pass = "";

			Telefone telefone = newTelefone();
			telefones.add(telefone);
			System.out.println("Deseja adicionar outro telefone? S/N");
			System.out.println(": ");
			pass = sc.nextLine();

			if (pass.toUpperCase().equalsIgnoreCase("S") || pass.toUpperCase().equalsIgnoreCase("SIM")) {
				continue;
			} else {
				ValidacaoNumero = true;
				System.out.println("\n---------------------------\n");
				ValidacaoNumero = true;
			}
		}

		// DATA NASCIMENTO
		boolean validacaoData = true;
		while (validacaoData) {
			try {
				dataNascimenro = inserirDataNascimento();
				validacaoData = false;
			} catch (java.text.ParseException e) {
				System.out.println("Data incorreta");
			}
			System.out.println("\n---------------------------\n");
		}
		dataCadastro = newDataCadastro();

		// MATRICULA
		while (ValidacaoMatricula != true) {
			System.out.println("Matrícula: ");
			matriculaFunc = sc.nextLine();
			if (ValidacaoIO.verificacaoStringNula(matriculaFunc) == false
					&& ValidacaoIO.verificacaoStringVazia(matriculaFunc) == false) {
				if (matriculaDuplicado(matriculaFunc) == false) {
					ValidacaoMatricula = true;

				} else {
					System.out.println("Matrícula já existe!");
					System.out.println("\n---------------------------\n");

				}
			} else {
				System.out.println("Matrícula inválida!");
				System.out.println("\n---------------------------\n");

			}
		}
		System.out.println("\n---------------------------\n");

		// CARGO
		while (ValidacaoCargo != true) {
			System.out.println("Cargo: ");
			cargo = sc.nextLine();
			if (ValidacaoIO.verificacaoStringNula(cargo) == false
					&& ValidacaoIO.verificacaoStringVazia(cargo) == false) {
				ValidacaoCargo = true;
			} else {
				System.out.println("Matrícula inválida!");
			}
		}
		System.out.println("\n---------------------------\n");

		// SALARIO
		boolean ValidacaoSalario = false;
		while (ValidacaoSalario != true) {
			try {
				System.out.println("		Salário		");
				System.out.println("Salário: ");
				salario = sc.nextDouble();
				sc.nextLine();
				if (salario >= 1320) {
					ValidacaoSalario = true;
				} else {
					System.out.println("Salário inválido!");
					System.out.println("Salário deve ser igual ou maior que R$1320,00\n");
				}
			} catch (java.util.InputMismatchException e2) {
				sc.nextLine();
				System.out.println("Salário inválido!");
				System.out.println("\n---------------------------\n");
			}
		}
		System.out.println("\n---------------------------\n");

		// COMISSAO
		boolean ValidacaoComissao = false;

		while (ValidacaoComissao != true) {
			try {
				System.out.println("Comissão: ");
				comissao = sc.nextDouble();
				sc.nextLine();
				System.out.println("\n---------------------------\n");
				ValidacaoComissao = true;
			} catch (java.util.InputMismatchException e2) {
				sc.nextLine();
				System.out.println("Comissão inválida!");
				System.out.println("\n---------------------------\n");
			}
		}

		Funcionario funcionario = new Funcionario(cpf, nome, dataNascimenro, email, endereco, telefones, matriculaFunc,
				cargo, salario, dataCadastro, comissao);

		listFuncionario.add(funcionario);
	}

	@Override
	public void atualizar() {
//		listFuncionario.add(obj);

	}

	@Override
	public void deletar() {
		if (listFuncionario.size() < 1) {
			System.out.println("Não existe funcionários cadastrados!");
		} else {
			System.out.println("		Remover Funcionário			\n");

			System.out.println("Digite a matrícula do funcionário: ");
			String mat = sc.nextLine();
			for (int i = 0; i < listFuncionario.size(); i++) {
				System.out.println(listFuncionario.get(i).getMatriculaFunc());
				if (listFuncionario.get(i).getMatriculaFunc().equalsIgnoreCase(mat)) {
					System.out.println(listFuncionario.get(i).toString() + "\n");
					System.out.println("Deseja remover este funcionário? S/N ");
					System.out.println(": ");
					while (true) {
						String remove = sc.nextLine();
						if (remove.toUpperCase().equalsIgnoreCase("S")
								|| remove.toUpperCase().equalsIgnoreCase("Sim")) {
							listFuncionario.remove(i);
							System.out.println("\n Funcionário removido! ");
							System.out.println("\n---------------------------\n");
							break;
						} else {
							System.out.println("Resposta inválida! \n");

						}

					}

				} else {
					System.out.println("\n Funcionario não encontrado");
				}
			}
		}
	}

	@Override
	public List<Funcionario> listarTodos() {
		if (listFuncionario.size() < 1) {
			System.out.println("Não existe funcionários cadastrados!");
		} else {
			List<Funcionario> lista = FuncionarioRepository.getInstance().getListFuncionario();
			for (int i = 0; i < lista.size(); i++) {

				System.out.println(lista.get(i).toString());
			}
		}
		System.out.println("\n---------------------------\n");

		return null;
	}

	public List<Funcionario> getListFuncionario() {
		return listFuncionario;
	}

	public void buscarMatricula() {

	}

	// Metodos private

	private Boolean cpfDuplicado(String cpf) throws ClienteJaCadastradoException {
		Boolean b = false;

		List<Funcionario> f = FuncionarioRepository.getInstance().getListFuncionario();

		for (int i = 0; i < f.size(); i++) {
			if (cpf.equals(f.get(i).getCpfPessoa())) {
				b = true;

			}
		}
		return b;

	}

	private Date inserirDataNascimento() throws ParseException {
		System.out.println("-- INFO DATA NASCIMENTO --");
		System.out.printf("\n---------------------------\n");

		Date dataNasc = new Date();
		SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
		String str;
		boolean pass = true;
		boolean pass1 = true;

		int dia = 0;
		int mes = 0;
		int ano = 0;
		while (pass) {
			while (pass1) {
				try {
					System.out.printf("DIA DE NASCIMENTO: ");
					dia = sc.nextInt();

					System.out.printf("MÊS DE NASCIMENTO: ");
					mes = sc.nextInt();

					System.out.printf("ANO DE NASCIMENTO: ");
					ano = sc.nextInt();
					sc.nextLine();
					pass1 = false;
				} catch (java.util.InputMismatchException e1) {
					System.out.println("Data inválida!");
					sc.nextLine();
				}
			}

			if (ValidacaoIO.validarData(dia, mes, ano) == true) {
				str = dia + "/" + mes + "/" + ano;
				str = str.replaceAll(" ", "");

				dataNasc = formato.parse(str);
				pass = false;

			} else {
				throw new ParseException("Data Incorreta!!", 1);
			}
		}
		return dataNasc;
	}

	private Endereco newEndereco() throws AtributosNaoNulosNaoVaziosException {

		Endereco endereco;

		String estado = "";
		String cidade = "";
		String nomeRua = "";
		String numeroImovel = "";

		boolean estadoV = true;
		boolean cidadeV = true;
		boolean ruaV = true;
		boolean numV = true;

		while (estadoV) {
			System.out.println("Estado: ");
			estado = sc.nextLine();
			if (ValidacaoIO.verificacaoStringNula(estado) == false
					&& ValidacaoIO.verificacaoStringVazia(estado) == false) {
				estadoV = false;
			} else {
				System.out.println("Estádo inválido!");
			}

		}
		System.out.println("\n---------------------------\n");
		while (cidadeV) {
			System.out.println("Cidade: ");
			cidade = sc.nextLine();
			if (ValidacaoIO.verificacaoStringNula(cidade) == false
					&& ValidacaoIO.verificacaoStringVazia(cidade) == false) {
				cidadeV = false;
			} else {
				System.out.println("Cidade inválida!");
			}

		}
		System.out.println("\n---------------------------\n");

		while (ruaV) {
			System.out.println("Rua: ");
			nomeRua = sc.nextLine();
			if (ValidacaoIO.verificacaoStringNula(nomeRua) == false
					&& ValidacaoIO.verificacaoStringVazia(nomeRua) == false) {
				ruaV = false;
			} else {
				System.out.println("Rua inválida!");
			}

		}
		System.out.println("\n---------------------------\n");

		while (numV) {
			System.out.println("Número: ");
			numeroImovel = sc.nextLine();
			if (ValidacaoIO.verificacaoStringNula(numeroImovel) == false
					&& ValidacaoIO.verificacaoStringVazia(numeroImovel) == false) {
				numV = false;
			} else {
				System.out.println("Número inválida!");
			}

		}
		endereco = new Endereco(numeroImovel, nomeRua, cidade, estado);

		return endereco;
	}

	private Telefone newTelefone() throws AtributosNaoNulosNaoVaziosException {
		boolean validacaoNumero = false;
		String numTelefone = "";
		while (validacaoNumero != true) {

			System.out.println("Número: ");
			numTelefone = sc.nextLine();
			if (ValidacaoIO.verificacaoStringNula(numTelefone) == false
					&& ValidacaoIO.verificacaoStringVazia(numTelefone) == false) {

				validacaoNumero = true;
			} else {
				System.out.println("Telefone  inválido");
			}
		}
		Telefone telefone = new Telefone(numTelefone);
		return telefone;
	}

	private Date newDataCadastro() throws ParseException {
		Date dataInscricao = new Date();
		DateFormat dF = new SimpleDateFormat("dd/MM/yyyy");

		String resp = dF.format(dataInscricao);
		dataInscricao = dF.parse(resp);

		return dataInscricao;
	}

	private Boolean matriculaDuplicado(String cpf) throws ClienteJaCadastradoException {
		Boolean b = false;

		List<Funcionario> f = FuncionarioRepository.getInstance().getListFuncionario();

		for (int i = 0; i < f.size(); i++) {
			if (cpf.equals(f.get(i).getMatriculaFunc())) {
				b = true;
			}
		}
		return b;

	}
}
