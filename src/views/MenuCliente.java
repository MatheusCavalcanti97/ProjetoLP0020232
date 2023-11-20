package views;

import java.util.InputMismatchException;
import java.util.Scanner;

import exceptionsClass.ClienteJaCadastradoException;
import exceptionsClass.CpfException;
import exceptionsClass.DataNascimentoException;
import exceptionsClass.ListaVaziaException;
import repository.ClienteRepository;

public class MenuCliente {
	
	public static void menuCliente() {

		Integer opcaoMenu2 = null;
		boolean varFlagMenu = true;

		while (varFlagMenu) {

			try {
				Scanner ler = new Scanner(System.in);
				System.out.printf("\n-------------------------------------------------------\n");
				System.out.printf("Informe uma Opção." + "\n1. Inserir Info Pessoais." + "\n2. Atualizar Info Cliente."
						+ "\n3. Deletar Cliente." + "\n4. Listar Cliente." + "\n0. Sair." + "-> ");

				opcaoMenu2 = ler.nextInt();
				System.out.printf("\n-------------------------------------------------------\n");
			} catch (InputMismatchException e) {
				System.out.printf("\n-------------------------------------------------------\n");
				System.out.printf("\nCaracter Inserido Incorretamente.\nTente Novamente.");
				System.out.printf("\n-------------------------------------------------------\n");
				continue;
			}

			if (opcaoMenu2 == 0) {
				System.out.printf("\n-------------------------------------------------------\n");
				System.out.printf("\nRETORNANDO PRO MENU ANTERIOR...\n");
				System.out.printf("\n-------------------------------------------------------\n");
				varFlagMenu = false;
			} else if (opcaoMenu2 == 1) {
//				try {
//
//					ClienteRepository.inserirCliente();
//
//				} catch (CpfException ex1) {
//					System.out.printf("\n-------------------------------------------------------\n");
//					System.out.printf(ex1.getMessage());
//					System.out.printf("\n-------------------------------------------------------\n");
//				} catch (DataNascimentoException ex2) {
//					System.out.printf("\n-------------------------------------------------------\n");
//					System.out.printf(ex2.getMessage());
//					System.out.printf("\n-------------------------------------------------------\n");
//				}

			} else if (opcaoMenu2 == 2) {

//				try {
//					ClienteRepository.atualizar();
//				} catch (ListaVaziaException ex1) {
//					System.out.printf("\n-------------------------------------------------------\n");
//					System.out.printf(ex1.getMessage());
//					System.out.printf("\n-------------------------------------------------------\n");
//				} catch (ClienteJaCadastradoException ex2) {
//					System.out.printf("\n-------------------------------------------------------\n");
//					System.out.printf(ex2.getMessage());
//					System.out.printf("\n-------------------------------------------------------\n");
//				} catch (Exception ex3) {
//					System.out.printf("\n-------------------------------------------------------\n");
//					System.out.printf(ex3.getMessage());
//					System.out.printf("\n-------------------------------------------------------\n");
//				}

			} else if (opcaoMenu2 == 3) {
//				try {
//					ClienteRepository.deletarCliente();;
//				} catch (Exception ex1) {
//					System.out.printf("\n-------------------------------------------------------\n");
//					System.out.printf(ex1.getMessage());
//					System.out.printf("\n-------------------------------------------------------\n");
//				}
			} else if (opcaoMenu2 == 4) {

//				try {
//					ClienteRepository.listarTodosClientes();;
//				} catch (ListaVaziaException e) {
//					System.out.printf("\n-------------------------------------------------------\n");
//					System.out.printf(e.getMessage());
//					System.out.printf("\n-------------------------------------------------------\n");
//				}

			} else {
				System.out.printf("\n-------------------------------------------------------");
				System.out.printf("\nInsira uma Opção Correta para o Menu..\n");
				System.out.printf("\n-------------------------------------------------------\n");
			}
		}
	}

}
