package com.vilebe.aluguelcarros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.vilebe.aluguelcarros.domains.Cliente;
import com.vilebe.aluguelcarros.domains.Locacao;
import com.vilebe.aluguelcarros.domains.Login;
import com.vilebe.aluguelcarros.domains.Veiculo;

public class LocacaoDAO {

	private static Connection con;
	private static PreparedStatement ps;

	private static Locacao locacao;
	private static Veiculo veiculo;
	private static Cliente cliente;
	public static ArrayList<Locacao> locacoes;

	public ArrayList<Locacao> readAll() throws SQLException {
		locacoes = new ArrayList<>();

		String query = "select * from Locacao" 
		+ "from locacao  inner join Cliente on (Cliente.idCliente = Locacao.idCliente)"
		+ "inner join Veiculo on (Locacao.idVeiculo = Veiculo.idVeiculo)";

		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			Veiculo v = new Veiculo(
					rs.getInt("idVeiculo"),
					rs.getString("tipo"),
					rs.getString("modelo"),
					rs.getString("marca")
					);
			Cliente c = new Cliente(
					rs.getInt("idCliente"),
					rs.getString("nome")
					);
		
			locacao = new Locacao(
					rs.getInt("idLoc"),
					c,
					v,
					rs.getString("DataRetirada"),
					rs.getString("DataDevolucao"),
					rs.getString("LocalRetirada"),
					rs.getString("LocalDevolucao")
					);
			locacoes.add(locacao);
		}
	
		con.close();
		return locacoes;
	}
	public void criar(Locacao loc) throws SQLException{
		System.out.println(loc);
		String query = "select * from Locacao "
				+ "inner join cliente on (cliente.idCliente = locacao.idCliente) "
				+"inner join veiculo on (veiculo.idVeiculo = locacao.idVeiculo)"
				+ "where nome = '" + cliente.getNome() + "', tipo  = '" + veiculo.getTipo() + "'";
		System.out.println(query);
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		

	}
		
}