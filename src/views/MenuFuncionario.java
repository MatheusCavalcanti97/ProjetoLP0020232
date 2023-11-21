package views;

import java.util.Scanner;

import repository.FuncionarioRepository;

public class MenuFuncionario {

	Scanner sc = new Scanner(System.in);

	private static MenuFuncionario instance;

	public static synchronized MenuFuncionario getInstance() {

		if (instance == null) {
			instance = new MenuFuncionario();
		}
		return instance;

	}

	public void opcoesFuncionario() {

		int opcao = 0;
		while (opcao != 5) {

			System.out.println("		Opções Funcionário		");
			System.out.println("1. Cadastrar ");
			System.out.println("2. Remover ");
			System.out.println("3. Listar ");
			System.out.println("4. Buscar por Matrícula");
			System.out.println("5. Voltar");

			opcao = sc.nextInt();
			
			if (opcao == 1) {
				FuncionarioRepository.getInstance().inserir();;
			}
			else if (opcao == 2) {
				FuncionarioRepository.getInstance().deletar();
			}
			else if (opcao == 3) {
				FuncionarioRepository.getInstance().listarTodos();
			}
			else if (opcao == 4) {
				FuncionarioRepository.getInstance().buscarMatricula();
			}
			
			
		}

	}
}
