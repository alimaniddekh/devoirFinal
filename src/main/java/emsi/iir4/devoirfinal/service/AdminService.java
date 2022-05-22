package emsi.iir4.devoirfinal.service;

import java.util.List;

import emsi.iir4.devoirfinal.models.Developpeur;
import emsi.iir4.devoirfinal.models.Ticket;
import emsi.iir4.devoirfinal.repository.AdministrateurRepository;
import emsi.iir4.devoirfinal.repository.DeveloppeurRepository;
import emsi.iir4.devoirfinal.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AdminService {
	@Autowired
	AdministrateurRepository ar;
	@Autowired
	TicketRepository tr;
	@Autowired
	DeveloppeurRepository dr;
	
	public List<Ticket> ticketsNonAttribue(){
		return tr.ticketNonAttribue();
		
	}
   
	public void AttrDevT(int idT,int idD) {
		Developpeur d=dr.findById(idD).get();
		Ticket t=tr.findById(idT).get();
		List<Ticket> tt=d.getTicks();
		if(t!=null) {
			if(d!=null) {
				tt.add(t);
				d.setTicks(tt);
				dr.save(d);
				t.setAttr(true);
			}
		}		
	}
	
	public Ticket getTick(int id) {
		return tr.findById(id).get();
	}
	
	public List<Developpeur> getDev() {
		return dr.findAll() ;
	}
}
