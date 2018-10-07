package net.ssh.onlineshopping.handler;

import org.springframework.stereotype.Component;

import net.ssh.shoppingbackend.dto.Address;
import net.ssh.shoppingbackend.dto.RegisterModel;
import net.ssh.shoppingbackend.dto.User;

@Component
public class RegisterHandler {

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
}
