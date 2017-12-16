package com.luantran.musicstore.validator;

import java.util.regex.Pattern;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.luantran.musicstore.model.Cart;
@Component
public class CheckoutValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Cart.class.equals(clazz);
	}

	@Override
	public void validate(Object c, Errors errors) {
		Pattern patternPhone = Pattern.compile("^[0-9]*$"); //only enter number 
		Pattern patternAdress = Pattern.compile("^[a-zA-Z0-9 ]*$");
		
		Cart cart = (Cart) c;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "NotEmpty");
		
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "NotEmpty");
		if(!(patternPhone.matcher(cart.getPhone()).matches())) {
       	 errors.rejectValue("phone","Phone.cart.invalid");
		}
	
   
		
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "NotEmpty");
		if(!(patternAdress).matcher(cart.getAddress()).matches()) {
			errors.rejectValue("address", "Address.cart.invalid");
		}

		
	}

}
