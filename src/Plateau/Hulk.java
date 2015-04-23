package Plateau;

import java.util.Random;

public class Hulk extends ElementMobile {

	//	NE SURTOUT PAS OUBLIER DE SUPPRIMER LA LIGNE QUI SUIT SINON LE MONSTRE NE PREND PAS DE PV
	//public Boolean vivant;

	public Hulk(FenetreMap fenetreMap) {
		super(fenetreMap, 'H', "hulk.png", "Hulk");
		this.vivant = true;
	}

	@Override

	protected void changerDirection() {
		this.direction = new Random().nextInt(4);


		int x = this.calculerNouveauX();	//Asigne la variable x la nouvelle valeur de deplacement sur les x
		int y = this.calculerNouveauY();	//Asigne la variable y la nouvelle valeur de deplacement sur les y


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
		this.dessin = 'H';
		this.setImage("croix.png");
		Dragon.vie++;	//BUF, quand un hulk meurt il incremente la  variable qui lui fait perdre de la vie
		if(Dragon.vie>2){ //dès que 1HULK meurt le monstre perd 1pv de plus à chaque tour / limite de 3pv/tour
			Dragon.vie=3; 
		}
	}


	@Override
	public void seDeplacer() {
		if (!this.vivant) {
			return;
		}
		super.seDeplacer();
		//		System.out.println("HULK : X =" +getX() +"Y =" + getY());
		//valeurX=getX();
		//valeurY=getY();
	}

}
