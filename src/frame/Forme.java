package frame;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import struct.Couleur;

public abstract class Forme extends JPanel{

	// attributs
	protected int coefficient;
	protected int X;
	protected int Y;
	protected int hauteur;
	protected int largeur;
	// TODO s'occuper d'orientation
	private double orientation;
	protected Couleur couleur;

	// constructeur

	public Forme(int X, int Y, int hauteur, int largeur, double orientation, Couleur couleur) {
		
		this.X = X; // centre
		this.Y = Y;
		this.hauteur = hauteur;
		this.largeur = largeur;
		this.orientation = orientation;
		this.couleur = couleur;

	}

	// Methode

		
	 
	 public  abstract void paintComponent(Graphics g);
	 
	 
	 
		  public int getPosX() {
		    return X;
		  }
		  public void setPosX(int posX) {
		    this.X = posX;
		  }
		  public int getPosY() {
		    return Y;
		  }
		  public void setPosY(int posY) {
		    this.Y = posY;
		  }
		  
		  public int gethauteur() {
			    return hauteur;
			  }
		  
		  public int getlargeur() {
			    return largeur;
			  }
		
}

		
	
	
	
	
	
	
	
	
	
	
	

