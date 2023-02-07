package vue;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import controleur.Demineur;

public class PanelPartieDim extends PanelGeneralPartie implements ActionListener{

	private JButton btJouer = new JButton("Jouer");
	private JButton btAnnuler = new JButton("Annuler");
	
	private JTextField txtDim = new JTextField();
	
	private JPanel panelForm = new JPanel();
	
	
	public PanelPartieDim() {
		super(Color.orange);
		// TODO Auto-generated constructor stub
		// parametrage
		this.panelForm.setBackground(Color.orange);
		this.panelForm.setBounds(0,0,200,75);
		this.panelForm.setLayout(new GridLayout (2,2));
		this.panelForm.add(new JLabel ("Dimensions :"));
		this.panelForm.add(this.txtDim);
		this.panelForm.add(this.btAnnuler);
		this.panelForm.add(this.btJouer);
		this.add(this.panelForm);
		
		//rendre les boutons ecoutables
		this.btAnnuler.addActionListener(this);
		this.btJouer.addActionListener(this);

	}
	public void effacerChamps() {
		this.txtDim.setText(null);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.btAnnuler) {
			this.effacerChamps();
		}
		else if (e.getSource() == this.btJouer) {
			int dim;
			try {
				   dim = Integer.parseInt(this.txtDim.getText());
				}
				catch (NumberFormatException exp) {
				   dim = 0;
				}
			if (dim != 0) {
				this.effacerChamps();
				Demineur.creerDetruirePartie(true,dim);
				Demineur.rendreVisibleVueAccueil(false);
			}else {
				this.effacerChamps();
				Demineur.creerDetruirePartie(true);
				Demineur.rendreVisibleVueAccueil(false);
			}
		}
	}

}
