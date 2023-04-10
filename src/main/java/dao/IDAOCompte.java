package dao;

import model.Compte;

public interface IDAOCompte extends IDAO<Compte, Integer>{
	
	public Compte connex(String login, String password);

}
