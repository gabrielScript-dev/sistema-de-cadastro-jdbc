package br.com.sistema.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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
	
	public void remover(Contato contato) {
		String sql = "delete from contatos where id=?";
		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			stmt.setLong(1, contato.getId());
			stmt.execute();
			stmt.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void atualizar(Contato contato) {
		String sql = "update contatos set nome=?, email=?, endereco=?, where id=?";
		try {
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			stmt.setString(1, contato.getNome());
			stmt.setString(2, contato.getEmail());
			stmt.setString(3, contato.getEndereco());
			stmt.setLong(4, contato.getId());
			
			stmt.execute();
			stmt.close();
		} catch(SQLException e) {
			throw new RuntimeException(e);
		}
				
	}
	
	public List<Contato> getLista() {
		
		List<Contato> lista = new ArrayList<Contato>();
		
		try {
			PreparedStatement stmt = this.conn.prepareStatement("select * from contatos");
			ResultSet result = stmt.executeQuery();
			
			while(result.next()) {
				Contato contato = new Contato();
				contato.setId(result.getLong("id"));
				contato.setNome(result.getString("nome"));
				contato.setEmail(result.getString("email"));
				contato.setEndereco(result.getString("endereco"));
				
				lista.add(contato);
			}
			
			result.close();
			stmt.close();
			
			return lista;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}