package br.com.tuliorocha.desafiomv.interfaces;

import java.util.List;

import br.com.tuliorocha.desafiomv.model.Colaborador;

public interface ColaboradorImpl {
	
	Colaborador findById(Integer id);
	
	List<Colaborador> findAll();
	
	void delete(Integer id);
	
	void update(Colaborador c);
	
	void create(Colaborador c) throws Exception;

}
