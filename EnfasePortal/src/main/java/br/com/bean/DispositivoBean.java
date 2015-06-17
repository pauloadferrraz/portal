package br.com.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.dao.DispositivoDao;
import br.com.dao.SimpleEntityManager;
import br.com.model.Dispositivo;

@ManagedBean(name = "DispositivoBean")
public class DispositivoBean {

	private DispositivoDao dao;
	private Dispositivo dispositivo;
	private Dispositivo dispositivo_novo;
	private SimpleEntityManager simpleEntityManager;

	public DispositivoBean() {		
		this.dispositivo_novo = new Dispositivo();
		this.simpleEntityManager = new SimpleEntityManager("enfase");
		this.dispositivo = new Dispositivo();
		dao = new DispositivoDao(simpleEntityManager.getEntityManager());
	}
	
	
	/*
	public void salvar() {
		try {
			simpleEntityManager.beginTransaction();
			dao.save(this.dispositivo);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}
	
	
	public void add() {
		try {
			simpleEntityManager.beginTransaction();
			dao.save(this.dispositivo_novo);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
		
		dispositivo_novo = null;
	}
	*/
	
	public List<Dispositivo> findAll(){
		return dao.findAll();
	}

	public Dispositivo getDispositivo() {
		return dispositivo;
	}

	public void setDispositivo(Dispositivo dispositivo) {
		this.dispositivo = dispositivo;
	}

	public Dispositivo getDispositivo_novo() {
		return dispositivo_novo;
	}


}
