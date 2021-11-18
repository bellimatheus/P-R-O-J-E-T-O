package com.vilebe.aluguelcarros.domains;

import java.util.Objects;

public class Login {
	private int idCliente;
	private String email;
	private String senha;
	
	public Login() {}
	
	public Login(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public Login(String email, String senha) {
		this.email = email;
		this.senha = senha;
	}
	
	public Login(int idCliente, String email, String senha) {
		this.idCliente = idCliente;
		this.email = email;
		this.senha = senha;
	}

	public int getidCliente() {
		return idCliente;
	}
	
	public void setidCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public String getEmail() {
		return email;
	}
	
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idCliente);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Login other = (Login) obj;
		return idCliente == other.idCliente;
	}

	@Override
	public String toString() {
		return email + "\t" + senha + "\t\n";
	}
}

