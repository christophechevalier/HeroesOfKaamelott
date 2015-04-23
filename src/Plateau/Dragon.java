package Plateau;

import java.util.Random;

import Menu.DonjonEtDragon;

public class Dragon extends ElementMobile {

	private int i=1;
	private int valeurRandom=0;
	private int nombreDeplacementDragon=0;
	public static int vieDragon =250;
	public static int positionDuMonstreX;
	public static int positionDuMonstreY;
	public static int vie=1;
	public static int enVie=1;

	// ACCESSEUR POUR LE NB DE DEPLACEMENT DU DRAGON
	public int getNombreDeplacementDragon() {
		return nombreDeplacementDragon;
	}
	
	public Dragon(FenetreMap fenetreMap) {
		super(fenetreMap, 'D', "dragon.png", "Dragon");
		this.vivant=true;
	}

	@Override
	protected void changerDirection() {
		nombreDeplacementDragon++;	//Calcule le nombre de deplacement du monstre, accesseur pour recup cette valeur
		valeurRandom++;		//Incremente la valeur de la variable qui as pour limite 25. A  25 elle revient a 0

		final int x = this.calculerNouveauX();	//Asigne la variable x la nouvelle valeur de deplacement sur les x
		final int y = this.calculerNouveauY();	//Asigne la variable y la nouvelle valeur de deplacement sur les y

		if (!this.fenetreMap.getXY(x, y).estVide()) {	// A chaque fois que la case de la nouvelle  valeur x ou y n'est pas vide il rentre dans la condition
			this.direction = i++;	//Change de direction si la case sur lequel il veut aller n'est pas vide

			if(i>=3){	// Nord, est, sud, ouest
				i=0;
			}		 

		}
		if(valeurRandom == 25){	//Quand la variable atteint 25, elle tire une direction au random
			this.direction = new Random().nextInt(4);
			//System.out.println("VALEUR RANDOM");
			valeurRandom=0;
		}
		
//////////////////////////////////////////////////////////////////////////////////////////

		ElementMobile e = this.fenetreMap.getElementMobile(this.calculerNouveauX(),this.calculerNouveauY());
		if(this.direction==0){
			//System.out.println("Le dragon va vers le nord");
		}
		else if(this.direction==1){
			//System.out.println("Le dragon va vers le est");
		}
		else if(this.direction==2){
			//System.out.println("Le dragon va vers le sud");
		}
		else if(this.direction==3){
			//System.out.println("Le dragon va vers le ouest");
		}
		
		if (e != null) {	//Si la case ou le dragon s'est déplacé  n'est pas vide, et si elle contient un hulk alors il execute le if qui suit
				if (e.getEspece().equals("Hulk")) {
					System.out.println("");
					System.out.println("");
					System.out.println("DRAGON: X =" +getX() +"Y =" + getY());
					Hulk hulk = (Hulk) e;
					
					if(e.estVivant() == true){	//Le monstre prend 20pv quand il tue un hulk
						this.vieDragon = vieDragon+20;
						fenetreMap.nbDeHulk--;	//CALCULE LE NOMBRE DE HULK ENCORE EN vieDragon - VARIABLE PUBLIC
						
					}
					
					
					//fenetreMap.nbDeChevalierRestant<0 && fenetreMap.nbDeHulkRestant<0
					
					hulk.mourir();
					
					//System.out.println(vieDragon);
				}
				else if (e.getEspece().equals("Chevalier")) {	//Si la case ou le dragon s'est déplacé  n'est pas vide, et si elle contient un chevalier alors il execute le else if qui suit
					Chevalier chevalier = (Chevalier) e;
					
					if(e.estVivant() == true){	//Le monstre prend 20pv quand il tue un hulk
						this.vieDragon = vieDragon+20;
						fenetreMap.nbDeChevalier--;	//CALCULE LE NOMBRE DE CHEVALIER ENCORE EN vieDragon - VARIABLE PUBLIC
						System.out.println("NB DE CHEVALIER : "+fenetreMap.nbDeChevalier);	
					}
					
					chevalier.mourir();
	
					//System.out.println(vieDragon);
				}
		}
	}
	
	@Override
	public void seDeplacer() {

		if(vieDragon > 0){	//tant que le dragon a plus de 0pv il se déplace, il perd un pv à chaque tour, sauf si il a recu des malus des personnages
			super.seDeplacer();
			vieDragon=vieDragon-vie;
			System.out.println(vieDragon);
			//System.out.println("DRAGON: X =" +getX() +"Y =" + getY());
			positionDuMonstreX = getX();
			positionDuMonstreY = getY();
			System.out.println("NB DE HULK : "+fenetreMap.nbDeHulk);
			if(fenetreMap.nbDeHulk <= 0 && fenetreMap.nbDeChevalier <= 0){
				//System.out.println("QUITTE TOUTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT");
				DonjonEtDragon.lancerPopUpDefeat();
			}
		}
		
		
		else{
			this.vivant = false;
			mourir();
		}
	}
	public void mourir() {
		this.vivant = false;
		this.dessin = 'H';
		this.setImage("croixDragon.png");
		this.enVie=0;
		DonjonEtDragon.lancerPopUpVictory();		
	}
	
}
