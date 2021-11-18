package com.vilebe.aluguelcarros.process;

import java.sql.SQLException;

import com.vilebe.aluguelcarros.dao.LoginDAO;
import com.vilebe.aluguelcarros.domains.Cliente;
import com.vilebe.aluguelcarros.domains.Login;



public class LoginProcess {
	public static LoginDAO  ld = new LoginDAO();
	
	public static Cliente verLogin(Login login) {
		try {
			return (ld.mkLogin(login));
		}catch(SQLException e) {
			return null;
		}
	}
}
