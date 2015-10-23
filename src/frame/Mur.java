package frame;

import java.awt.Graphics;

import struct.Couleur;



public class Mur extends Forme {

	public Mur(int X, int Y, int hauteur, int largeur, double orientation,
			Couleur couleur)

	{
		super(X, Y, hauteur, largeur, orientation, couleur);
		this.coefficient = 10;
	}

	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub

		g.setColor(new java.awt.Color(couleur.getRed(), couleur.getGreen(),
				couleur.getBlue()));
		g.fillRect((int) (X - (largeur / 2.0)), (int) (Y - (hauteur / 2.0)),
				hauteur, largeur);
		
		if (coefficient <= 10){
			this.coefficient += 1;
			if (coefficient == 10){
				WhiteColor();
			}
		}
		
		
	    

	}
	
	public int getW(){
		return (int)((largeur / 2.0));
	}
	
	public int getH(){
		return (int)((hauteur / 2.0));
	}
	
	public  void RedColor(){
		this.couleur = new Couleur(255,0,0);
		
		this.coefficient = 0;
	}
	
	public  void WhiteColor(){
		this.couleur = new Couleur(255,255,255);
		
		this.coefficient = 0;
	}
	

}
