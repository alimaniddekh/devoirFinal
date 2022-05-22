package emsi.iir4.devoirfinal.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idT;
	private String description;
	private String urgence;
	private String envExecu;
	private String logiciel;
	private String statut;
	private Boolean attr;
	
	public int getIdT() {
		return idT;
	}

	public void setIdT(int id) {
		this.idT = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUrgence() {
		return urgence;
	}

	public void setUrgence(String urgence) {
		this.urgence = urgence;
	}

	public String getEnvExecu() {
		return envExecu;
	}

	public void setEnvExecu(String envExecu) {
		this.envExecu = envExecu;
	}

	public String getLogiciel() {
		return logiciel;
	}

	public void setLogiciel(String logiciel) {
		this.logiciel = logiciel;
	}

	public String getStatut() {
		return statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}

	public Boolean getAttr() {
		return attr;
	}

	public void setAttr(Boolean attr) {
		this.attr = attr;
	}


	
	
	
	

}
