package edu.mvc.model.bl;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import edu.mvc.model.entities.Departamento;
import edu.mvc.model.entities.Provincia;
import edu.mvc.model.service.IUbigeoService;

@Stateless
public class UbigeoEJB implements IUbigeoEJB {

	@EJB(beanName="UbigeoService")
	private IUbigeoService ubigeoService;

	@Override
	public List<Departamento> findAllDepartamento() {
		// TODO Auto-generated method stub
		return ubigeoService.findAllDepartamento();
	}

	@Override
	public Departamento findDepartamento(Long id) {
		// TODO Auto-generated method stub
		return ubigeoService.findDepartamento(id);
	}

	@Override
	public Provincia findProvincia(Long id) {
		return ubigeoService.findProvincia(id);
	}
}
