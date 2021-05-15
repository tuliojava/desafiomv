package br.com.tuliorocha.desafiomv.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tuliorocha.desafiomv.model.Opcao;
import br.com.tuliorocha.desafiomv.service.OpcaoService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/opcao")
public class OpcaoController {
	
	private final OpcaoService opcaoService;
	
	@GetMapping
	public ResponseEntity<List<Opcao>> findAll(){
		return new ResponseEntity<>(opcaoService.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Opcao> findById(@PathVariable Integer id) {
		
		return new ResponseEntity<>(opcaoService.findById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		opcaoService.delete(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Opcao opcao){
		opcaoService.create(opcao);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Opcao opcao){
		opcaoService.update(opcao);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
}
