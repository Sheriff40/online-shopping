package net.ssh.onlineshopping.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import net.ssh.shoppingbackend.dao.userDAO;
import net.ssh.shoppingbackend.dto.Address;
import net.ssh.shoppingbackend.dto.Cart;
import net.ssh.shoppingbackend.dto.RegisterModel;
import net.ssh.shoppingbackend.dto.User;

@Component
public class RegisterHandler {

	@Autowired
	userDAO dao;
	
	public RegisterModel init()
	{
		return new RegisterModel();
	}
	
	
	public void save(RegisterModel registerModel, User user)
	{
		registerModel.setUser(user);
	}
	
	public void save(RegisterModel registerModel, Address address)
	{
		registerModel.setAddress(address);
	}
	
	public String saveAll(RegisterModel registerModel)
	{
		String transitionMessage = "success";
		
			User user = registerModel.getUser();
			if(user.getRole().equals("USER"))
			{
				Cart cart = new Cart();
				cart.setUser(user);
				user.setCart(cart);
			}
			dao.addUser(user);
			
			Address add = registerModel.getAddress();
			add.setBilling(true);
			add.setUser(user);
			
			dao.addAddress(add);
		
		return transitionMessage;
			
		
	}
}
