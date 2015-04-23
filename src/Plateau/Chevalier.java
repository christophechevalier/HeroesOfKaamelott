package Plateau;

import java.util.Random;

public class Chevalier extends ElementMobile {

	public Chevalier(FenetreMap fenetreMap) {
		super(fenetreMap, 'C', "chevalier.png", "Chevalier");
		this.vivant = true;
	}

	@Override
	protected void changerDirection() {
		int i;

		final int x = this.calculerNouveauX();	//Asigne la variable x la nouvelle valeur de deplacement sur les x
		final int y = this.calculerNouveauY();	//Asigne la variable y la nouvelle valeur de deplacement sur les y

		if (!this.fenetreMap.getXY(x, y).estVide()) {
			this.direction =  new Random().nextInt(3);	// Random entre 0 et 3 pour indiquer la direction de deplacement du personnnage
		}

		ElementMobile e = this.fenetreMap.getElementMobile(this.calculerNouveauX(),this.calculerNouveauY());	// Check si la case sur lequel se deplace le personnage contient une pierre
		if (e != null) {																						//Si la case contient une pierre alors il appelle la methode qui va la deplacer
			if (e.getEspece().equals("Pierre")){
				Pierre pierre = (Pierre) e;
				pierre.bouger();
			}	
		}
	}

	public void mourir() {
		this.vivant = false;
		this.dessin = 'C';
		this.setImage("croix.png");
		//fenetreMap.nbDeChevalier --;
		Dragon.vieDragon-=30;	//Inflige 30 pt de dgt au dragon quand un chevalier meurt
	}

	@Override
	public void seDeplacer() {
		if (!this.vivant) {	//  Si le chevalier et mort alors le personnage ne se deplace pas
			return;
		}
		super.seDeplacer();
	}
}
