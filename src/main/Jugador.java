package main;

import java.awt.Graphics;
import java.awt.Rectangle;

import javax.swing.JOptionPane;

import animaciones.Animacion;
import animaciones.Control;
import animaciones.Sound;
import animaciones.Texturas;
import main.entidades.Colisiones;
import main.entidades.EntidadAmiga;
import main.entidades.EntidadEnemiga;

public class Jugador extends GameObjeto implements EntidadAmiga{
	private double velX = 0;
	private double velY = 0;
	private Texturas tex;
	Game game;
	Control control;
	private boolean explojugador = false;
	private Jugador jugador;
	Animacion anim,animUp;
	private int mov=0;
	
	
	
	public Jugador(double x, double y, Texturas tex, Game game, Control control){
		super(x,y);
		this.tex = tex;
		this.anim = new Animacion(5, tex.jugador[0], tex.jugador[1], tex.jugador[2],
					tex.jugador[3], tex.jugador[4], tex.jugador[5], tex.jugador[6],
					tex.jugador[7], tex.jugador[8], tex.jugador[9]);
		this.animUp = new Animacion(5, tex.jugadorUp[0], tex.jugadorUp[1], tex.jugadorUp[2],
					tex.jugadorUp[3], tex.jugadorUp[4], tex.jugadorUp[5], tex.jugadorUp[6],
					tex.jugadorUp[7], tex.jugadorUp[8], tex.jugadorUp[9]);
		this.game = game;
		this.control = control;
	}
	
	public void tick(){
		x+=velX;
		y+=velY;
		
		if(x <= 0) x = 0;
		if(x >= 640) x = 640 - 32;
		if(y <= 0) y = 0;
		if(y >= 480) y = 480 - 32;
		
		for(int i=0; i < game.ee.size();i++){
			EntidadEnemiga temporalEntidad = game.ee.get(i);
			if(Colisiones.Colision(this, temporalEntidad)){
				game.setEnemigodown(game.getEnemigodown()+1);
				control.quitarEntidad(temporalEntidad);
				game.VIDA -= 1;				
				
				explojugador = true;
				if(game.audio == true)Sound.explosion.play();
				if(game.VIDA==0){
					//System.exit(1);
					//JOptionPane.showMessageDialog(null, "GAME OVER");
					game.VIDA = 100;
					game.PUNT = 0;
					
					while(!game.ee.isEmpty()){game.ee.removeFirst();}
					
					if(game.audio == true){
						Sound.background.stop();
						Sound.gameover.play();
					}
					
					Game.Estado = Game.ESTADO.GAMEOVER;
					Game.Nivel = Game.NIVEL.NIVEL1;
				}
			}
		}
		
		//anim.runAnimacion();
		if(mov == 0)anim.runAnimacion();
		if(mov == 1)animUp.runAnimacion();
	}
	
	public void render(Graphics g){
		//anim.drawAnimation(g, x, y, 0);
		if(mov == 0)anim.drawAnimation(g, x, y, 0);
		if(mov == 1)animUp.drawAnimation(g, x, y, 0);
	}
	
	public Rectangle getBounds(){
		return new Rectangle ((int)x,(int)y,32,32);
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public void setX(double x){
		this.x = x;
	}
	
	public void setY(double y){
		this.y = y;
	}
	
	public void setVelX(double velX){
		this.velX = velX;
	}
	
	public void setVelY(double velY){
		this.velY = velY;
	}
	
	public void setMov(int mov){
		this.mov = mov;
	}
	
	public boolean getExplo(){
		return this.explojugador;
	}
	
	public void setExplo(boolean explo){
		this.explojugador = explo;
	}
}
