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

import br.com.tuliorocha.desafiomv.model.Colaborador;
import br.com.tuliorocha.desafiomv.service.ColaboradorService;
import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/colaborador")
public class ColaboradorController {
	
	private final ColaboradorService colaboradoRservice;
	
	@GetMapping
	public ResponseEntity<List<Colaborador>> findAll(){
		return new ResponseEntity<>(colaboradoRservice.findAll(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Colaborador> findById(@PathVariable Integer id) {
		
		return new ResponseEntity<>(colaboradoRservice.findById(id), HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		colaboradoRservice.delete(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody Colaborador colaborador){
		try {
			colaboradoRservice.create(colaborador);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
			
		}
		
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody Colaborador colaborador){
		colaboradoRservice.update(colaborador);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
