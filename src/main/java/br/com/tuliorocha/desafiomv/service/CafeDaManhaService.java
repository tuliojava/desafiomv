package br.com.tuliorocha.desafiomv.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.tuliorocha.desafiomv.interfaces.CafeDaManhaImpl;
import br.com.tuliorocha.desafiomv.model.CafeDaManha;
import br.com.tuliorocha.desafiomv.repository.CafeDaManhaRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CafeDaManhaService implements CafeDaManhaImpl {
	
	private final CafeDaManhaRepository cafeDaManhaRepository;
	
	public void create(CafeDaManha cafeDaManha) throws Exception {
		var cafeDaManhaExistentes = cafeDaManhaRepository.findAll();
		
		boolean existeJaCadastrado = cafeDaManhaExistentes.stream().filter( f -> f.getOpcao().getId().equals(cafeDaManha.getOpcao().getId()))
		.findFirst().isPresent();
		
		if(existeJaCadastrado) { throw new Exception("Opção ja cadastrada"); }
		
		cafeDaManhaRepository.inserir(cafeDaManha);
	}
	
	public CafeDaManha findById(Integer id) {
		return cafeDaManhaRepository.findById(id);
	}
	
	public List<CafeDaManha> findAll(){
		return cafeDaManhaRepository.findAll();
	}
	
	public void delete(Integer id) {
		cafeDaManhaRepository.delete(id);
	} 
	
	public void update(CafeDaManha cafeDaManha) {
		cafeDaManhaRepository.update(cafeDaManha);
	}

}
