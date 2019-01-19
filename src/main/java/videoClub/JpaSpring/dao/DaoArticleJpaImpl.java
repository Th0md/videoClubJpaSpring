package videoClub.JpaSpring.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import videoClub.JpaSpring.model.Article;

@Repository
@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=true)
public class DaoArticleJpaImpl implements DaoArticle {

	@PersistenceContext
	private EntityManager em;
	
	@SuppressWarnings("unchecked") 
	public List<Article> findAll() {
		return em.createQuery("select a from Article a").getResultList(); //"from Personne p" fonctionne aussi
	}

	public Article findByKey(Integer key) {
		return em.find(Article.class, key);
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void insert(Article obj) {
			em.persist(obj);
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void update(Article obj) {
			em.merge(obj);
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void delete(Article objet) {
			em.remove(em.merge(objet));
	}

	@Transactional(propagation=Propagation.REQUIRED, isolation=Isolation.DEFAULT, readOnly=false)
	public void deleteByKey(Integer key) {
			em.remove(em.find(Article.class, key));
	}

}
