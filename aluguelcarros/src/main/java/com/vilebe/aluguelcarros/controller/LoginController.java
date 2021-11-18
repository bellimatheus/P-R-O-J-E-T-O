package com.vilebe.aluguelcarros.controller;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.vilebe.aluguelcarros.domains.Cliente;
import com.vilebe.aluguelcarros.domains.Login;
import com.vilebe.aluguelcarros.process.LoginProcess;



@RestController
public class LoginController {
	private JSONObject objJSON;
	private Login login;
	
	@PostMapping(path = "/locadora/login")
	public ResponseEntity<Cliente> efetuarLogin(@RequestBody String body) throws Exception{
		objJSON = new JSONObject(body);
		
		login = new Login(
				objJSON.getString("email"), 
				objJSON.getString("senha")
				);
		
		if(LoginProcess.verLogin(login) == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}else {
			return new ResponseEntity<Cliente>(LoginProcess.verLogin(login), HttpStatus.FOUND);
		}
	}
}
