package br.com.dao;

import javax.persistence.EntityManager;

import br.com.model.Dispositivo;


public class DispositivoDao extends GenericDAO<Long, Dispositivo>{
	
	public DispositivoDao(EntityManager entityManager) {
        super(entityManager);
    }
}
