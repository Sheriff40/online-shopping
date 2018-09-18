package net.ssh.onlineshopping.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.NoHandlerFoundException;

import net.ssh.shoppingbackend.dto.CustomException;

@ControllerAdvice
public class GlobalDefaultExceptionHandler {

	@ExceptionHandler(NoHandlerFoundException.class)
			
		public ModelAndView handlerNotFoundHandler()
		{
			ModelAndView mv = new ModelAndView("error");
			mv.addObject("errorTitle","Page Not Found");
			mv.addObject("errorDescription","The following page does not exist!!!");
			mv.addObject("title","404 Error: Not Found");
			return mv;
		}
	
	@ExceptionHandler(CustomException.class)
	public ModelAndView CustomException()
	{
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "Object does not Exist");
		mv.addObject("errorDescription","The following object does not exist!!!");
		mv.addObject("title","Object Not Found");
		return mv;
	}
	
	@ExceptionHandler(Exception.class)
	public ModelAndView Exception()
	{
		ModelAndView mv = new ModelAndView("error");
		mv.addObject("errorTitle", "The Object you searched for does not Exist");
		mv.addObject("errorDescription","The following object id does not exist!!!");
		mv.addObject("title","Bad Request");
		return mv;
	}
}
