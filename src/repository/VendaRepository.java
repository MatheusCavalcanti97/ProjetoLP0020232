package repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.xml.crypto.Data;

import entidades.Cliente;
import entidades.Funcionario;
import entidades.Produto;
import entidades.Venda;
import exceptionsClass.AtributosNaoNulosNaoVaziosException;
import exceptionsClass.ListaVaziaException;
import util.ValidacaoIO;

public class VendaRepository {

	Scanner sc = new Scanner(System.in);

	private static VendaRepository instance;
	private List<Venda> listVendas = new ArrayList<>();

	public static synchronized VendaRepository getInstance() {

		if (instance == null) {
			instance = new VendaRepository();
		}
		return instance;
	}

	public void vender() throws ListaVaziaException, AtributosNaoNulosNaoVaziosException {

		
		
		
		}



	public void listarTodos() {
		if (this.listVendas.size() == 0) {
			System.out.println("Nemhuma Venda cadastrada!\n");

		} else {
			for (int i = 0; i < listVendas.size(); i++) {
				System.out.println(listVendas.get(i).toString() + "\n\n");
			}
		}
	}

}
