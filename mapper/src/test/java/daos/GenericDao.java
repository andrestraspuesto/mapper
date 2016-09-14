package daos;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import jpa.domain.Domain;

public abstract class GenericDao<P extends Serializable, T extends Domain> {

	@PersistenceContext
	EntityManager em;

	private Class<T> pC;

	@SuppressWarnings("unchecked")
	public GenericDao() {
		pC = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass())
				.getActualTypeArguments()[1];
	}

	public EntityManager getEntityManager() {
		return this.em;
	}

	public List<T> list(){
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<T> cq = cb.createQuery(pC);
		Root<T> root = cq.from(pC);
        CriteriaQuery<T> allCrit = cq.select(root);
        TypedQuery<T> all = em.createQuery(allCrit);
        return all.getResultList();
		
	}
	
	public T getById(P key) {
		return (T) em.find(pC, key);
	}

	public T save(T domain) {
		if(domain.getId() == null){
			em.persist(domain);
		} else {
			domain = em.merge(domain);
		}
		return domain;
	}

	public void delete(T entity) {
		em.remove(entity);
	}
}
