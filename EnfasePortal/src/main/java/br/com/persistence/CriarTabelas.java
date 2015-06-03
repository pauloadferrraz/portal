package br.com.persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import br.com.model.Dispositivo;
import br.com.util.JpaUtil;

public class CriarTabelas {

	public static void main(String[] args) {
		EntityManager manager = new JpaUtil().getEntityManager();
		
		
		EntityTransaction trx = manager.getTransaction();
		trx.begin();
		
		
		Dispositivo dispositivo = new Dispositivo();
		Dispositivo dispositivo2 = new Dispositivo();
		
		dispositivo.setNome("Sensor Movimento");
		dispositivo.setValor(2.3);
		
		dispositivo2.setNome("Sensor Gas");
		dispositivo2.setValor(3.2);
		
		
		manager.persist(dispositivo);
		manager.persist(dispositivo2);
		
		trx.commit();
			
		manager.close();
		
	}

}
