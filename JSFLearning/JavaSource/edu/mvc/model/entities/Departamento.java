package edu.mvc.model.entities;

import java.util.List;

public class Departamento extends NamedEntity {

	private List<Provincia> lstProvincia;

	public Departamento() {
		
	}

	public List<Provincia> getLstProvincia() {
		return lstProvincia;
	}

	public void setLstProvincia(List<Provincia> lstProvincia) {
		this.lstProvincia = lstProvincia;
	}
}
