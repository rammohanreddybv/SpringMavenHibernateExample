/**
 * 
 */
package org.jma.wireless.dto;

import org.jma.wireless.model.Person;

/**
 * @author Needa-Con
 *
 */
public class PersonDTO {

	private String name;
	private String email;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Person toPerson() {
		Person p = new Person();
		p.setName(name);
		p.setEmail(email);
		return p;
	}

	@Override
	public String toString() {
		return "PersonDTO [name=" + name + ", email=" + email + "]";
	}

}
