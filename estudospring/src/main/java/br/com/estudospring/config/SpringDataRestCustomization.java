package br.com.estudospring.config;

import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

import br.com.estudospring.models.Item;
import br.com.estudospring.repository.ClienteRepository;

public class SpringDataRestCustomization extends RepositoryRestConfigurerAdapter{
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Item.class, ClienteRepository.class);
	}
}
