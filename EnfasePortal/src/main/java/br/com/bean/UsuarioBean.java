package br.com.bean;

import java.util.ArrayList;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;
import javax.faces.model.SelectItem;

import br.com.dao.PermissaoDao;
import br.com.dao.SimpleEntityManager;
import br.com.dao.UsuarioDao;
import br.com.model.Permissao;
import br.com.model.Usuario;

@ManagedBean(name = "UsuarioBean")
public class UsuarioBean {
	
	private String confirmarSenha;
	private UsuarioDao dao;
	private PermissaoDao daoPermi;
	private Permissao permissao;
	private Usuario usuario;
	private Usuario usuario_novo;
	private SimpleEntityManager simpleEntityManager;

	public UsuarioBean() {
		this.simpleEntityManager = new SimpleEntityManager("enfase");
		this.usuario = new Usuario();
		dao = new UsuarioDao(simpleEntityManager.getEntityManager());
		daoPermi = new PermissaoDao(simpleEntityManager.getEntityManager());
	}

	public void salvar() {
		try {
			simpleEntityManager.beginTransaction();
			dao.save(this.usuario);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack();
		}
	}

	public String login() {

		if (usuario.getLogin().equalsIgnoreCase("admin")
				&& usuario.getSenha().equalsIgnoreCase("admin")){
			return "dispositivos?faces-redirect=true";
		}
		else{
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",
							"Contate o admin."));
			return null;
		}
	}
	
	public void add() {
		
		if(usuario_novo.getSenha().equals(confirmarSenha)){
			try {
				simpleEntityManager.beginTransaction();
				dao.save(this.usuario_novo);
				simpleEntityManager.commit();
			} catch (Exception e) {
				e.printStackTrace();
				simpleEntityManager.rollBack();
			}
			
			usuario_novo = null;
		}
		else{
			FacesContext.getCurrentInstance().addMessage(
					null,
					new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error!",
							"Digite a senha corretamente, confirme"));
		}
		
	}
	
	public List<Permissao> findP(){
		/*
		List<SelectItem> items = new ArrayList<SelectItem>();
		   List<Permissao> perList = daoPermi.findAll();
		    for(Permissao per: perList){
		       items.add(new SelectItem(per.getClass(), per.getPermissao()));
		   }
		   return items;
		   */
		List<Permissao> perList = daoPermi.findAll();
		for(Permissao per: perList){
		       System.out.println(per.getPermissao());
		   }
		   return perList;
	}
	
	public List<Usuario> findAll(){
		return dao.findAll();
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getConfirmarSenha() {
		return confirmarSenha;
	}

	public void setConfirmarSenha(String confirmarSenha) {
		this.confirmarSenha = confirmarSenha;
	}

	public Usuario getUsuario_novo() {
		return usuario_novo;
	}

	public Permissao getPermissao() {
		return permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

	
}
