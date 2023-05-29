package com.alemeza.licencia.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.alemeza.licencia.models.License;
import com.alemeza.licencia.models.Person;
import com.alemeza.licencia.services.MainService;

import jakarta.validation.Valid;

@Controller
public class MainController {
	
	@Autowired
	private MainService mainService;
	
	
	@GetMapping("/")
	public String raiz(Model viewModel) {
		List<Person> todos = mainService.todosUsuario();
		viewModel.addAttribute("todos", todos);
		return "index.jsp";
	}
	
	@GetMapping("/{idUsuario}")
	public String mostrarUser(@PathVariable("idUsuario") Long id, Model viewModel) {
		viewModel.addAttribute("persona",mainService.getPersona(id));
		return "mostrar.jsp";
	}
	
	// RUTAS PERSONA
	@GetMapping("/persons/new")
	public String formularioPersona(@ModelAttribute("persona") Person persona) {
		return "nuevaPersona.jsp";
	}
	
	@PostMapping("/persons/new")
	public String crearPersona(@Valid @ModelAttribute("persona") Person persona, BindingResult resultado) {
		if(resultado.hasErrors()) {
			return "nuevaPersona.jsp";
		}
//		Person nuevaPerson = mainService.crearPersona(persona);
//		System.out.println(nuevaPerson.getApellido());
		mainService.crearPersona(persona);
		return "redirect:/";
	}
	
	//RUTAS LICENCIA
	@GetMapping("/licenses/new")
	public String formularioLicencia(@ModelAttribute("licencia") License licencia, 
			Model viewModel) {
//		List<Person> usuario = mainService.todosUsuario();
//		viewModel.addAttribute("personas", usuario);	
		List<Person> usuariosSinLicencia = mainService.obtenerNoLicenciadosJPA();
		viewModel.addAttribute("personas", usuariosSinLicencia);
		return "nuevaLicencia.jsp";
	}
	@PostMapping("/licenses/new")
	public String crearLicencia(@Valid @ModelAttribute("licencia") License licencia,
			BindingResult resultado, Model viewModel) {
		if(resultado.hasErrors()) {
			viewModel.addAttribute("personas", mainService.obtenerNoLicenciadosJPA());
			return "nuevaLicencia.jsp";
		}
		mainService.crearLicencia(licencia);
		return "redirect:/";
	}

}