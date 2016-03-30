package menus;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import animaciones.Sound;
import main.Game;

public class Raton implements MouseListener{

	private boolean on = true;
	
	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		int ratonx = e.getX();
		int ratony = e.getY();
		//public Rectangle jugarBoton = new Rectangle(Game.ANCHO/2+120,150,100,50);
		// jugar BOTON
		if(ratonx>=Game.ANCHO/2 + 120 && ratonx <= Game.ANCHO / 2 + 220 && Game.Estado == Game.Estado.MENU){
			if(ratony >= 150 && ratony <= 200){
				Sound.intro.stop();
				if(Game.audio == true)Sound.background.loop();
				Game.Estado = Game.Estado.JUEGO;
			}
		}
		
		//public Rectangle salirBoton = new Rectangle(Game.ANCHO/2+120,350,100,50);
		// salir BOTON
		if(ratonx>=Game.ANCHO/2 + 120 && ratonx <= Game.ANCHO / 2 + 220 && Game.Estado == Game.Estado.MENU){
			if(ratony >= 350 && ratony <= 400){
				System.exit(1);
			}
		}
		
		//public Rectangle ayudarBoton = new Rectangle(Game.ANCHO/2+120,250,100,50);
		// ayudar BOTON
		if(ratonx>=Game.ANCHO/2 + 120 && ratonx <= Game.ANCHO / 2 + 220 && Game.Estado == Game.Estado.MENU){
			if(ratony >= 250 && ratony <= 300){
				Game.Estado = Game.Estado.AYUDA;
			}
		}
		
		//public Rectangle menuBoton = new Rectangle(Game.ANCHO/2+120,400,100,50);
		// menu BOTON
		if(ratonx>=Game.ANCHO/2 + 120 && ratonx <= Game.ANCHO / 2 + 220 && Game.Estado == Game.Estado.AYUDA){
			if(ratony >= 400 && ratony <= 450){
				Game.Estado = Game.Estado.MENU;
			}
		}
		
		//public Rectangle menuBoton = new Rectangle(Game.ANCHO/2+120,400,100,50);
		// menu BOTON desde GAMEOVER
		if(ratonx>=Game.ANCHO/2 + 120 && ratonx <= Game.ANCHO / 2 + 220 && Game.Estado == Game.Estado.GAMEOVER){
			if(ratony >= 400 && ratony <= 450){
				Game.Estado = Game.Estado.MENU;
			}
		}
		
		//Rectangle(10,450,100,50);
		// no audio BOTON desde MENU
		if(ratonx >=0 && ratonx <= 150 && Game.Estado == Game.ESTADO.MENU){
			if(ratony>=400 && ratony<=600){
				if(on==true){
					Sound.intro.stop();
					Game.audio = false;
					on = false;
				}else{
					Sound.intro.loop();
					Game.audio = true;
					on = true;
				}
			}
		}
		
		//Rectangle(470,450,100,50)
		//dificultad 1/2 BOTON desde MENU
		if(ratonx >= 400 && ratonx <= 640 && Game.Estado == Game.ESTADO.MENU){
			if(ratony>=300 && ratony<=480){
				if(Game.Nivel == Game.Nivel.NIVEL2) Game.Nivel = Game.Nivel.NIVEL3;
				else if(Game.Nivel == Game.Nivel.NIVEL3) Game.Nivel = Game.Nivel.NIVEL1;
				else if(Game.Nivel == Game.Nivel.NIVEL1) Game.Nivel = Game.Nivel.NIVEL2;
			}
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
