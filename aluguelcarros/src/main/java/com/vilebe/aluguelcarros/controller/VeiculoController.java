package com.vilebe.aluguelcarros.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vilebe.aluguelcarros.domains.Cliente;
import com.vilebe.aluguelcarros.domains.Veiculo;
import com.vilebe.aluguelcarros.process.ClienteProcess;
import com.vilebe.aluguelcarros.process.VeiculoProcess;

@RestController
public class VeiculoController {
	private JSONObject jsonOBJ;
	private Veiculo veiculo;

	@GetMapping(path = "/locadora/veiculo")
	public ArrayList<Veiculo> abrirVeiculo() {
		VeiculoProcess.abrir();
		return VeiculoProcess.veiculos;

	}

	@GetMapping(path = "//locadora/veiculos")
	public Veiculo abrirVeiculo(@RequestBody String json) throws JSONException {
		VeiculoProcess.abrir();
		jsonOBJ = new JSONObject();
		if (VeiculoProcess.veiculos.contains(new Veiculo(jsonOBJ.getInt("idVeiculo")))) {
			return VeiculoProcess.veiculos
					.get(VeiculoProcess.veiculos.indexOf(new Veiculo(jsonOBJ.getInt("idVeiculo"))));
		} else
			return null;

	}

	@PostMapping(path = "/locadora/veiculo")
	public void criarVeiculo(@RequestBody String body) throws JSONException {
		jsonOBJ = new JSONObject(body);
		veiculo = new Veiculo(0, jsonOBJ.getString("tipo"), jsonOBJ.getString("modelo"), jsonOBJ.getString("marca"),
				jsonOBJ.getString("placa"), jsonOBJ.getString("espf"), jsonOBJ.getString("img")
);
		VeiculoProcess.addVeiculo(veiculo);

	}

	@DeleteMapping(path = "/locadora/veiculo")
	public void excluirVeiculo(@RequestBody String id) throws JSONException {
		jsonOBJ = new JSONObject(id);
		VeiculoProcess.delVeiculo(jsonOBJ.getString("idVeiculo"));
	}

	@PutMapping(path = "/locadora/veiculo")
	public void alterarVeiculo(@RequestBody String body) throws JSONException {
		jsonOBJ = new JSONObject(body);
		String[] params = { "tipo", "modelo", "marca", "placa", "espf","img" };
		Map<String, String> args = new HashMap<String, String>();
		for (int i = 0; i < params.length; i++) {
			if (!jsonOBJ.isNull(params[i])) {
				args.put(params[i], jsonOBJ.getString(params[i].toString()));
			}
		}
		veiculo = new Veiculo(args);

		VeiculoProcess.updtVeiculo(jsonOBJ.getString("idVeiculo"), veiculo);

	}

}
