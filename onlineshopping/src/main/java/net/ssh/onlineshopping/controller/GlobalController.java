package net.ssh.onlineshopping.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import net.ssh.shoppingbackend.dao.userDAO;
import net.ssh.shoppingbackend.dto.User;
import net.ssh.shoppingbackend.dto.UserModel;

@ControllerAdvice
public class GlobalController {
	
	@Autowired
	private HttpSession session;
	
	private UserModel userModel = null;
	
	@Autowired
	private userDAO dao;
	
	@ModelAttribute(name="userModel")
	public UserModel getUserModel()
	{
		if(session.getAttribute("userModel")==null)
		{
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			User user = dao.getUserByEmail(auth.getName());
			if (user!=null)
			{
				userModel = new UserModel();
				userModel.setId(user.getId());
				userModel.setFullName(user.getFirstName() + " " + user.getLastName());
				userModel.setRole(user.getRole());
				userModel.setEmail(user.getEmail());
				if(userModel.getRole().equals("USER"))
				{
					userModel.setCart(user.getCart());
				}
				session.setAttribute("userModel", userModel);
				return userModel;
			}
			
		}
		return (UserModel)session.getAttribute("userModel");
	}
	
}
