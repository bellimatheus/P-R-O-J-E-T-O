package com.vilebe.aluguelcarros.process;

import java.sql.SQLException;
import java.util.ArrayList;

import com.vilebe.aluguelcarros.dao.VeiculoDAO;
import com.vilebe.aluguelcarros.domains.Veiculo;

public class VeiculoProcess {
	public static ArrayList<Veiculo> veiculos = new ArrayList<>();
	public static VeiculoDAO vd = new VeiculoDAO();

	public static void abrir() {
		try {
			veiculos = vd.readAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void addVeiculo(Veiculo veiculo) {
		try {
			vd.addVeiculoSQL(veiculo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void updtVeiculo(String idVeiculo, Veiculo veiculo) {
		try {
			vd.updtVeiculoSQL(idVeiculo, veiculo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void delVeiculo(String id) {
		try {
			vd.delVeiculoSQL(id);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
