package emsi.iir4.devoirfinal.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

@Entity
public class Client extends User {

	@OneToMany
	private List<Ticket> ticks;

	public List<Ticket> getTicks() {
		return ticks;
	}

	public void setTicks(List<Ticket> ticks) {
		this.ticks = ticks;
	}
	
	
	


}
