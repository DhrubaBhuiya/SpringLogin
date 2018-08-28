package com.spring.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {
	@RequestMapping(method = RequestMethod.GET)
	public String init(Model model) {
		model.addAttribute("error", "Please Enter Your Login Details");
		return "login";
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String submit(Model model,@Valid @ModelAttribute("loginBean") LoginBean loginBean,BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result.toString());
			return "login";
		}
		if (loginBean != null && loginBean.getUserName() != null & loginBean.getPassword() != null) 
		{
			if (loginBean.getUserName().equals("Dhruba") && loginBean.getPassword().equals("Dhruba@1234"))
			{
				model.addAttribute("msg", loginBean.getUserName());
				return "success";
			} else 
			{
				model.addAttribute("error", "Invalid Details");
				return "login";
			}
		} 
		else 
		{
			model.addAttribute("error", "Please enter Details");
			return "login";
		}
	}
}
