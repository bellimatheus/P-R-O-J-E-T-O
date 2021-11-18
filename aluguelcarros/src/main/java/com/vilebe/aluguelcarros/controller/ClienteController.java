package com.vilebe.aluguelcarros.controller;

import java.sql.SQLException;
import java.text.ParseException;
import java.util.ArrayList;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vilebe.aluguelcarros.domains.Cliente;
import com.vilebe.aluguelcarros.domains.Login;
import com.vilebe.aluguelcarros.process.ClienteProcess;

@RestController
public class ClienteController {
	JSONObject objJSON;
	Cliente cliente;
	Login login;
	
	@PostMapping(path = "/status")
	public void ha() {
		System.out.println("Teste");
	}
	
	@GetMapping(path = "/locadora/clientes")
	public ArrayList<Cliente> abrir(){
		ClienteProcess.abrir();
		return ClienteProcess.clientes;
	}
	
	@PostMapping(path = "/locadora/cliente")
	public void efetuarCadastro(@RequestBody String json) throws  ParseException {
		try {
			objJSON = new JSONObject(json);
			login = new Login(
					objJSON.getString("email"), 
					objJSON.getString("senha")
					);
			System.out.println(login);
			cliente = new Cliente(
					objJSON.getString("nome"),
					objJSON.getString("idade"),
					objJSON.getString("cnh"),
					objJSON.getString("cpf"),
					objJSON.getString("telefone"),
					login
					);
			ClienteProcess.criar(cliente, login);	
		}catch (JSONException e) {
			e.printStackTrace();
		}
	}
	@DeleteMapping(path = "/locadora/cliente")
	public void deletarCadastro(@RequestBody String id) throws SQLException, JSONException {
		objJSON = new JSONObject(id);
		ClienteProcess.deletarCliente(objJSON.getString("idCliente"));
	}
}

