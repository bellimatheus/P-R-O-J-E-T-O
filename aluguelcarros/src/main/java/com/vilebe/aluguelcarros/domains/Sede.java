package com.vilebe.aluguelcarros.domains;

import java.util.Map;
import java.util.Objects;

public class Sede {
	private int idSede;
	private String nome;
	private String estado;

	public Sede(int idSede, String nome, String estado) {

		this.idSede = idSede;
		this.nome = nome;
		this.estado = estado;
	}

	public Sede(String idSede, String nome, String estado) {

		this.idSede = Integer.parseInt(idSede);
		this.nome = nome;
		this.estado = estado;
	}

	public Sede() {

	}

	public Sede(int idSede) {

		this.idSede = idSede;
	}

	public Sede(String idSede) {

		this.idSede = Integer.parseInt(idSede);
	}

	public Sede(String nome, String estado) {

		this.nome = nome;
		this.estado = estado;
	}

	public Sede(Map<String, String> args) {
		if (args.containsKey("nome")) {
			this.nome = args.get("nome");
		}
		if (args.containsKey("estado")) {
			this.estado = args.get("estado");
		}

	}

	public int getidSede() {
		return idSede;
	}

	public void setidSede(int idSede) {
		this.idSede = idSede;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getestado() {
		return estado;
	}

	public void setestado(String estado) {
		this.estado = estado;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idSede);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sede other = (Sede) obj;
		return idSede == other.idSede;
	}

	@Override
	public String toString() {
		return idSede + "\t" + nome + "\t" + estado + "\r\n";
	}

}
