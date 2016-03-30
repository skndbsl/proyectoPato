package main;

import java.awt.Graphics;
import java.awt.Rectangle;

import animaciones.Texturas;
import main.entidades.EntidadAmiga;

public class Balas extends GameObjeto implements EntidadAmiga{

	
	private Texturas tex;
	private Game game;
	int tipoBala;
	
	
	public Balas(double x, double y, Texturas tex, Game game, int tipoBala){
		
		super(x,y);
		this.tex = tex;
		this.game = game;
		this.tipoBala = tipoBala;
	}
	
	public void tick(){
		y -= 10;
	}
	
	public void render (Graphics g){
		g.drawImage(tex.bala[tipoBala], (int )x, (int )y, null);
	}
	
	public Rectangle getBounds(){
		return new Rectangle ((int)x,(int)y,32,32);
	}
	
	public double getY(){
		return y;
	}

	public double getX() {
		// TODO Auto-generated method stub
		return x;
	}
}
