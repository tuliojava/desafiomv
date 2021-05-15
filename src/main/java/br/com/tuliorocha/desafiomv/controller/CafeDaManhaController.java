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

import br.com.tuliorocha.desafiomv.model.CafeDaManha;
import br.com.tuliorocha.desafiomv.service.CafeDaManhaService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cafe-da-manha")
public class CafeDaManhaController {
	
	private final CafeDaManhaService cafeDaManhaService;
	
	@GetMapping
	public ResponseEntity<List<CafeDaManha>> findAll(){
		return new ResponseEntity<>(cafeDaManhaService.findAll(), HttpStatus.OK);
	}
	
	@PostMapping
	public ResponseEntity<?> create(@RequestBody CafeDaManha cafeDaManha){
		try {
			cafeDaManhaService.create(cafeDaManha);
		} catch (Exception e) {
			return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
		}
		return new ResponseEntity<>(HttpStatus.CREATED);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<CafeDaManha> findById(@PathVariable Integer id){
		return new ResponseEntity<>(cafeDaManhaService.findById(id), HttpStatus.OK);
	}
	
	
	@PutMapping
	public ResponseEntity<?> update(@RequestBody CafeDaManha cafeDaManha){
		cafeDaManhaService.update(cafeDaManha);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id){
		cafeDaManhaService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	

}
