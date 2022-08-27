package com.evoke.springwebboot;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("home")
	
	public ModelAndView home(Alien alien)
	{
		
		ModelAndView mv = new ModelAndView();  //ModelAndView is a holder for both Model and View in the web MVC framework.
		mv.addObject("obj", alien);
		mv.setViewName("home");
        return mv;

	}

}
