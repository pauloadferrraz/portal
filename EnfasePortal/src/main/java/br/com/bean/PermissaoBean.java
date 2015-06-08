package br.com.bean;

import java.util.List;

import javax.faces.bean.ManagedBean;
import br.com.dao.PermissaoDao;
import br.com.dao.SimpleEntityManager;
import br.com.model.Permissao;

@ManagedBean(name = "PermissaoBean")
public class PermissaoBean {

	private PermissaoDao dao;
	private Permissao permissao;
	private Permissao permissao_novo;
	private SimpleEntityManager simpleEntityManager;

	public PermissaoBean() {		
		this.permissao_novo = new Permissao();
		this.simpleEntityManager = new SimpleEntityManager("enfase");
		this.permissao = new Permissao();
		dao = new PermissaoDao(simpleEntityManager.getEntityManager());
	}

	public void salvar() {
		try {
			simpleEntityManager.beginTransaction();
			dao.save(this.permissao);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}
	
	public void add() {
		try {
			simpleEntityManager.beginTransaction();
			dao.save(this.permissao_novo);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
		
		permissao_novo = null;
	}
		
	public List<Permissao> findAll(){
		return dao.findAll();
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	public Permissao getPermissao_novo() {
		return permissao_novo;
	}

}
