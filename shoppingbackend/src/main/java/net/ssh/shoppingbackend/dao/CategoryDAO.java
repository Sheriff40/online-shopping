package net.ssh.shoppingbackend.dao;


import java.util.List;

import net.ssh.shoppingbackend.dto.Category;

public interface CategoryDAO {

	public List<Category> getCustomers(); 
	public Category  getById(int id); 
	public boolean insert(Category category);
	public boolean update(Category category);
	public boolean delete(Category category);
}
