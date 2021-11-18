package com.vilebe.aluguelcarros.domains;

import static java.lang.Integer.parseInt;

import java.util.Objects;

public class Locacao {
	private int idLoc;
	private Cliente idCliente;
	private Veiculo idVeiculo;
	private String DataDevolucao;
	private String DataRetirada;
	private String LocalRetirada;
	private String LocalDevolucao;

	public Locacao(int idLoc, Cliente idCliente, Veiculo idVeiculo, String dataDevolucao, String dataRetirada,
			String localRetirada, String localDevolucao) {

		this.idLoc = idLoc;
		this.idCliente = idCliente;
		this.idVeiculo = idVeiculo;
		DataDevolucao = dataDevolucao;
		DataRetirada = dataRetirada;
		LocalRetirada = localRetirada;
		LocalDevolucao = localDevolucao;
	}

	public Locacao(Cliente idCliente, Veiculo idVeiculo, String dataDevolucao, String dataRetirada,
			String localRetirada, String localDevolucao) {

		this.idCliente = idCliente;
		this.idVeiculo = idVeiculo;
		DataDevolucao = dataDevolucao;
		DataRetirada = dataRetirada;
		LocalRetirada = localRetirada;
		LocalDevolucao = localDevolucao;
	}

	public Locacao(String idLoc, Cliente idCliente, Veiculo idVeiculo, String dataDevolucao, String dataRetirada,
			String localRetirada, String localDevolucao) {

		this.idLoc = parseInt(idLoc);
		this.idCliente = idCliente;
		this.idVeiculo = idVeiculo;
		DataDevolucao = dataDevolucao;
		DataRetirada = dataRetirada;
		LocalRetirada = localRetirada;
		LocalDevolucao = localDevolucao;
	}
	


	public Locacao(int idLoc) {

		this.idLoc = idLoc;
	}
	
	public Locacao(String idLoc) {
		this.idLoc = Integer.parseInt(idLoc);
	}
	
	public Locacao() {
		
	}

	public int getIdLoc() {
		return idLoc;
	}

	public void setIdLoc(int idLoc) {
		this.idLoc = idLoc;
	}

	public Cliente getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Cliente idCliente) {
		this.idCliente = idCliente;
	}

	public Veiculo getIdVeiculo() {
		return idVeiculo;
	}

	public void setIdVeiculo(Veiculo idVeiculo) {
		this.idVeiculo = idVeiculo;
	}

	public String getDataDevolucao() {
		return DataDevolucao;
	}

	public void setDataDevolucao(String dataDevolucao) {
		DataDevolucao = dataDevolucao;
	}

	public String getDataRetirada() {
		return DataRetirada;
	}

	public void setDataRetirada(String dataRetirada) {
		DataRetirada = dataRetirada;
	}

	public String getLocalRetirada() {
		return LocalRetirada;
	}

	public void setLocalRetirada(String localRetirada) {
		LocalRetirada = localRetirada;
	}

	public String getLocalDevolucao() {
		return LocalDevolucao;
	}

	public void setLocalDevolucao(String localDevolucao) {
		LocalDevolucao = localDevolucao;
	}

}
