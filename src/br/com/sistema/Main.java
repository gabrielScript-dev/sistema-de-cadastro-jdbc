package br.com.sistema;

import java.util.List;
import java.util.Scanner;

import br.com.sistema.dao.ContatoDao;
import br.com.sistema.modelo.Contato;

public class Main {

	static ContatoDao dao = new ContatoDao();
	static Scanner entrada = new Scanner(System.in);
	
	static void cadastrar() {
		Contato contato = new Contato();
		System.out.print("Informe o nome: ");
		contato.setNome(entrada.nextLine());
		System.out.print("Informe o email: ");
		contato.setEmail(entrada.nextLine());
		System.out.print("Informe seu endereço: ");
		contato.setEndereco(entrada.nextLine());
		
		dao.adicionar(contato);
		
		System.out.println("CONTATO CADASTRADO COM SUCESSO!\n---\n\n");
	}
	
	static void remover() {
		System.out.print("Informe o ID do contato: ");
		Long id = entrada.nextLong();
		dao.remover(id);
		
		System.out.println("CONTATO REMOVIDO COM SUCESSO!\n---\n\n");
	}
	
	static void listarContatos() {
		List<Contato> lista = dao.getLista();
		
		System.out.println("LISTA: \n");
		
		for(Contato c : lista) {
			System.out.println("Nome: " + c.getNome());
			System.out.println("Email: " + c.getEmail());
			System.out.println("Endereço: " + c.getEndereco());
			System.out.println("---");
		}
	}
	
	static void exibirMenu() {
		System.out.println("\n--- SISTEMA DE CADASTRO DE CONTATOS ---\nMENU:\n");
		System.out.println("1 - CADASTRAR CONTATO");
		System.out.println("2 - CONTATOS CADASTRADOS");
		System.out.println("3 - REMOVER CONTATO");
		System.out.println("4 - ATUALIZAR CONTATO");
		System.out.println("5 - SAIR\n\n");
	}
	
	public static void main(String[] args) {
		
		boolean estado = true;
		
		while(estado) {
			
			exibirMenu();
			
			System.out.print("ESCOLHA UMA OPÇÃO: ");
			int opc = entrada.nextInt();
			entrada.nextLine();
			
			switch(opc) {
				case 1:
					cadastrar();
					break;
				case 2:
					listarContatos();
					break;
				case 3:
					remover();
					break;
				case 4:
					break;
				case 5:
					estado = false;
					break;
				default:
					System.out.println("OPÇÃO INVÁLIDA!");
			}
		}
		
		entrada.close();
	}
}
