package br.com.estudospring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import br.com.estudospring.repository.PedidoRepository;

@Controller
@RequestMapping("pedidos/")
public class PedidoController {
	@Autowired
	private PedidoRepository repository;
	
	private static final String PEDIDO_URI = "pedidos/";
	
	
		
}
