/**
 * 
 */
package org.jma.wireless.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Needa-Con
 *
 */
@RestController
public class HomeController2 {
	


	@RequestMapping("/home2")
	public String Home() {
		System.out.println("Hello home");
		return "home2";
	}
	
	@RequestMapping("/sdru2")
	public String Sdru() {
		System.out.println("Hello SDRU");
		return "sdru2";
	}
	
	


}
