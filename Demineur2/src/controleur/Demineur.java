package controleur;

import vue.VueAccueil;

public class Demineur {
	
	private static Partie unePartie;
	private static VueAccueil uneVueAccueil;
	
	public static void main(String[] args) {
		// Instanciation de la classe convertisseur
		VueAccueil uneVueAccueil = new VueAccueil();
	}
	public static void rendreVisibleVueAccueil (boolean action) {
		uneVueAccueil.setVisible(action);
	}
	public static void creerDetruirePartie (boolean action, int dim, int nbBombes) {
		if (action == true) {
			unePartie = new Partie(dim, nbBombes);
			unePartie.setVisible(true);
		}
		else {
			unePartie.dispose();
		}
	}
	public static void creerDetruirePartie (boolean action, int dim) {
		if (action == true) {
			unePartie = new Partie(dim);
			unePartie.setVisible(true);
		}
		else {
			unePartie.dispose();
		}
	}
	public static void creerDetruirePartie (boolean action) {
		if (action == true) {
			unePartie = new Partie();
			unePartie.setVisible(true);
		}
		else {
			unePartie.dispose();
		}
	}
}
