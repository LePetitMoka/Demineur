package controleur;


import java.awt.Color;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class Case {
	//instanciation des attributs
	private int bombe, radar;
	private boolean drapeau;
	private JButton bouton;
	
	//Constructeur(s)
	public Case() {
		this.drapeau = false;
		this.radar = 0;
		this.bombe = 0;
		this.bouton = new JButton();
		this.bouton.setForeground(Color.RED);
		this.bouton.setEnabled(true);

	}
	
	public void placerBounds(int Ox, int Oy, int Sx, int Sy) {
		this.bouton.setBounds(Ox, Oy, Sx, Sy);
	}
	public void placerBombe(int x, int y){
		this.bombe = 1;
	}
	public void switchDrapeau() {
		if (this.drapeau == true) {
			this.drapeau = false;
			this.bouton.setIcon(null);
		} else {
			this.drapeau = true;
			ImageIcon flag = new ImageIcon("src/images/Flag.png");
			this.bouton.setIcon(flag);
		}
	}
	public void revelerCase() {
		this.bouton.setIcon(null); //on enleve le drapeau (si la fonction est executee par autorevelation)
		this.drapeau = false;
		if (this.bombe == 0) {
			switch(this.radar) {
				case 0:this.bouton.setText(null);break;
				case 1:this.bouton.setText("1");break;
				case 2:this.bouton.setText("2");break;
				case 3:this.bouton.setText("3");break;
				case 4:this.bouton.setText("4");break;
				case 5:this.bouton.setText("5");break;
				case 6:this.bouton.setText("6");break;
				case 7:this.bouton.setText("7");break;
				case 8:this.bouton.setText("8");break;
			}
		} else if (this.bombe == 1){
			ImageIcon bombe = new ImageIcon("src/images/Bombe.png"); //image ne s'affiche pas correctement
			this.bouton.setIcon(bombe);
		}
		this.bouton.setEnabled(false);
	}
	public void revelerExplosion() { //utilise lorsque clic sur case bombe (fin de partie)
		ImageIcon redbombe = new ImageIcon("src/images/Explosion.png");
		Image image = redbombe.getImage();
		Image newimage = image.getScaledInstance(50, 50, Image.SCALE_AREA_AVERAGING);
		ImageIcon redbombeRES = new ImageIcon(newimage);
		this.bouton.setIcon(null);
		this.bouton.setDisabledIcon(redbombeRES);
	}
	
	public int getBombe() {
		return this.bombe;
	}

	public void setBombe(int bombe) {
		this.bombe = bombe;
	}
	public int getRadar() {
		return this.radar;
	}

	public void setRadar(int radar) {
		this.radar = radar;
	}

	public JButton getBouton() {
		return this.bouton;
	}

	public void setBouton(JButton bouton) {
		this.bouton = bouton;
	}

	public boolean isDrapeau() {
		return this.drapeau;
	}

	public void setDrapeau(boolean drapeau) {
		this.drapeau = drapeau;
	}
	
}
