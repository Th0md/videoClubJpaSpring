package videoClub.JpaSpring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import videoClub.JpaSpring.model.Adherent;

@Repository
@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=true)
public class DaoAdherentJpaImpl implements DaoAdherent {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked") 
	public List<Adherent> findAll() {
		return em.createQuery("select a from Adherent a").getResultList(); //"from Personne p" fonctionne aussi
	}

	public Adherent findByKey(Integer key) {
		return em.find(Adherent.class, key);
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void insert(Adherent obj) {
			em.persist(obj);
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void update(Adherent obj) {
			em.merge(obj);
	}
	
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void delete(Adherent objet) {
			em.remove(em.merge(objet));
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void deleteByKey(Integer key) {
			em.remove(em.find(Adherent.class, key));
	}
}
