package controleur;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import java.security.SecureRandom;


public class Partie extends JFrame implements ActionListener, MouseListener{
	
	private Grille uneGrille;
	private int dimGrille;
		
	public Partie(int dim, int nbBombes) {
		//initialisation des attributs de la classe
		this.dimGrille = dim;
		this.uneGrille = new Grille(this.dimGrille,nbBombes);
		
		//proprietes de la fenetre
		this.setTitle("Partie");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(200,200,(5*(1+this.dimGrille))+(50*this.dimGrille),70+(5*(1+this.dimGrille))+(50*this.dimGrille));
		this.setLayout(null);
		this.getContentPane().setBackground(Color.orange);
		
		//placement des boutons (OrigX,OrigY,DimX,DimY)
		this.uneGrille.placerBounds();
		for (int x = 0; x < this.dimGrille; x++) {
			for (int y = 0; y < this.dimGrille; y++) {
				this.add(uneGrille.getCases()[x][y].getBouton());
			}
		}
		//placement des Labels
		this.add(this.uneGrille.getScoreLabel());
		
		//rendre les boutons ecoutables
		for (int x = 0; x < this.dimGrille; x++) {
			for (int y = 0; y < this.dimGrille; y++) {
				this.uneGrille.getCases()[x][y].getBouton().addActionListener(this);
			}
		}
		//rendre les boutons ecoutables pour les clics
		for (int x = 0; x < this.dimGrille; x++) {
			for (int y = 0; y < this.dimGrille; y++) {
				this.uneGrille.getCases()[x][y].getBouton().addMouseListener(this);
			}
		}
		
		this.setVisible(true);
	}
	public Partie(int dim) {
		//initialisation des attributs de la classe
		this.dimGrille = dim;
		this.uneGrille = new Grille(this.dimGrille);
		
		//proprietes de la fenetre
		this.setTitle("Partie");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(200,200,(5*(1+this.dimGrille))+(50*this.dimGrille),70+(5*(1+this.dimGrille))+(50*this.dimGrille));
		this.setLayout(null);
		this.getContentPane().setBackground(Color.orange);
		
		//placement des boutons (OrigX,OrigY,DimX,DimY)
		this.uneGrille.placerBounds();
		for (int x = 0; x < this.dimGrille; x++) {
			for (int y = 0; y < this.dimGrille; y++) {
				this.add(uneGrille.getCases()[x][y].getBouton());
			}
		}
		//placement des Labels
		this.add(this.uneGrille.getScoreLabel());
		
		//rendre les boutons ecoutables
		for (int x = 0; x < this.dimGrille; x++) {
			for (int y = 0; y < this.dimGrille; y++) {
				this.uneGrille.getCases()[x][y].getBouton().addActionListener(this);
			}
		}
		//rendre les boutons ecoutables pour les clics
		for (int x = 0; x < this.dimGrille; x++) {
			for (int y = 0; y < this.dimGrille; y++) {
				this.uneGrille.getCases()[x][y].getBouton().addMouseListener(this);
			}
		}
		
		this.setVisible(true);
	}
	public Partie() {
		SecureRandom random = new SecureRandom();
		//initialisation des attributs de la classe
		this.dimGrille = random.nextInt(4,14);
		this.uneGrille = new Grille(this.dimGrille);
		
		//proprietes de la fenetre
		this.setTitle("Partie");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.setBounds(200,200,(5*(1+this.dimGrille))+(50*this.dimGrille),70+(5*(1+this.dimGrille))+(50*this.dimGrille));
		this.setLayout(null);
		this.getContentPane().setBackground(Color.orange);
		
		//placement des boutons (OrigX,OrigY,DimX,DimY)
		this.uneGrille.placerBounds();
		for (int x = 0; x < this.dimGrille; x++) {
			for (int y = 0; y < this.dimGrille; y++) {
				this.add(uneGrille.getCases()[x][y].getBouton());
			}
		}
		//placement des Labels
		this.add(uneGrille.getScoreLabel());
		
		//rendre les boutons ecoutables
		for (int x = 0; x < this.dimGrille; x++) {
			for (int y = 0; y < this.dimGrille; y++) {
				this.uneGrille.getCases()[x][y].getBouton().addActionListener(this);
			}
		}
		//rendre les boutons ecoutables pour les clics
				for (int x = 0; x < this.dimGrille; x++) {
					for (int y = 0; y < this.dimGrille; y++) {
						this.uneGrille.getCases()[x][y].getBouton().addMouseListener(this);
					}
				}
		
		this.setVisible(true);
	}
	public void retournerAccueil() {
		Demineur.creerDetruirePartie(false);
		Demineur.rendreVisibleVueAccueil(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		for (int x = 0; x < this.dimGrille; x++) {
			for (int y = 0; y < this.dimGrille; y++) {
				if (e.getSource() == this.uneGrille.getCases()[x][y].getBouton() && this.uneGrille.getCases()[x][y].isDrapeau() == false ) {
					//reveler la case
					this.uneGrille.getCases()[x][y].revelerCase();
					//SI une bombe alors partie terminee
					if (this.uneGrille.getCases()[x][y].getBombe() == 1) {
						this.uneGrille.getCases()[x][y].revelerExplosion(); //ne marche pas (format d'image ?)
						this.uneGrille.revelerGrille();
						//inserer fonction redbombe
						int Quitter = JOptionPane.showConfirmDialog(this, "Perdu !\nScore : "+ this.uneGrille.getScore(),"Defaite",JOptionPane.WARNING_MESSAGE);
						if (Quitter == 0) {
							this.retournerAccueil();; //tuer l'application
						}
					} else if(this.uneGrille.getCases()[x][y].getRadar() == 0){
						this.uneGrille.setScore(this.uneGrille.getScore()+1);
						this.uneGrille.autorevelation(x, y);
						if(this.uneGrille.testVictoire() ==  true) {
							this.uneGrille.revelerGrille();
							int Quitter = JOptionPane.showConfirmDialog(this, "Grille securisee !\nScore : "+ this.uneGrille.getScore(),"Victoire",JOptionPane.WARNING_MESSAGE);
							if (Quitter == 0) {
								this.retournerAccueil();; //tuer l'application
							}
						}
					}else { //SINON on augmente le score puis verifie si la partie est gagnee
						this.uneGrille.setScore(this.uneGrille.getScore()+1);
						this.uneGrille.getScoreLabel().setText("Score : "+this.uneGrille.getScore());
						if(this.uneGrille.testVictoire() ==  true) {
							this.uneGrille.revelerGrille();
							int Quitter = JOptionPane.showConfirmDialog(this, "Grille securisee !\nScore : "+ this.uneGrille.getScore(),"Victoire",JOptionPane.WARNING_MESSAGE);
							if (Quitter == 0) {
								this.retournerAccueil(); //tuer l'application
							}
						}
					}
				}
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		for (int x = 0; x < this.dimGrille; x++) {
			for (int y = 0; y < this.dimGrille; y++) {
				if (e.getSource() == this.uneGrille.getCases()[x][y].getBouton() && e.getButton() == MouseEvent.BUTTON3 && this.uneGrille.getCases()[x][y].getBouton().isEnabled() == true){
					this.uneGrille.getCases()[x][y].switchDrapeau();
				}
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}