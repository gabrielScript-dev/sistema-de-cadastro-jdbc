package br.com.sistema;

import br.com.sistema.dao.ContatoDao;
import br.com.sistema.modelo.Contato;

public class Main {

	public static void main(String[] args) {
		
		ContatoDao dao = new ContatoDao();
		
		Contato c1 = new Contato();
		c1.setNome("Gabriel");
		c1.setEmail("gabriel.script@gmail.com");
		c1.setEndereco("R. Paes Cabral");
		
		Contato c2 = new Contato();
		c2.setNome("Caio");
		c2.setEmail("caio.dev@gmail.com");
		c2.setEndereco("R. NeverLand");

		dao.adicionar(c1);
		dao.adicionar(c2);
		
		
		for(Contato contato : dao.getLista()) {
			System.out.println("ID: " + contato.getId());
			System.out.println("NOME: " + contato.getNome());
			System.out.println("---\n");
		}
		
		dao.remover(dao.getLista().get(1));

		for(Contato contato : dao.getLista()) {
			System.out.println("ID: " + contato.getId());
			System.out.println("NOME: " + contato.getNome());
			System.out.println("---\n");
		}
	}
}
