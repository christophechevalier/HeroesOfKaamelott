package Affichage;

import java.awt.Graphics;
import java.util.ArrayList;
import javax.swing.JPanel;

public class PlateauPanneau extends JPanel	{
	private static final long serialVersionUID = -3618605287900763008L;
	private final PlateauCase[][] plateauCases;
	private final ArrayList<PlateauPiece> pieces;
	private final int largeur;
	private final int hauteur;

	public PlateauPanneau(int largeur, int hauteur, PlateauCase[][] plateauCases)
	{
		this.largeur = largeur;
		this.hauteur = hauteur;
		this.plateauCases = plateauCases;
		this.pieces = new ArrayList();
	}

	public void paintComponent(Graphics g)
	{
		int tailleLargeur = getWidth() / this.largeur;
		int tailleHauteur = getHeight() / this.hauteur;
		int j;
		for (int i = 0; i < this.largeur; i++) {
			for (j = 0; j < this.hauteur; j++) {
				g.drawImage(this.plateauCases[i][j].getImage(), tailleLargeur * i, tailleHauteur * 
						j, tailleLargeur, tailleHauteur, this);
			}
		}
		for (PlateauPiece piece : this.pieces) {
			g.drawImage(piece.getImage(), tailleLargeur * piece.getPositionHorizontale(), 
					tailleHauteur * piece.getPositionVerticale(), tailleLargeur, tailleHauteur, 
					this);
		}
	}

	public void placerPiece(PlateauPiece piece)
	{
		this.pieces.add(piece);
	}
}
