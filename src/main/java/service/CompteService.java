package service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import exception.CompteException;
import model.Compte;
import repository.CompteRepository;

@Service
public class CompteService {
	
	@Autowired	
	private CompteRepository compteRepo;
	
	public void suppression(Compte compte) {
		Compte compteEnBase;
		compteEnBase=compteRepo.findById(compte.getId()).orElseThrow(CompteException::new);
		compteRepo.delete(compte);
	}
	
	public void creationOuModification() {
		
	}
	
	
	public Compte getByLogin() {
		Compte compte=null;
		
		return compte;
	}

}
