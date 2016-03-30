package animaciones;

import java.awt.Graphics;
import java.util.LinkedList;
import java.util.Random;

import main.BalasEnemigo;
import main.BalasEnemigoConstructor;
import main.Constructor;
import main.Enemigo;
import main.Game;
import main.entidades.EntidadAmiga;
import main.entidades.EntidadEnemiga;

public class Control {
	//private LinkedList<Entidad> e = new LinkedList<Entidad>();
	private LinkedList<EntidadAmiga> ea = new LinkedList<EntidadAmiga>();
	private LinkedList<EntidadEnemiga> ee = new LinkedList<EntidadEnemiga>();
	
	EntidadAmiga enta;
	EntidadEnemiga ente;
	
	private double xbalaenemiga, ybalaenemiga, xdif, ydif, xinicial;
	
	private Game game;
	
	Random r = new Random();
	private Texturas tex;
	
	public Control (Texturas tex, Game game){
		this.tex = tex;
		this.game = game;
	}
	
	public void añadeEnemigo(int enemigocont){
		for(int i=0;i<enemigocont;i++){
			xinicial = r.nextInt(640);
			xdif = game.getjugadorX() - xinicial;
			ydif = game.getjugadorY();
			
			//System.out.println(game.getjugadorX());
			//System.out.println(game.getjugadorY());
			
			if((Math.abs(xdif) > ydif) && ((xdif/ydif)>0)){xbalaenemiga = xdif/ydif;ybalaenemiga = 1;}
			if((Math.abs(xdif) > ydif) && ((xdif/ydif)<0)){xbalaenemiga = xdif/ydif;ybalaenemiga = 1;}
			
			if((ydif > Math.abs(xdif)) && ((ydif/xdif)>0)){ybalaenemiga = ydif/xdif;xbalaenemiga = 1;}
			if((ydif > Math.abs(xdif)) && ((ydif/xdif)<0)){xbalaenemiga = -1;ybalaenemiga = Math.abs(ydif/xdif);}
			
			if(ydif == Math.abs(xdif) && xdif>0){xbalaenemiga = 1;ybalaenemiga = 1;}
			if(ydif == Math.abs(xdif) && xdif<0){xbalaenemiga = -1;ybalaenemiga = 1;}
			
			añadeEntidad(new Enemigo(xinicial, -10, tex, this, game));
			añadeEntidad(new BalasEnemigo(xinicial, 0, tex, this, game,xbalaenemiga,ybalaenemiga));
		}

	}
	
	public void tick(){
		//EntidadAmiga clase
		for(int i = 0;i<ea.size();i++){
			enta = ea.get(i);
			enta.tick();
		}
		//EntidadEnemiga clase
		for(int i = 0;i<ee.size();i++){
			ente = ee.get(i);
			ente.tick();
		}
		
	}
	
	public void render (Graphics g){
		//EntidadAmiga clase
		for(int i = 0; i<ea.size();i++){
			enta = ea.get(i);
			enta.render(g);
		}
		//EntidadEnemiga clase
		for(int i = 0;i<ee.size();i++){
			ente = ee.get(i);
			ente.render(g);
		}
	}
	
	public void añadeEntidad(EntidadAmiga grupo){
		ea.add(grupo);
	}
	
	public void quitarEntidad(EntidadAmiga grupo){
		ea.remove(grupo);
	}
	
	public void añadeEntidad(EntidadEnemiga grupo){
		ee.add(grupo);
	}
	
	public void quitarEntidad(EntidadEnemiga grupo){
		ee.remove(grupo);
	}

	public void añadeConstructor(int constructorcont){
		xdif = game.getjugadorX() - 250;
		ydif = game.getjugadorY();
		
		if((Math.abs(xdif) > ydif) && ((xdif/ydif)>0)){xbalaenemiga = xdif/ydif;ybalaenemiga = 1;}
		if((Math.abs(xdif) > ydif) && ((xdif/ydif)<0)){xbalaenemiga = xdif/ydif;ybalaenemiga = 1;}
		
		if((ydif > Math.abs(xdif)) && ((ydif/xdif)>0)){ybalaenemiga = ydif/xdif;xbalaenemiga = 1;}
		if((ydif > Math.abs(xdif)) && ((ydif/xdif)<0)){xbalaenemiga = -1;ybalaenemiga = Math.abs(ydif/xdif);}
		
		if(ydif == Math.abs(xdif) && xdif>0){xbalaenemiga = 1;ybalaenemiga = 1;}
		if(ydif == Math.abs(xdif) && xdif<0){xbalaenemiga = -1;ybalaenemiga = 1;}
		
		añadeEntidad(new Constructor(250,-10,tex,game,this));
		añadeEntidad(new BalasEnemigoConstructor (250,0,tex,this,game));
	}
	
	public LinkedList<EntidadAmiga> getEntidadAmiga() {
		// TODO Auto-generated method stub
		return ea;
	}

	public LinkedList<EntidadEnemiga> getEntidadEnemiga() {
		// TODO Auto-generated method stub
		return ee;
	}
}
