package br.com.dao;

import javax.persistence.EntityManager;

import br.com.model.Usuario;

public class UsuarioDao extends GenericDAO<Long, Usuario> {
	public UsuarioDao(EntityManager entityManager) {
        super(entityManager);
    }
}
