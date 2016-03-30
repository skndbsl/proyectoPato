package main;

import java.awt.Graphics;
import java.awt.Rectangle;

import animaciones.Control;
import animaciones.Sound;
import animaciones.Texturas;
import main.entidades.Colisiones;
import main.entidades.EntidadAmiga;
import main.entidades.EntidadEnemiga;

public class Constructor extends GameObjeto implements EntidadEnemiga{

	private Texturas tex;
	private Game game;
	private Control control;
	private int constructorTocado = 0;
	public static boolean exploconstructor = false;
	public static double xconstructordown, yconstructordown;
	
	public Constructor(double x, double y, Texturas tex, Game game, Control control) {
		super(x, y);
		this.tex = tex;
		this.game = game;
		this.control = control;
	}

	@Override
	public void tick() {
		// TODO Auto-generated method stub
		y+=1;
		
		for(int i=0;i<game.ea.size();i++){
			EntidadAmiga temporalEntidad = game.ea.get(i);
			
			if(Colisiones.Colision(this, temporalEntidad)){
				constructorTocado++;
				game.PUNT += 10;
				
				exploconstructor = true;
				xconstructordown = x;
				yconstructordown = y;
				
				control.quitarEntidad(temporalEntidad);
				
				if(constructorTocado == 30){
					control.quitarEntidad(this);
					if(game.audio == true)Sound.explosion.play();
					while(!game.ee.isEmpty()){game.ee.removeFirst();}
					Game.Estado = Game.ESTADO.MENU;
					Game.Nivel = Game.NIVEL.NIVEL1;
				}
			}
		}
		
		if(y>(Game.ALTO * Game.ESCALA)){
			while(!game.ee.isEmpty()){game.ee.removeFirst();}
			Game.Estado = Game.ESTADO.MENU;
			Game.Nivel = Game.NIVEL.NIVEL1;
		}
	}

	@Override
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(tex.constructor,(int )x,(int)y,null);
	}

	@Override
	public Rectangle getBounds() {
		// TODO Auto-generated method stub
		return new Rectangle ((int)x,(int)y,32,32);
	}

	public void setY(double y){
		this.y = y;
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
