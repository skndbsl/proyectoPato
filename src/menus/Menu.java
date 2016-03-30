package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.Game;
import main.Game.NIVEL;

public class Menu {
	
	public Rectangle jugarBoton = new Rectangle(Game.ANCHO/2 + 120,150,100,50);
	public Rectangle ayudarBoton = new Rectangle(Game.ANCHO/2 + 120,250,100,50);
	public Rectangle salirBoton = new Rectangle(Game.ANCHO/2 + 120,350,100,50);
	
	public void render(Graphics g){
		
		Graphics2D g2d = (Graphics2D)g;
		
		Font font = new Font("Courier", Font.BOLD, 50);
		g.setFont(font);
		g.setColor(Color.black);
		g.drawString("STAR FOX", Game.ANCHO/2, 100);
		
		Font font10 = new Font("Arial", Font.PLAIN, 20);
		g.setFont(font10);
		g.setColor(Color.gray);
		g.drawString("audio on/off", 10, 450);
		
		Font font11 = new Font("Arial", Font.PLAIN, 20);
		g.setFont(font11);
		g.setColor(Color.blue);
		if(Game.Nivel == NIVEL.NIVEL1) g.drawString("Nivel 1", Game.ANCHO*Game.ESCALA - 120, 450);
		else if(Game.Nivel == NIVEL.NIVEL2) g.drawString("Nivel 2", Game.ANCHO*Game.ESCALA - 120, 450);
		else if(Game.Nivel == NIVEL.NIVEL3) g.drawString("Nivel 3", Game.ANCHO*Game.ESCALA - 120, 450);
		
		g.setColor(Color.black);
		g.fillRect(Game.ANCHO/2 +120, 150, 100, 50);
		g.setColor(Color.white);
		Font font1 = new Font ("Arial", Font.BOLD, 20);
		g.setFont(font1);
		g.drawString("JUGAR", jugarBoton.x+14, jugarBoton.y+30);
		
		g.setColor(Color.black);
		g.fillRect(Game.ANCHO/2 +120, 250, 100, 50);
		g.setColor(Color.white);
		Font font2 = new Font ("Arial", Font.BOLD, 20);
		g.setFont(font2);
		g.drawString("AYUDA", ayudarBoton.x+14, ayudarBoton.y+30);
		
		g.setColor(Color.black);
		g.fillRect(Game.ANCHO/2 +120, 350, 100, 50);
		g.setColor(Color.white);
		Font font3 = new Font ("Arial", Font.BOLD, 20);
		g.setFont(font3);
		g.drawString("SALIR", salirBoton.x+14, salirBoton.y+30);
		
		g2d.draw(jugarBoton);
		g2d.draw(ayudarBoton);
		g2d.draw(salirBoton);
	}
}
