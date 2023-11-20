package repository;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import entidades.Estoque;
import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.EstoqueUnicoException;
import exceptionsClass.ListaVaziaException;
import util.ValidacaoIO;

public class EstoqueRepository {
	private static Estoque e;

//	public static Estoque getInstance() {
//		if (e == null) {
//			e = new Estoque();
//		}
//		return e;
//	}
//
//	public static void inserirEstoque()
//			throws AtributosNaoNulosNaoVaziosException, NullPointerException, EstoqueUnicoException {
//		Scanner ler = new Scanner(System.in);
//
//		Estoque er = EstoqueRepository.getInstance();
//		Estoque estoque = new Estoque();
//		String descricaoEstoque;
//		int quantidadeProduto;
//		Date dataEntradaProd = new Date();
//		Date dataSaída = new Date();
//		Boolean flagMenu = true;
//
//		System.out.println("\n-------------------------------------------------------");
//		System.out.println("-- INSIRA AS INFORMAÇÕES PESSOAIS REFERENTE AO CLIENTE --");
//		System.out.println("-------------------------------------------------------");
//
//		while (flagMenu) {
//
//			try {
//
//				System.out.printf("\nInforme o Nome do Estoque: ");
//				descricaoEstoque = ler.nextLine();
//
//				if (ValidacaoIO.verificacaoStringVazia(descricaoEstoque) == false
//						&& ValidacaoIO.verificacaoStringNula(descricaoEstoque) == false) {
//
//					System.out.println("\n-------------------------------------------------------");
//
//					quantidadeProduto = 0;
//					dataEntradaProd = null;
//					dataSaída = null;
//					estoque = new Estoque(descricaoEstoque, quantidadeProduto, dataEntradaProd, dataSaída);
//
//					er.inserir(estoque);
//
//				} else {
//					flagMenu = true;
//					throw new AtributosNaoNulosNaoVaziosException("O PREENCHIMENTO DO NOME DO ESTOQUE É OBRIGATÓRIO.");
//				}
//
//				System.out.println("\n-------------------------------------------------------");
//				System.out.printf("\nESTOQUE INSERIDO");
//				System.out.println("\n-------------------------------------------------------");
//				System.out.println(estoque.toString());
//
//				estoque = null;
//				flagMenu = false;
//			} catch (NullPointerException ex1) {
//				System.out.println(ex1.getMessage());
//			}
//		}
//	}
//
//	public static void atualizarEstoque() throws ListaVaziaException, EstoqueUnicoException {
//		Scanner ler = new Scanner(System.in);
//
//		Boolean varFlag = false;
//		Estoque e1 = null;
//		Estoque e2 = EstoqueRepository.getInstance();
//		List<Estoque> eList = e2.listarTodos();
//		String buscarEstoqueNome = "";
//
//		System.out.printf("\n-------------------------------------------------------\n");
//		System.out.printf("\n Estoque Cadastrados \n");
//		for (int i = 0; i < eList.size(); i++) {
//			System.out.println((i + 1) + "º - " + eList.get(i).getDescricaoEstoque());
//		}
//
//		System.out.printf("\n-------------------------------------------------------\n");
//		System.out.printf("Digite o Nome do Estoque que\ndeseja Atualizar o Nome/Descrição: ");
//		buscarEstoqueNome = ler.nextLine();
//
//		for (int i = 0; i < eList.size(); i++) {
//			if (eList.get(i).getDescricaoEstoque().toUpperCase().equalsIgnoreCase(buscarEstoqueNome.toUpperCase())) {
//				e1 = eList.get(i);
//				varFlag = true;
//			}
//		}
//
//		if (varFlag == true) {
//			buscarEstoqueNome = null;
//			Estoque est = null;
//			System.out.printf("\n-------------------------------------------------------\n");
//			System.out.println("Informe o Novo Nome do Estoque: ");
//			buscarEstoqueNome = ler.nextLine();
//
//			e1.setDescricaoEstoque(buscarEstoqueNome);
//			e1.atualizar(e1);
//			System.out.printf("\n-------------------------------------------------------\n");
//			System.out.printf("\nNOME DO ESTOQUE ATUALIZADO COM SUCESSO...\n");
//			System.out.printf("\n-------------------------------------------------------\n");
//			System.out.println(e1.toString());
//		} else {
//			throw new EstoqueUnicoException("Nenhum Estoque Cadastrado com esse nome\nfoi encontrado.");
//		}
//
//	}
//
//	public static void deletarEstoque() throws EstoqueUnicoException, ListaVaziaException {
//		Scanner ler = new Scanner(System.in);
//
//		Boolean varFlag = false;
//		Estoque e1 = null;
//		Estoque e2 = EstoqueRepository.getInstance();
//		List<Estoque> eList = e2.listarTodos();
//		String buscarEstoqueNome = "";
//
//		System.out.printf("\n-------------------------------------------------------\n");
//		System.out.printf("\nEstoque Cadastrados\n");
//		System.out.printf("\n-------------------------------------------------------\n");
//		for (int i = 0; i < eList.size(); i++) {
//			System.out.println((i + 1) + "º - " + eList.get(i).getDescricaoEstoque());
//		}
//
//		System.out.printf("\n-------------------------------------------------------\n");
//		System.out.printf("Digite o Nome do Estoque que\ndeseja Deletar: ");
//		buscarEstoqueNome = ler.nextLine();
//
//		for (int i = 0; i < eList.size(); i++) {
//			if (eList.get(i).getDescricaoEstoque().toUpperCase().equalsIgnoreCase(buscarEstoqueNome.toUpperCase())) {
//				e1 = eList.get(i);
//				varFlag = true;
//			}
//		}
//
//		if (varFlag == true) {
//			System.out.printf("\n-------------------------------------------------------\n");
//			e2.deletar(e1);
//			System.out.printf("\n-------------------------------------------------------\n");
//			System.out.printf("\nNOME DO ESTOQUE DELETADO COM SUCESSO...\n");
//			System.out.printf("\n-------------------------------------------------------\n");
//		} else {
//			throw new EstoqueUnicoException("Nenhum Estoque Cadastrado com esse nome\nfoi encontrado.");
//		}
//	}
//
//	public static void listaEstoqueAll() throws ListaVaziaException {
//		Estoque er = EstoqueRepository.getInstance();
//		List<Estoque> eList = er.listarTodos();
//
//		System.out.printf("\n-------------------------------------------------------");
//		System.out.printf("\n ESTOQUES CADASTRADOS");
//		System.out.println("\n-------------------------------------------------------");
//		for (int i = 0; i < eList.size(); i++) {
//			System.out.println((i+1) + "º - " + eList.get(i).toString());
//			System.out.println("\n-------------------------------------------------------");
//		}
//
//	}

}
