package br.com.tuliorocha.desafiomv.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import br.com.tuliorocha.desafiomv.model.CafeDaManha;

@Repository
public class CafeDaManhaRepository {
	
	@PersistenceContext
    private EntityManager cafeDaManhaManager;
	
	@Transactional
	public void inserir(CafeDaManha cafeDaManha) {
		
		cafeDaManhaManager
		.createNativeQuery(" INSERT INTO cafedamanha (opcao_id, colaborador_id) VALUES (?,?) ")
		.setParameter(1, cafeDaManha.getOpcao().getId())
	    .setParameter(2, cafeDaManha.getColaborador().getId())
	    .executeUpdate();
	}
	
	public List<CafeDaManha> findAll() {
		Query query = cafeDaManhaManager.createNativeQuery(" SELECT * FROM cafedamanha ", CafeDaManha.class);
		return query.getResultList();
	}
	
	public CafeDaManha findById(Integer id) {
		Query query = cafeDaManhaManager.createNativeQuery(" SELECT * FROM cafedamanha WHERE id = ? ", CafeDaManha.class)
				.setParameter(1, id);
		return (CafeDaManha) query.getSingleResult();
	}
	
	@Transactional
	public void update(CafeDaManha cafeDaManha) {
		cafeDaManhaManager
		.createNativeQuery("UPDATE cafedamanha SET opcao_id = ?, colaborador_id = ? WHERE id = ? ")
	    .setParameter(1, cafeDaManha.getOpcao().getId())
	    .setParameter(2, cafeDaManha.getColaborador().getId())
	    .setParameter(3, cafeDaManha.getId())
	    .executeUpdate();
	}
	
	
	@Transactional
	public void delete(Integer id) {
		cafeDaManhaManager
		.createNativeQuery(" DELETE FROM cafedamanha WHERE id = ? ")
	    .setParameter(1, id)
	    .executeUpdate();
	}

}
