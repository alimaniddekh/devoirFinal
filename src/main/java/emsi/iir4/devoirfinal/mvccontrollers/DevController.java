package emsi.iir4.devoirfinal.mvccontrollers;

import emsi.iir4.devoirfinal.service.DevService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/dev")
public class DevController {
	DevService ds;
	
	 @GetMapping("/{id}")
	 public String listTicket(@PathVariable int id, Model model){
		 model.addAttribute("ticket", ds.getTicket(id));
		 return "dev/tickets" ;
	 }
	 
	 
	 
	 
	

}
