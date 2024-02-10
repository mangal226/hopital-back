package dao.jpa;

import model.Compte;
import util.Context;
import java.util.List;


import dao.IDAOCompte;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;

public class DAOCompte implements IDAOCompte {

	public Compte findById(Integer Id) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf= Context.getInstance().getEmf();
		EntityManager em=emf.createEntityManager();
		Compte objet=em.find(Compte.class,Id);
		em.close();
		
		return objet;
	}

	public List<Compte> findAll() {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Context.getInstance().getEmf();
		EntityManager em=emf.createEntityManager();
		List <Compte> comptes=em.createQuery("from Compte").getResultList();
		em.close();
		
		return comptes;
	}

	public void delete(Integer Id) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Context.getInstance().getEmf();
		EntityManager em=emf.createEntityManager();
		Compte compte=em.find(Compte.class, Id);
		
		em.getTransaction().begin();
		em.remove(compte);
		em.getTransaction().commit();
		em.close();
		
	}

	public void save(Compte ob) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Context.getInstance().getEmf();
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(ob);
		em.close();
		
	}

	public Compte connex(String login, String password) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Context.getInstance().getEmf();
		EntityManager em=emf.createEntityManager();
		Query req=em.createQuery("from Compte c where c.login=:log AND c.password=:pass");
				req.setParameter("log", login);
				req.setParameter("pass", password);
		
		Compte connected=null;		
		try {
			connected=(Compte) req.getSingleResult();
		}
		catch (Exception e) { e.printStackTrace();}
		em.close();
		
		return connected;
	}




}
