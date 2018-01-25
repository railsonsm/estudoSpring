package br.com.estudospring.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.estudospring.models.Item;
import br.com.estudospring.repository.ItemRepository;

@Controller
@RequestMapping("/itens")
public class ItensController {
	@Autowired
	private ItemRepository repository;
	
	private final String ITEM_URI = "itens/";
	
	@RequestMapping("/novo")
	public String novo(@ModelAttribute Item item) {
		return ITEM_URI +"form";
	}
	
	@PostMapping(params="form")
	public ModelAndView adicionar(@Valid Item item, BindingResult result, RedirectAttributes request) {
		if(result.hasErrors()) {
			return new ModelAndView(ITEM_URI + "form", "formErrors", result.getAllErrors());
		}
		repository.save(item);
		return new ModelAndView("redirect:/itens/{item.id}", "item.id", item.getId());
	}
	
	@GetMapping("{id}")
	public ModelAndView view(@PathVariable("id") Item item) {
		return new ModelAndView("itens/view", "item", item);
	}
	
	@GetMapping("alterar/{id}")
	public ModelAndView alterar(@PathVariable("id") Item item, RedirectAttributes rediretc) {
		return new ModelAndView("/itens/form", "item", item);
	}
	
	@GetMapping("remover/{id}")
	public ModelAndView remover(@PathVariable("id") Long id) {
		repository.delete(id);
		return new ModelAndView("redirect:/itens");
	}
	
	@GetMapping
	public ModelAndView listar() {
		List<Item> itens = repository.findAll();
		return new ModelAndView("itens/lista", "itens", itens);
	}
	
}
