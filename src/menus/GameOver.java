package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.Game;

public class GameOver {

	public Rectangle menuBoton = new Rectangle(Game.ANCHO/2+120,400,100,50);
	
	public void render(Graphics g){
		
		Graphics2D g2d = (Graphics2D)g;
		
		Font font = new Font("Courier", Font.BOLD, 50);
		g.setFont(font);
		g.setColor(Color.white);
		g.drawString("Game Over", Game.ANCHO, 100);
		
		Font font1 = new Font("Courier", Font.BOLD, 30);
		g.setFont(font1);
		g.drawString(" insert coin,", Game.ANCHO, 250);
		
		Font font2 = new Font("Courier", Font.BOLD, 30);
		g.setFont(font2);
		g.drawString(" loser.", Game.ANCHO, 280);
		
		g.setColor(Color.white);
		g.fillRect(Game.ANCHO/2+120, 400, 100, 50);
		g.setColor(Color.black);
		Font font7 = new Font("Arial", Font.BOLD, 20);
		g.setFont(font7);
		g.drawString(" MENU ", menuBoton.x+14, menuBoton.y+30);
		g2d.draw(menuBoton);
	}
}
