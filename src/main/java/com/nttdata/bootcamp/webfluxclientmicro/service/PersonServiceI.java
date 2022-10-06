package com.nttdata.bootcamp.webfluxclientmicro.service;

import com.nttdata.bootcamp.webfluxclientmicro.model.Person;

import reactor.core.publisher.Flux;

public interface PersonServiceI {

	/**
	 * Método que realiza cuatro peticiones GET al servicio de Personas y recoge cuatro Flux de tipo persona con personas creadas y los unifica en un único flux.
	 * 
	 * @return Flux<Person>
	 */
	public Flux<Person> allPersons();
}
