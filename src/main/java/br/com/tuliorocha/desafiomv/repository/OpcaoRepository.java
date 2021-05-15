package br.com.tuliorocha.desafiomv.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.tuliorocha.desafiomv.model.Opcao;

@Repository
public class OpcaoRepository {
	
	@PersistenceContext
    private EntityManager opcaoManager;
	
	public Opcao findById(Integer id) {
		Query query = opcaoManager.createNativeQuery(" SELECT * FROM opcao WHERE id = ? ", Opcao.class);
		query.setParameter(1, id);
		
		return  (Opcao) query.getSingleResult();
	}
	
	public List<Opcao> findAll() {
		Query query = opcaoManager.createNativeQuery(" SELECT * FROM opcao ", Opcao.class);
		return query.getResultList();
	}
	
	@Transactional
	public void delete(Integer id) {
		opcaoManager
		.createNativeQuery("DELETE FROM opcao WHERE id = ? ")
	    .setParameter(1, id)
	    .executeUpdate();
	}
	
	@Transactional
	public void inserir(Opcao lanche) {
		opcaoManager
		.createNativeQuery("INSERT INTO opcao (nome) VALUES (?)")
	    .setParameter(1, lanche.getNome())
	    .executeUpdate();
	}
	
	@Transactional
	public void update(Opcao lanche) {
		opcaoManager
		.createNativeQuery("UPDATE opcao SET nome = ? WHERE id = ? ")
	    .setParameter(1, lanche.getNome())
	    .setParameter(2, lanche.getId())
	    .executeUpdate();
	}

}
