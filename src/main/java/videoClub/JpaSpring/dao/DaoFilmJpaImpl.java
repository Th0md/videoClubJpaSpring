package videoClub.JpaSpring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import videoClub.JpaSpring.model.Film;

@Repository
@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=true)
public class DaoFilmJpaImpl implements DaoFilm {

	@PersistenceContext
	private EntityManager em;
		
	@SuppressWarnings("unchecked") 
	public List<Film> findAll() {
		return em.createQuery("select f from Film f").getResultList(); //"from Personne p" fonctionne aussi
	}

	public Film findByKey(Integer key) {
		return em.find(Film.class, key);
	}

	
	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void insert(Film obj) {
		System.out.println("GGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGGG");
			em.persist(obj);
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void update(Film obj) {
			em.merge(obj);
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void delete(Film objet) {
			em.remove(em.merge(objet));
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void deleteByKey(Integer key) {
			em.remove(em.find(Film.class, key));
	}

}
