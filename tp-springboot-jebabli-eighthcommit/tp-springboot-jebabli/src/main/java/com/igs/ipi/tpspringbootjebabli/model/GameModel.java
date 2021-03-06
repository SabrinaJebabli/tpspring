package com.igs.ipi.tpspringbootjebabli.model;

import java.util.List;

public class GameModel {	
	
	public static final int NB_A_ALIGNER = 4;
	
	private String nom1;
	private String nom2;	
	private Jeton[][] jetons = new Jeton[6][7];
	private boolean tourJoueur1;
	private int numJoueurGagnant = 0;
	
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
				Jeton jeton = tourJoueur1 ? Jeton.ROUGE : Jeton.BLEU;
				jetons[h][index] = jeton;
				boolean coupGagnant = isCoupGagnant(index, h);
				if (coupGagnant) {
					numJoueurGagnant = tourJoueur1 ? 1 : 2;
				}
				tourJoueur1 = ! tourJoueur1;
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
	
	public boolean isCoupGagnant(int x, int y) {
		Jeton jeton = jetons[x][y];
		Coord init = new Coord (x,y);
		List<List<Coord>> alignementsPossibles = init.getAlignementsPossibles(NB_A_ALIGNER, 7,6);
		for (List<Coord> alignement : alignementsPossibles) {
			int nbAlignes = 0;
			for(Coord c : alignement) {
				if (jetons[c.y][c.x] == jeton) {
					nbAlignes++;
				}
				else {
					nbAlignes = 0;
				}
				if (nbAlignes == NB_A_ALIGNER) {
					return true;
				}
			}
		}
		return false;
	}
	
	public Integer getNumJoueurGagnant() {
		return numJoueurGagnant;
	}
	
	public boolean isJoueur1Gagnant() {
		return numJoueurGagnant == 1;
	}
	
	public boolean isJoueur2Gagnant() {
		return numJoueurGagnant == 2;
	}

	
	
	
}
