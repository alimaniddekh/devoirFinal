package emsi.iir4.devoirfinal.mvccontrollers;

import emsi.iir4.devoirfinal.models.User;
import emsi.iir4.devoirfinal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/")
public class HomeController {
	
	@Autowired
	UserService userService;
	
	@GetMapping
	public String index() {
		return "index";
	}
	
	@GetMapping("/login")
	public String login() {
		return "connexion";
	}
	
	
	@GetMapping("/inscription")
	public String insc(Model m) {
		m.addAttribute("user",new User());
		return "inscription";
	}
	
	@PostMapping("/inscription")
	public String insc(@ModelAttribute User user,BindingResult result) {
		if (result.hasErrors())
			return "inscription";
		userService.save(user);
		return "redirect:login";
	}
	
}