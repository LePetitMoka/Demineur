package vue;

import java.awt.Color;

import javax.swing.JPanel;

public abstract class PanelGeneralPartie extends JPanel{
	public PanelGeneralPartie(Color uneCouleur) {
		this.setBounds(50,70,200,100);
		this.setBackground(uneCouleur);
		this.setLayout(null);
		this.setVisible(false);
	}
}
