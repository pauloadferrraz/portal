package br.com.bean;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.dao.PermissaoDao;
import br.com.dao.SimpleEntityManager;
import br.com.dao.UsuarioDao;
import br.com.model.Permissao;
import br.com.model.Usuario;

@ManagedBean(name = "UsuarioBean")
public class UsuarioBean {
	
	private String confirmarSenha;
	//private UsuarioDao dao;
	//private PermissaoDao daoPermi;
	private Permissao permissao;
	private Usuario usuario;
	private Usuario usuario_novo;
	//private SimpleEntityManager simpleEntityManager;
	private  List<Permissao> LstPermissao;


	public UsuarioBean() {
		//this.simpleEntityManager = new SimpleEntityManager("enfase");
		this.usuario = new Usuario();
		this.usuario_novo = new Usuario();
		this.permissao = new Permissao();
		//dao = new UsuarioDao(simpleEntityManager.getEntityManager());
		
		//daoPermi = new PermissaoDao(simpleEntityManager.getEntityManager());
		LstPermissao = this.findP();
	}

	public void salvar() {
		SimpleEntityManager simpleEntityManager = new SimpleEntityManager("enfase"); 
		try {
			
			simpleEntityManager.beginTransaction();
			this.usuario_novo.setPermissao(this.permissao);
			UsuarioDao dao = new UsuarioDao(simpleEntityManager.getEntityManager());
			dao.save(this.usuario_novo);
			simpleEntityManager.commit();
		} catch (Exception e) {
			e.printStackTrace();
			simpleEntityManager.rollBack(); 
		}
	}

	public String login() {

		if ("admin".equals(this.usuario.getLogin())
				&& "admin".equals(this.usuario.getSenha())){
			return "/faces/dispositivos?faces-redirect=true";
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
				//simpleEntityManager.beginTransaction();
				this.usuario_novo.setPermissao(this.permissao);
				//dao.save(this.usuario_novo);
				//simpleEntityManager.commit();
			} catch (Exception e) {
				e.printStackTrace();
				//simpleEntityManager.rollBack();
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
		SimpleEntityManager simpleEntityManager = new SimpleEntityManager("enfase");
		//simpleEntityManager.beginTransaction();
		
		PermissaoDao dao = new PermissaoDao(simpleEntityManager.getEntityManager());
 
		List<Permissao> perList = dao.findAll();

		simpleEntityManager.close();
		//for(Permissao per: perList){
		//       System.out.println(per.getPermissao());
		 //  }
		   return perList;
	}
	
	//public List<Usuario> findAll(){
	//	return dao.findAll();
	//}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public void setUsuario_novo(Usuario usuario_novo) {
		this.usuario_novo = usuario_novo;
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

	public List<Permissao> getLstPermissao() {
		return LstPermissao;
	}

	public void setLstPermissao(List<Permissao> lstPermissao) {
		LstPermissao = lstPermissao;
	}

	
}
