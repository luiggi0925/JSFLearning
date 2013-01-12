package edu.mvc.model.entities;

import java.util.List;

public class Provincia extends NamedEntity {

	private List<Distrito> lstDistrito;

	public Provincia() {
		
	}

	public List<Distrito> getLstDistrito() {
		return lstDistrito;
	}

	public void setLstDistrito(List<Distrito> lstDistrito) {
		this.lstDistrito = lstDistrito;
	}
}
