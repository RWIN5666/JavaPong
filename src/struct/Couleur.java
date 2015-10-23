package struct;

public class Couleur {
	
	// attribut
	
	//TODO ajouter alpha	
	private int red; // de 0 a 255
	private int green; // de 0 a 255
	private int blue; // de 0 a 255
	
	
	// constructeur
	
	public Couleur( int r, int g , int b ){//,  int a );
		this.setRed(r);
		this.setGreen(g); 
		this.setBlue(b); 
	}
	
	public Couleur(){
		this(0,0,0);
	}

	public void setRed(int red) {
		this.red = red;
	}

	public int getRed() {
		return red;
	}

	public void setGreen(int green) {
		this.green = green;
	}

	public int getGreen() {
		return green;
	}

	public void setBlue(int blue) {
		this.blue = blue;
	}

	public int getBlue() {
		return blue;
	}
	
	
	
}
