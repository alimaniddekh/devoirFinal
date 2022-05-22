package emsi.iir4.devoirfinal.mvccontrollers;

import emsi.iir4.devoirfinal.models.Ticket;
import emsi.iir4.devoirfinal.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/admin")
public class AdministrateurController  {
	@Autowired
	 private AdminService as;

	 
	 @GetMapping
	 public ModelAndView listTicket(){
		 ModelAndView m = new ModelAndView("admin/users");
		 m.addObject("bugs", as.ticketsNonAttribue());
		 return m;
	 }
	 
	 @GetMapping("/{id}")
	 public String Attribuer(@PathVariable int id, Model m) {
		 Ticket t=as.getTick(id);
		 if(t!=null) {
				m.addAttribute("ticket",t);
				m.addAttribute("devs",as.getDev());
				return "admin/attribuer";
			}	 		 
		 return"admin/bugs";
	 }
	 
	 @GetMapping("/attribuer/{idT}/{idD}") 
	 public String SaveC(@PathVariable int idT, @PathVariable int idD) {
		 as.AttrDevT(idT, idD);
		 return "admin/bugs";
	 }
	 
}
	
	


