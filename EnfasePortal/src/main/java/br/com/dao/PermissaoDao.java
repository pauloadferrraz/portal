package br.com.dao;

import javax.persistence.EntityManager;

import br.com.model.Permissao;


public class PermissaoDao extends GenericDAO<Long, Permissao>{
	
	public PermissaoDao(EntityManager entityManager) {
        super(entityManager);
    }
}
