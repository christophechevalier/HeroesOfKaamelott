package Menu;

import java.applet.Applet;
import java.applet.AudioClip;

/*********************************
 * *******************************
 * TODO ALL SOUNDS
 * *******************************
 *//******************************/

public class Sound {

	private AudioClip clip;	
	public static final Sound soundDonjon = new Sound("/DonjonAdventure.wav");
	public static final Sound soundIntroPopUp = new Sound("/drakeIntro.wav");
	public static final Sound soundPushStart = new Sound("/cestPasFaux.wav");
	public static final Sound soundMapArene = new Sound("/CombatArene.wav");
	public static final Sound soundOnEnAGros = new Sound("/onEnAGros.wav");
	
	/*********************************
	 * *******************************
	 * TODO CONSTRUCTEUR SOUND
	 * *******************************
	 *//******************************/
	
	public Sound(String filename){

		try{
			clip = Applet.newAudioClip(Sound.class.getResource(filename));
		}
		catch(Exception e){
			e.printStackTrace();
		}
	}
	
	/*********************************
	 * *******************************
	 * TODO SOUND PLAY
	 * *******************************
	 *//******************************/
	
	public void play(){

		try{
			new Thread(){

				public void run(){

					clip.play();
					//System.out.println("musicPlay");
				}
			}.start();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}

	/*********************************
	 * *******************************
	 * TODO SOUND STOP
	 * *******************************
	 *//******************************/
	
	public void stop(){

		try{
			new Thread(){

				public void run(){

					clip.stop();
					//System.out.println("musicPlay");
				}
			}.start();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
	

	/*********************************
	 * *******************************
	 * TODO SOUND LOOP
	 * *******************************
	 *//******************************/
	
	public void loop(){

		try{
			new Thread(){

				public void run(){

					clip.loop();
					//System.out.println("boucleMusic");
				}
			}.start();
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
	}
}