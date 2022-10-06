package com.nttdata.bootcamp.webfluxclientmicro.service;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.nttdata.bootcamp.webfluxclientmicro.model.Person;

import reactor.core.publisher.Flux;

@Service
public class PersonServiceImpl implements PersonServiceI{

	public Flux<Person> allPersons(){
		
		WebClient webClient = WebClient.create("http://localhost:8080");
		Flux<Person> persons1 = webClient.get()
		        .uri("/person-list-1")
		        .retrieve()
		        .bodyToFlux(Person.class);
		
		Flux<Person> persons2 = webClient.get()
		        .uri("/person-list-2")
		        .retrieve()
		        .bodyToFlux(Person.class);
		
		Flux<Person> persons3 = webClient.get()
		        .uri("/person-list-3")
		        .retrieve()
		        .bodyToFlux(Person.class);
		
		Flux<Person> persons4 = webClient.get()
		        .uri("/person-list-4")
		        .retrieve()
		        .bodyToFlux(Person.class);
		
		Flux<Person> fullList = Flux.concat(persons1,persons2, persons3, persons4 );
	
		
		return fullList;
	}
}
