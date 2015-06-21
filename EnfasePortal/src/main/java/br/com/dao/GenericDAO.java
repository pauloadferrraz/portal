package br.com.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;
 



import javax.persistence.EntityManager;
import javax.persistence.Query;

import br.com.model.Permissao;
import br.com.model.Usuario;
 
@SuppressWarnings("unchecked")
public class GenericDAO<PK, T> {
    private EntityManager entityManager;
 
    public GenericDAO(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
 
    public T getById(PK pk) {
        return (T) entityManager.find(getTypeClass(), pk);
    }
 
    public void save(T entity) {
        entityManager.persist(entity);
    }
 
    public void update(T entity) {
        entityManager.merge(entity);
    }
 
    public void delete(T entity) {
        entityManager.remove(entity);
    }
    
    //Somente para Login
    public Usuario query(String query){
    	Query res = entityManager.createQuery(query);
    	if(!res.getResultList().isEmpty()){
    		return (Usuario) res.getSingleResult();
    	}else{
    		return null;
    	}
    }
    
    public Permissao queryPer(String query){
    	Query res = entityManager.createQuery(query);
    	if(!res.getResultList().isEmpty()){
    		return (Permissao) res.getSingleResult();
    	}else{
    		return null;
    	}
    }
    

    
    public List<T> findAll() {
        return entityManager.createQuery(("FROM " + getTypeClass().getName()))
                .getResultList();
    }
 
    private Class<?> getTypeClass() {
        Class<?> clazz = (Class<?>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass()).getActualTypeArguments()[1];
        return clazz;
    }
}