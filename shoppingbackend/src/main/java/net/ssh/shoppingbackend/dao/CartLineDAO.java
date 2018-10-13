package net.ssh.shoppingbackend.dao;

import java.util.List;

import net.ssh.shoppingbackend.dto.Cart;
import net.ssh.shoppingbackend.dto.CartLine;

public interface CartLineDAO {

	public boolean insert(CartLine cartLine);
	public boolean update(CartLine cartLine);
	public CartLine getById(int id);
	public List<CartLine> getCartLine();
	public boolean updateCart(Cart cart);
	
	/* Extra methods */
	public List<CartLine> getAvailableLine();
	public CartLine getByProductAndCartId(int cartId, int productId);
	public List<CartLine> getByCartId(int cartId);


	
}
