package br.com.estudospring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/ambiente")
public class AmbienteController {
	
	@GetMapping
	public String ambiente() {
		return "ambiente";
	}
	
	
	
	
}
