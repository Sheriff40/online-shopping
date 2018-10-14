package net.ssh.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.ssh.shoppingbackend.dao.CartLineDAO;
import net.ssh.shoppingbackend.dao.productDAO;
import net.ssh.shoppingbackend.dao.userDAO;
import net.ssh.shoppingbackend.dto.Cart;
import net.ssh.shoppingbackend.dto.CartLine;
import net.ssh.shoppingbackend.dto.Product;
import net.ssh.shoppingbackend.dto.User;
public class cartLineTest {

	private static AnnotationConfigApplicationContext context;
	private static CartLineDAO lineDAO;
	private static userDAO userDAO;
	private static productDAO productDAO;
	private User user;
	private Product product;
	private Cart cart;
	private CartLine cartLine;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("net.ssh.shoppingbackend");
		context.refresh();
		
		lineDAO = (CartLineDAO) context.getBean("CartLineDAOImpl");
		userDAO = (userDAO) context.getBean("userDAOImpl");
		productDAO = (productDAO) context.getBean("ProductDAOImpl");
	}
	
	@Test
	public void addCartLine()
	{
		user = userDAO.getUserByEmail("pramod@gmail.com");
		
		cart = user.getCart();
		
		product = productDAO.getById(5);
		
		cartLine = new CartLine();
		cartLine.setCartId(cart.getId());
		cartLine.setProduct(product);
		cartLine.setBuyingPrice(product.getUnitPrice());
		cartLine.setProductCount(cartLine.getProductCount() + 1);
		cartLine.setTotal(cartLine.getProductCount() * product.getUnitPrice());
		cartLine.setAvailable(true);
	
		assertEquals("Wrong",true,lineDAO.insert(cartLine));
		
		cart.setCartLine(cart.getCartLine() + 1);
		cart.setGrandTotal(cart.getGrandTotal() + cartLine.getTotal());
		
		assertEquals("wrong",true,lineDAO.updateCart(cart)); 
		
		assertEquals("wrong",2, lineDAO.getByCartId(cart.getId()).size());
		
	}
	
	
}
