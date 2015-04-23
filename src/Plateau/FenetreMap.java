package Plateau;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import Affichage.Plateau;

public class FenetreMap {

	public static int NB_CASES = 300;
	public static int vitesseTour;
	private static int TAILLEGRILLE = (int)Math.sqrt(NB_CASES);
	public static int LARGEUR = TAILLEGRILLE;
	public static int HAUTEUR = TAILLEGRILLE;
	private Case cases[][];
	private Random hasard;
	private ArrayList<ElementMobile> mobiles;
	
	private int nb_cases;
	private int tailleGrille;
	private int largeur;
	private int hauteur;
	
	public int nbDeCases;
	public int nbWall;
	public int nbDeHulk;
	public int nbDeChevalier;
	public int nbObstacles; //nbDePierre
	
	/*
	 *  Liste des bugs pierre:
	 *  
	 *  Les pierres se superposes
	 *  Les pierres sortent des bordures
	 *  les pierres qui sont placé sur des corps sont imbougeable par les personnages
	 *  Les monstres passe sur les pierres 
	 *  
	 *  Faire appaitre les pv du monstre
	 *  faire apparaiitre le nombre de pas du monstre
	 *  le nombre de perso /race encore en vie ;)
	 *  
	 */
	
	
//	public int NB_DE_HULK_RESTANT=NB_HULK;
//	public int NB_DE_CHEVALIER_RESTANT=NB_CHEVALIER;
	
	public int getNb_cases() {
		return nb_cases;
	}
	public void setNb_cases(int nb_cases) {
		this.nb_cases = nb_cases;
	}
	public int getTailleGrille() {
		return tailleGrille;
	}
	public void setTailleGrille(int tailleGrille) {
		this.tailleGrille = tailleGrille;
	}
	public int getLargeur() {
		return largeur;
	}
	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}
	public int getHauteur() {
		return hauteur;
	}
	public void setHauteur(int hauteur) {
		this.hauteur = hauteur;
	}

	private Boolean affichageConsole = false;
	private Plateau plateau;
	
	public FenetreMap(int currentValueCases, int currentValueWall , int currentValueHulk, int currentValueKnight, int currentValueObstacles, int currentValueVitesseJeu) {
		this.nbDeCases=currentValueCases;
		this.nbWall=currentValueWall;
		this.nbDeChevalier=currentValueKnight;
		this.nbObstacles=currentValueObstacles;
		this.nbDeHulk=currentValueHulk;
		this.vitesseTour=currentValueVitesseJeu;
		creerFenetreMap(currentValueCases, currentValueObstacles, currentValueHulk, currentValueKnight, currentValueWall, currentValueVitesseJeu);		
	}

	public void afficher() {
		if (this.affichageConsole) {
			//this.afficherConsole();
		} else {
			this.afficherGraphique();
		}
	}

	private void afficherGraphique() {
		this.plateau.rafraichir();
	}

	private Case construireBordure() {
		return new Bordure();
	}

	private Case construireSol() {
		return new Vide();
	}


	public ElementMobile getElementMobile(final int x, final int y) {
		for (final ElementMobile e : this.mobiles) {
			if (e != null) {
				if ((e.getX() == x) && (e.getY() == y)) {
					return e;
				}
			}
		}
		return null;
	}

	public Case getXY(final int x, final int y) {
		return this.cases[x][y];
	}

	public void jouer() {
		for (final ElementMobile e : this.mobiles) {
			e.seDeplacer();
		}
	}

	
	
	private void placerLesPierre() { //********************************************      OK       *************************************
		Pierre p;
		for (int i = 0; i < nbObstacles; i++) {
			p = new Pierre(this);
			this.mobiles.add(p);
			this.placerUnElementMobileAuHasard(p);
			this.plateau.placerPiece(p);
		}
	}
	
	private void placerLesHulk() { 
		Hulk h;
		for (int i = 0; i < nbDeHulk; i++) {
			h = new Hulk(this);
			this.mobiles.add(h);
			this.placerUnElementMobileAuHasard(h);
			this.plateau.placerPiece(h);
		}
	}

	private void placerLesKnight() { 
		Chevalier c;
		for (int i = 0; i < nbDeChevalier; i++) {
			c = new Chevalier(this);
			this.mobiles.add(c);
			this.placerUnElementMobileAuHasard(c);
			this.plateau.placerPiece(c);
		}
	}

	private void placerLeDragon() { // Changer le nom de la methode
		final Dragon dragon= new Dragon(this);
		this.mobiles.add(dragon);
		this.placerUnElementMobileAuHasard(dragon);
		this.plateau.placerPiece(dragon);
	}

	private void placerUnElementMobileAuHasard(final ElementMobile e) { // On change pas le nom
		int x = this.hasard.nextInt(this.getLargeur());
		int y = this.hasard.nextInt(this.getHauteur());
		while ((!this.getXY(x, y).estVide()) && (this.getElementMobile(x, y) == null)) {
			x = this.hasard.nextInt(this.getLargeur());
			y = this.hasard.nextInt(this.getHauteur());
		}
		e.setX(x);
		e.setY(y);
	}

	public void setXY(final int x, final int y, final Case c) {
		this.cases[x][y] = c;
	}
	
	
	public void creerFenetreMap(int currentValueCases, int currentValueWall, int currentValueObstacles, int currentValueHulk, int currentValueKnight, int currentValueVitesseJeu) {
		
		int tailleGrille = (int)Math.sqrt(currentValueCases);
		this.setTailleGrille(tailleGrille);
		
		int largeur = tailleGrille;
		this.setLargeur(largeur);
		
		int hauteur = tailleGrille;
		this.setHauteur(hauteur);
		
		ArrayList<String> arrList = new ArrayList<String>();
		this.cases = new Case[largeur][hauteur];
		this.hasard = new Random();
		this.mobiles = new ArrayList<>();

		Case uneCase = null;
		for (int y = 0; y < hauteur; y++) {
			for (int x = 0; x < largeur; x++) {
				uneCase = this.construireSol();
				this.setXY(x, y, uneCase);	
			}
		}
		for (int y = 0; y < hauteur; y++) {
			for (int x = 0; x < largeur; x++) {
				if ((x == 0) || (x == (largeur - 1)) || (y == 0) || (y == (hauteur - 1))) {
					uneCase = new Bordure();
					this.setXY(x, y, uneCase);
				}
			}
		}

		// EMPLACEMENT DES MURS  
		int numLigne=0;
		int numCol=0;
		int v = nbWall;
		int tour=1;
		String valeurConcatene=null;
		while(v!=0){
			numLigne = (int) (Math.random()*largeur-1);
			numCol = (int) (Math.random()*hauteur-1);

			
			
			while(numLigne==0 || numCol==0 || numLigne==largeur || numCol==hauteur){	//Genere aléatoirement l'emplacement des murs
				numLigne = (int) (Math.random()*largeur-1);
				numCol = (int) (Math.random()*hauteur-1);
//				System.out.println(numLigne +"///"+numCol);
			}
			
			valeurConcatene= ""+numLigne+numCol;		//CAST le int en String et concataine les deux variable (v1=20, v2=20 donne 2020)	
			//CAST LES RANDOM DANS UN ARRAYLIST	
			arrList.add(valeurConcatene);		//Ajoute la valeurConcatene à l'arrayList
		
//			for(String elem: arrList){		//Affiche les valeur de l'arraylist en console
//				System.out.println("Valeur de l'arrayList1 :" +elem);
//			}
			
			//PARCOUR UN TABLEAU DARRAYLIST ET CHECK SI LA DERNIERE VALEUR RAND EXISTE DEJA
			
			// Créer une liste de contenu sans doublon basée sur les éléments de l'ArrayList
		    Set<String> mySet = new HashSet<String>(arrList);
		 
		    // Afficher le contenu de ArrayList
//		    System.out.println("Contenu sans doublon: "+mySet);
		    
		    /*Comme l'on génère un chiffre par tour, on teste la condition (SI le nombre d'element contenu dans l'arrayList
		     * est inférieure au nombre de tour, ça veux dire qu'il y à eu un doublon. On doit donc incrementé la variable "v"
		     * pour que la boucle s'execute une fois de plus.
		     * Il est 2h35 du matin
		     */
		    if(mySet.size()<tour){		//Calcule le nombre d'element que contient l'Arraylist
//		    System.out.println("Taille de l'arrayList plus petite que le tour :" + mySet.size());
		    v++;
		    tour--;	//Decremente la variable tour, puisque la derniere valeur  random etait un doublon, et quelle à était supprimé.
		    }
			

			for (int y = 0; y < hauteur; y++) {
				for (int x = 0; x < largeur; x++) {

					if(numLigne==x && numCol==y){
						uneCase = this.construireBordure();
						this.setXY(x, y, uneCase);
						
					}
				}
			}
			v--;
//			System.out.println("Tour" +tour);
			tour++;
		}

		this.plateau = new Plateau(largeur, hauteur, this.cases);

		this.placerLesHulk();	//Place les hulk sur la map
		this.placerLesKnight();	//Place les chevalier sur la map
		this.placerLeDragon();	//Place le dragon sur la map
		this.placerLesPierre();	//Place les pierres sur la map
	}
	
}
