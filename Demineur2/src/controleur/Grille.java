package controleur;


import java.security.SecureRandom;

import javax.swing.JLabel;


public class Grille {
	//instanciation des attributs
	private Case[][]Cases;
	private int dimGrille, nbBombes, score;
	private JLabel scoreLabel;
	
	//Contructeur(s)
	public Grille(int dim, int nbBombes) {
		this.score = 0;
		this.dimGrille = dim;
		this.scoreLabel = new JLabel("Score : "+this.score);
		this.Cases = new Case[this.dimGrille][this.dimGrille];		
		//initialisation des cases dans le tableau a deux dimensions
		for(int x = 0; x < this.dimGrille; x++){
			for (int y = 0; y < this.dimGrille; y++) {
				this.Cases[x][y] = new Case();
			}
		}
		this.nbBombes = nbBombes;
		placerBounds();
		placerBombes();
		detecteur();
	}
	public Grille(int dim) {
		SecureRandom random = new SecureRandom();
		this.score = 0;
		this.dimGrille = dim;
		this.scoreLabel = new JLabel("Score : "+this.score);
		this.Cases = new Case[this.dimGrille][this.dimGrille];
		//initialisation des cases dans le tableau a deux dimensions
		for(int x = 0; x < this.dimGrille; x++){
			for (int y = 0; y < this.dimGrille; y++) {
				this.Cases[x][y] = new Case();
			}
		}
		this.nbBombes = random.nextInt(1,(this.dimGrille*this.dimGrille)/3);
		placerBounds();
		placerBombes();
		detecteur();
	}
	public Grille() {
		SecureRandom random = new SecureRandom();
		this.score = 0;
		this.dimGrille = random.nextInt(4, 12);
		this.scoreLabel = new JLabel("Score : "+this.score);
		//initialisation des cases dans le tableau a deux dimensions
		for(int x = 0; x < this.dimGrille; x++){
			for (int y = 0; y < this.dimGrille; y++) {
			this.Cases[x][y] = new Case();
			}
		}
		this.nbBombes = random.nextInt(1,(this.dimGrille*this.dimGrille)/3);
		placerBounds();
		placerBombes();
		detecteur();
	}
	public void placerBombes() {
		SecureRandom random = new SecureRandom();
		int compteur = this.nbBombes;
		while(compteur != 0) {
			int x = random.nextInt(0,this.dimGrille);
			int y = random.nextInt(0,this.dimGrille);
			if( this.Cases[x][y].getBombe() < 1) {
				this.Cases[x][y].setBombe(1);
				compteur --;
			}
		}
	}
	public void revelerGrille() {
		for(int x = 0; x  < this.dimGrille; x++){
			for (int y = 0; y < this.dimGrille; y++) {
				this.Cases[x][y].getBouton().setIcon(null);
				this.Cases[x][y].revelerCase();
			}
		}
	}
	public void detecteur() { 
		//analyse les mines autour de chaque case (A UTILISER SEULEMENT APRES LE PLACEMENT DES MINES)
		for(int x = 0; x  < this.dimGrille; x++){
			for (int y = 0; y < this.dimGrille; y++) {
				if(this.Cases[x][y].getBombe() != 1) { //Si pas de bombes sur la case centrale, alors debute l'analyse des cases alentours
					int S = 0; //nb total de mines aux alentour
					for(int a = -1; a <=1; a++ ) {
						for(int b = -1; b <=1; b++ ) {
							try {
								S += this.Cases[a+x][b+y].getBombe();
							} catch (ArrayIndexOutOfBoundsException exp) {}
						}
					}
					this.Cases[x][y].setRadar(S);
				}
			}
		}
	}
	public boolean testVictoire() {
		if (score == this.dimGrille*this.dimGrille - this.nbBombes) {
			this.score += this.nbBombes;
			this.scoreLabel.setText("Score : "+this.score);
			return true;
		} else {
			return false;
		}
	}
	public void autorevelation(int x, int y) { //a utiliser a la place de revelerCase lorsque la case clique a un radar = 0. Fonction recursive.
		for(int a = -1; a <=1; a++ ) {
			for(int b = -1; b <=1; b++ ) {
				try {
					if (this.Cases[x+a][y+b].getBouton().isEnabled() == true && this.Cases[x+a][y+b].getBombe() != 1) { //si la case est active et qu'elle contient une bombe
						this.Cases[x+a][y+b].revelerCase(); //ALORS on la revele, on augmente le score
						this.score ++;
						this.scoreLabel.setText("Score : "+this.score);
						if(this.Cases[x+a][y+b].getRadar() == 0) { //Si cette meme case n'a aucune bombe autour d'elle, alors elle autorevele a son tour
							autorevelation(x+a,y+b);
						}
					}
				} catch (ArrayIndexOutOfBoundsException exp) {}
			}
		}
	}
	// BOUTONS
	public void placerBounds() {
		for(int x = 0; x  < this.dimGrille; x++){ //place les bounds des boutons cases
			for (int y = 0; y < this.dimGrille; y++) {
				this.Cases[x][y].placerBounds(((x+1)*5)+((x*50)), ((y+1)*5)+((y*50)), 50, 50);
			}
		}
		this.scoreLabel.setBounds((this.dimGrille*5)+((this.dimGrille*50)/2-50), (this.dimGrille*5)+(this.dimGrille*50)-5,100, 50);
	}
	public JLabel getScoreLabel() {
		return this.scoreLabel;
	}
	public void setScoreLabel(JLabel scoreLabel) {
		this.scoreLabel = scoreLabel;
	}
	public int getScore() {
		return this.score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	public Case[][] getCases() {
		return this.Cases;
	}
	public void setCases(Case[][] cases) {
		this.Cases = cases;
	}
	public int getDimGrille() {
		return this.dimGrille;
	}
	public void setDimGrille(int dimGrille) {
		this.dimGrille = dimGrille;
	}
	public int getNbBombes() {
		return this.dimGrille;
	}
	public void setNbBombes(int dimGrille) {
		this.dimGrille = dimGrille;
	}
	
}
