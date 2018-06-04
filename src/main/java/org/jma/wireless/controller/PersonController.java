/**
 * 
 */
package org.jma.wireless.controller;

import java.util.List;

import org.jma.wireless.dto.PersonDTO;
import org.jma.wireless.model.Person;
import org.jma.wireless.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Needa-Con
 *
 */
@RestController
// @RequestMapping("/person")
public class PersonController {

	@Autowired
	PersonService personService;

	@PostMapping(value = "/person", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody PersonDTO create(@RequestBody PersonDTO personDTO) {

		Person p = personService.create(personDTO);

		return personDTO.getPersonDTO(p);
	}

	@GetMapping("/person")
	public @ResponseBody List<PersonDTO> getAllPersons() {
		return personService.getAllPersons();
		
		
	}
	
	@GetMapping("/person/{id}")
	public @ResponseBody PersonDTO getPerson(@PathVariable("id") int id) {
		
		return personService.getPerson(id);
	}
	
	@PutMapping(value = "/person", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody PersonDTO updatePerson(@RequestBody Person person) {
		
		return personService.updatePerson(person);
		
	}
	
	@DeleteMapping("/person/{id}")
	public void deletePerson(@PathVariable("id") int id) {
		personService.deletePerson(id);
	}
}
