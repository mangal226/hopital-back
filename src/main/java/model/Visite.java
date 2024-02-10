package model;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;


@Entity
@Table(name="visite")
public class Visite {
	
	@Id
	@GeneratedValue
	@Column(name="numero")
	private int id;
	
	private int prix;
	
	@OneToOne
	@JoinColumn(name="id_patient")
	private Patient patient;
	
	@Override
	public int hashCode() {
		return Objects.hash(id);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Visite other = (Visite) obj;
		return id == other.id;
	}


	@OneToOne
	@JoinColumn(name="id_medecin")
	private Medecin medecin;
	
	@Column(name="date_visite")
	LocalDate date;
	
	public Visite() {
		
	}
	
	
	public Visite( int salle, Patient patient, Medecin medecin) {
		this.prix = 20;
		this.patient = patient;
		this.medecin = medecin;
		this.date = LocalDate.now();
	}
	
	public Patient getPatient() {
		return patient;
	}
	public void setPatient(Patient patient) {
		this.patient = patient;
	}
	public Medecin getMedecin() {
		return medecin;
	}
	public void setMedecin(Medecin medecin) {
		this.medecin = medecin;
	}

	public int getPrix() {
		return prix;
	}

	public void setPrix(int prix) {
		this.prix = prix;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}


	@Override
	public String toString() {
		return "Visite [id=" + id + ", prix=" + prix + ", patient=" + patient + ", medecin=" + medecin + ", date="
				+ date + "]";
	}


	
	
	

	
	
	
	
}
