package emsi.iir4.devoirfinal.mvccontrollers;

import emsi.iir4.devoirfinal.models.Ticket;
import emsi.iir4.devoirfinal.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/client")
public class ClientController {
	
	@Autowired
	 private ClientService cs;

	 
	 @GetMapping("/{id}")
	 public String listTicket(@PathVariable int id ,Model model){
		 model.addAttribute("ticket", cs.tiCli(id));
		 return "/client/ticket" ;
	 }
	 
	 @GetMapping("/add")
	 public String creationT(Model m) {
		 Ticket t=new Ticket();
		 m.addAttribute("ticket", t);
		 return"client/newTicket";
	 }
	 
	 @PostMapping("/add") 
	 public String SaveT(@ModelAttribute("ticket") Ticket t) {
		if(t!=null) {
		 cs.CreeTick(t);
		 return "client/newTicket";
		}
		return "/client" ;
	 }
	
	 }

