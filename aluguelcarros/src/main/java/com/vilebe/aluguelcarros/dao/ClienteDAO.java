package com.vilebe.aluguelcarros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.vilebe.aluguelcarros.domains.Cliente;
import com.vilebe.aluguelcarros.domains.Login;

public class ClienteDAO {
	private static Connection con;
	private static PreparedStatement ps;

	private static Cliente cliente;
	private static ArrayList<Cliente> clientes;

	public ArrayList<Cliente> readAll() throws SQLException {
		clientes = new ArrayList<>();

		String query = "select cliente.idCliente, nome, idade, cnh, cpf, telefone, l.email, l.senha from cliente inner join login as l on (cliente.idCliente = l.idCliente);";

		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Login l = new Login(rs.getInt("idCliente"), rs.getString("email"), rs.getString("senha"));
			cliente = new Cliente(rs.getInt("idCliente"), rs.getString("nome"), rs.getInt("idade"), rs.getString("cnh"),
					rs.getString("cpf"), rs.getString("telefone"), l);
			clientes.add(cliente);
		}
		con.close();
		return clientes;
	}

	public void cadastrarCliente(Cliente cliente, Login login) throws SQLException {
		String queryCliente = "insert into cliente(nome, idade, cnh, cpf, telefone) values (?, ?, ?, ?, ?);";
		String queryLogin = "insert into login(idCliente, email, senha) values ((SELECT MAX(idCliente) FROM cliente), ?, ?)";

		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(queryCliente);
		ps.setString(1, cliente.getNome());
		ps.setInt(2, cliente.getIdade());
		ps.setString(3, cliente.getCnh());
		ps.setString(4, cliente.getCpf());
		ps.setString(5, cliente.getTelefone());
		ps.execute();

		ps = con.prepareStatement(queryLogin);
		ps.setString(1, login.getEmail());
		ps.setString(2, login.getSenha());
		ps.execute();

		con.close();
	}

	public void delCliente(String id) throws SQLException {

		String query = "delete from login where idCliente = " + id + "; ";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ps.execute();
		con.close();
	}
}
