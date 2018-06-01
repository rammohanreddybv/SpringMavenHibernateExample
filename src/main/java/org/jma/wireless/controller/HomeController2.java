/**
 * 
 */
package org.jma.wireless.controller;


import org.jma.wireless.service.DBServiceProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Needa-Con
 *
 */
@RestController
public class HomeController2 {
	
	@Autowired
	DBServiceProvider dBServiceProvider;

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
	
	@RequestMapping("/populate")
	public String populate() {
		System.out.println("This is Populate method");
		return dBServiceProvider.populate();		
	}
	
	@RequestMapping("/test")
	public String test() {
		System.out.println("This is Test method");
		return dBServiceProvider.test();		
	}


}
