package xyz.cafeconleche.web.thebride.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import xyz.cafeconleche.web.thebride.dto.Greeting;

@Controller
public class GreetingsController {
	
	@RequestMapping("/hello")
	public ModelAndView hello() {
		
		System.out.println("hello");
		ModelAndView mav = new ModelAndView("greeting");
		Greeting greeting = new Greeting();
		greeting.setId(1);
		greeting.setContent("Hello world!");
		mav.addObject("greeting", greeting);
		return mav;
	}

}
