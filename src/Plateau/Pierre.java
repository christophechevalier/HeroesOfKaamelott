package Plateau;

import java.util.Random;

public class Pierre extends ElementMobile {


	public Pierre(FenetreMap fenetreMap) {
		super(fenetreMap, 'P', "rocher.png", "Pierre");
		this.vivant = true;
		//System.out.println("PIERRE: X =" +getX() +"Y =" + getY());
	}

	@Override
	public void seDeplacer() {
		//Ne rien faire
	}

	@Override
	protected void changerDirection() {
		//Ne rien faire
	}
	
	public void bouger(){
//		int x = this.calculerNouveauX();
//		int y = this.calculerNouveauY();
//		System.out.println("Y A UNE PIERRE ICI");
//		System.out.println("X :"+getX()+ " Y : "+getY());
		
		if(Hulk.direction == 0){	// Si le monstre allé vers le  nord lors du deplacement de la pierre
			if(getY()>1){
			setY(y-1);	//La pierre va vers le nord
			}
		}
		else if(Hulk.direction == 1){	// Si le monstre allé vers l'est lors du deplacement de la pierre
			if(getX()<fenetreMap.LARGEUR-3){
			setX(x+1);	//La pierre va vers l'est
			}
		}
		else if(Hulk.direction == 2){	// Si le monstre allé vers le sud lors du deplacement de la pierre
			if(getX()<fenetreMap.HAUTEUR-3){
			setY(y+1);	//La pierre va vers le sud
			}
		}
		else if(Hulk.direction == 3){	// Si le monstre allé vers l'ouest lors du deplacement de la pierre
			if(getX()>1){
			setX(x-1);	//La pierre va vers l'ouest
			}
		}
	}
	
}
