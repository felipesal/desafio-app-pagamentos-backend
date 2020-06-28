package com.picpay.users.services;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.picpay.users.domain.Consumer;
import com.picpay.users.domain.Seller;
import com.picpay.users.domain.Transaction;
import com.picpay.users.domain.User;
import com.picpay.users.domain.enums.Status;
import com.picpay.users.repositories.ConsumerRepository;
import com.picpay.users.repositories.SellerRepository;
import com.picpay.users.repositories.TransactionRepository;
import com.picpay.users.repositories.UserRepository;

@Service
public class DBService {
	
	@Autowired
    private UserRepository userRepository;
	
	@Autowired
	private ConsumerRepository consumerRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Autowired
	private TransactionRepository transactionRepository;

    public void instanciateTestDataBase() {
        

	User u1 = new User(null, "Ana Paula Carlesso", "12312312312", "999999999", "ana@gmail.com", "123abc");
    User u2 = new User(null, "Bruno da Silva", "23423423423", "8888888888", "bruno@gmail.com", "123abc");
    User u3 = new User(null, "Carla Perez de Castro", "34534534534", "777777777", "carla@gmail.com", "123abc");
    User u4 = new User(null,  "Daniel Almeida Conceição", "45645645645", "666666666", "daniel@gmail.com", "123abc");
    User u5 = new User(null, "Eduarda Santana de Jesus", "17117117117", "555555555", "eduarda@gmail.com", "123abc");
    User u6 = new User(null, "Fernando Fernandes" , "25325125215" , "444444444" , "fernando@gmail.com" , "123abc");
            
    Consumer c1 = new Consumer(null,u1, "aninha" );
    Consumer c2 = new Consumer(null, u2, "bruninho");
    Consumer c3 = new Consumer(null, u6, "nando");
    Consumer c4 = new Consumer(null, u5, "duda");
      
    u1.setConsumer(c1);
    u2.setConsumer(c2);
    u6.setConsumer(c3);
    u5.setConsumer(c4);
    
    consumerRepository.saveAll(Arrays.asList(c1, c2, c3, c4));
    
    
   // 
    
    Seller s1 = new Seller(null, u3, "Carla SA", "Carla Bijoux", "999999999999999", "carlabijoux");
    Seller s2 = new Seller(null, u4, "Daniel SA", "Dani Artes", "888888888888888", "danielartes");
    
    
    u3.setSeller(s1);
    u4.setSeller(s2);
   
    
    
    sellerRepository.saveAll(Arrays.asList(s1, s2));
    userRepository.saveAll(Arrays.asList(u1,u2,u3,u4, u5, u6));
    
    Transaction t1 = new Transaction(null, u1, u2, Status.SOLICITADO, 58.89);
    Transaction t2 = new Transaction(null, u2, u3, Status.SOLICITADO, 45.69);
    Transaction t3 = new Transaction(null, u5, u1, Status.SOLICITADO, 4.89);
    
    transactionRepository.saveAll(Arrays.asList(t1, t2, t3));
    
   
	
}
}
