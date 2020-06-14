package com.picpay.users.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.picpay.users.DTO.ConsumerNewDTO;
import com.picpay.users.domain.Consumer;
import com.picpay.users.domain.Seller;
import com.picpay.users.repositories.ConsumerRepository;
import com.picpay.users.repositories.SellerRepository;
import com.picpay.users.resources.exceptions.FieldMessage;

public class ConsumerInsertValidator implements ConstraintValidator<ConsumerInsert, ConsumerNewDTO> {

	@Autowired
	private ConsumerRepository consumerRepository;
	
	@Autowired
	private SellerRepository sellerRepository;
	
	@Override
	public boolean isValid(ConsumerNewDTO obj, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		
		// username is unique test
		
		Seller verificadorSeller = sellerRepository.findByUsername(obj.getUsername());
		
		Consumer verificadorConsumer = consumerRepository.findByUsername(obj.getUsername());
		
		if(verificadorSeller != null || verificadorConsumer != null) {
			list.add(new FieldMessage("username", "Username já utilizado"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		
		return list.isEmpty();
	}
	
}
