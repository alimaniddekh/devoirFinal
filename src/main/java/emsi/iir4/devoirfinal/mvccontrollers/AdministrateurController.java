package emsi.iir4.devoirfinal.mvccontrollers;

import emsi.iir4.devoirfinal.models.Developpeur;
import emsi.iir4.devoirfinal.models.Ticket;
import emsi.iir4.devoirfinal.service.AdminService;
import emsi.iir4.devoirfinal.service.DevService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;


@Controller
@RequestMapping("/admin")
public class AdministrateurController  {
	@Autowired
	 private AdminService as;
	 
	 @GetMapping
	 public ModelAndView listTicket(){
		 ModelAndView m = new ModelAndView("admin/bugs");
		 m.addObject("bugs", as.ticketsNonAttribue());
		 return m;
	 }

	@GetMapping("/add")
	public String addD(Model m) {
		Developpeur d=new Developpeur();
		m.addAttribute("developppeur", d);
		return"admin/newDev";
	}

	@PostMapping("/add")
	public String SaveD(@ModelAttribute("developpeur") Developpeur d) {
		if(d!=null) {
			as.addDev(d);
			return "admin/newDev";
		}
		return "/admin" ;
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
	
	


