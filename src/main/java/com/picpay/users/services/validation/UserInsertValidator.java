package com.picpay.users.services.validation;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.picpay.users.DTO.UserNewDTO;
import com.picpay.users.domain.User;
import com.picpay.users.repositories.UserRepository;
import com.picpay.users.resources.exceptions.FieldMessage;

public class UserInsertValidator implements ConstraintValidator<UserInsert, UserNewDTO> {
	
	
	
	@Autowired
	private UserRepository repo;
	
	@Override
	public void initialize(UserInsert ann) {
	}

	@Override
	public boolean isValid(UserNewDTO obj, ConstraintValidatorContext context) {
		List<FieldMessage> list = new ArrayList<>();
		// email is unique test
		User verificadorEmail = repo.findByEmail(obj.getEmail());
		
		// cpf is unique test
		User verificadorCpf = repo.findByCpf(obj.getCpf());
		
		if( verificadorEmail != null) {
			list.add(new FieldMessage("email", "Email já cadastrado"));
		}
		
		if(verificadorCpf != null) {
			list.add(new FieldMessage("cpf", "CPF já cadastrado na base de dados"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		
		return list.isEmpty();
	}
	
	
	
}
