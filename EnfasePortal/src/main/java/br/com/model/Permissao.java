package br.com.model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;


@Entity(name="permissao")
public class Permissao implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 660783179887908118L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "perm_seq_gen")
	@SequenceGenerator(name = "perm_seq_gen", sequenceName = "permi_id_seq", initialValue = 1, allocationSize = 1)
	private long id;
	
	private String permissao;
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPermissao() {
		return permissao;
	}

	public void setPermissao(String permissao) {
		this.permissao = permissao;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result
				+ ((permissao == null) ? 0 : permissao.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Permissao other = (Permissao) obj;
		if (id != other.id)
			return false;
		if (permissao == null) {
			if (other.permissao != null)
				return false;
		} else if (!permissao.equals(other.permissao))
			return false;
		return true;
	}		
	
}
