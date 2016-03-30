package main;

import java.awt.Graphics;
import java.awt.Rectangle;

import main.entidades.EntidadEnemiga;
import animaciones.Control;
import animaciones.Sound;
import animaciones.Texturas;

public class BalasEnemigoConstructor extends GameObjeto implements EntidadEnemiga{

	private Texturas tex;
	private Game game;
	private Control control;
	private Jugador jugador;
	private double xdireccion,ydireccion;
	private double xdif, ydif;
	
	public BalasEnemigoConstructor(double x, double y, Texturas tex, Control control, Game game) {
		super(x,y);
		this.tex = tex;
		this.game = game;
		this.control = control;
		
		this.x = 250;
		this.y = 0;
	}
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		xdif = game.getjugadorX() - x;
		ydif = game.getjugadorY() - y;
		
		//quadrante abajo-derecha
		if((xdif > ydif) && xdif>0 && ydif>0){xdireccion = xdif/ydif;ydireccion = 1;}
		if((ydif > xdif) && xdif>0 && ydif>0){xdireccion = 1;ydireccion = ydif/xdif;}
		
		//quadrante abajo-izquierda
		if((Math.abs(xdif) > ydif) && xdif<0 && ydif>0){xdireccion = xdif/ydif;ydireccion = 1;}
		if((ydif > Math.abs(xdif)) && xdif<0 && ydif>0){xdireccion = -1;ydireccion = Math.abs(ydif/xdif);}
		
		//quadrante arriba-derecha
		if((xdif > Math.abs(ydif)) && xdif>0 && ydif<0){xdireccion = xdif/ydif;ydireccion = -1;}
		if((Math.abs(ydif) > xdif) && xdif>0 && ydif<0){xdireccion = 1;ydireccion = ydif/xdif;}
		
		//quadrante arriba-izquierda
		if((Math.abs(xdif) > Math.abs(ydif)) && xdif<0 && ydif<0){xdireccion = -(xdif/ydif);ydireccion = -1;}
		if((Math.abs(ydif) > Math.abs(xdif)) && xdif<0 && ydif<0){xdireccion = -1;ydireccion = -(ydif/xdif);}
		
		//iguales
		if((Math.abs(xdif) == Math.abs(ydif)) && xdif>0 && ydif>0){xdireccion = 1;ydireccion = 1;}
		if((Math.abs(xdif) == Math.abs(ydif)) && xdif>0 && ydif<0){xdireccion = 1;ydireccion = -1;}
		if((Math.abs(xdif) == Math.abs(ydif)) && xdif<0 && ydif>0){xdireccion = -1;ydireccion = 1;}
		if((Math.abs(xdif) == Math.abs(ydif)) && xdif<0 && ydif<0){xdireccion = -1;ydireccion = -1;}
		
		y = y + ydireccion;
		x = x + xdireccion;
		
		if(game.jugador.getBounds().intersects(getBounds())){
			if(game.audio == true){Sound.background.stop();Sound.gameover.play();Sound.explosion.play();}
			Game.Estado = Game.ESTADO.GAMEOVER;
			Game.Nivel = Game.NIVEL.NIVEL1;
			while(!game.ee.isEmpty()){game.ee.removeFirst();}
		}
		
		if(y>Game.ALTO * Game.ESCALA){control.quitarEntidad(this);}
		if(x>Game.ANCHO * Game.ESCALA){control.quitarEntidad(this);}
		if(x<0){control.quitarEntidad(this);}
		if(y<0){control.quitarEntidad(this);}
	}
	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(tex.balaenemigoconstructor,(int)x,(int)y,null);
	}
	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle ((int)x,(int)y,32,32);
	}
	@Override
	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}
	@Override
	public double getY() {
		// TODO Auto-generated method stub
		return y;
	}
	
	
}
