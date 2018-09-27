package net.ssh.onlineshopping.util;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.multipart.MultipartFile;

public class multipartUtility {

	private static final String ABS_PATH = "D:\\project\\online-shopping\\onlineshopping\\src\\main\\webapp\\assets\\images\\";
	private static String REAL_PATH = "";
	public void insertFile(MultipartFile file, HttpServletRequest request, String code) {
		
		REAL_PATH = request.getSession().getServletContext().getRealPath("/assets/images/");
		
		
		//to make sure that all the directories exist
		if(!new File(ABS_PATH).exists())
		{
			//create the directories
			new File(ABS_PATH).mkdirs();
		}
		
		if(!new File(REAL_PATH).exists())
		{
			//create the directories
			new File(REAL_PATH).mkdirs();
		}
		
		try
		{
			file.transferTo(new File(ABS_PATH + code + ".jpg"));
			
			file.transferTo(new File(REAL_PATH + code + ".jpg"));
		}
		catch(IOException io)
		{
			
		}
		
	}
		
	
}
