package br.com.tuliorocha.desafiomv.interfaces;

import java.util.List;

import br.com.tuliorocha.desafiomv.model.CafeDaManha;

public interface CafeDaManhaImpl {
	
	void create(CafeDaManha cafeDaManha) throws Exception;
	
	CafeDaManha findById(Integer id);
	
	List<CafeDaManha> findAll();
	
	void delete(Integer id);

	void update(CafeDaManha cafeDaManha);
}
