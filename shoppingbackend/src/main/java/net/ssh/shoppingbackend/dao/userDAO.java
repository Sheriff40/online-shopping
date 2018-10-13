package net.ssh.shoppingbackend.dao;

import java.util.List;

import net.ssh.shoppingbackend.dto.Address;
import net.ssh.shoppingbackend.dto.Cart;
import net.ssh.shoppingbackend.dto.User;

public interface userDAO {

	public boolean addUser(User user);
	public User getUserByEmail(String email);
	

	public boolean addAddress(Address address);
	
	public Address getBillingAddress(User user);
	public List<Address> getShippingAddress(User user);
}
