package br.com.sistema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import br.com.sistema.jdbc.ConnectionFactory;
import br.com.sistema.modelo.Contato;

public class ContatoDao {

	private Connection conn;
	
	public ContatoDao() {
		this.conn = new ConnectionFactory().getConnection();
	}
	
	public void adicionar(Contato contato) {
		
		String sql = "insert into contatos " +
		"(nome, email, endereco)" + "values (?,?,?)";
		
		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			
			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}