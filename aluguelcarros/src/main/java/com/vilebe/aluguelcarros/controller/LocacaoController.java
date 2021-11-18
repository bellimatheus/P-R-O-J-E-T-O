package com.vilebe.aluguelcarros.controller;

import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vilebe.aluguelcarros.domains.Cliente;
import com.vilebe.aluguelcarros.domains.Locacao;
import com.vilebe.aluguelcarros.domains.Veiculo;
import com.vilebe.aluguelcarros.process.LocacaoProcess;

@RestController
public class LocacaoController {
	JSONObject objJSON;
	Locacao locacao;

	@GetMapping(path = "/locadora/locacaos")
	public ArrayList<Locacao> abrir(){
		LocacaoProcess.abrir();
		return LocacaoProcess.locacoes;
	}
	
	@PostMapping(path = "/locadora/locacao")
	public void criarLocacao(@RequestBody String json) throws JSONException {
			Cliente c = new Cliente(
					objJSON.getInt("idCliente")
					);
			Veiculo v = new Veiculo(
					objJSON.getInt("idVliente")
					);
	
			locacao = new Locacao(
					c,
					v,
					objJSON.getString("DataRetirada"),
					objJSON.getString("DataDevolucao"),
					objJSON.getString("LocalRetirada"),
					objJSON.getString("LocalDevolucao")
					);
			
			LocacaoProcess.criar(locacao);
		}
	}
