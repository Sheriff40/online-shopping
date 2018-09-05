package net.ssh.onlineshopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import net.ssh.shoppingbackend.dao.CategoryDAO;
import net.ssh.shoppingbackend.dto.Category;

@Controller
public class pageController {

	@Autowired
	CategoryDAO dao;
	
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
	
}
