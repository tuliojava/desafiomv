package br.com.tuliorocha.desafiomv.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.tuliorocha.desafiomv.model.Colaborador;

@Repository
public class ColaboradorRepostory {
	
	@PersistenceContext
    private EntityManager colaboradorManager;
	
	public Colaborador findById(Integer id) {
		Query query = colaboradorManager.createNativeQuery(" SELECT * FROM colaborador WHERE id = ? ", Colaborador.class);
		query.setParameter(1, id);
		
		return (Colaborador) query.getSingleResult();
		
	}
	
	public List<Colaborador> findAll() {
		Query query = colaboradorManager.createNativeQuery(" SELECT * FROM colaborador ", Colaborador.class);
		return query.getResultList();
	}
	
	@Transactional
	public void delete(Integer id) {
		colaboradorManager
		.createNativeQuery("DELETE FROM colaborador WHERE id = ? ")
	    .setParameter(1, id)
	    .executeUpdate();
	}
	
	@Transactional
	public void inserir(Colaborador c) {
		colaboradorManager
		.createNativeQuery("INSERT INTO colaborador (cpf, nome) VALUES (?,?)")
		.setParameter(1, c.getCpf())
	    .setParameter(2, c.getNome())
	    .executeUpdate();
	}
	
	@Transactional
	public void update(Colaborador c) {
		colaboradorManager
		.createNativeQuery("UPDATE colaborador SET cpf = ?, nome = ? WHERE id = ? ")
		.setParameter(1, c.getCpf())
        .setParameter(2, c.getNome())
        .setParameter(3, c.getId())
        .executeUpdate();
	}
	

}
