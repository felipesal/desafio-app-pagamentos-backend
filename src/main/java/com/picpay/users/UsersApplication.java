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
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private ConsumerRepository consumerRepository;
	
	@Autowired
	private SellerRepository sellerRepository;

    public static void main(String[] args) {
        SpringApplication.run(UsersApplication.class, args);
        
    }

	@Override
	public void run(String... args) throws Exception {
		
		
		
		
		User u1 = new User(null, "Ana", "12312312312", "999999999", "ana@gmail.com", "123abc");
        User u2 = new User(null, "Bruno", "23423423423", "8888888888", "bruno@gmail.com", "123abc");
        User u3 = new User(null, "Carla", "34534534534", "777777777", "carla@gmail.com", "123abc");
        User u4 = new User(null,  "Daniel", "45645645645", "666666666", "daniel@gmail.com", "123abc");
        
                
        Consumer c1 = new Consumer(null,u1, "aninha" );
        Consumer c2 = new Consumer(null, u2, "bruninho");
          
        u1.setConsumer(c1);
        u2.setConsumer(c2);
        
        consumerRepository.saveAll(Arrays.asList(c1));
        
        
       // 
        
        Seller s1 = new Seller(null, u3, "Carla SA", "Carla Bijoux", "999999999999999", "carlabijoux");
        Seller s2 = new Seller(null, u4, "Daniel SA", "Dani Artes", "888888888888888", "danielartes");
        
        u3.setSeller(s1);
        u4.setSeller(s2);
        
        
        sellerRepository.saveAll(Arrays.asList(s1, s2));
        userRepository.saveAll(Arrays.asList(u1,u2,u3,u4));
        
        
		
	}

}
