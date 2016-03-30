package animaciones;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.LinkedList;

import main.Explosion;
import main.Game;

public class ControlExplosion {

	private LinkedList<Explosion> e = new LinkedList<Explosion>();
	private ArrayList<Long> time = new ArrayList<Long>();
	private Explosion explosionTemp;
	private Game game;
	private Texturas tex;
	private int j = 0;
	
	public ControlExplosion(Texturas tex, Game game){
		this.tex = tex;
		this.game = game;
	}
	
	public void tick(){
		for(int i=0;i<e.size();i++){
			explosionTemp = e.get(i);
			explosionTemp.tick();
		}
		if(e.size()>0){
			for(int i=0;i<e.size();i++){
				long now = System.nanoTime();
				if((now-time.get(i))>1000000000){
					quitaInstanteExplosion(time.get(i));
					quitaExplosion(e.get(i));
				}
			}
		}
	}
	
	public void render(Graphics g){
		for(int i=0;i<e.size();i++){
			explosionTemp = e.get(i);
			explosionTemp.render(g);
		}
	}
	
	public void añadeExplosion(Explosion grupo){
		e.add(grupo);
	}
	
	public void quitaExplosion(Explosion grupo){
		e.remove(grupo);
	}
	
	public void añadeInstanteExplosion(long grupo){
		time.add(grupo);
	}
	
	public void quitaInstanteExplosion(long grupo){
		time.remove(grupo);
	}
}
