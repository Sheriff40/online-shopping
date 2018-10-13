package net.ssh.onlineshopping.service;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ssh.shoppingbackend.dao.CartLineDAO;
import net.ssh.shoppingbackend.dto.Cart;
import net.ssh.shoppingbackend.dto.CartLine;
import net.ssh.shoppingbackend.dto.UserModel;

@Service(value = "cartService")
public class CartLineServiceClass {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private CartLineDAO linedao;
	
	
	
	public Cart getCart()
	{
		return ((UserModel) session.getAttribute("userModel")).getCart();
	}
	
	public List<CartLine> getCartLine()
	{
		return linedao.getByCartId(this.getCart().getId());		
	}
	
}
