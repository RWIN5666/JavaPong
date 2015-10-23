package main;

import frame.Cercle;
import frame.Mur;
import frame.Triangle;
import ihm.Fenetre;

import javax.swing.JFrame;

import struct.Couleur;

public class Appli {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Cercle cercle1 = new Cercle(250, 400, 40, 0, new Couleur(255, 0,128),2);

		Cercle cercle2 = new Cercle(600, 400, 40, 0, new Couleur(255, 156,128),3);

		Cercle cercle3 = new Cercle(800, 500, 40, 0, new Couleur(125, 156,	128),1);
		
		
		Cercle cercle4 = new Cercle(300, 540, 40, 0, new Couleur(141, 156,	0),1);
		
		

		Triangle triangle1 = new Triangle(700,500, 30, 0, new Couleur(0,255, 128),3);
		Cercle cercle5 = new Cercle(500,900,40, 0, new Couleur(125, 0,	128),2);
		
		
	
		

		
		
		Mur mur4 = new Mur(500, 500, 100, 100, 0, new Couleur(255, 255, 255));
		
		
		Fenetre fenetre = new Fenetre();

		for (int i =100;i <= 1000 ; i+=20 ){
			
			Mur mur = new Mur(i,100,20,20, 0, new Couleur(255, 255, 255));
			fenetre.addMur(mur);
			Mur mur2 = new Mur(i,600,20,20, 0, new Couleur(255, 255, 255));
			fenetre.addMur(mur2);
		}
		
		
		for (int j = 120; j < 600 ; j+=20){
			Mur mur = new Mur(100,j,20,20, 0, new Couleur(255, 255, 255));
			fenetre.addMur(mur);
			Mur mur2 = new Mur(1000,j,20,20, 0, new Couleur(255, 255, 255));
			fenetre.addMur(mur2);
		
		}
		fenetre.addMur(mur4);
		fenetre.addMobile(triangle1);
		fenetre.addMobile(cercle5);
		
		fenetre.addMobile(cercle1);
		fenetre.addMobile(cercle2);
		fenetre.addMobile(cercle3);
		fenetre.addMobile(cercle4);
		
		
	}

}
