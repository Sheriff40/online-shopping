package net.ssh.shoppingbackend.dao;

import java.util.List;

import net.ssh.shoppingbackend.dto.Product;

public interface productDAO {
	public List<Product> getProducts(); 
	public Product  getById(int id); 
	public boolean insert(Product product);
	public boolean update(Product product);
	public boolean delete(Product product);
	
	
	
	public List<Product> getActiveProducts();
	public List<Product> getProductsByCategory(int categoryId);
	public List<Product> getLatestActiveProduct(int count);
	
}
