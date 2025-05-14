package com.app.OrtoDomotizzato.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.OrtoDomotizzato.model.Lettura;
import com.app.OrtoDomotizzato.model.DTO.LetturaDTO;
import com.app.OrtoDomotizzato.service.LetturaService;

@RestController
@RequestMapping("/api")
public class LetturaController {
	
	@Autowired
	private LetturaService letturaService;
	
	@PostMapping
	public ResponseEntity<Void> ricevi(@RequestBody Lettura lettura) {
		letturaService.salvaLettura(lettura);
		return ResponseEntity.ok().build();
		
	}
	
	@PostMapping("/salvaLetture")
	public ResponseEntity<Void> salvaLetture(@RequestBody List<Lettura> letture) {
		letturaService.salvaLettura(letture);
	    return ResponseEntity.ok().build();
	}
	
	@GetMapping
	public List<LetturaDTO> ultime() {
		return letturaService.ultimeLetture();
	}
	

}
