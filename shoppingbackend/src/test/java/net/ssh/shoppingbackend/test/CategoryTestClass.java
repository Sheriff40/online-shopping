package net.ssh.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.ssh.shoppingbackend.dao.CategoryDAO;
import net.ssh.shoppingbackend.dto.Category;

public class CategoryTestClass {

	private static AnnotationConfigApplicationContext context;
	
	
	private static CategoryDAO dao;
	
	private Category category;
	
	@BeforeClass
	public static void init()
	{
		context = new AnnotationConfigApplicationContext();
		context.scan("net.ssh.shoppingbackend");
		context.refresh();
		dao = (CategoryDAO)context.getBean("CategoryDAOImpl");

		
	}
	
	@Test
	public void TestCRUDCategory()
	{
		
		/* Add Data */
		category = new Category();
		category.setName("Radio");
		category.setDescription("This is radio");
		category.setImageURL("image/radio.png");
		assertEquals("Successfully inserted data into table",true,dao.insert(category));
		
		category = new Category();
		category.setName("Telivision");
		category.setDescription("This is telivision");
		category.setImageURL("image/radio.png");
		assertEquals("Successfully inserted data into table",true,dao.insert(category));
		
		/* Update Data */
		category = dao.getById(2);
		category.setName("TV");
		assertEquals("Successfuly fetched category by id",true,dao.update(category));
	
		
		/* Delete Data */
		category = dao.getById(2);
		assertEquals("Successfuly fetched category by id",true,dao.delete(category));
	
		/* List Data */
		assertEquals("Successfuly fetched all category",12,dao.getCustomers().size());
	}
}
