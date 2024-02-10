package dao.jpa;
import model.Patient;
import util.Context;
import java.util.List;


import dao.IDAOPatient;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class DAOPatient implements IDAOPatient{

	public Patient findById(Integer Id) {
		EntityManagerFactory emf=Context.getInstance().getEmf();
		EntityManager em=emf.createEntityManager();
		Patient p=em.find(Patient.class, Id);
		em.close();
		
		
		return p;
	}

	public List<Patient> findAll() {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Context.getInstance().getEmf();
		EntityManager em=emf.createEntityManager();
		List <Patient> patients=em.createQuery("from Patient").getResultList();
		em.close();
		
		return patients;
	}

	public void delete(Integer Id) {
		// TODO Auto-generated method stub
		EntityManagerFactory emf=Context.getInstance().getEmf();
		EntityManager em=emf.createEntityManager();
		Patient p=em.find(Patient.class, Id);
		em.getTransaction().begin();
		em.remove(p);
		em.getTransaction().commit();
		em.close();
		
	}

	public void save(Patient ob) {
		EntityManagerFactory emf=Context.getInstance().getEmf();
		EntityManager em=emf.createEntityManager();
	
		em.getTransaction().begin();
		em.merge(ob);
		em.getTransaction().commit();
		em.close();
		
	}

	
}

