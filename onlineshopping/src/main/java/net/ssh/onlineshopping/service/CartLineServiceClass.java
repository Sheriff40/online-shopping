package net.ssh.onlineshopping.service;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ssh.shoppingbackend.dao.CartLineDAO;
import net.ssh.shoppingbackend.dto.Cart;
import net.ssh.shoppingbackend.dto.CartLine;
import net.ssh.shoppingbackend.dto.Product;
import net.ssh.shoppingbackend.dto.UserModel;

@Service(value = "cartService")
public class CartLineServiceClass {

	@Autowired
	private HttpSession session;
	
	@Autowired
	private CartLineDAO lineDAO;
	
	
	
	public Cart getCart()
	{
		return ((UserModel) session.getAttribute("userModel")).getCart();
	}
	
	public List<CartLine> getCartLine()
	{
		return lineDAO.getByCartId(this.getCart().getId());		
	}
	
	
	public String updateCartLine(int id, int count)
	{
		CartLine cartLine = lineDAO.getById(id);
		
		if(cartLine == null)
		{
			return "false";
		}
		else
		{
			Product product = cartLine.getProduct();
			double oldTotal = cartLine.getTotal();
			cartLine.setProductCount(count);
			cartLine.setTotal(product.getUnitPrice() * count);
			lineDAO.update(cartLine);
			
			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
			lineDAO.updateCart(cart);
			
			return "true";
		}
		
		
		
	}
}
