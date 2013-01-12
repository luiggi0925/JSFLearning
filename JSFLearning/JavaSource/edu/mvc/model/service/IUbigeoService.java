package edu.mvc.model.service;

import java.util.List;

import edu.mvc.model.entities.Departamento;
import edu.mvc.model.entities.Provincia;

public interface IUbigeoService {

	List<Departamento> findAllDepartamento();
	Departamento findDepartamento(Long id);
	Provincia findProvincia(Long id);
}
