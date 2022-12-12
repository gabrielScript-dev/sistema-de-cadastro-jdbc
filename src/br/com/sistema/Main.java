package br.com.sistema;

import br.com.sistema.dao.ContatoDao;
import br.com.sistema.modelo.Contato;

public class Main {

	public static void main(String[] args) {
		
		ContatoDao dao = new ContatoDao();
		
		Contato contato = new Contato();
		contato.setNome("Gabriel");
		contato.setEmail("gabriel.script@gmail.com");
		contato.setEndereco("R. Paes Cabral");
		
		dao.adicionar(contato);

	}

}
