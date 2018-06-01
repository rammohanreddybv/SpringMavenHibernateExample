/**
 * 
 */
package org.jma.wireless.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author Needa-Con
 *
 */
@Controller
@PropertySource(value = { "classpath:application.properties" })
public class HomeController {
	
	@Value("${name}")
	private String personName;
	
	@RequestMapping("/home")
	public String Home(Model model) {
		System.out.println("Hello home-"+personName);
		model.addAttribute("greeting", "my Greeting");
		System.out.println(model);
		return "home";
	}
	
	@RequestMapping("/sdru")
	public String Sdru() {
		System.out.println("Hello SDRU");
		return "sdru";
	}
	
}
