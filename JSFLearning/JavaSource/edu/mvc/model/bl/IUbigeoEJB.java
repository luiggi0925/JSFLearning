package edu.mvc.model.bl;

import java.util.List;

import javax.ejb.Stateless;

import edu.mvc.model.entities.Departamento;
import edu.mvc.model.entities.Provincia;

@Stateless
public interface IUbigeoEJB {

	List<Departamento> findAllDepartamento();
	Departamento findDepartamento(Long id);
	Provincia findProvincia(Long id);
}
