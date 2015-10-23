package ihm;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import struct.Couleur;

import frame.Cercle;
import frame.Mobile;
import frame.Mur;
import frame.Triangle;

public class Fenetre extends JFrame implements ActionListener {

	// TODO renomer Fenetre en Pong

	// taille de la fenetre
	private int x = 1200;
	private int y = 800;

	// les forme qui sont ajouter depuis appli
	private ArrayList<Mobile> mobiles = new ArrayList<Mobile>();
	private ArrayList<Mur> murs = new ArrayList<Mur>();

	// les boutons
	private JButton bouton = new JButton("Mon bouton");
	private JButton bouton2 = new JButton("Mon deuxieme bouton");

	private JPanel container = new JPanel();
	private JLabel label = new JLabel("Le JLabel SMBC");

	private int compteur = 0;

	private boolean animated = true;

	private Thread t;

	
	public Fenetre() {
		this.setTitle("Ma premiere de merde");
		this.setSize(x, y);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		container.setBackground(Color.blue);
		container.setLayout(new BorderLayout());

		// on ajouter nos objet dans le container

		// precedement

		// container.add(c1);

		// Nous ajoutons notre fen�tre � la liste des auditeurs de notre bouton
		bouton.addActionListener(new BoutonListener());
		bouton.setEnabled(false);
		bouton2.addActionListener(new Bouton2Listener());

		JPanel south = new JPanel();
		south.add(bouton);
		south.add(bouton2);

		container.add(south, BorderLayout.SOUTH);

		// D�finition d'une police d'�criture
		Font police = new Font("Tahoma", Font.BOLD, 16);
		// On l'applique au JLabel
		label.setFont(police);
		// Changement de la couleur du texte
		label.setForeground(Color.white);
		// On modifie l'alignement du texte gr�ce aux attributs statiques
		// de la classe JLabel
		label.setHorizontalAlignment(JLabel.CENTER);

		container.add(label, BorderLayout.NORTH);
		this.setContentPane(container);
		this.setVisible(true);

		// if(launchAnimation == 1){
		// go();
		// }

	}

	private void AddToContainer() {

		container.setBackground(Color.black);

		for (int i = 0; i < this.mobiles.size(); i++) {

			container.add(this.mobiles.get(i));
			this.setContentPane(container);
			this.setVisible(true);

		}

		for (int j = 0; j < this.murs.size(); j++) {

			container.add(this.murs.get(j));
			this.setContentPane(container);
			this.setVisible(true);

		}

		container.add(label, BorderLayout.NORTH);
		this.setContentPane(container);
		this.setVisible(true);

	}

	// Methode qui sera appelee lors d'un clic sur le bouton

	// TODO erwin : quelle est l'utilité ??
	public void actionPerformed(ActionEvent arg0) {

		this.compteur++;
		label.setText("Vous avez cliqu� " + this.compteur + " fois");

	}

	private void go() {

		while (this.animated) {

			// on check les colisions
			
			for (int i = 0; i < this.mobiles.size(); i++) {

				this.mobiles.get(i).deplace();
				this.mobiles.get(i).Clear_Collisioneur();
				
			
			}
			
			Detect_collision();
			
			

		
			
			repaint();

			// pause(30 milli�mes dseconde) encapsuler an cas de probleme
			try {
				Thread.sleep(15);

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	class BoutonListener implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {

			JOptionPane jop = new JOptionPane();
			int option = jop.showConfirmDialog(null,
					"Voulez-vous lancer le programme PONG ?",
					"Lancement du programme", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);

			if (option == JOptionPane.OK_OPTION) {

				// J'AJOUTE LES OBJET AU LANCEMENT
				AddToContainer();

				animated = true;
				t = new Thread(new PlayAnimation());
				t.start();
				bouton.setEnabled(false);
				bouton2.setEnabled(true);

			}
		}
	}

	class Bouton2Listener implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			JOptionPane jop = new JOptionPane();
			int option = jop.showConfirmDialog(null,
					"Voulez-vous arr�ter le programme PONG ?",
					"Arr�t du programme", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE);

			if (option != JOptionPane.NO_OPTION
					&& option != JOptionPane.CANCEL_OPTION
					&& option != JOptionPane.CLOSED_OPTION) {
				animated = false;
				bouton.setEnabled(true);
				bouton2.setEnabled(false);

			}
		}
	}

	class PlayAnimation implements Runnable {

		public void run() {
			go();
		}
	}

	public void addMobile(Mobile mobile) {
		mobiles.add(mobile);
	}

	public void addMur(Mur mur) {
		murs.add(mur);
	}
	

	
	

	public void Detect_collision()

	{

		for (int i = 0; i < this.mobiles.size(); i++) {
			int Mi_x = mobiles.get(i).getPosX();
			int Mi_y = mobiles.get(i).getPosY();
			int Mi_R = mobiles.get(i).GetRayon();
			
			
			
			//collision avec un mur
			
			for(int j = 0; j < this.murs.size();j++){
				
				int Mj_x = murs.get(j).getPosX();
				int Mj_y = murs.get(j).getPosY();
				int Mj_W = murs.get(j).getW();
				int Mj_H = murs.get(j).getH();
				
				
				 if(((Mi_x - Mi_R >=Mj_x + Mj_W) // trop à droite
				 || (Mi_x + Mi_R <= Mj_x - Mj_W) // trop à gauche
				 || (Mi_y - Mi_R >= Mj_y + Mj_H) // trop en bas
				 || (Mi_y + Mi_R <= Mj_y - Mj_H))) // trop en haut
				 {;}			 
				 else {
					 collision_Mur(i,j);
					 this.murs.get(j).RedColor();
//					 System.out.println("mur" + "    x : " +Mj_x + "    y : " + Mj_y );
//					 System.out.println("balle" + "    x : " +Mi_x + "    y : " + Mi_y );
					 
				 }
				 
				
				 
				
				

			}
					
			
			
			//collision avec un mobile
			
			for(int k = 0; k < this.mobiles.size();k++){
				
											
							
							int Mk_x = mobiles.get(k).getPosX();
							int Mk_y = mobiles.get(k).getPosY();
							int Mk_R = mobiles.get(k).GetRayon();
									
						      if (i != k){  // on test si les moblies ne sont pas les meme
						    	  
						    	double d2 = ((double)Mi_x-(double)Mk_x)*
						    				 ((double)Mi_x-(double)Mk_x)  +
						    			     ((double)Mi_y-(double)Mk_y)*
						    			     ((double)Mi_y-(double)Mk_y);
							   if (d2 > ((double)Mi_R + (double)Mk_R)*((double)Mi_R + (double)Mk_R))
							      {;}
							   else{
							
								   if  (mobiles.get(k).Collisioneur.size() == 0){
									   collision_Mobile(i,k);
									   System.out.println("collison");
								   }
							
								   
								   else{
										   for(int l = 0; l < mobiles.get(k).Collisioneur.size(); l++){
												
												if (mobiles.get(k).Collisioneur.get(l) ==  mobiles.get(i)){
													System.out.println("Wtf" + " i : " + i + "      j : " + k  );
													break;
													
													
												}
												else {
													collision_Mobile(i,k);
													System.out.println("collison"+ " i : " + i + "      j : " + k);}
												}
										   }
								  
								   }
					
							
							
				
						      }
						      
					   
				      
				
					
			}
		
	}

			
			
	}	
	

	
public void collision_Mur(int i, int j){
	
			//on cherche le cote ou a eu lieu l'impact
		
				int Mi_x = mobiles.get(i).getPosX();
				int Mi_y = mobiles.get(i).getPosY();
				int Mi_R = mobiles.get(i).GetRayon();
				
				int Mj_x = murs.get(j).getPosX();
				int Mj_y = murs.get(j).getPosY();
				int Mj_W = murs.get(j).getW();
				int Mj_H = murs.get(j).getH();
				
				
				int Mur_droit = Mj_x +  Mj_W;
				int Mur_gauche = Mj_x -  Mj_W;
				int Mur_haut = Mj_y- Mj_H;
				int Mur_bas = Mj_y+ Mj_H;
	
			// collision en haut
				
				
			if( (Mi_x) < Mur_droit & (Mi_x)> Mur_gauche ){
				mobiles.get(i).SetbackY(-1);
			}
			
			
			if( Mi_y  > Mur_haut & Mi_y < Mur_bas ){
				mobiles.get(i).SetbackX(-1);
						
			}
			
			
			
			

	 		 
	

}





public void collision_Mobile(int i, int k){
	
//	System.out.println("mobile 1" + "    x: " + mobiles.get(i).getPosX() + "    y: "+ mobiles.get(i).getPosY());
//	System.out.println("mobile 2" + "    x: " + mobiles.get(k).getPosX() + "    y: "+ mobiles.get(k).getPosY());
//	
//			System.out.println("mobile 1" + "    x: " + mobiles.get(i).GetOld_X() + "    y: "+ mobiles.get(i).GetOld_Y());
//			System.out.println("mobile 2" + "    x: " + mobiles.get(k).GetOld_X() + "    y: "+ mobiles.get(k).GetOld_Y());
			
			
			
		//mobiles.get(i).Add_Collisioneur(mobiles.get(k));
			
			
			//constitue le "vecteur" entre les deux balles 
			double directionX_M1 = mobiles.get(k).GetOld_X() - mobiles.get(i).GetOld_X();
			double directionY_M1 = mobiles.get(k).GetOld_Y() - mobiles.get(i).GetOld_Y();
			
			
			// contitue le "vecteur" tangent entre les deux balle
			
			double directionX_M2 = directionY_M1;
			double directionY_M2 = directionX_M1;
			
			// vecteur vitesse de la balle i 
			double Vi_x = -1*mobiles.get(i).GetOld_X()+ mobiles.get(i).getPosX();
			double Vi_y = - 1*mobiles.get(i).GetOld_X()+ mobiles.get(i).getPosX();
			
			double vitesse_i = Math.sqrt((Vi_x*Vi_x)+(Vi_y*Vi_y));
			
			double vitesse_j = Math.sqrt((directionX_M1*directionX_M1)+(directionY_M1 *directionY_M1 ));
			double coef_j = vitesse_i/vitesse_j;
			
			
		
//	TODO : presque !!!
			mobiles.get(i).vitesseX(directionX_M1*coef_j- Vi_x );
			
			mobiles.get(i).vitesseY(directionY_M1*coef_j - Vi_y );
		
			mobiles.get(k).vitesseX(directionX_M1*coef_j);
			
			mobiles.get(k).vitesseY(directionY_M1* coef_j);
			
			
			//TODO : rotation triangle lors dune colision
			
			if(mobiles.get(i).getClass() ==Triangle.class){
				mobiles.get(i).Rotation();
			
					
			}
			
}


}




