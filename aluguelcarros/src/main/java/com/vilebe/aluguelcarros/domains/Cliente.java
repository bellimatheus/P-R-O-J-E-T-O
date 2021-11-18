package com.vilebe.aluguelcarros.domains;

import java.text.ParseException;
import java.util.Objects;

public class Cliente {
	private int idCliente;
	private String nome;
	private int idade;
	private String cnh;
	private String cpf;
	private String telefone;
	private Login login;
	
	
	public Cliente() {}
	
	public Cliente(int idCliente) {
		this.idCliente = idCliente;
	}
	public Cliente(String nome, int idade, String cnh, String cpf, String telefone,
			Login login) {
		this.nome = nome;
		this.idade = idade;
		this.cnh = cnh;
		this.cpf = cpf;
		this.telefone = telefone;
		this.login = login;
	}
	
	public Cliente(String nome, String idade, String cnh, String cpf, String telefone,
			Login login) throws ParseException {
		this.nome = nome;
		this.idade = Integer.parseInt(idade);
		this.cnh = cnh;
		this.cpf = cpf;
		this.telefone = telefone;
		this.login = login;
	}
	
	public Cliente(int idCliente, String nome, int idade, String cnh, String cpf, String telefone,
			Login login) {
		this.idCliente = idCliente;
		this.nome = nome;
		this.idade = idade;
		this.cnh = cnh;
		this.cpf = cpf;
		this.telefone = telefone;
		this.login = login;
	}
	
	public Cliente(int idCliente, String nome) {
		
		this.idCliente = idCliente;
		this.nome = nome;
	}

	public int getIdCliente() {
		return idCliente;
	}
	
	public void setIdCliente(int idCliente) {
		this.idCliente = idCliente;
	}
	
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public int getIdade() {
		return idade;
	}
	
	public void setIdade(int idade) {
		this.idade = idade;
	}
	
	public String getCnh() {
		return cnh;
	}
	
	public void setCnh(String cnh) {
		this.cnh = cnh;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Login getLogin() {
		return login;
	}
	
	public void setLogin(Login login) {
		this.login = login;
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
		Cliente other = (Cliente) obj;
		return idCliente == other.idCliente;
	}

	@Override
	public String toString() {
		return idCliente + "\t" + nome + "\t" + idade
				+ "\t" + cnh + "\t" + cpf + "\t" + telefone + "\t" + login + "\t\n";
	}
}