package com.vilebe.aluguelcarros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;



import com.vilebe.aluguelcarros.domains.Sede;

public class SedeDAO {

	private Connection con;
	private PreparedStatement ps;

	private Sede sede;
	private ArrayList<Sede> sedes;

	public ArrayList<Sede> readAll() throws SQLException {
		sedes = new ArrayList<>();
		String query = "select * from Sede";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ResultSet rs = ps.executeQuery();
		while (rs.next()) {
			sede = new Sede(rs.getInt("idSede"), rs.getString("nome"), rs.getString("estado"));
			sedes.add(sede);
		}
		con.close();
		return sedes;

	}

	public void addSedeSQL(Sede sede) throws SQLException {
		String query = "insert into sede (nome,estado) values (?,?)";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ps.setString(1, sede.getNome());
		ps.setString(2, sede.getestado());

	
		ps.execute();
		con.close();
	}

	public void delSedeSQL(String id) throws SQLException {
		String query = "delete from sede where idSede = " + id;
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ps.execute();
		con.close();
	}

	public void updtSedeSQL(String id, Sede sede) throws SQLException {
		String query = "update sede set ";
		if (sede.getNome() != null) {
			query += "nome = '" + sede.getNome() + "', ";
		}
		if (sede.getestado() != null) {
			query += "estado = '" + sede.getestado() + "', ";
		}

		if (query.endsWith(", ")) {
			query = query.substring(0, query.length() - 1);
			query = query.substring(0, query.length() - 1);
			query += " ";
		}

		query += " where idSede = " + id + ";";
		con = ConnectionDB.getConnection();
		ps = con.prepareStatement(query);
		ps.execute();
		con.close();
	}
}
