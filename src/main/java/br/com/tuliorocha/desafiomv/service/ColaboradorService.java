package br.com.tuliorocha.desafiomv.service;

import java.util.List;

import org.springframework.stereotype.Service;

import br.com.tuliorocha.desafiomv.interfaces.ColaboradorImpl;
import br.com.tuliorocha.desafiomv.model.Colaborador;
import br.com.tuliorocha.desafiomv.repository.ColaboradorRepostory;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ColaboradorService implements ColaboradorImpl {
	
	private final ColaboradorRepostory colaboradoRepository;
	
	public Colaborador findById(Integer id) {
		return colaboradoRepository.findById(id);
	}
	
	public List<Colaborador> findAll(){
		return colaboradoRepository.findAll();
	}
	
	public void delete(Integer id) {
		colaboradoRepository.delete(id);
	}
	
	public void update(Colaborador c) {
		colaboradoRepository.update(c);
	}
	
	public void create(Colaborador c) throws Exception {
		var colaboradoresAtuais = colaboradoRepository.findAll();
		
		boolean existeCpf = colaboradoresAtuais.stream().filter( f -> f.getCpf().equalsIgnoreCase(c.getCpf())).findFirst().isPresent();
		
		if(existeCpf) { throw new Exception("Cpf já cadastrado"); }

		
		colaboradoRepository.inserir(c);
	}

}
