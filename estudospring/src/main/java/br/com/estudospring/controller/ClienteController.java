package br.com.estudospring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Cliente cliente) {
		return new ModelAndView("clientes/view", "cliente", cliente);
	}
	
	@PostMapping(params="form")
	public ModelAndView adicionar(@Valid Cliente cliente, BindingResult result, RedirectAttributes redirect ) {
		if(result.hasErrors()) {
			return new ModelAndView(CLIENTE_URI + "form", "formErrors", result.getAllErrors());
		}
		repository.save(cliente);	
		if(cliente.getId() != null) {
			redirect.addFlashAttribute("globalMensagem", "Cliente alterado com sucesso");
		}
		else {
			redirect.addFlashAttribute("globalMensagem", "Cliente gravado com sucesso");
		}	
		//return new ModelAndView("redirect:/" + CLIENTE_URI + "novo");
		return new ModelAndView("redirect:/" + CLIENTE_URI + "{cliente.id}", "cliente.id" , cliente.getId());
	}
	
	@GetMapping("alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Cliente cliente) {
		return new ModelAndView("/clientes/form", "cliente", cliente);
	}
	
	@GetMapping("remover/{id}")
	public ModelAndView excluir(@PathVariable("id") Long id, RedirectAttributes rediretc) {
		repository.delete(id);
		rediretc.addAttribute("globalMensagem", "Cliente excluido com sucesso");
		List<Cliente> clientes = repository.findAll();
		ModelAndView modelAndView = new ModelAndView("clientes/lista", "clientes",  clientes);
		modelAndView.addObject("globalMensagem", "Cliente excluido com sucesso");
		return modelAndView;
	}
	
	@GetMapping
	public ModelAndView listar() {
		List<Cliente> clientes = repository.findAll();
		return new ModelAndView("clientes/lista", "clientes", clientes);
	}
	
	
}
