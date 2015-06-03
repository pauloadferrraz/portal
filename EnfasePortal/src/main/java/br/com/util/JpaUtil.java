package br.com.util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaUtil {

	private static EntityManagerFactory factory;

	/*
	 * um bloco estático para inicializar a fábrica de Entity Manager. Isso
	 * ocorrerá apenas uma vez, no carregamento da classe.
	 */
	static {
		factory = Persistence.createEntityManagerFactory("enfase");
	}
	
	/*
	 * EntityManager manager = JpaUtil.getEntityManager();
	 * */

	public static EntityManager getEntityManager() {
		return factory.createEntityManager();
	}

}
