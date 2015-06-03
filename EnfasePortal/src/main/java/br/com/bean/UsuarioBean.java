package br.com.bean;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import br.com.dao.SimpleEntityManager;
import br.com.dao.UsuarioDao;
import br.com.model.Usuario;

@ManagedBean(name = "UsuarioBean")
public class UsuarioBean {

	private UsuarioDao dao;
	private Usuario usuario;
	private SimpleEntityManager simpleEntityManager;

	public UsuarioBean() {
		this.simpleEntityManager = new SimpleEntityManager("enfase");
		this.usuario = new Usuario();
		dao = new UsuarioDao(simpleEntityManager.getEntityManager());
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

}
