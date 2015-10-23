package frame;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

import struct.Couleur;

public class Cercle extends Mobile {

	
	// constructeur
	public Cercle(int X, int Y, int rayon, double orientation,
			Couleur couleur, int vitesse) {
		
		
		super(X, Y, rayon, orientation, couleur, vitesse);

	}
	
	
	public Cercle()
	{
		this(0,0,0,0,new Couleur(),0);
	}

	// Methodes
	
	
	public void paintComponent(Graphics g){
	
		g.setColor(new java.awt.Color(couleur.getRed(), couleur.getGreen(),
				couleur.getBlue()));
		g.fillOval(  (int)(X- (largeur/2.0)) ,(int)(Y- (hauteur/2.0)), hauteur, largeur);
		
	}
	
//	public void dessine(){
//		this.repaint();
//		
//	}

	

	
	
	
	
	@Override
	public void deplace() {
			this.Old_X = this.X;
			this.Old_Y = this.Y;
	
			this.X += (int) ((backX* vitesseX * vitesse )); 
		
	    	this.Y += (int) ((backY * vitesseY *vitesse )) ; 
	    	
	

	}


	@Override
	public void Rotation() {
		// TODO Auto-generated method stub
	
		
	}


	
	

	
	
}
