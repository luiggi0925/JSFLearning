package edu.mvc.model.service;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;

import edu.mvc.model.entities.Departamento;
import edu.mvc.model.entities.Distrito;
import edu.mvc.model.entities.Provincia;

@Stateless
public class UbigeoService implements IUbigeoService {

	private static final List<Departamento> lstDepartamentoBD = new ArrayList<Departamento>();

	static {
		Departamento departamento;
		Provincia provincia;
		Distrito distrito;
		List<Provincia> lstProvincia;
		List<Distrito> lstDistrito;

		departamento = new Departamento();
		lstProvincia = new ArrayList<Provincia>();
		provincia = new Provincia();
		lstDistrito = new ArrayList<Distrito>();
		distrito = new Distrito();
		distrito.setId(1L);
		distrito.setNombreCorto("Lima");
		distrito.setDescripcion("Lima");
		lstDistrito.add(distrito);
		distrito = new Distrito();
		distrito.setId(2L);
		distrito.setNombreCorto("Ancon");
		distrito.setDescripcion("Ancon");
		lstDistrito.add(distrito);
		distrito = new Distrito();
		distrito.setId(3L);
		distrito.setNombreCorto("Lima");
		distrito.setDescripcion("Lima");
		lstDistrito.add(distrito);
		provincia.setId(1L);
		provincia.setNombreCorto("Lima");
		provincia.setDescripcion("Lima");
		provincia.setLstDistrito(lstDistrito);
		lstProvincia.add(provincia);

		provincia = new Provincia();
		lstDistrito = new ArrayList<Distrito>();
		distrito = new Distrito();
		distrito.setId(4L);
		distrito.setNombreCorto("Barranca");
		distrito.setDescripcion("Barranca");
		lstDistrito.add(distrito);
		distrito = new Distrito();
		distrito.setId(5L);
		distrito.setNombreCorto("Paramonga");
		distrito.setDescripcion("Paramonga");
		lstDistrito.add(distrito);
		provincia.setId(2L);
		provincia.setNombreCorto("Barranca");
		provincia.setDescripcion("Barranca");
		provincia.setLstDistrito(lstDistrito);
		lstProvincia.add(provincia);
		departamento.setId(1L);
		departamento.setNombreCorto("Lima");
		departamento.setDescripcion("Lima");
		departamento.setLstProvincia(lstProvincia);
		lstDepartamentoBD.add(departamento);



		departamento = new Departamento();
		lstProvincia = new ArrayList<Provincia>();
		provincia = new Provincia();
		lstDistrito = new ArrayList<Distrito>();
		distrito = new Distrito();
		distrito.setId(6L);
		distrito.setNombreCorto("San Juan");
		distrito.setDescripcion("San Juan");
		lstDistrito.add(distrito);
		distrito = new Distrito();
		distrito.setId(7L);
		distrito.setNombreCorto("Iquitos");
		distrito.setDescripcion("Iquitos");
		lstDistrito.add(distrito);
		provincia.setId(3L);
		provincia.setNombreCorto("Maynas");
		provincia.setDescripcion("Maynas");
		provincia.setLstDistrito(lstDistrito);
		lstProvincia.add(provincia);

		provincia = new Provincia();
		lstDistrito = new ArrayList<Distrito>();
		distrito = new Distrito();
		distrito.setId(8L);
		distrito.setNombreCorto("Balsapuerto");
		distrito.setDescripcion("Balsapuerto");
		lstDistrito.add(distrito);
		distrito = new Distrito();
		distrito.setId(9L);
		distrito.setNombreCorto("Yurimaguas");
		distrito.setDescripcion("Yurimaguas");
		lstDistrito.add(distrito);
		provincia.setId(4L);
		provincia.setNombreCorto("Alto Amazonas");
		provincia.setDescripcion("Alto Amazonas");
		provincia.setLstDistrito(lstDistrito);
		lstProvincia.add(provincia);
		departamento.setId(2L);
		departamento.setNombreCorto("Loreto");
		departamento.setDescripcion("Loreto");
		departamento.setLstProvincia(lstProvincia);
		lstDepartamentoBD.add(departamento);
	}

	@Override
	public List<Departamento> findAllDepartamento() {
		// TODO Auto-generated method stub
		return lstDepartamentoBD;
	}

	@Override
	public Departamento findDepartamento(Long id) {
		// TODO Auto-generated method stub
		for(Departamento departamento : lstDepartamentoBD) {
			if (departamento.getId().equals(id)) {
				return departamento;
			}
		}
		return null;
	}

	@Override
	public Provincia findProvincia(Long id) {
		for(Departamento departamento : lstDepartamentoBD) {
			for(Provincia provincia : departamento.getLstProvincia()) {
				if (provincia.getId().equals(id)) {
					return provincia;
				}
			}
		}
		return null;
	}
}
