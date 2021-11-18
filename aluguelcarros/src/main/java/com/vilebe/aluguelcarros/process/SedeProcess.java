package com.vilebe.aluguelcarros.process;

import java.sql.SQLException;
import java.util.ArrayList;

import com.vilebe.aluguelcarros.dao.SedeDAO;
import com.vilebe.aluguelcarros.domains.Sede;

public class SedeProcess {
	public static ArrayList<Sede>sedes = new ArrayList<>();
	public static SedeDAO ad = new SedeDAO();
	
	public static void abrir() {
		try {
			sedes = ad.readAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void addSede(Sede sede) {
		try {
			ad.addSedeSQL(sede);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void delSede(String id) {
		try {
			ad.delSedeSQL(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void updtSede(String id, Sede sede ) {
		try {
			ad.updtSedeSQL(id, sede);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
