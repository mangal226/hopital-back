package fonctions;

import model.Patient;
import model.Visite;
import util.Context;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Query;
import java.util.List;
import java.util.Scanner;

public class Fonctions {
	
	
	// Fonctions d'insertion
	public static int SaisieInt(String texte) {
	System.out.println(texte);
	Scanner sc=new Scanner(System.in);
	int val=sc.nextInt();
	return val;           
	}
	
	public static Boolean SaisieBoolean(String texte) {
		System.out.println(texte);
		Scanner sc=new Scanner(System.in);
		Boolean val=sc.nextBoolean();
		return val;           
		}
	
	public static double SaisieDouble(String texte) {
		System.out.println(texte);
		Scanner sc=new Scanner(System.in);
		double val=sc.nextDouble();
		return val;           
		}
	
	public static String SaisieString(String texte) {
		
		System.out.println(texte);
		Scanner sc=new Scanner(System.in);
		String val=sc.nextLine();
		return val;           
		}

	
	// Fonctions metiers
	public static void afficherVisitesPatient() {
		// TODO Auto-generated method stub
		int num=SaisieInt("Veuillez donner votre numero de securit�:");
		EntityManagerFactory emf= Context.getInstance().getEmf();
		EntityManager em=emf.createEntityManager();
		Patient p= em.find(Patient.class, num);
		Query req_visites=em.createQuery("from Visite v where v.patient= :patient");
			req_visites.setParameter("patient", p);
			
			List <Visite> visites=null;
		try {
			 visites=(List <Visite>) req_visites.getResultList();
		}
		catch (Exception e) { e.printStackTrace();}
		em.close();
		if (visites==null) {
			System.out.println("Vous n'avez pas de visites");
		}
		else {
			for (Visite v : visites)
			{System.out.println(v);}
		}
		
			}

	public static void partirEnPause() {
		// TODO Auto-generated method stub
		
	}

	public static void afficherFile(List <Patient>  fileAttente) {
		// TODO Auto-generated method stub
		if (fileAttente==null) {
			System.out.println("La file est vide");
		}
		else {
			for (Patient p : fileAttente) {
				System.out.println(p);
			}
		}	
	}

	public static List <Patient> ajoutPatient( List <Patient>  fileAttente) {
		// TODO Auto-generated method stub
		int num=SaisieInt("Veuillez donner votre numero de securit�:");
		EntityManagerFactory emf=Context.getInstance().getEmf();
		EntityManager em=emf.createEntityManager();
		Patient p=em.find(Patient.class, num);
		if (p==null) {
			String nom=SaisieString("Veuillez donner votre nom:");
			String prenom=SaisieString("Veuillez donner votre prenom:");
			p= new Patient(nom,prenom);
			em.getTransaction().begin();
			em.merge(p);
			em.getTransaction().commit();
			em.close();
		}
		
		fileAttente.add(p);
		
		
		return fileAttente;
	}
	

	public static void revenirPause() {
		// TODO Auto-generated method stub
		
	}

	
	public static void saveVisites() {
		// TODO Auto-generated method stub
		
	}


	public static void recevoir() {
		// TODO Auto-generated method stub
		
	}
	
}
