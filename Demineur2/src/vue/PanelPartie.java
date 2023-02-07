package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import controleur.Demineur;

public class PanelPartie extends PanelGeneralPartie implements ActionListener {

	private JButton btJouer = new JButton("Jouer");
	
	private JPanel panelForm = new JPanel();
	
	
	public PanelPartie() {
		super(Color.orange);
		// TODO Auto-generated constructor stub
		// parametrage
		this.btJouer.setBounds(63,30,70,50);
		this.add(this.btJouer);
		
		//rendre les boutons ecoutables
		this.btJouer.addActionListener(this);
		
		this.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.btJouer) {
			Demineur.creerDetruirePartie(true);
			Demineur.rendreVisibleVueAccueil(false);
		}
	}
}

