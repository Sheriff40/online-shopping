package net.ssh.onlineshopping.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import net.ssh.shoppingbackend.dao.productDAO;
import net.ssh.shoppingbackend.dto.Product;

@Controller
@RequestMapping(value = "/json/data")
public class jsonController {
	
	@Autowired
	productDAO dao;
	
	@RequestMapping(value = "/all/products")
	@ResponseBody
	public List<Product> getAll()
	{
		return dao.getActiveProducts();
	}
	
	@RequestMapping(value = "/admin/all/products")
	@ResponseBody
	public List<Product> getProductsForAdmin()
	{
		return dao.getProducts();
	}
	
	@RequestMapping(value = "/category/{id}/products")
	@ResponseBody
	public List<Product> getAll(@PathVariable("id")int id)
	{
		int cid = id;
		return dao.getProductsByCategory(cid);
	}
}
