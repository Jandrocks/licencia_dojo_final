package com.alemeza.licencia.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alemeza.licencia.models.License;
import com.alemeza.licencia.models.Person;
import com.alemeza.licencia.repositories.LicenseRepo;
import com.alemeza.licencia.repositories.PersonaRepo;

@Service
public class MainService {

	@Autowired
	private PersonaRepo personaRepo;
	@Autowired
	private LicenseRepo licenseRepo;
	
	
	/// CRUD Personas
	public Person getPersona(Long id) {
		return personaRepo.findById(id).orElse(null);
	}
	
	public Person crearPersona(Person persona) {
		return personaRepo.save(persona);
	}
	
	public List<Person> todosUsuario(){
		return personaRepo.findAll();
	}
	// OBTENER NO LICENCIADOS
	public List<Person> obtenerNoLicenciados(){
		return personaRepo.findByNoLicense();
	}
	public List<Person> obtenerNoLicenciadosJPA(){
		return personaRepo.findByLicenseIdIsNull();
	}
	
	
	
	//CRUD Licencias
	public License crearLicencia(License licencia) {
//		System.out.println(this.generarNumeroLic());
		licencia.setNumero(this.generarNumeroLic());
		return licenseRepo.save(licencia);
	}
	
	public int generarNumeroLic() {
		License lic = licenseRepo.findTopByOrderByNumeroDesc();
//		if(lic.getNumero() == null)
		if(lic == null ) {
			return 1;
		}
		int numeroMayor = lic.getNumero();
		numeroMayor++;

		return numeroMayor;
	}
	
	
}