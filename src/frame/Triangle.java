package frame;

import java.lang.Math;
import java.awt.Graphics;
import java.awt.Graphics2D;

import struct.Couleur;

public class Triangle extends Mobile {

	private final int nbPoint = 3;
	private int xPoints[] = new int[nbPoint];
	private int yPoints[] = new int[nbPoint];

	private double xPointsF[] = new double[nbPoint];
	private double yPointsF[] = new double[nbPoint];

	private double angle = 10;

	// Constructor
	public Triangle(int X, int Y, int rayon, double orientation,
			Couleur couleur, int vitesse) {
		super(X, Y, rayon, orientation, couleur, vitesse);
		xPoints_calc();
		yPoints_calc();
	}

	// Methodes

	private void xPoints_calc() {

		this.xPoints[0] = this.X - (int)(largeur/2.0);
		this.xPoints[1] = this.X;
		this.xPoints[2] = this.X + (int)(largeur/2.0);

		this.xPointsF[0] = this.X - (int)(largeur/2.0);
		this.xPointsF[1] = this.X;
		this.xPointsF[2] = this.X + (int)(largeur/2.0);

	}

	private void yPoints_calc() {

		this.yPoints[0] = this.Y + (int)(largeur/2.0*Math.sqrt(3)/2.0);
		this.yPoints[1] = this.Y - (int)(largeur/2.0*Math.sqrt(3)/2.0);
		this.yPoints[2] = this.Y + (int)(largeur/2.0*Math.sqrt(3)/2.0);

		this.yPointsF[0] = this.Y + (largeur/2.0*Math.sqrt(3)/2.0);
		this.yPointsF[1] = this.Y - (largeur/2.0*Math.sqrt(3)/2.0);
		this.yPointsF[2] = this.Y + (largeur/2.0*Math.sqrt(3)/2.0);

	}

	@Override
	public void Rotation() {
		
		double angle_temp = this.angle;
		
		this.angle = ((this.angle / 180.0) * Math.PI);
		double cosAngle = Math.cos(this.angle);
		double sinAngle = Math.sin(this.angle);
	
		this.xPoints[0] = this.X+ (int) ((this.xPointsF[0] - this.X) * cosAngle - (this.yPointsF[0] - this.Y)* sinAngle);
		this.xPoints[1] = this.X+ (int) ((this.xPointsF[1] - this.X) * cosAngle - (this.yPointsF[1] - this.Y)* sinAngle);
		this.xPoints[2] = this.X+ (int) ((this.xPointsF[2] - this.X) * cosAngle - (this.yPointsF[2] - this.Y)* sinAngle);

		this.yPoints[0] = this.Y+ (int) ((this.xPointsF[0] - this.X) * sinAngle + (this.yPointsF[0] - this.Y)* cosAngle);
		this.yPoints[1] = this.Y+ (int) ((this.xPointsF[1] - this.X) * sinAngle + (this.yPointsF[1] - this.Y)* cosAngle);
		this.yPoints[2] = this.Y+ (int) ((this.xPointsF[2] - this.X) * sinAngle + (this.yPointsF[2] - this.Y)* cosAngle);

		this.angle = angle_temp;
		
		this.angle = this.angle + 10;

	}

@Override
public void deplace() {

	


			for (int i = 0; i < nbPoint; i++) {

				this.xPointsF[i]  +=  backX* vitesse* vitesseX;
				this.xPoints[i]  +=  (int) backX* vitesse* vitesseX;
				

				this.yPointsF[i]  +=  backY* vitesse* vitesseY;
				this.yPoints[i]  +=  (int) backY* vitesse* vitesseY;
			
			
		

			}
			
			this.Old_X = this.X;
			this.Old_Y = this.Y;
			this.X   +=  backX* vitesse* vitesseX;
			this.Y   +=  backY* vitesse* vitesseY;


	}

	@Override
	public void paintComponent(Graphics g) {

	
		g.setColor(new java.awt.Color(couleur.getRed(), couleur.getGreen(),
				couleur.getBlue()));

		g.fillPolygon(this.xPoints, this.yPoints, nbPoint);
		 
	
	}




}
