package animaciones;

import java.awt.image.BufferedImage;

import main.Game;

public class Texturas {
	
	public BufferedImage[] jugador = new BufferedImage[10];
	public BufferedImage[] jugadorUp = new BufferedImage[10];
	
	public BufferedImage[] enemigo = new BufferedImage[4];
	
	public BufferedImage[] explosion = new BufferedImage[14];
	
	public BufferedImage[] bala  =  new BufferedImage[5];
	
	public BufferedImage exploenemigo, balaenemigo, constructor, balaenemigoconstructor;
	
	private SpriteSheet ss, ssexplo, ssconstru;
	//private SpriteSheet ssexploenemigo;
	
	public Texturas(Game game){
		ss = new SpriteSheet(game.getSpriteSheet());
		ssexplo = new SpriteSheet(game.getSpriteSheetExplosion());
		ssconstru = new SpriteSheet(game.getSpriteSheetConstructor());
		getTexturas();
	}
	
	private void getTexturas(){
		jugador[0] = ss.grabImage(1, 1, 32, 32);
		jugador[1] = ss.grabImage(2, 1, 32, 32);
		jugador[2] = ss.grabImage(3, 1, 32, 32);
		jugador[3] = ss.grabImage(4, 1, 32, 32);
		jugador[4] = ss.grabImage(5, 1, 32, 32);
		jugador[5] = ss.grabImage(6, 1, 32, 32);
		jugador[6] = ss.grabImage(7, 1, 32, 32);
		jugador[7] = ss.grabImage(8, 1, 32, 32);
		jugador[8] = ss.grabImage(9, 1, 32, 32);
		jugador[9] = ss.grabImage(10, 1, 32, 32);
		
		jugadorUp[0] = ss.grabImage(1, 4, 32, 32);
		jugadorUp[1] = ss.grabImage(2, 4, 32, 32);
		jugadorUp[2] = ss.grabImage(3, 4, 32, 32);
		jugadorUp[3] = ss.grabImage(4, 4, 32, 32);
		jugadorUp[4] = ss.grabImage(5, 4, 32, 32);
		jugadorUp[5] = ss.grabImage(6, 4, 32, 32);
		jugadorUp[6] = ss.grabImage(7, 4, 32, 32);
		jugadorUp[7] = ss.grabImage(8, 4, 32, 32);
		jugadorUp[8] = ss.grabImage(9, 4, 32, 32);
		jugadorUp[9] = ss.grabImage(10, 4, 32, 32);
		
		enemigo[0] = ss.grabImage(1, 2, 32, 32);
		enemigo[1] = ss.grabImage(2, 2, 32, 32);
		enemigo[2] = ss.grabImage(3, 2, 32, 32);
		enemigo[3] = ss.grabImage(4, 2, 32, 32);
		
		bala[0] = ss.grabImage(1, 3 ,32, 32);
		bala[1] = ss.grabImage(2, 3 ,32, 32);
		bala[2] = ss.grabImage(3, 3 ,32, 32);
		bala[3] = ss.grabImage(4, 3, 32, 32);
		
		balaenemigo = ss.grabImage(1, 5, 32, 32);
		balaenemigoconstructor = ss.grabImage(2, 5, 32, 32);
		constructor = ssconstru.grabImage(1,1,75,65);
		
		explosion[0] = ssexplo.grabImage(1, 1, 64, 64);
		explosion[1] = ssexplo.grabImage(3, 1, 64, 64);
		explosion[2] = ssexplo.grabImage(5, 1, 64, 64);
		explosion[3] = ssexplo.grabImage(7, 1, 64, 64);
		explosion[4] = ssexplo.grabImage(1, 3, 64, 64);
		explosion[5] = ssexplo.grabImage(3, 3, 64, 64);
		explosion[6] = ssexplo.grabImage(5, 3, 64, 64);
		explosion[7] = ssexplo.grabImage(7, 3, 64, 64);
		explosion[8] = ssexplo.grabImage(1, 5, 64, 64);
		explosion[9] = ssexplo.grabImage(3, 5, 64, 64);
		explosion[10] = ssexplo.grabImage(5, 5, 64, 64);
		explosion[11] = ssexplo.grabImage(7, 5, 64, 64);
		explosion[12] = ssexplo.grabImage(1, 7, 64, 64);
		explosion[13] = ssexplo.grabImage(3, 7, 64, 64);
	}
}
