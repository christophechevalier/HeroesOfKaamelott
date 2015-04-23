package Menu;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;

import Plateau.Dragon;

public class PopUpInfo extends JFrame {
  private JPanel container = new JPanel();
  private JTextField jtf = new JTextField();
  private JLabel label = new JLabel("Point de vie Dragon");

	/*********************************
	 * *******************************
	 * TODO CONSTRUCTEUR POPUPINFO
	 * *******************************
	 *//******************************/	
  
  public PopUpInfo(){
	  
		/*********************************
		 * *******************************
		 * TODO PANEL PRINCIPAL
		 * *******************************
		 *//******************************/	
	  
    this.setTitle("Animation");
    this.setSize(300, 300);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLocationRelativeTo(null);
    container.setBackground(Color.white);
    container.setLayout(new BorderLayout());
    JPanel top = new JPanel();
    Font police = new Font("Arial", Font.BOLD, 14);
    jtf.setFont(police);
    jtf.setPreferredSize(new Dimension(150, 30));
    jtf.setForeground(Color.BLUE);
    top.add(label);
    top.add(jtf);
    container.add(top, BorderLayout.NORTH);
    this.setContentPane(container);
    this.setVisible(true);   
    //jtf.setText(Dragon.vieDragon);
  }
}













//package Menu;
//
//import java.awt.Color;
//import java.awt.Font;
//
//import javax.swing.JFrame;
//import javax.swing.JPanel;
//
//public class PopUpInfo extends JFrame {
//
//	private static final long serialVersionUID = 1L;
//	private JPanel panelMain;
//
//	Font policeTitreEtBoutons = new Font("Segoe Marker", Font.BOLD, 30);
//	Font policeTexte = new Font("Segoe Script", Font.BOLD, 15);
//
//	/*********************************
//	 * *******************************
//	 * TODO CONSTRUCTEUR POPUPINFO
//	 * *******************************
//	 *//******************************/	
//
//	public PopUpInfo()  {
//
//		/*********************************
//		 * *******************************
//		 * TODO PANEL PRINCIPAL
//		 * *******************************
//		 *//******************************/	
//		
//		super();				
//		final JPanel panelMain = new JPanel();
//
//		panelMain.setOpaque(true);
//		panelMain.setBackground(Color.lightGray);
//		
//		this.add(panelMain);
//		this.setVisible(true);
//		this.setSize(300,300);
//		this.setResizable(false);
//		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//	
//	}
//
//}



