package br.com.estudospring.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.estudospring.models.Cliente;
import br.com.estudospring.repository.ClienteRepository;


@Controller
@RequestMapping("/clientes")
public class ClienteController {

	private final ClienteRepository repository;
	private final String CLIENTE_URI = "clientes/";

	public ClienteController(ClienteRepository clienteRepository) {
		this.repository = clienteRepository;
	}
	
	@RequestMapping("/novo")
	public String createForm(@ModelAttribute Cliente cliente) {
		return CLIENTE_URI + "form";
	}
	
	@PostMapping(params="form")
	public ModelAndView adicionar(@Valid Cliente cliente, BindingResult result, RedirectAttributes redirect ) {
		if(result.hasErrors()) {
			return new ModelAndView(CLIENTE_URI + "form", "formErrors", result.getAllErrors());
		}
		cliente = repository.save(cliente);
		redirect.addFlashAttribute("globalMensagem", "Cliente gravado com sucesso");
		return new ModelAndView("redirect:/" + CLIENTE_URI + "novo");
		//return new ModelAndView("redirect:/" + CLIENTE_URI , "cliente.id" , cliente.getId());
	}
}
