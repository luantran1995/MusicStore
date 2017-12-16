package com.luantran.musicstore.validator;

import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.luantran.musicstore.model.Users;
import com.luantran.musicstore.service.UserService;

@Component

public class UserValidator implements Validator {

	@Autowired
    private UserService userService;
	

	@Override
	public boolean supports(Class<?> aClass) {

		return Users.class.equals(aClass);
	}

	@Override
	public void validate(Object b, Errors errors) {

		Users user = (Users) b;
		Pattern pattern = Pattern.compile("/\\b[A-Z0-9._%+-]+@(?:[A-Z0-9-]+\\.)+[A-Z]{2,6}\\b/i",  Pattern.CASE_INSENSITIVE);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "NotEmpty");
		if (user.getEmail().length() < 6 || user.getEmail().length() > 32) {
			errors.rejectValue("email", "Size.userForm.email");
		}
		System.out.println("validate");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "NotEmpty");
        if (user.getPassword().length() < 8 || user.getPassword().length() > 32) {
            errors.rejectValue("password", "Size.userForm.password");
        }
        if(userService.findByUsername(user.getEmail())!=null) {
        	errors.rejectValue("email", "Duplicate.userForm.email");
        }
         if(!(pattern.matcher(user.getEmail()).matches())) {
        	 errors.rejectValue("email", "user.email.invalid");
         }
        
        if (!user.getPasswordConfirm().equals(user.getPassword())) {
            errors.rejectValue("passwordConfirm", "Diff.userForm.passwordConfirm");
        }

	}

}
