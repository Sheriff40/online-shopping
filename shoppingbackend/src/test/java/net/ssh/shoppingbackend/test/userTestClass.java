package net.ssh.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.ssh.shoppingbackend.dao.userDAO;
import net.ssh.shoppingbackend.dto.Address;
import net.ssh.shoppingbackend.dto.Cart;
import net.ssh.shoppingbackend.dto.User;

public class userTestClass {

	private static AnnotationConfigApplicationContext context;
	private static userDAO dao;
	private User user;
	private Cart cart;
	private Address address;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.ssh.shoppingbackend");
		context.refresh();
		dao = (userDAO) context.getBean("userDAOImpl");

	}

	@Test
	public void userTest() {
		/*
		 user = new User(); user.setFirstName("Sheriff"); user.setLastName("Hussain");
		 user.setEmail("sheriff@gmail.com"); user.setContactNumber("442284");
		 user.setRole("ADMIN"); user.setPassword("123123");
		  
		 cart = new Cart();
		 cart.setCartLine(3); cart.setGrandTotal(50000); cart.setUser(user);
		 user.setCart(cart);
		 assertEquals("Can't insert user",true,dao.addUser(user));
		 address = new Address(); address.setUserId(user.getId());
		 address.setAddressLineOne("Budhanilhanta-5");
		 address.setAddressLineTwo("Hadiigaoun-5"); address.setCity("Kathmandu");
		 address.setCountry("Nepal"); address.setPostalCode("1234");
		 address.setBilling(true);
		 assertEquals("Can't inser user",true,dao.addAddress(address));
		 address = new Address(); address.setUserId(user.getId());
		 address.setAddressLineOne("Budhanilhanta- 10");
		 address.setAddressLineTwo("Yolo-5"); address.setCity("Kathmandu");
		 address.setCountry("Nepal"); address.setPostalCode("1235");
		 address.setShipping(true);
		 assertEquals("Can't insert user",true,dao.addAddress(address));
		 user = dao.getUserByEmail("sheriff@gmail.com");
		 cart = user.getCart();
		 cart.setCartLine(20); cart.setGrandTotal(60000);
		  dao.updateCart(cart);
		 */

		/*user = new User();
		user.setFirstName("Uttsikha");
		user.setLastName("Adhikari");
		user.setEmail("uttu@gmail.com");
		user.setContactNumber("552284");
		user.setRole("USER");
		user.setPassword("123123");

		
		
		

		address = new Address();
		address.setAddressLineOne("Kumaripati-5");
		address.setAddressLineTwo("Lalitpur-5");
		address.setCity("Lalitpur");
		address.setCountry("Nepal");
		address.setPostalCode("5432");
		address.setBilling(true);
		address.setUser(user);*/

		
		/*user = new User();
		user.setFirstName("Uttsikha");
		user.setLastName("Adhikari");
		user.setEmail("uttu@gmail.com");
		user.setContactNumber("552284");
		user.setRole("USER");
		user.setPassword("123123");
		
		
		address = new Address();
		address.setAddressLineOne("Kumaripati- 6");
		address.setAddressLineTwo("Kupandol-5");
		address.setCity("Lalitpur");
		address.setCountry("Nepal");
		address.setPostalCode("1235");
		address.setShipping(true);
		address.setUser(user);
		
		user.getAddress().add(address); */
		
		/*
		
		address = new Address();
		address.setAddressLineOne("YOLO- 10");
		address.setAddressLineTwo("SOLO-10");
		address.setCity("Lalitpur");
		address.setCountry("Nepal");
		address.setPostalCode("54321");
		address.setShipping(true);
		address.setUser(user);
		
		
		assertEquals("Can't insert user", true, dao.addAddress(address));

		address = new Address();
		address.setAddressLineOne("Kumaripati- 10");
		address.setAddressLineTwo("Kupondol-10");
		address.setCity("Lalitpur");
		address.setCountry("Nepal");
		address.setPostalCode("09999");
		address.setBilling(true);
		address.setUser(user);
		
		
		assertEquals("Can't insert user", true, dao.addAddress(address)); */
		
		/*user = new User();
		user.setFirstName("Uttsikha");
		user.setLastName("Adhikari");
		user.setEmail("uttu@gmail.com");
		user.setContactNumber("552284");
		user.setRole("USER");
		user.setPassword("123123");
	
		
		address = new Address();
		address.setAddressLineOne("YOLO- 10");
		address.setAddressLineTwo("SOLO-10");
		address.setCity("Lalitpur");
		address.setCountry("Nepal");
		address.setPostalCode("54321");
		address.setShipping(true);
		address.setUser(user);
		user.getAddress().add(address);
		
		address = new Address();
		address.setAddressLineOne("Kumaripati- 6");
		address.setAddressLineTwo("Kupandol-5");
		address.setCity("Lalitpur");
		address.setCountry("Nepal");
		address.setPostalCode("1235");
		address.setShipping(true);
		address.setUser(user);
		user.getAddress().add(address);
		
		address = new Address();
		address.setAddressLineOne("Kumaripati- 10");
		address.setAddressLineTwo("Kupondol-10");
		address.setCity("Lalitpur");
		address.setCountry("Nepal");
		address.setPostalCode("09999");
		address.setBilling(true);
		address.setUser(user);
		user.getAddress().add(address);
		
		
		assertEquals("Can't insert user",true,dao.addUser(user)); */
		
		/*user = dao.getUserByEmail("uttu@gmail.com");
		
		assertEquals("Wrong number",2,dao.getShippingAddress(user).size());
		
		assertEquals("Wrong number","Lalitpur",dao.getBillingAddress(user).getCity());*/
		
	
	}
	
	

}
