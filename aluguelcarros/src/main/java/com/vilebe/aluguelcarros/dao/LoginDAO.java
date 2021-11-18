package com.vilebe.aluguelcarros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.vilebe.aluguelcarros.domains.Cliente;
import com.vilebe.aluguelcarros.domains.Login;

public class LoginDAO {

	private static Connection con;
	private static PreparedStatement ps;

	private static Login login;
	private static Cliente cliente;

	public Cliente mkLogin(Login L) throws SQLException {
		System.out.println(L);
		String query = "select * from login "
				+ "inner join cliente on (cliente.idCliente = login.idCliente) "
				+ "where email = '" + L.getEmail() + "' and senha = '" + L.getSenha() + "'";
		System.out.println(query);
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		
		if(rs.next()) {
			login = new Login(
					rs.getInt("idCliente"), 
					rs.getString("email"), 
					rs.getString("senha"));
			cliente = new Cliente(
					rs.getInt("idCliente"),
					rs.getString("nome"),
					rs.getInt("idade"),
					rs.getString("cnh"),
					rs.getString("cpf"),
					rs.getString("telefone"),
					
					login
					);
			
			return cliente;
		}else {
			return null;
		}
		
	}
}