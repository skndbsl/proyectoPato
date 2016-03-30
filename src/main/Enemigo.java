package main;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

import animaciones.Animacion;
import animaciones.Control;
import animaciones.Sound;
import animaciones.Texturas;
import main.entidades.Colisiones;
import main.entidades.EntidadAmiga;
import main.entidades.EntidadEnemiga;

public class Enemigo extends GameObjeto implements EntidadEnemiga{
	
	private Texturas tex;
	Random r = new Random();
	private int speed = r.nextInt(3)+1;
	private Game game;
	private Control control;
	private Animacion anim;
	
	private double xbalaenemiga,ybalaenemiga,xdif,ydif,xinicial;
	
	public static boolean exploenemigo = false;
	public static double xenemigodown, yenemigodown;
	
	public Enemigo(double x, double y, Texturas tex, Control control, Game game){
		super(x,y);
		this.tex = tex;
		this.control = control;
		this.game = game;
		this.anim = new Animacion(3, tex.enemigo[0], tex.enemigo[1], tex.enemigo[2], tex.enemigo[3]);
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		y += speed;
		if(y>(Game.ALTO * Game.ESCALA)){
			speed = r.nextInt(3)+1;
			y = 1;
			x = r.nextInt(Game.ANCHO * Game.ESCALA);
			//control.añadeEntidad(new BalasEnemigo(x,10,tex,control,game));
			
			xdif = game.getjugadorX()-x;
			ydif = game.getjugadorY();
			
			if((Math.abs(xdif) > ydif) && ((xdif/ydif)>0)){xbalaenemiga = xdif/ydif;ybalaenemiga = 1;}
			if((Math.abs(xdif) > ydif) && ((xdif/ydif)<0)){xbalaenemiga = xdif/ydif;ybalaenemiga = 1;}
			
			if((ydif > Math.abs(xdif)) && ((ydif/xdif)>0)){xbalaenemiga = ydif/xdif;ybalaenemiga = 1;}
			if((ydif > Math.abs(xdif)) && ((ydif/xdif)<0)){xbalaenemiga = -1;ybalaenemiga = Math.abs(ydif/xdif);}
			
			if((ydif == Math.abs(xdif)) && xdif>0){xbalaenemiga = 1;ybalaenemiga = 1;}
			if((ydif == Math.abs(xdif)) && xdif<0){xbalaenemiga = -1;ybalaenemiga = 1;}
			
			if(Game.Nivel == Game.Nivel.NIVEL2)control.añadeEntidad(new BalasEnemigo(x,0,tex,control,game,xbalaenemiga,ybalaenemiga));
			
			//if(Game.DIFICULTAD ==true)
			//control.añadeEntidad(new BalasEnemigo(x,0,tex,control,game,xbalaenemiga,ybalaenemiga));
		}
		for(int i=0;i<game.ea.size();i++){
			EntidadAmiga temporalEntidad = game.ea.get(i);
			if(Colisiones.Colision(this, temporalEntidad)){
				game.setEnemigodown(game.getEnemigodown()+1);
				game.PUNT += 10;
				
				exploenemigo = true;
				xenemigodown = x;
				yenemigodown = y;
				
				control.quitarEntidad(temporalEntidad);
				control.quitarEntidad(this);
				
				if(game.audio == true)Sound.explosion.play();
				
				//System.out.println("puntuacion: " + game.PUNT);
			}
		}
		anim.runAnimacion();
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		//g.drawImage(tex.enemigo, (int) x, (int)y, null);
		anim.drawAnimation(g, x, y, 0);
	}
	
	public Rectangle getBounds(){
		return new Rectangle((int)x, (int)y, 32, 32);
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
	
	public void setY(double y){
		this.y = y;
	}
}
