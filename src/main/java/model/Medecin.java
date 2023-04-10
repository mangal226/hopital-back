package model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("Medecin")
public class Medecin extends Compte{
	
	private Integer salle;

	public Medecin() {
	}
	
	
	
	public Medecin(String login, String password) {
		super(login, password);
	}
	
	public Medecin(String login, String password, int salle) {
		super(login, password);
		this.salle=salle;
	}
	
	
	public int getSalle() {
		return salle;
	}

	public void setSalle(int salle) {
		this.salle = salle;
	}



	@Override
	public String toString() {
		return "Medecin [salle=" + salle + ", id=" + id + ", login=" + login + ", password=" + password + "]";
	}




	
	

}
