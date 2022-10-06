package com.nttdata.bootcamp.webfluxclientmicro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nttdata.bootcamp.webfluxclientmicro.model.Person;
import com.nttdata.bootcamp.webfluxclientmicro.service.PersonServiceImpl;

import reactor.core.publisher.Flux;

@Controller
public class PersonListController {

	/**Instancia del servicio */
	@Autowired
	PersonServiceImpl personService;
	
	/**
	 * Método que muestra el Flux de tipo Person recibido desde el servicio y lo muestra en una plantilla HTML.
	 * 
	 * @param model
	 * @return String
	 */
	@GetMapping("/person-list")
	public String personList(final Model model) {
		final Flux<Person> personList = personService.allPersons();
		model.addAttribute("personList", personList);
		return "personList";
	}
}
