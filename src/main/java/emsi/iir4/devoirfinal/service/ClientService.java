package emsi.iir4.devoirfinal.service;

import java.util.List;

import emsi.iir4.devoirfinal.models.Ticket;
import emsi.iir4.devoirfinal.repository.ClientRepository;
import emsi.iir4.devoirfinal.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class ClientService {
	@Autowired
	ClientRepository cr;
	@Autowired
	TicketRepository tr;

	public List<Ticket> tiCli(int id) {
		return cr.TickClient(id);
	}

	public void CreeTick(Ticket t) {
		if (t != null) {
			tr.save(t);	
		}

	}
	
	

}
