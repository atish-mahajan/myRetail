package com.target.myretailrestapi.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.target.myretailrestapi.model.Product;

@Configuration
public class MongoConfiguration implements RepositoryRestConfigurer {
	@Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Product.class);
	}

}
