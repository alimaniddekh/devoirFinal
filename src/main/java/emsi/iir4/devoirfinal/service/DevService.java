package emsi.iir4.devoirfinal.service;



import java.util.List;

import emsi.iir4.devoirfinal.models.Developpeur;
import emsi.iir4.devoirfinal.models.Ticket;
import emsi.iir4.devoirfinal.repository.DeveloppeurRepository;
import emsi.iir4.devoirfinal.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class DevService {
	@Autowired
	DeveloppeurRepository dr;
	@Autowired
	TicketRepository tr;
	
	public List<Ticket> getTicket(int id){
		Developpeur d=dr.getById(id);
		List<Ticket> tickets=d.getTicks();
		return tickets;
	}
	
	public void la(int idT) {
		Ticket t=tr.getById(idT);
		if(t!=null) {
			if(t.getStatut()==null) {
				t.setStatut("en cours de traitement");
			}
			else if(t.getStatut()=="en cours de traitement") {
				t.setStatut("résolu");
			}
		}
	}
	
	
	
	
}
