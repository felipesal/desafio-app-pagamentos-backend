package com.picpay.users.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.picpay.users.services.DBService;

@Configuration
@Profile("test")
public class TestConfig {
	
	@Autowired
	private DBService service;

	@Bean
	public boolean instanciateDataBase() {
		
		service.instanciateTestDataBase();
		
		return true;
	}
	
}
