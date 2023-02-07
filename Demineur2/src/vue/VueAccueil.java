package vue;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class VueAccueil extends JFrame implements ActionListener {


	private JButton btQuitter = new JButton("Quitter");
	private JButton btP = new JButton("Aleatoire");
	private JButton btPD = new JButton("Dimensions");
	private JButton btPDB = new JButton("Dim + Bombe");

	
	private JTextField txtDim = new JTextField();
	private JTextField txtBombes = new JTextField();
	
	private PanelPartie unPanelP = new PanelPartie();
	private PanelPartieDim unPanelPD = new PanelPartieDim();
	private PanelPartieDimBombe unPanelPDB = new PanelPartieDimBombe();
	
	public VueAccueil() {
		
		//parametrage fenetre
		this.setTitle("Accueil demineur");
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setBounds(100,100,300,250);
        this.setResizable(false);
        this.setLayout(null);
        this.getContentPane().setBackground(Color.orange);
        
        
        //parametrage boutons et champs de texte
        
        this.btQuitter.setBounds(112,150,70,50);
        this.add(this.btQuitter);
        
        this.btP.setBounds(15,10,90,40);
        this.btP.setEnabled(false);
        this.add(this.btP);
        
        this.btPD.setBounds(105,10,90,40);
        this.add(this.btPD);
        
        this.btPDB.setBounds(195,10,90,40);
        this.add(this.btPDB);
        
        //ajout des panneaux
        
        this.add(this.unPanelP);
        this.add(this.unPanelPD);
        this.add(this.unPanelPDB);
                
        //rendre les boutons ecoutables
        this.btQuitter.addActionListener(this);
        this.btP.addActionListener(this);
        this.btPD.addActionListener(this);
        this.btPDB.addActionListener(this);
        
        this.setVisible(true);
	}
	public void afficherPanel (int choix) {
		
    	this.unPanelP.setVisible(false);
    	this.unPanelPD.setVisible(false);
    	this.unPanelPDB.setVisible(false);
    	this.btP.setEnabled(true);
    	this.btPD.setEnabled(true);
    	this.btPDB.setEnabled(true);

    	
    	switch(choix) {
    	
	    	case 1:this.unPanelP.setVisible(true);this.btP.setEnabled(false);break;
	    	case 2:this.unPanelPD.setVisible(true);this.btPD.setEnabled(false);break;
	    	case 3:this.unPanelPDB.setVisible(true);this.btPDB.setEnabled(false);break;
    	}
    }
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == this.btP) {
			this.afficherPanel(1);
		}
		else if (e.getSource() == this.btPD) {
			this.afficherPanel(2);
		}
		else if (e.getSource() == this.btPDB) {
			this.afficherPanel(3);
		}
		else if (e.getSource() == this.btQuitter) {
			this.dispose();
		}
	}

}
