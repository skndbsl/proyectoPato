package main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import animaciones.Control;
import animaciones.Texturas;
import main.entidades.EntidadEnemiga;

public class BalasEnemigo extends GameObjeto implements EntidadEnemiga{

	private Texturas tex;
	private Game game;
	private Enemigo enemigo;
	private Control control;
	private Jugador jugador;
	Random r = new Random();
	private int speed = r.nextInt(3)+1;
	private double xdireccion,ydireccion;

	public BalasEnemigo(double x, double y, Texturas tex, Control control, Game game, double xdireccion, double ydireccion) {
		super(x, y);
		// TODO Auto-generated constructor stub
		this.tex = tex;
		this.game = game;
		this.control = control;
		this.xdireccion = xdireccion;
		this.ydireccion = ydireccion;
		this.x = x;
		this.y = y;
	}
	
	@Override
	public void tick() {
		// TODO Auto-generated method stub
		//y += speed + 3;
		y += ydireccion;
		x += xdireccion;
		
		if(y>(Game.ALTO * Game.ESCALA)){control.quitarEntidad(this);}
		if(x>(Game.ANCHO * Game.ESCALA)){control.quitarEntidad(this);}
		if(x<0){control.quitarEntidad(this);}
		if(y<0){control.quitarEntidad(this);}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(tex.balaenemigo,(int)x,(int)y,null);
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
