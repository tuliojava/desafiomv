package br.com.tuliorocha.desafiomv.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.tuliorocha.desafiomv.model.Opcao;
import br.com.tuliorocha.desafiomv.repository.OpcaoRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class OpcaoService {
	
	private final OpcaoRepository opcaoRepository;
	
	public Opcao findById(Integer id) {
	    return opcaoRepository.findById(id);
	}

	public List<Opcao> findAll(){
	   return opcaoRepository.findAll();
	}
	
	public void delete(Integer id) {
		opcaoRepository.delete(id);
	}
	
	public void create(Opcao opcao) {
		opcaoRepository.inserir(opcao);
	}

	public void update(Opcao opcao) {
		opcaoRepository.update(opcao);
	}
	

}
