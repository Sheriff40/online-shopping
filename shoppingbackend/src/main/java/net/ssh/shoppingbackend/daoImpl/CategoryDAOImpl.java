package net.ssh.shoppingbackend.daoImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import net.ssh.shoppingbackend.dao.CategoryDAO;
import net.ssh.shoppingbackend.dto.Category;


@Repository(value ="CategoryDAOImp")
public class CategoryDAOImpl implements CategoryDAO {

	public static List<Category> categories = new ArrayList<>();
	
	static {
		Category cat = new Category();
		cat.setId(1);
		cat.setName("Mobile");
		cat.setDescription("This is mobile");
		cat.setActive(true);
		
		categories.add(cat);
		
		Category cat2 = new Category();
		cat2.setId(2);
		cat2.setName("Telivision");
		cat2.setDescription("This is Telivision");
		cat2.setActive(true);
		categories.add(cat2);
		
		Category cat3 = new Category();
		cat3.setId(3);
		cat3.setName("Laptop");
		cat3.setDescription("This is Laptop");
		cat3.setActive(true);
		categories.add(cat3);
	}
	
	
	@Override
	public List<Category> getCustomers() {
		
		return categories;
	}


	@Override
	public Category getById(int id) {
		
		for(Category c: categories)
		{
			if(c.getId()==id)
			{
				return c;
			}
		}
		return null;
	}
	
}
