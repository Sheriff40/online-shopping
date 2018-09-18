package net.ssh.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.ssh.shoppingbackend.dao.CategoryDAO;
import net.ssh.shoppingbackend.dao.productDAO;
import net.ssh.shoppingbackend.dto.Category;
import net.ssh.shoppingbackend.dto.CustomException;
import net.ssh.shoppingbackend.dto.Product;

@Controller
public class pageController {

	@Autowired
	CategoryDAO dao;
	
	@Autowired
	productDAO productDAO;
	
	@RequestMapping(value = {"/","/home","/index"})
	public ModelAndView index()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","home");
		mv.addObject("UserClickHome",true);
		mv.addObject("categories",dao.getCustomers());
		return mv;
		
	}
	

	@RequestMapping(value = {"/about"})
	public ModelAndView about()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","about");
		mv.addObject("UserClickAbout",true);
		return mv;
		
	}
	
	@RequestMapping(value = {"/contact"})
	public ModelAndView contact()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","contact");
		mv.addObject("UserClickContact",true);
		return mv;
		
	}
	
	@RequestMapping(value = {"/show/all/products"})
	public ModelAndView showAll()
	{
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title","All products");
		mv.addObject("UserClickShowAll",true);
		mv.addObject("categories", dao.getCustomers());
		return mv;
	}
	
	@RequestMapping(value = {"/show/category/{id}/product"}) 
	public ModelAndView showIdProduct(@PathVariable("id")int id)
	{
		Category cat = dao.getById(id);
		
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("title",cat.getName());
		mv.addObject("UserClickIdProduct",true);
		mv.addObject("categories", dao.getCustomers());
		mv.addObject("category", dao.getById(id));
		return mv;
		
	}
	
	@RequestMapping(value = {"/show/{id}/product"})
	public ModelAndView getSingleProduct(@PathVariable("id")int id) throws CustomException
	{
		
		ModelAndView mv = new ModelAndView("page");
		
		/*UPDATE THE TOTAL VIEWS */
		
		Product product = productDAO.getById(id);
		if(product==null) throw new CustomException();
		product.setViews(product.getViews() + 1);
		productDAO.update(product);
		
		Product pd = productDAO.getById(id);
		mv.addObject("product", productDAO.getById(id));
		mv.addObject("title",pd.getName());
		mv.addObject("UserClickSingleProduct",true);
		return mv;
		
	}
	
}
