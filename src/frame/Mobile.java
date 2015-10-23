package frame;

import java.awt.Graphics;
import java.util.ArrayList;

import struct.Couleur;

public abstract class Mobile extends Forme {

	// attributs
	
	
	public ArrayList<Mobile> Collisioneur = new ArrayList<Mobile>();
	
	protected int vitesse;

	
	//Le bool�en pour savoir si l'on recule ou non sur l'axe x
	protected int backX = 1;
    //Le bool�en pour savoir si l'on recule ou non sur l'axe y
	protected int backY = 1;
	
	// si c'est false on avance 
	
	protected double vitesseX = 1;
	protected  double vitesseY = 1;
	
	protected int Old_X =0;
	protected int Old_Y =0;
	
	// constructeur
	
	//on simplifie un mobile possede un rayon donc dans forme hauteur=largeur= rayon

	public Mobile(int X, int Y, int rayon, double orientation,
			Couleur couleur, int vitesse) {
		super(X, Y, rayon, rayon, orientation, couleur);
	
		this.vitesse = vitesse;
		this.Old_X =X;
		this.Old_Y =Y;
	}
	
	
	

	// Methodes

	public void Clear_Collisioneur(){
		Collisioneur.clear();
	}
	public void Add_Collisioneur(Mobile mobile){
		Collisioneur.add(mobile);
	}
	
	public int GetOld_X(){
		return this.Old_X;
	}
	
	public int GetOld_Y(){
		return this.Old_Y;
	}
	
	
	public void vitesseY(double speed){
		this.vitesseY = speed;
	}
	
	public void vitesseX(double speed){
		this.vitesseX = speed;
	}
	
	
	public int GetRayon(){
		return (int)(hauteur/2.0);
	}
	
	
	public int GetbackX(){
		return backX;
	}
	
	public int GetbackY(){
		return backY;
	}
	
	
	
	public void SetbackX(int TrueOrFalse){
		this.backX *= TrueOrFalse;
	}
	
	
	public void SetbackY(int TrueOrFalse){
		this.backY *= TrueOrFalse;
	}
	
	@Override
	public  abstract void  paintComponent(Graphics g);
	
	public  void  dessine(){repaint();}


	public abstract void deplace();


	public abstract void Rotation();

}
