package net.ssh.onlineshopping.service;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.ssh.shoppingbackend.dao.CartLineDAO;
import net.ssh.shoppingbackend.dao.productDAO;
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

	@Autowired
	private productDAO dao;

	public Cart getCart() {
		return ((UserModel) session.getAttribute("userModel")).getCart();
	}

	public List<CartLine> getCartLine() {
		return lineDAO.getByCartId(this.getCart().getId());
	}

	public String updateCartLine(int id, int count) {
		CartLine cartLine = lineDAO.getById(id);

		if (cartLine == null) {
			return "result=false";
		} else {
			Product product = cartLine.getProduct();
			double oldTotal = cartLine.getTotal();
			if (product.getQuantity() < count) 
			{
				cartLine.setProductCount(product.getQuantity());
				return "result=maximum";
			} 
			else 
			{
			
			cartLine.setProductCount(count);

			}
			cartLine.setTotal(product.getUnitPrice() * cartLine.getProductCount());
			lineDAO.update(cartLine);

			Cart cart = this.getCart();
			cart.setGrandTotal(cart.getGrandTotal() - oldTotal + cartLine.getTotal());
			lineDAO.updateCart(cart);

			return "result=true";
		}

	}

	public String deleteCartLine(int id) {

		CartLine cartline = lineDAO.getById(id);

		if (cartline == null) {
			return "result=false";
		} else {
			/* Update CART */
			Cart cart = this.getCart();
			cart.setCartLine(cart.getCartLine() - 1);
			cart.setGrandTotal(cart.getGrandTotal() - cartline.getTotal());
			lineDAO.updateCart(cart);
			lineDAO.delete(id);
			return "result=true";
		}

	}

	public String addCartLine(int id) {

		Product product = dao.getById(id);
		Cart cart = this.getCart();
		CartLine cartLine = lineDAO.getByProductAndCartId(cart.getId(), product.getId());
		if (cartLine == null) {
			cartLine = new CartLine();
			cartLine.setCartId(cart.getId());
			cartLine.setProduct(product);
			cartLine.setBuyingPrice(product.getUnitPrice());
			cartLine.setProductCount(1);
			cartLine.setTotal(product.getUnitPrice());
			cartLine.setAvailable(true);
			lineDAO.insert(cartLine);

			/* Updating Cart */
			cart.setCartLine(cart.getCartLine() + 1);
			cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
			lineDAO.updateCart(cart);

			return "result=true";
		} else {
			String response;
			int count = cartLine.getProductCount();
			if(count >= 3)
			{
				response =  "result=range";
			}
			else
			{
				response = this.updateCartLine(cartLine.getId(), cartLine.getProductCount() + 1);	
				
			}
			
			return response;
		}
		

	}
}
