package Menu;

import Plateau.Dragon;
import Plateau.ElementMobile;
import Plateau.FenetreMap;


public class DonjonEtDragon {

	public static void main(final String [] args){

		try {
			Sound.soundIntroPopUp.play();
			PopUp pop = new PopUp();
			pop.setVisible(true);	

			while (pop.reponseEnter == null){
				Thread.sleep(1);
			}

			if(pop.reponseEnter.equals(true)){
				//System.out.println("Saut");				//Test Console	
				lancerPopUp();
			}					
		}
		catch (final Exception e){
			e.printStackTrace();
		}

		Sound.soundIntroPopUp.stop();
		Sound.soundDonjon.loop();
		//Sound.soundOnEnAGros.play();

		try {

			FenetreMenu fen = new FenetreMenu();
			fen.setVisible(true);

			while (fen.reponseStart == null){
				Thread.sleep(1);
			}			

			if(fen.reponseStart.equals(true)){
				//System.out.println("Saut");				//Test Console	
				Sound.soundDonjon.stop();
				Sound.soundOnEnAGros.stop();
				Sound.soundPushStart.play();
				Sound.soundMapArene.loop();

				lancerJeu(fen.currentValueCases, fen.currentValueWall, fen.currentValueHulk, fen.currentValueKnight, fen.currentValueObstacles, fen.currentValueVitesseJeu);
			}					
		}
		catch (final Exception e){
			e.printStackTrace();
		}

		//Apres resultat Victoire ou Defaite
		try {
			PopUpVictory popUpVictory = new PopUpVictory();
			popUpVictory.setVisible(true);	
			PopUpDefeat popUpDefeat = new PopUpDefeat();
			popUpDefeat.setVisible(true);

			while (popUpVictory.reponseMenuReturn == null){
				Thread.sleep(1);
			}

			if(popUpVictory.reponseMenuReturn.equals(true)){
				//System.out.println("Saut");				//Test Console	
				lancerPopUp();
			}	
			else if(popUpDefeat.reponseMenuReturn1.equals(true)){
				//System.out.println("Saut");				//Test Console	
				lancerPopUp();
			}
			
		}
		catch (final Exception e){
			e.printStackTrace();
		}
	}


	public static void lancerJeu(int currentValueCases, int currentValueWall, int currentValueHulk, int currentValueKnight, int currentValueObstacles, int currentValueVitesseJeu) {

		final FenetreMap fenetreMap = new FenetreMap(currentValueCases, currentValueWall, currentValueHulk, currentValueKnight, currentValueObstacles, currentValueVitesseJeu);


		if(Dragon.enVie==1){
			for (;;) {

				fenetreMap.afficher();
				fenetreMap.jouer();
				//lancerPopUpInfo();

				try {
					Thread.sleep(FenetreMap.vitesseTour);
				} 
				catch (final InterruptedException e) {
					e.printStackTrace();
				}
				if(Dragon.enVie==0){
					return;
				}
			}
		}
	}

	public static void lancerPopUp()  {
		//		try {
		Sound.soundIntroPopUp.play();
		final PopUp pop = new PopUp();			
		//		} catch (Exception e){
		//			e.printStackTrace();
		//		}
	}

	public static void lancerPopUpVictory()  {
		try {
			PopUpVictory popUpVictory = new PopUpVictory();
			popUpVictory.setVisible(true);
			
			while (popUpVictory.reponseMenuReturn == null){
				Thread.sleep(1);
			}

			if(popUpVictory.reponseMenuReturn.equals(true)){
				//System.out.println("Saut");				//Test Console	
				lancerPopUp();
			}					
		}
		catch (final Exception e){
			e.printStackTrace();
		}


	}
	
	public static void lancerPopUpDefeat()  {
		try {
			PopUpDefeat popUpDefeat = new PopUpDefeat();
			popUpDefeat.setVisible(true);	

			while (popUpDefeat.reponseMenuReturn1 == null){
				Thread.sleep(1);
			}

			if(popUpDefeat.reponseMenuReturn1.equals(true)){
				//System.out.println("Saut");				//Test Console	
				lancerPopUp();
			}					
		}
		catch (final Exception e){
			e.printStackTrace();
		}
	}
		public static void lancerPopUpInfo()  {
			try {
				PopUpInfo popUpInfo = new PopUpInfo();
				popUpInfo.setVisible(true);			
			}
			catch (final Exception e){
				e.printStackTrace();
			}
		
	}
		
}
