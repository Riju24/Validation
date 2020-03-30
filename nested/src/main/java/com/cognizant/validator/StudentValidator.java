package com.cognizant.validator;

import javax.xml.registry.infomodel.User;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.cognizant.model.Student;

@Component
public class StudentValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
			return Student.class.isAssignableFrom(clazz);
		
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		Student student = (Student)target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id","","Empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name","","Empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "course","","Empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.houseNo","","Empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address.city","","Empty");
		
		if(student.getAddress().getHouseNo()==0)
		{
			errors.rejectValue("address.houseNo","","Invalid");
		}
	
	}

}
