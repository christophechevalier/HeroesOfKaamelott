package Affichage;

import javax.swing.JFrame;

public class PlateauFenetre extends JFrame	{
	private static final long serialVersionUID = -6563585351564617603L;
	private final PlateauPanneau plateauPanneau;

	public PlateauFenetre(int largeur, int hauteur, PlateauCase[][] plateauCases)
	{
		setTitle("Plateau de jeu");
		setSize(700, 700);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(3);
		this.plateauPanneau = new PlateauPanneau(largeur, hauteur, plateauCases);
		setContentPane(this.plateauPanneau);
		setVisible(true);
	}

	public void placerPiece(PlateauPiece piece)
	{
		this.plateauPanneau.placerPiece(piece);
	}

	public void rafraichir()
	{
		this.plateauPanneau.repaint();
	}
}

