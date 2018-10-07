package net.ssh.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.ssh.shoppingbackend.dao.productDAO;
import net.ssh.shoppingbackend.dto.Product;

public class productTestClass {
	
	private static AnnotationConfigApplicationContext context;
	
	private static productDAO dao;
	
	private Product product;
	
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("net.ssh.shoppingbackend");
		context.refresh();
		
		dao = (productDAO)context.getBean("ProductDAOImpl");
	}
	
	
	@Test
	public void TestCRUD()
	{
		
		product = new Product();
		product.setName("iPhone 5s");
		product.setBrand("Apple");
		product.setDescription("This is one of the best phone available in the market right now");
		product.setUnitPrice(35000);
		product.setQuantity(5);
		product.setActive(true);
		product.setCategoryId(5);
		product.setSupplierId(2);
		 
		assertEquals("Could not insert",true,dao.insert(product));
		
		
		product = new Product();
		product.setName("Oppo F5");
		product.setBrand("Oppo");
		product.setDescription("This is one of the cheapest phone available in the market right now");
		product.setUnitPrice(15000);
		product.setQuantity(3);
		product.setActive(true);
		product.setCategoryId(5);
		product.setSupplierId(2);
		 
		assertEquals("Could not insert",true,dao.insert(product));
		
		product = new Product();
		product.setName("Dell i5");
		product.setBrand("Dell");
		product.setDescription("i5 4GB dell i5 laptop");
		product.setUnitPrice(50000);
		product.setQuantity(5);
		product.setActive(true);
		product.setCategoryId(1);
		product.setSupplierId(2);
		 
		assertEquals("Could not insert",true,dao.insert(product));
		 
		product = new Product();
		product.setName("MacBook Pro");
		product.setBrand("Apple");
		product.setDescription("i5 4GB dell i5 laptop");
		product.setUnitPrice(70000);
		product.setQuantity(2);
		product.setActive(true);
		product.setCategoryId(3);
		product.setSupplierId(2);
		 
		assertEquals("Could not insert",true,dao.insert(product));
		
		product = new Product();
		product.setName("Samsung HD");
		product.setBrand("Samsung");
		product.setDescription("This is full HD 24'inch TV");
		product.setUnitPrice(40000);
		product.setQuantity(0);
		product.setActive(true);
		product.setCategoryId(1);
		product.setSupplierId(2);
		 
		assertEquals("Could not insert",true,dao.insert(product));
		
		product = new Product();
		product.setName("Bravo Full HD");
		product.setBrand("Braviria");
		product.setDescription("This is full HD 54'inch TV");
		product.setUnitPrice(70000);
		product.setQuantity(5);
		product.setActive(true);
		product.setCategoryId(1);
		product.setSupplierId(1);
		 
		assertEquals("Could not insert",true,dao.insert(product));
		
		
		
		/*product = dao.getById(2);
		product.setName("Oppo F5");
		assertEquals("Could not insert",true,dao.update(product));
		
		
		product = dao.getById(2);
		
		assertEquals("Could not insert",true,dao.delete(product));
		
		assertEquals("Updated data",2,dao.getProducts().size()); 
		
		assertEquals("Updated data",1,dao.getActiveProducts().size()); 
		
		assertEquals("Updated data",1,dao.getProductsByCategory(3).size()); 
		
		assertEquals("Updated data",1,dao.getLatestActiveProduct(1).size()); */ 
	}
}
