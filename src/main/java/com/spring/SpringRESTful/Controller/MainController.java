package com.spring.SpringRESTful.Controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class MainController {

	@RequestMapping("/")
	public String home()
	{
		return "index";
	}
}
