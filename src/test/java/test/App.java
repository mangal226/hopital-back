package test;

import model.*;
//import util.Context;

import java.util.LinkedList;

import fonctions.*;
import util.Context;


public class App {
	
	public static LinkedList <Patient> fileAttente=new LinkedList();
	
	

	public static void MenuConnexion() {
		System.out.println("---Menu de connexion---");
		String login=Fonctions.SaisieString("Veuillez entrer votre login:");
		String password=Fonctions.SaisieString("Veuillez entrer votre mot de passe:");
		Compte connected= Context.getInstance().getDaoC().connex(login, password);
		
		if(connected instanceof Medecin) 
		{
			int salle =Fonctions.SaisieInt("Dans quelle salle souhaitez vous aller ? (1 ou 2)");
			((Medecin) connected).setSalle(salle);
			menuMedecin();

		}
		else if(connected instanceof Secretaire) 
		{
			menuSecretaire();
		}
		else if(connected == null) {System.out.println("Identifiants invalides");}


		MenuConnexion();
	}
	

	public static void menuSecretaire(){
		Boolean pause=false;

		if (pause==false) {
			System.out.println("-----Menu Secretaire-----");
			System.out.println("1 - Ajouter un patient à la liste d'attente");
			System.out.println("2 - Afficher l'état de la file d'attente");
			System.out.println("3 - Afficher les visite(s) d'un patient");
			System.out.println("4 - Partir en pause");
			System.out.println("5 - Se deconnecter");


			int choix = Fonctions.SaisieInt("Choisir un menu : ");
			switch(choix) 
			{
			case 1 : Fonctions.ajoutPatient(fileAttente);break;
			case 2 : Fonctions.afficherFile(fileAttente);break;
			case 3 : Fonctions.afficherVisitesPatient();break;
			case 4 : Fonctions.partirEnPause();pause=true;break;
			case 5 : Context.getInstance().setConnex(null);MenuConnexion();break;
			
			}

		}
		else {


			System.out.println("-----Menu Secretaire Pause-----");
			System.out.println("1 - Revenir de pause");
			System.out.println("2 - Afficher l'état de la file d'attente");
			System.out.println("3 - Se déconnecter" );

			int choix = Fonctions.SaisieInt("Choisir un menu : ");
			switch(choix) 
			{

			// Recuperation liste des patients
			case 1 : Fonctions.revenirPause();pause=false;break;
			case 2 : Fonctions.afficherFile(fileAttente);break;
			case 3 : Context.getInstance().setConnex(null);MenuConnexion();break;
			}
		}
		menuSecretaire();
	}
	
	
	public static void menuMedecin(){
		System.out.println("-----Menu Medecin-----");
		System.out.println("1 - Faire la consultation suivante");
		System.out.println("2 - Visualiser la liste des patients");
		System.out.println("3 - Sauvegarder la liste des visites dans la base");
		System.out.println("4 - Se deconnecter");

		int choix = Fonctions.SaisieInt("Choisir un menu : ");
		switch(choix) 
		{
		case 1 : Fonctions.recevoir();break;
		case 2 : Fonctions.afficherFile(fileAttente);break;
		case 3 : Fonctions.saveVisites();break;
		case 4 : Fonctions.saveVisites();Context.getInstance().setConnex(null);MenuConnexion();break;
		}
		menuMedecin();
	}
	

	
	public static void main(String[] args) {
		MenuConnexion();

	}
	

}
