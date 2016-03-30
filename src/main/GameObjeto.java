package main;

import java.awt.Rectangle;

public class GameObjeto {
	public double x,y;
	
	public GameObjeto(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public Rectangle getBounds(int ancho, int alto){
		return new Rectangle((int)x, (int)y, ancho, alto);
	}
}
