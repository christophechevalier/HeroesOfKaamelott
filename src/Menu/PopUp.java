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

public class PopUp extends JFrame implements ActionListener {

	private static final long serialVersionUID = 1L;
	private JPanel panelMain, panelContinue;
	private JButton enter;

	public Boolean reponseEnter = null;
	String ligne1="\" Seigneur, je me vouerai tout entier à la noble quête dont vous m’honorâtes.";
	String ligne2="Mais avec l’équipe de romanos que je me promène, on n’est pas sorti des ronces. \"";
	String ligne3="ARTHUR";

	Font policeTitreEtBoutons = new Font("Segoe Marker", Font.BOLD, 30);
	Font policeTexte = new Font("Segoe Script", Font.BOLD, 15);

	/*********************************
	 * *******************************
	 * TODO CONSTRUCTEUR POPUP
	 * *******************************
	 *//******************************/	

	public PopUp()  {

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
		this.setSize(680,800);
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
		JLabel textePopup = new JLabel("<html><br>"+ligne1+"<br>"+ligne2+"<br>"+ligne3+"<br/></html>");		
		textePopup.setFont(policeTexte);
		textePopup.setVerticalAlignment(SwingConstants.CENTER);

		// ajout du panneau titre + texte
		p.add(texteTitre);	
		p.add(textePopup);
		panelMain.add(p);

		/*********************************
		 * *******************************
		 * TODO BOUTON ENTER + IMAGE FOND
		 * *******************************
		 *//******************************/	
		
		panelContinue = new JPanel();	
		panelContinue.setOpaque(true);
		panelContinue.setFont(policeTexte);

		// imageicon dragon
		ImageIcon bandeau = new ImageIcon();
		bandeau.getIconWidth();
		bandeau.getIconHeight();
		
		// buton enter
		enter = new JButton("Enter", new ImageIcon("images/DragonOrigins.png" ));
		enter.setFont(policeTitreEtBoutons);  
		enter.setCursor( Cursor.getPredefinedCursor(12));
		enter.setToolTipText("Press To Continue");
		enter.setOpaque(false);
		enter.addActionListener(this);	
		this.enter.setActionCommand("enter");

		// ajout du bouton enter
		panelContinue.add(enter);
		panelMain.add(panelContinue);	
	}

	/*********************************
	 * *******************************
	 * TODO EVENEMENT BOUTON ENTER
	 * *******************************
	 *//******************************/	
	
	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == enter) {

			enter.setEnabled(false);
			this.reponseEnter = false;
			this.setVisible(false);

		}
		else {
			System.exit(0);	
		}	
	}

	public Boolean getReponseEnter() {

		return this.reponseEnter;
	}
}



