package main;

import org.springframework.beans.factory.annotation.Autowired;

import model.Medecin;
import model.Patient;
import model.Secretaire;
import model.Visite;
import repository.CompteRepository;
import repository.PatientRepository;
import repository.VisiteRepository;

public class AppSpring {
	
	@Autowired
	private CompteRepository compteRepo;
	
	@Autowired
	private PatientRepository patientRepo;
	
	@Autowired VisiteRepository visiteRepo;
	
	
	public void run(String ... args) {
		
		initDataBase();
		
	}
	
	public void initDataBase() {
		
		Patient p1= new Patient("Abdine", "Walid");
		Patient p2= new Patient("Abdina", "Walid");
		Patient p3= new Patient("Abdinou", "Walid");
		patientRepo.save(p1);
		patientRepo.save(p2);
		patientRepo.save(p3);
		
		Medecin med1= new Medecin("med1", "med1");
		Medecin med2= new Medecin("med2", "med2");
		Secretaire sec= new Secretaire("sec", "sec");
		compteRepo.save(med1);
		compteRepo.save(med2);
		compteRepo.save(sec);
		
		
		
		Visite v1= new Visite( 1, p1, med1);
		Visite v2= new Visite( 1, p2, med1);
		Visite v3= new Visite( 2, p3, med2);
		visiteRepo.save(v1);
		visiteRepo.save(v2);
		visiteRepo.save(v3);
		
	}

}
