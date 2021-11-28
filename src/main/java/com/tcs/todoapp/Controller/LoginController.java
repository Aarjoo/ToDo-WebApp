package com.tcs.todoapp.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.tcs.todoapp.Service.LoginService;

@Controller
@SessionAttributes("username")
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String welcome(ModelMap model)
	{	
		model.addAttribute("username", getUserName());
		return "welcome";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login()
	{		
		return "login";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String login(@RequestParam("username") String userName, @RequestParam("password") String password
			,ModelMap model
			)
	{
		if(!loginService.isloggedIn(userName, password))
		{
			model.addAttribute("errorMessage","Wrong username and paswword specified");
			return "login";
		}
		model.addAttribute("username", userName);
		return "redirect:/todos-list";
	}
	
	public String getUserName()
	{
		Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		if(principal instanceof UserDetails)
		{
			return ((UserDetails) principal).getUsername();
		}
		
		return principal.toString();
	}
}