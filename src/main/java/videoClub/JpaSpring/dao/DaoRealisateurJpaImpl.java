package videoClub.JpaSpring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import videoClub.JpaSpring.model.Realisateur;

@Repository
@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=true)
public class DaoRealisateurJpaImpl implements DaoRealisateur {
	
	@PersistenceContext
	private EntityManager em;

	@SuppressWarnings("unchecked") 
	public List<Realisateur> findAll() {
		return em.createQuery("select r from Realisateur r").getResultList();
	}

	public Realisateur findByKey(Integer key) {
		return em.find(Realisateur.class, key);
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void insert(Realisateur obj) {
			em.persist(obj);
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void update(Realisateur obj) {
			em.merge(obj);
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void delete(Realisateur objet) {
			em.remove(em.merge(objet));
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void deleteByKey(Integer key) {
			em.remove(em.find(Realisateur.class, key));
	}

	
}
