package util;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import dao.jpa.DAOCompte;
import dao.jpa.DAOPatient;
import dao.jpa.DAOVisite;
import model.Compte;


public class Context {
	
	private Compte connex;
	private DAOCompte daoC = new DAOCompte();
	private DAOVisite daoV = new DAOVisite();
	private DAOPatient daoP = new DAOPatient(); 
	
	
	//private EntityManagerFactory emf = Persistence.createEntityManagerFactory("hopital");
	//private static Context singleton=null;
	
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("hopital");
	private static Context singleton=null;

	private Context() {}
	
	//getInstance est la methode permettant de recuper l'objet unique dans l'appi (singleton) 
	public static Context getInstance() 
	{
		if(singleton==null) 
		{
			singleton=new Context();
		}
		return singleton;
	}
	
	public DAOCompte getDaoC() {
		return daoC;
	}

	public void setDaoC(DAOCompte daoC) {
		this.daoC = daoC;
	}

	public DAOVisite getDaoV() {
		return daoV;
	}

	public void setDaoV(DAOVisite daoV) {
		this.daoV = daoV;
	}

	public DAOPatient getDaoP() {
		return daoP;
	}

	public void setDaoP(DAOPatient daoP) {
		this.daoP = daoP;
	}

	public static Context getSingleton() {
		return singleton;
	}

	public static void setSingleton(Context singleton) {
		Context.singleton = singleton;
	}

	public Compte getConnex() {
		return connex;
	}

	public void setConnex(Compte connex) {
		this.connex = connex;
	}

	public EntityManagerFactory getEmf() {
		return emf;
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
	

}
