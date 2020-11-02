package negocio.bean;

import java.util.Date;

import dados.RepositorioComentarios;


public class Evento {
	
	private int id;
	private Pessoa owner;
	private Date data;
	private String descricao;
	private RepositorioComentarios comentarios;
	
	public Evento() {
		
	}
	

	public Evento(int id, Pessoa owner, Date data, String descricao, RepositorioComentarios comentarios) {
		super();
		this.id = id;
		this.owner = owner;
		this.data = data;
		this.descricao = descricao;
		this.comentarios = comentarios;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Pessoa getOwner() {
		return owner;
	}
	public void setOwner(Pessoa owner) {
		this.owner = owner;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}

	
	
	public RepositorioComentarios getComentarios() {
		return comentarios;
	}


	public void setComentarios(RepositorioComentarios comentarios) {
		this.comentarios = comentarios;
	}


	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((data == null) ? 0 : data.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + id;
		result = prime * result + ((owner == null) ? 0 : owner.hashCode());
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
		Evento other = (Evento) obj;
		if (data == null) {
			if (other.data != null)
				return false;
		} else if (!data.equals(other.data))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id != other.id)
			return false;
		if (owner == null) {
			if (other.owner != null)
				return false;
		} else if (!owner.equals(other.owner))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return descricao + " (evento: " + id + ") , feito por: " + owner + ", na data " + data + "," 
				+ ", comentarios:=" + comentarios + ".";
	}
	
}
