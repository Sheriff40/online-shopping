package net.ssh.onlineshopping.controller;

import java.io.Console;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import net.ssh.onlineshopping.util.multipartUtility;
import net.ssh.onlineshopping.util.validator;
import net.ssh.shoppingbackend.dao.CategoryDAO;
import net.ssh.shoppingbackend.dao.productDAO;
import net.ssh.shoppingbackend.dto.Category;
import net.ssh.shoppingbackend.dto.Product;

@Controller
@RequestMapping(value = "/manage")
public class manageController {

	@Autowired
	CategoryDAO dao;

	@Autowired
	productDAO productDAO;

	@RequestMapping(value = "/products", method = RequestMethod.GET)
	public ModelAndView manageProducts(@RequestParam(name = "operation", required = false) String operate) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("UserClickManageProducts", true);
		mv.addObject("title", "Manage Products");
		Product prod = new Product();
		prod.setActive(true);
		prod.setSupplierId(1);
		mv.addObject("product", prod);
		mv.addObject("category", dao.getCustomers());

		if (operate != null) {
			if (operate.equals("product")) {
				mv.addObject("message", "Successfully inserted the product");
			}
			if (operate.equals("category")) {
				mv.addObject("message", "Successfully inserted the product");
			}

		}

		return mv;
	}

	@ModelAttribute("cate")
	public Category getCategory() {
		return new Category();
	}

	@RequestMapping(value = "/edit/{id}/product", method = RequestMethod.GET)
	public ModelAndView editProducts(@PathVariable("id") int id) {
		ModelAndView mv = new ModelAndView("page");
		mv.addObject("UserClickManageProducts", true);
		mv.addObject("title", "Edit Products");
		Product prod = productDAO.getById(id);
		mv.addObject("product", prod);
		mv.addObject("category", dao.getCustomers());

		return mv;
	}

	@RequestMapping(value = "/products/save", method = RequestMethod.POST)
	public String manageProducts(@Valid @ModelAttribute("product") Product product, BindingResult results, Model model,
			HttpServletRequest request) {
		if (product.getId() == 0) {
			new validator().validate(product, results);
		} else {
			if (!product.getFile().getOriginalFilename().equals("")) {
				new validator().validate(product, results);
			}

		}

		if (results.hasErrors()) {
			model.addAttribute("UserClickManageProducts", true);
			model.addAttribute("title", "Manage Products");
			return "page";
		}

		if (product.getId() == 0) {
			productDAO.insert(product);
		} else {
			productDAO.update(product);
		}

		if (!product.getFile().getOriginalFilename().equals("")) {

			new multipartUtility().insertFile(product.getFile(), request, product.getCode());
		}

		return "redirect:/manage/products?operation=product";
	}

	@RequestMapping(value = "{id}/product/activation", method = RequestMethod.POST)
	@ResponseBody
	public String changeActiveProducts(@PathVariable("id") int id) {
		Product product = productDAO.getById(id);
		Boolean active = product.isActive();
		product.setActive(!active);
		productDAO.update(product);
		return ("Successfully completed the action");
	}

	@RequestMapping(value = "/category/save", method = RequestMethod.POST)
	public String saveCategory(@ModelAttribute("cate") Category ncategory) {

		dao.insert(ncategory);
		return "redirect:/manage/products?operation=category";

	}
}
