package views;

import java.util.InputMismatchException;
import java.util.Scanner;

import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.EstoqueUnicoException;
import exceptionsClass.ListaVaziaException;
import repository.EstoqueRepository;

public class MenuEstoque {

	public static void menuEstoque() {

		Integer opcaoMenu2 = null;
		boolean varFlagMenu = true;

		while (varFlagMenu) {

			try {
				Scanner ler = new Scanner(System.in);
				System.out.printf("\n-------------------------------------------------------\n");
				System.out.printf("Informe uma Opção." + "\n1. Inserir Estoque." + "\n2. Atualizar Info Estoque."
						+ "\n3. Deletar Estoque." + "\n4. Listar Todos Estoques." + "\n0. Sair." + "-> ");

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
//					EstoqueRepository.inserirEstoque();
//				} catch (AtributosNaoNulosNaoVaziosException e) {
//					System.out.println("\n-------------------------------------------------------\n");
//					System.out.println(e.getMessage());
//				} catch (EstoqueUnicoException ex2) {
//					System.out.println("\n-------------------------------------------------------\n");
//					System.out.println(ex2.getMessage());
//				}
			} else if (opcaoMenu2 == 2) {
//				try {
//					EstoqueRepository.atualizarEstoque();
//				} catch (ListaVaziaException ex1) {
//					System.out.println("\n-------------------------------------------------------\n");
//					System.out.println(ex1.getMessage());
//				} catch (EstoqueUnicoException ex2) {
//					System.out.println("\n-------------------------------------------------------\n");
//					System.out.println(ex2.getMessage());
//				}
			} else if (opcaoMenu2 == 3) {
//				try {
//					EstoqueRepository.deletarEstoque();
//				} catch (EstoqueUnicoException ex1) {
//					System.out.println("\n-------------------------------------------------------\n");
//					System.out.println(ex1.getMessage());
//				} catch (ListaVaziaException ex2) {
//					System.out.println("\n-------------------------------------------------------\n");
//					System.out.println(ex2.getMessage());
//				}
			} else if (opcaoMenu2 == 4) {
//				try {
//					EstoqueRepository.listaEstoqueAll();
//				} catch (ListaVaziaException ex1) {
//					System.out.println("\n-------------------------------------------------------\n");
//					System.out.println(ex1.getMessage());
//				}
			} else {
				System.out.printf("\n-------------------------------------------------------");
				System.out.printf("\nInsira uma Opção Correta para o Menu Estoque...\n");
				System.out.printf("\n-------------------------------------------------------\n");
			}
		}
	}

}
