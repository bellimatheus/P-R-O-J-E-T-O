package com.vilebe.aluguelcarros.process;

import java.sql.SQLException;
import java.util.ArrayList;

import com.vilebe.aluguelcarros.dao.LocacaoDAO;
import com.vilebe.aluguelcarros.domains.Locacao;

public class LocacaoProcess {
	public static ArrayList<Locacao> locacoes = new ArrayList<Locacao>();
	public static LocacaoDAO ld = new LocacaoDAO();
	
	public static void abrir() {
		try {
			locacoes = ld.readAll();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	public static void criar(Locacao loc) {
		try {
			ld.criar(loc);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
}

