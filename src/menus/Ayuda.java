package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.Game;

public class Ayuda {
	
	public Rectangle menuBoton = new Rectangle(Game.ANCHO/2+120,400,100,50);
	
	public void render (Graphics g){
		Graphics2D g2d = (Graphics2D) g;
		
		Font font = new Font("Courier", Font.BOLD,50);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Ayuda", Game.ANCHO/2, 100);
		
		Font font1 = new Font("Arial", Font.BOLD,20);
		g.setFont(font1);
		g.drawString("Este juego tiene un pato psicodélico", Game.ANCHO/2, 150);
		
		Font font2 = new Font("Arial", Font.BOLD,20);
		g.setFont(font2);
		g.drawString("que mata zorros locos.", Game.ANCHO/2, 180);
		
		Font font3 = new Font("Arial", Font.BOLD,20);
		g.setFont(font3);
		g.drawString("Dispara sin parar", Game.ANCHO/2, 210);
		
		Font font4 = new Font("Arial", Font.BOLD,20);
		g.setFont(font4);
		g.drawString("y mata a todos los zorros que puedas.", Game.ANCHO/2, 240);
		
		Font font5 = new Font("Arial", Font.BOLD,20);
		g.setFont(font5);
		g.drawString("Conviertete en el matazorros.", Game.ANCHO/2, 270);
		
		Font font6 = new Font("Arial", Font.BOLD,20);
		g.setFont(font6);
		g.drawString("Cuac.", Game.ANCHO/2, 350);
		
		g.setColor(Color.black);
		g.fillRect(Game.ANCHO/2 +120, 400, 100, 50);
		g.setColor(Color.white);
		Font font7 = new Font("Arial", Font.BOLD,20);
		g.setFont(font7);
		g.drawString("MENU", menuBoton.x+14, menuBoton.y+30);
		g2d.draw(menuBoton);
		
	}

}
