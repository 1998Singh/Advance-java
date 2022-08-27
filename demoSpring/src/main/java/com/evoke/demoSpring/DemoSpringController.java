package com.evoke.demoSpring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoSpringController {
	@RequestMapping("/home")
	public String demoSpringPage() {
		
		return "home";

	}

}
