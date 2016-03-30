package main;

import java.awt.Graphics;

import animaciones.Animacion;
import animaciones.Texturas;

public class Explosion {
	private double x,y;
	private Texturas tex;
	private Animacion anim;
	private Explosion explosionTemp;
	
	public Explosion(double x, double y, Texturas tex){
		this.tex = tex;
		this.x = x;
		this.y = y;
		anim = new Animacion(3, tex.explosion[0], tex.explosion[1], tex.explosion[2], tex.explosion[3],
				tex.explosion[4], tex.explosion[5], tex.explosion[6], tex.explosion[7], tex.explosion[8],
				tex.explosion[9], tex.explosion[10], tex.explosion[11], tex.explosion[12], tex.explosion[13]);
	}
	
	public void tick(){
		anim.runAnimacion();
	}
	
	public void render(Graphics g){
		anim.drawAnimation(g, x, y, 0);
	}
}
