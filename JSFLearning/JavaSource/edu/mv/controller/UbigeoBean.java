package edu.mv.controller;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

import edu.mvc.model.bl.IUbigeoEJB;
import edu.mvc.model.entities.Departamento;
import edu.mvc.model.entities.Distrito;
import edu.mvc.model.entities.Provincia;
import edu.mvc.util.JSFHelper;

@ManagedBean
@ViewScoped
public class UbigeoBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1240023904487502341L;

	@EJB(beanName="UbigeoEJB")
	private IUbigeoEJB ubigeoEJB;

	private Map<String, Long> mapDepartamento;
	private Map<String, Long> mapProvincia;
	private Map<String, Long> mapDistrito;
	private Long idDepartamentoSelected;
	private Long idProvinciaSelected;
	private Long idDistritoSelected;

	private Departamento departamentoSelected;
	private Provincia provinciaSelected;
	private Distrito distritoSelected;
	private Boolean procesado = false;

	public UbigeoBean() {
	}

	@PostConstruct
	public void init() {
		List<Departamento> lstDepartamento = ubigeoEJB.findAllDepartamento();
		mapDepartamento = JSFHelper.convertListToDDLMap(lstDepartamento);
	}

	public Map<String, Long> getMapDepartamento() {
		return mapDepartamento;
	}

	public void setMapDepartamento(Map<String, Long> mapDepartamento) {
		this.mapDepartamento = mapDepartamento;
	}

	public Long getIdDepartamentoSelected() {
		return idDepartamentoSelected;
	}

	public void setIdDepartamentoSelected(Long idDepartamentoSelected) {
		this.idDepartamentoSelected = idDepartamentoSelected;
	}

	public Map<String, Long> getMapProvincia() {
		return mapProvincia;
	}

	public void setMapProvincia(Map<String, Long> mapProvincia) {
		this.mapProvincia = mapProvincia;
	}

	public Map<String, Long> getMapDistrito() {
		return mapDistrito;
	}

	public void setMapDistrito(Map<String, Long> mapDistrito) {
		this.mapDistrito = mapDistrito;
	}

	public Long getIdProvinciaSelected() {
		return idProvinciaSelected;
	}

	public void setIdProvinciaSelected(Long idProvinciaSelected) {
		this.idProvinciaSelected = idProvinciaSelected;
	}

	public Long getIdDistritoSelected() {
		return idDistritoSelected;
	}

	public void setIdDistritoSelected(Long idDistritoSelected) {
		this.idDistritoSelected = idDistritoSelected;
	}

	public Departamento getDepartamentoSelected() {
		return departamentoSelected;
	}

	public void setDepartamentoSelected(Departamento departamentoSelected) {
		this.departamentoSelected = departamentoSelected;
	}

	public Provincia getProvinciaSelected() {
		return provinciaSelected;
	}

	public void setProvinciaSelected(Provincia provinciaSelected) {
		this.provinciaSelected = provinciaSelected;
	}

	public Distrito getDistritoSelected() {
		return distritoSelected;
	}

	public void setDistritoSelected(Distrito distritoSelected) {
		this.distritoSelected = distritoSelected;
	}

	public Boolean getProcesado() {
		return procesado;
	}

	public void setProcesado(Boolean procesado) {
		this.procesado = procesado;
	}

	public void selectDepartamento() {
		if (mapProvincia != null) {
			mapProvincia.clear();
		}
		if (mapDistrito != null) {
			mapDistrito.clear();
		}
		if (idDepartamentoSelected != null) {
			Departamento departamento = ubigeoEJB.findDepartamento(idDepartamentoSelected);
			mapProvincia = JSFHelper.convertListToDDLMap(departamento.getLstProvincia());
			mapDistrito = null;
		}
	}

	public void selectProvincia() {
		if (mapDistrito != null) {
			mapDistrito.clear();
		}
		if (idProvinciaSelected != null) {
			Provincia provincia = ubigeoEJB.findProvincia(idProvinciaSelected);
			mapDistrito = JSFHelper.convertListToDDLMap(provincia.getLstDistrito());
		}
	}

	public void showData() {
		procesado = false;
		if (idDistritoSelected != null) {
			procesado = true;
			departamentoSelected = ubigeoEJB.findDepartamento(idDepartamentoSelected);
			provinciaSelected = ubigeoEJB.findProvincia(idProvinciaSelected);
			distritoSelected = new Distrito();
			distritoSelected.setId(idDistritoSelected);
			distritoSelected.setNombreCorto("Por implementar!");
		} else {
			FacesContext.getCurrentInstance().addMessage(null, new FacesMessage("Seleccione todos los datos."));
		}
	}
}
