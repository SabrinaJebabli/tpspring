package com.igs.ipi.tpspringbootjebabli.model;


public class GameModel {	
	
	private String nom1;
	private String nom2;	
	private Jeton[][] jetons = new Jeton[6][7];
	private boolean tourJoueur1;
	
	public GameModel() {
		for (int i = 0; i < jetons.length; i++) {
			for (int j = 0; j < jetons[i].length; j++) {
				jetons[i][j] = Jeton.VIDE;
			}
		}
		tourJoueur1 = true;
	}
	
	public GameModel(String nom1, String nom2) {
		super();
		this.nom1 = nom1;
		this.nom2 = nom2;	
	}
		
	public String getNom1() {
		return nom1;
	}

	public void setNom1(String nom1) {
		this.nom1 = nom1;
	}
	
	public String getNom2() {
		return nom2;
	}
	
	public void setNom2(String nom2) {
		this.nom2 = nom2;
	}

	public Jeton[][] getJetons() {
		return jetons;
	}

	public void setJetons(Jeton[][] jetons) {
		this.jetons = jetons;
	}
	
	public void add(Integer index) {
		for(int h = jetons.length-1; h >= 0; h--) {
			if (jetons[h][index] == Jeton.VIDE) {
				jetons[h][index] = Jeton.ROUGE;		
				tourJoueur1 =!tourJoueur1;
			return;
			}
		}
		throw new IllegalArgumentException("Pas de place disponible à cet endroit"+index);
	}
	
	public boolean isTourJoueur1() {
		return tourJoueur1;
	}
	
	public void setTourJoueur1(boolean tourJoueur1) {
		this.tourJoueur1 = tourJoueur1;
	}

	
	
	
}
