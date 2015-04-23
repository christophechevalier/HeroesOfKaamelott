package Menu;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.WindowConstants;


public class PopUpVictory extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panelMain, panelVictoire;
	private JButton menuReturn;

	public Boolean reponseMenuReturn = null;
	String ligne1="\" Félicitation, vous avez gagné !\"";

	Font policeTitreEtBoutons = new Font("Segoe Marker", Font.BOLD, 30);
	Font policeTexte = new Font("Segoe Script", Font.BOLD, 15);

	/*********************************
	 * *******************************
	 * TODO CONSTRUCTEUR POPUP
	 * *******************************
	 *//******************************/	

	public PopUpVictory()  {

		/*********************************
		 * *******************************
		 * TODO PANEL PRINCIPAL
		 * *******************************
		 *//******************************/	
		
		super();				
		final JPanel panelMain = new JPanel();

		panelMain.setOpaque(true);
		panelMain.setBackground(Color.lightGray);
		
		this.add(panelMain);
		this.setVisible(true);
		this.setSize(450,600);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); 
		/*********************************
		 * *******************************
		 * TODO TITRE + TEXTE
		 * *******************************
		 *//******************************/	
		
		// GridLayout = nombres de lignes par le nombres de colonnes
		JPanel p = new JPanel(new GridLayout(2,1));
		p.setBackground(Color.lightGray);
		
		// label 1
		JLabel texteTitre = new JLabel("<html>Heroes of Kaamelott</html>");
		texteTitre.setOpaque(true);		
		texteTitre.setFont(policeTitreEtBoutons);
		texteTitre.setHorizontalAlignment(SwingConstants.CENTER);
		texteTitre.setVerticalAlignment(SwingConstants.CENTER);
		texteTitre.setBackground(Color.darkGray);

		// label 2
		JLabel textePopup = new JLabel("<html><br>"+ligne1+"<br/></html>");		
		textePopup.setFont(policeTexte);
		textePopup.setVerticalAlignment(SwingConstants.CENTER);

		// ajout du panneau titre + texte
		p.add(texteTitre);	
		p.add(textePopup);
		panelMain.add(p);

		/*********************************
		 * *******************************
		 * TODO BOUTON MENU RETURN + IMAGE FOND
		 * *******************************
		 *//******************************/	
		
		panelVictoire = new JPanel();	
		panelVictoire.setOpaque(true);
		panelVictoire.setFont(policeTexte);

		// imageicon dragon
		ImageIcon bandeau = new ImageIcon();
		bandeau.getIconWidth();
		bandeau.getIconHeight();
		
		// buton win
		menuReturn = new JButton("You Win !", new ImageIcon("images/seli.png" ));
		menuReturn.setFont(policeTitreEtBoutons);  
		menuReturn.setCursor( Cursor.getPredefinedCursor(12));
		menuReturn.setToolTipText("Press To Quit");
		menuReturn.setOpaque(false);
		menuReturn.addActionListener(this);	
		this.menuReturn.setActionCommand("menuReturn");

		// ajout du bouton win
		panelVictoire.add(menuReturn);
		panelMain.add(panelVictoire);	
	}

	/*********************************
	 * *******************************
	 * TODO EVENEMENT BOUTON MENU RETURN
	 * *******************************
	 *//******************************/	
	


	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == menuReturn) {

			menuReturn.setEnabled(false);
			this.reponseMenuReturn = false;
			this.setVisible(false);
			new FenetreMenu();
			System.out.println("ouvretoi");
			System.exit(0);
			
		}
		else {
			System.exit(0);	
		}	
	}

	public Boolean getReponseMenuReturn() {

		return this.reponseMenuReturn;
	}
}



