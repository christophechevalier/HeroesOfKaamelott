package Menu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.ImageIcon;

import java.util.Hashtable;

import Plateau.FenetreMap;

/*********************************
 * *******************************
 * TODO FENETREMENU
 * *******************************
 *//******************************/

public class FenetreMenu extends JFrame implements ChangeListener, ActionListener  {

	private static final long serialVersionUID = 1L;
	public static String NAME = "Sound";	
	public static int minCases = 100;
	public static int maxCases = 10000;
	public static int initCases = FenetreMap.NB_CASES;
	
	public static int minWall = 0;
	public static int maxWall = 50;
	public static int initWall = 20;
	
	public static int minObstacles = 0;
	public static int maxObstacles = 50;
	public static int initObstacles = 25;

	public static int minHulk = 0;
	public static int maxHulk = 80;
	public static int initHulk = 4;
	
	public static int minKnight = 0;
	public static int maxKnight = 80;	
	public static int initKnight = 4;
	
	public static int minVitesseJeu = 20;
	public static int maxVitesseJeu = 800;	
	public static int initVitesseJeu = 250;
	
	// nombre de cases sélectionnées
	public static int currentValueCases = initCases;
	// nombre de wall sélectionnés
	public static int currentValueWall = initWall;
	// nombre de Hulk sélectionnés
	public static int currentValueHulk = initHulk;		
	// nombre de Knight sélectionnés
	public static int currentValueKnight = initKnight;	
	// nombre de pierre sélectionnés
	public static int currentValueObstacles = initObstacles;
	// vitesse jeu sélectionnés
	public static int currentValueVitesseJeu = initVitesseJeu;
	
	private JButton start, quit, nbrDeCases, nbrDeHeros1, nbrDeHeros2, nbrWall, nbrObstacles, classicMode, hitAndRun, vitesseJeu;
	private JLabel texteTitre, texteBoutonsEtSliders, imagaOnEnAGros;
	private JPanel p1, p2, p3, p4, p5, containerPrincipal;
	
	Font policeTitre = new Font("Segoe Marker", Font.BOLD, 30);
	Font policeBoutons = new Font("Segoe Script", Font.BOLD, 15);

	int longueurButton = 150;
	int hauteurButton = 100;
	
	public Boolean reponseStart = null;

	
	/*********************************
	 * *******************************
	 * TODO CONSTUCTEUR FENETREMENU
	 * *******************************
	 *//******************************/

	public FenetreMenu(){							
		// GridLayout = nombres de lignes par le nombres de colonnes
		containerPrincipal = new JPanel(new GridLayout(5,4));								
		containerPrincipal.setOpaque(true);
		
		super.getContentPane().add(containerPrincipal);	
		
		this.setVisible(true);	
		this.setResizable(false);
		this.setVisible(true);
		this.setSize(800,1000);
		this.setResizable(false);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null); 
		
		
		/*********************************
		 * *******************************
		 * TODO TITRE
		 * PANEL 1
		 * *******************************
		 *//******************************/	
		
		// GridLayout = nombres de lignes par le nombres de colonnes
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		p1.setBackground(Color.lightGray);	
		
		// label 1
		JLabel imagaOnEnAGros = new JLabel(new ImageIcon("images/logo.png"));
			
		/*********************************
		 * *******************************
		 * TODO CASES ET WALL
		 * PANEL 2
		 * *******************************
		 *//******************************/

		JPanel p2 = new JPanel();
		p2.setBackground(Color.darkGray);
		p2.setLayout(null);
		
		// label 2
		JLabel texteBoutonsEtSliders = new JLabel();
		texteBoutonsEtSliders.setOpaque(true);		
		texteBoutonsEtSliders.setFont(policeBoutons);
		texteBoutonsEtSliders.setHorizontalAlignment(SwingConstants.CENTER);
		texteBoutonsEtSliders.setVerticalAlignment(SwingConstants.CENTER);
		texteBoutonsEtSliders.setBackground(Color.darkGray);
		
		/***************
		 * Slider Cases
		 **************/		
		JSlider sliderCases = new JSlider(JSlider.VERTICAL, minCases, maxCases, initCases);
		sliderCases.setName("sliderCases");
		
		Hashtable<Integer, JLabel> labelTableCases = new Hashtable<Integer, JLabel>();
		// mini
		//labelTableCases.put(gradMinCase, new JLabel(String.valueOf(gradMinCase)));
		// valeur courante
		labelTableCases.put(sliderCases.getValue(), new JLabel(String.valueOf(sliderCases.getValue())));
		
		currentValueCases = sliderCases.getValue();
		// maxi
		//labelTableCases.put(gradMaxCase, new JLabel(String.valueOf(gradMaxCase)));
		
		
		//sliderCases.setMajorTickSpacing(10);
		//sliderCases.setMinorTickSpacing(1);
        
		sliderCases.setLabelTable(labelTableCases);
		sliderCases.setPaintLabels(true);
		sliderCases.addChangeListener(this);
		sliderCases.setPaintTicks(true);
		sliderCases.setPaintTrack(true);
		sliderCases.setOpaque(true);
		sliderCases.setFont(policeBoutons);	
		sliderCases.setCursor( Cursor.getPredefinedCursor(12));
		sliderCases.setBounds(210, 50, 80, 120);
		
		/*****************
		 * Slider Wall
		 ****************/
		JSlider sliderWall = new JSlider(JSlider.VERTICAL, minWall, maxWall, initWall);
		sliderWall.setName("sliderWall");
		
		Hashtable<Integer, JLabel> labelTableWall = new Hashtable<Integer, JLabel>();
		// mini
		//labelTableWall.put(0, new JLabel("0"));
		// valeur courante
		labelTableWall.put(sliderWall.getValue(), new JLabel(String.valueOf(sliderWall.getValue())));
		// maxi
		//labelTableWall.put(sliderCases.getMaximum()/10, new JLabel(String.valueOf(sliderCases.getMaximum()/10)));	
		
		sliderWall.setLabelTable(labelTableWall);
		sliderWall.setPaintLabels(true);
		sliderWall.addChangeListener(this);
		sliderWall.setPaintTicks(true);											//graduations
		sliderWall.setPaintTrack(true);	
		sliderWall.setOpaque(true);
		sliderWall.setFont(policeBoutons);										// choix de ma police déjà init
		sliderWall.setCursor( Cursor.getPredefinedCursor(12));					// modif image curseur souris
		sliderWall.setBounds(510, 50, 80, 120);

		nbrDeCases = new JButton("Cases");
		nbrDeCases.addChangeListener(this);
		nbrDeCases.setFont(policeBoutons);
		nbrDeCases.setCursor( Cursor.getPredefinedCursor(12));
		nbrDeCases.setToolTipText("Size Map ?");
		nbrDeCases.setBounds(50, 50, longueurButton, hauteurButton);

		nbrWall = new JButton("Wall");
		nbrWall.addChangeListener(this);
		nbrWall.setFont(policeBoutons);
		nbrWall.setCursor( Cursor.getPredefinedCursor(12));
		nbrWall.setToolTipText("How many ?");
		nbrWall.setBounds(600, 50, longueurButton, hauteurButton);
		
		/*********************************
		 * *******************************
		 * TODO HULK ET KNIGHT
		 * PANEL 3
		 * *******************************
		 *//******************************/

		JPanel p3 = new JPanel();
		p3.setBackground(Color.darkGray);
		p3.setLayout(null);
		
		/***************
		 * Slider Hulk
		 **************/
		JSlider sliderHulk = new JSlider(JSlider.VERTICAL, minHulk, maxHulk, initHulk);
		sliderHulk.setName("sliderHulk");
		
		Hashtable<Integer, JLabel> labelTableHulk = new Hashtable<Integer, JLabel>();
		// mini
//		labelTableHulk.put(0, new JLabel("0"));
		// valeur courante
		labelTableHulk.put(sliderHulk.getValue(), new JLabel(String.valueOf(sliderHulk.getValue())));		
		// maxi
//		labelTableHulk.put(sliderCases.getMaximum()/5, new JLabel(String.valueOf(sliderCases.getMaximum()/5)));
		
		sliderHulk.setLabelTable(labelTableHulk);
		sliderHulk.setPaintLabels(true);
		sliderHulk.addChangeListener(this);
		sliderHulk.setPaintTicks(true);												//graduations
		sliderHulk.setPaintTrack(true);
		sliderHulk.setOpaque(true);
		sliderHulk.setCursor( Cursor.getPredefinedCursor(12));
		sliderHulk.setBounds(210, 50, 80, 120);
		
		/*******************
		 * Slider Chevalier
		 ******************/
		
		JSlider sliderKnight = new JSlider(JSlider.VERTICAL, minKnight, maxKnight, initKnight);
		sliderKnight.setName("sliderKnight");
		
		Hashtable<Integer, JLabel> labelTableKnight = new Hashtable<Integer, JLabel>();
		// mini
//		labelTableKnight.put(0, new JLabel("0"));
		// valeur courante
		labelTableKnight.put(sliderKnight.getValue(), new JLabel(String.valueOf(sliderKnight.getValue())));			
		// maxi
//		labelTableKnight.put(sliderCases.getMaximum()/5, new JLabel(String.valueOf(sliderCases.getMaximum()/5)));	
		
	
		sliderKnight.setFont(policeBoutons);	
		sliderKnight.setLabelTable(labelTableKnight);
		sliderKnight.setPaintLabels(true);
		sliderKnight.addChangeListener(this);
		sliderKnight.setPaintTicks(true);										//graduations
		sliderKnight.setPaintTrack(true);	
		sliderKnight.setOpaque(true);
		sliderKnight.setFont(policeBoutons);	
		sliderKnight.setCursor( Cursor.getPredefinedCursor(12));
		sliderKnight.setBounds(510, 50, 80, 120);

		nbrDeHeros1 = new JButton("Hulk");
		nbrDeHeros1.addChangeListener(this);
		nbrDeHeros1.setFont(policeBoutons);
		nbrDeHeros1.setCursor( Cursor.getPredefinedCursor(12));
		nbrDeHeros1.setToolTipText("How many ?");
		nbrDeHeros1.setBounds(50, 50, longueurButton, hauteurButton);

		nbrDeHeros2 = new JButton("Knight");
		nbrDeHeros2.addChangeListener(this);
		nbrDeHeros2.setFont(policeBoutons);
		nbrDeHeros2.setCursor( Cursor.getPredefinedCursor(12));
		nbrDeHeros2.setToolTipText("How many ?");
		nbrDeHeros2.setBounds(600, 50, longueurButton, hauteurButton);

		
		/*********************************
		 * *******************************
		 * TODO CHOIX CLASSIC MODE OU HIT & RUN
		 * PANEL 5
		 * *******************************
		 *//******************************/

		JPanel p5 = new JPanel();
		p5.setBackground(Color.lightGray);
		p5.setLayout(null);
			
		ButtonGroup groupeChoixMode = new ButtonGroup();
		
		JRadioButton classicMode = new JRadioButton("Classic Mode");
		classicMode.setFont(policeBoutons);  
		classicMode.setToolTipText("Ça vous fait pas mal à la tête de glandouiller vingt-quatre heures sur vingt-quatre ?");
		classicMode.setOpaque(true);
		classicMode.setBounds(0, 0, 200, 200);

		JRadioButton hitAndRun = new JRadioButton("Hit & Run");

		hitAndRun.setFont(policeBoutons); 
		hitAndRun.setBackground(Color.gray);
		hitAndRun.setToolTipText("Ah le printemps ! La nature se réveille, les oiseaux reviennent, on crame des mecs...");
		hitAndRun.setOpaque(true);
		hitAndRun.setBounds(200, 0, 200, 200);
		
		/*********************************
		 * *******************************
		 * TODO START ET QUIT
		 * *******************************
		 *//******************************/
		
		start = new JButton("Start");
		start.setFont(policeBoutons);  
		start.setCursor( Cursor.getPredefinedCursor(12));
		start.setToolTipText("Let's go !");
		start.addActionListener(this);	
		this.start.setActionCommand("Start");
		start.setBounds(400, 0, 200, 200);

		quit = new JButton("Quit");
		quit.setFont(policeBoutons);
		quit.setCursor( Cursor.getPredefinedCursor(12));
		quit.setToolTipText("See you !");
		quit.addActionListener(this);
		quit.setBounds(600, 0, 200, 200);
	
		// taille des boutons
		nbrDeCases.setPreferredSize(new Dimension(longueurButton,hauteurButton));
//		nbrObstacles.setPreferredSize(new Dimension(longueurButton,hauteurButton));
		nbrDeHeros1.setPreferredSize(new Dimension(longueurButton,hauteurButton));
		nbrDeHeros2.setPreferredSize(new Dimension(longueurButton,hauteurButton));
		start.setPreferredSize(new Dimension(longueurButton,hauteurButton));
		quit.setPreferredSize(new Dimension(longueurButton,hauteurButton));
	
		
		/*********************************
		 * *******************************
		 * TODO OBSTACLES
		 * PANEL 4
		 * *******************************
		 *//******************************/
		
		JPanel p4 = new JPanel();
		p4.setBackground(Color.darkGray);
		p4.setLayout(null);
		
		/*******************
		 * Slider Obstacles
		 ******************/
		
		JSlider sliderObstacles = new JSlider(JSlider.VERTICAL, minObstacles, maxObstacles, initObstacles);
		sliderObstacles.setName("sliderObstacles");
		
		Hashtable<Integer, JLabel> labelTableObstacles = new Hashtable<Integer, JLabel>();
		// mini
//		labelTableObstacles.put(0, new JLabel("0"));
		// valeur courante
		labelTableObstacles.put(sliderObstacles.getValue(), new JLabel(String.valueOf(sliderObstacles.getValue())));			
		// maxi
//		labelTableObstacles.put(sliderCases.getMaximum()/5, new JLabel(String.valueOf(sliderCases.getMaximum()/5)));	
		
	
		sliderObstacles.setFont(policeBoutons);	
		sliderObstacles.setLabelTable(labelTableObstacles);
		sliderObstacles.setPaintLabels(true);
		sliderObstacles.addChangeListener(this);
		sliderObstacles.setPaintTicks(true);										//graduations
		sliderObstacles.setPaintTrack(true);	
		sliderObstacles.setOpaque(true);
		sliderObstacles.setFont(policeBoutons);	
		sliderObstacles.setCursor( Cursor.getPredefinedCursor(12));
		sliderObstacles.setBounds(210, 50, 80, 120);
		
		/*******************
		 * Slider Vitesse
		 ******************/
		
		JSlider sliderVitesse = new JSlider(JSlider.VERTICAL, minVitesseJeu, maxVitesseJeu, initVitesseJeu);
		sliderVitesse.setName("sliderVitesse");
		
		Hashtable<Integer, JLabel> labelTableVitesse = new Hashtable<Integer, JLabel>();
		// mini
//		labelTableVitesse.put(0, new JLabel("0"));
		// valeur courante
		labelTableVitesse.put(sliderVitesse.getValue(), new JLabel(String.valueOf(sliderVitesse.getValue())));			
		// maxi
//		labelTableVitesse.put(sliderCases.getMaximum()/5, new JLabel(String.valueOf(sliderCases.getMaximum()/5)));	
		
	
		sliderVitesse.setFont(policeBoutons);	
		sliderVitesse.setLabelTable(labelTableVitesse);
		sliderVitesse.setPaintLabels(true);
		sliderVitesse.addChangeListener(this);
		sliderVitesse.setPaintTicks(true);										//graduations
		sliderVitesse.setPaintTrack(true);	
		sliderVitesse.setOpaque(true);
		sliderVitesse.setFont(policeBoutons);	
		sliderVitesse.setCursor( Cursor.getPredefinedCursor(12));
		sliderVitesse.setBounds(510, 50, 80, 120);
		
		/*******************
		 * Bouton Obstacles
		 ******************/
		
		nbrObstacles = new JButton("Obstacles");
		nbrObstacles.addChangeListener(this);
		nbrObstacles.setFont(policeBoutons);
		nbrObstacles.setCursor( Cursor.getPredefinedCursor(12));
		nbrObstacles.setToolTipText("How many ?");
		nbrObstacles.setBounds(50, 50, longueurButton, hauteurButton);
		
		/*******************
		 * Bouton Vitesse
		 ******************/
		
		vitesseJeu = new JButton("Speed");
		vitesseJeu.addChangeListener(this);
		vitesseJeu.setFont(policeBoutons);
		vitesseJeu.setCursor( Cursor.getPredefinedCursor(12));
		vitesseJeu.setToolTipText("How many ?");
		vitesseJeu.setBounds(600, 50, longueurButton, hauteurButton);
		
		/*************************************************************
		 * ajout du panneau titre + boutons + sliders + image + start 
		 * **********************************************************/
		
		// CHOIX MODE
		groupeChoixMode.add(classicMode);
		groupeChoixMode.add(hitAndRun);
		
		p1.add(imagaOnEnAGros);	
		
		// PANEL 2
		p2.add(texteBoutonsEtSliders);
		p2.add(nbrDeCases);
		p2.add(sliderCases);
		p2.add(nbrWall);
		p2.add(sliderWall);
	
		// PANEL 3
		p3.add(texteBoutonsEtSliders);
		p3.add(nbrDeHeros1);
		p3.add(sliderHulk);
		p3.add(nbrDeHeros2);
		p3.add(sliderKnight);
		
		// PANEL 4
		p4.add(texteBoutonsEtSliders);
		p4.add(nbrObstacles);		
		p4.add(sliderObstacles);
		p4.add(vitesseJeu);		
		p4.add(sliderVitesse);

		
		// PANEL 5
		p5.add(texteBoutonsEtSliders);
		p5.add(classicMode);
		p5.add(hitAndRun);
		p5.add(start);
		p5.add(quit);
		
		// ajout des panels dans mon panel principal
		containerPrincipal.add(p1);	
		containerPrincipal.add(p2);
		containerPrincipal.add(p3);
		containerPrincipal.add(p4);
		containerPrincipal.add(p5);	
		
	}

	/*********************************
	 * *******************************
	 * TODO EVENEMENTS START ET QUIT
	 * *******************************
	 *//******************************/

	@Override
	public void actionPerformed(ActionEvent e) {

		if (e.getSource() == start) {

			quit.setEnabled(true);
			start.setEnabled(false);
			//this.reponseStart = "Start";
			this.reponseStart  = true;
			this.setVisible(false);
			//new FenetreMap();

		}	
		else if (e.getSource() == quit) {

			quit.setEnabled(false);
			start.setEnabled(true);

			System.exit(0);				
		} 
	}			

	public Boolean getReponseStart() {

		return this.reponseStart;
	}

	/*********************************
	 * *******************************
	 * TODO EVENEMENTS SLIDERS
	 * *******************************
	 *//******************************/

	@Override
	public void stateChanged(ChangeEvent evt) {

		JSlider source = (JSlider)evt.getSource();

		
		if ("sliderCases".equals(source.getName())) {
		    if (!source.getValueIsAdjusting()) {
		    	currentValueCases = (int)source.getValue();
		    }
		    Hashtable<Integer, JLabel> labelTableCases = new Hashtable<Integer, JLabel>();
		    labelTableCases.put(currentValueCases, new JLabel(String.valueOf(currentValueCases)));
		    
		    source.setLabelTable(labelTableCases);

		}
		
		if ("sliderObstacles".equals(source.getName())) {
		    if (!source.getValueIsAdjusting()) {
		    	currentValueObstacles = (int)source.getValue();
		    }
		    Hashtable<Integer, JLabel> labelTableObtables = new Hashtable<Integer, JLabel>();
		    labelTableObtables.put(currentValueObstacles, new JLabel(String.valueOf(currentValueObstacles)));
		    
		    source.setLabelTable(labelTableObtables);
		}
			

		if ("sliderHulk".equals(source.getName())) {
		    if (!source.getValueIsAdjusting()) {
		    	currentValueHulk = (int)source.getValue();
		    }
		    Hashtable<Integer, JLabel> labelTableHulk = new Hashtable<Integer, JLabel>();
		    labelTableHulk.put(currentValueHulk, new JLabel(String.valueOf(currentValueHulk)));
		    
		    source.setLabelTable(labelTableHulk);
		}

		if ("sliderKnight".equals(source.getName())) {
		    if (!source.getValueIsAdjusting()) {
		    	currentValueKnight = (int)source.getValue();
		    }
		    Hashtable<Integer, JLabel> labelTableKnight = new Hashtable<Integer, JLabel>();
		    labelTableKnight.put(currentValueKnight, new JLabel(String.valueOf(currentValueKnight)));
		    
		    source.setLabelTable(labelTableKnight);
		}

		if ("sliderWall".equals(source.getName())) {
		    if (!source.getValueIsAdjusting()) {
		    	currentValueWall = (int)source.getValue();
		    }
		    Hashtable<Integer, JLabel> labelTableWall = new Hashtable<Integer, JLabel>();
		    labelTableWall.put(currentValueWall, new JLabel(String.valueOf(currentValueWall)));
		    
		    source.setLabelTable(labelTableWall);
		}
		
		if ("sliderVitesse".equals(source.getName())) {
		    if (!source.getValueIsAdjusting()) {
		    	currentValueVitesseJeu = (int)source.getValue();
		    }
		    Hashtable<Integer, JLabel> labelTableVitesse = new Hashtable<Integer, JLabel>();
		    labelTableVitesse.put(currentValueVitesseJeu, new JLabel(String.valueOf(currentValueVitesseJeu)));
		    
		    source.setLabelTable(labelTableVitesse);
		}

	}
}