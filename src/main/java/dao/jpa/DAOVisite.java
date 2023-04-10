package dao.jpa;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import dao.IDAOVisite;
import model.Visite;
import util.Context;

public class DAOVisite implements IDAOVisite{

	public Visite findById(Integer Id) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Context.getInstance().getEmf();
		EntityManager em=emf.createEntityManager();
		Visite visite=em.find(Visite.class, Id);
		em.close();
		return visite;
	}

	public List<Visite> findAll() {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Context.getInstance().getEmf();
		EntityManager em=emf.createEntityManager();
		List <Visite> visites=em.createQuery("from Visite").getResultList();
		em.close();
		
		return visites;
	}

	public void delete(Integer Id) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Context.getInstance().getEmf();
		EntityManager em=emf.createEntityManager();
		Visite visite=em.find(Visite.class, Id);
		em.getTransaction().begin();
		em.remove(visite);
		em.getTransaction().commit();
		em.close();
		
	}

	public void save(Visite ob) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Context.getInstance().getEmf();
		EntityManager em=emf.createEntityManager();
		
		em.getTransaction().begin();
		em.merge(ob);
		em.getTransaction().commit();
		em.close();
		
	}

}
