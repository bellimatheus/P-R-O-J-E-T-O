package com.vilebe.aluguelcarros.process;

import java.sql.SQLException;
import java.util.ArrayList;

import com.vilebe.aluguelcarros.dao.ClienteDAO;
import com.vilebe.aluguelcarros.domains.Cliente;
import com.vilebe.aluguelcarros.domains.Login;

public class ClienteProcess {
	public static ArrayList<Cliente> clientes = new ArrayList<>();
	public static ClienteDAO cd = new ClienteDAO();
	
	public static void abrir() {
		try {
			clientes = cd.readAll();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	
	public static void criar(Cliente cliente, Login login) {
		try {
			cd.cadastrarCliente(cliente, login);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void deletarCliente(String id) throws SQLException {
		cd.delCliente(id);
	}
}