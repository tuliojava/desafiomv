package br.com.tuliorocha.desafiomv.interfaces;

import java.util.List;

import br.com.tuliorocha.desafiomv.model.Opcao;

public interface OpcaoImpl {

	Opcao findById(Integer id);
	
	List<Opcao> findAll();
	
	void delete(Integer id);
	
	void create(Opcao opcao);
	
	void update(Opcao opcao);
}
