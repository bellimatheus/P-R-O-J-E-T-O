package com.vilebe.aluguelcarros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import java.sql.PreparedStatement;

import com.vilebe.aluguelcarros.domains.Veiculo;

public class VeiculoDAO {

	private Connection con;
	private PreparedStatement ps;

	private Veiculo veiculo;
	private ArrayList<Veiculo> veiculos;

	public ArrayList<Veiculo> readAll() throws SQLException {
		veiculos = new ArrayList<>();
		String query = "select * from Veiculo";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			veiculo = new Veiculo(rs.getInt("idVeiculo"), rs.getString("tipo"), rs.getString("modelo"),
					rs.getString("marca"), rs.getString("placa"), rs.getString("espf"), rs.getString("img"));
			veiculos.add(veiculo);
		}
		con.close();
		return veiculos;

	}

	public void addVeiculoSQL(Veiculo veiculo) throws SQLException {
		String query = "insert into veiculo (tipo,modelo,marca,placa,espf,img) values (?,?,?,?,?,?)";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ps.setString(1, veiculo.getTipo());
		ps.setString(2, veiculo.getModelo());
		ps.setString(3, veiculo.getMarca());
		ps.setString(4, veiculo.getPlaca());
		ps.setString(5, veiculo.getEspf());
		ps.setString(6, veiculo.getImg());
	
		ps.execute();
		con.close();
	}

	public void delVeiculoSQL(String id) throws SQLException {
		String query = "delete from veiculo where idVeiculo = " + id;
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ps.execute();
		con.close();
	}

	public void updtVeiculoSQL(String id, Veiculo veiculo) throws SQLException {
		String query = "update veiculo set ";
		if (veiculo.getTipo() != null) {
			query += "tipo = '" + veiculo.getTipo() + "', ";
		}
		if (veiculo.getModelo() != null) {
			query += "modelo = '" + veiculo.getModelo() + "', ";
		}
		if (veiculo.getMarca() != null) {
			query += "marca = '" + veiculo.getMarca() + "', ";
		}
		if (veiculo.getPlaca() != null) {
			query += "placa =  '" + veiculo.getPlaca() + "', ";
		}
		if (veiculo.getEspf() != null) {
			query += "espf = '" + veiculo.getEspf() + "', ";
		}
		if (veiculo.getImg() != null) {
			query += "img = '" + veiculo.getImg() + "', ";
		}

		if (query.endsWith(", ")) {
			query = query.substring(0, query.length() - 1);
			query = query.substring(0, query.length() - 1);
			query += " ";
		}

		query += " where idVeiculo = " + id + ";";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ps.execute();
		con.close();
	}
}
