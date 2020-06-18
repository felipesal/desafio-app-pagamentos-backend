package com.picpay.users;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.picpay.users.domain.Consumer;
import com.picpay.users.domain.Seller;
import com.picpay.users.domain.User;
import com.picpay.users.repositories.ConsumerRepository;
import com.picpay.users.repositories.SellerRepository;
import com.picpay.users.repositories.UserRepository;

@SpringBootApplication
public class UsersApplication implements CommandLineRunner{
	
	public static void main(String[] args) {
		SpringApplication.run(UsersApplication.class, args);
      
    }

	@Override
	public void run(String... args) throws Exception {
		
	 
		
	}

	}
