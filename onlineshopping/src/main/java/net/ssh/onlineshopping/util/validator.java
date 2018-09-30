package net.ssh.onlineshopping.util;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import net.ssh.shoppingbackend.dto.Product;

public class validator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		
		return Product.class.equals(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		
		Product product = (Product)target;
		
		if(product.getFile().getOriginalFilename().equals("") || product.getFile()==null)
		{
			errors.rejectValue("file", null, "Please insert and image");
			return;
		}
		
		if(!(product.getFile().getContentType().equals("image/png")||
				product.getFile().getContentType().equals("image/jpg")||
						product.getFile().getContentType().equals("image/jpeg")))
						{
							errors.rejectValue("file", null, "The file must be a jpeg or png file");
							return;
						}

	}

}
