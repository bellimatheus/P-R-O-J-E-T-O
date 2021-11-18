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

import com.vilebe.aluguelcarros.domains.Sede;
import com.vilebe.aluguelcarros.domains.Sede;
import com.vilebe.aluguelcarros.process.SedeProcess;
import com.vilebe.aluguelcarros.process.SedeProcess;

@RestController
public class SedeController {
	private JSONObject OBJjson;
	private Sede sede;

	@GetMapping(path = "/locadora/sede")
	public ArrayList<Sede> abrirAero() {
		SedeProcess.abrir();
		return SedeProcess.sedes;
	}

	@GetMapping(path = "/locadora/sedes")
	public Sede abrirSede(@RequestBody String json) throws JSONException {
		SedeProcess.abrir();
		if (SedeProcess.sedes.contains(new Sede(OBJjson.getInt("idSede")))) {
			return SedeProcess.sedes.get(SedeProcess.sedes.indexOf(new Sede(OBJjson.getInt("idSede"))));
		} else
			return null;
	}

	@PostMapping(path = "/locadora/sede")
	public void criarSede(@RequestBody String body) throws JSONException {
		OBJjson = new JSONObject(body);
		sede = new Sede(OBJjson.getString("nome"), OBJjson.getString("estado"));
		System.out.println(OBJjson);
		SedeProcess.addSede(sede);
	}

	@DeleteMapping(path = "/locadora/sede")
	public void delSede(@RequestBody String id) throws JSONException {
		OBJjson = new JSONObject(id);
		SedeProcess.delSede(OBJjson.getString("idSede"));

	}

	@PutMapping(path = "/locadora/sede")
	public void alterarSede(@RequestBody String body) throws JSONException {
		OBJjson = new JSONObject(body);
		String[] params = { "nome", "estado" };
		Map<String, String> args = new HashMap<String, String>();
		for (int i = 0; i < params.length; i++) {
			if (!OBJjson.isNull(params[i])) {
				args.put(params[i], OBJjson.getString(params[i].toString()));
			}
		}
		sede = new Sede(args);

		SedeProcess.updtSede(OBJjson.getString("idSede"), sede);

	}
}
