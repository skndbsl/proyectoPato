package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.LinkedList;

import javax.swing.JFrame;

import animaciones.BufferedImageLoader;
import animaciones.Control;
import animaciones.ControlExplosion;
import animaciones.Sound;
import animaciones.Texturas;
import main.entidades.EntidadAmiga;
import main.entidades.EntidadEnemiga;
import menus.Ayuda;
import menus.GameOver;
import menus.Menu;
import menus.Raton;
import menus.Teclado;

@SuppressWarnings("serial")
public class Game extends Canvas implements Runnable{
	
	public static final int ANCHO = 320;
	public static final int ALTO = ANCHO / 12 * 9;
	public static final int ESCALA = 2;
	public final String TITULO = "Star Fox (Press C for change bullet)";
	
	private boolean corriendo = false;
	private Thread hilo;
	
	private BufferedImage imagen = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_RGB);
	private BufferedImage spriteSheet = null;
	private BufferedImage spriteSheetExplosion = null;
	private BufferedImage spriteSheetConstructor = null;
	
	private BufferedImage fondo = null;
	private BufferedImage fondoMenu = null;
	private BufferedImage fondoAyuda = null;
	private BufferedImage fondoGameOver = null;
	
	private boolean disparando = false;
	
	private int enemigocont = 10;
	private int enemigodown = 0;
	private int constructorcont = 1;
	private int tipoBala = 0;
	
	public Jugador jugador;
	private Control control;
	private Enemigo enemigo;
	private Texturas tex;
	private Menu menu;
	private Ayuda ayuda;
	private GameOver gameOver;
	private ControlExplosion controlexplosion;
	private Constructor constructor;
	public LinkedList<EntidadAmiga> ea;
	public LinkedList<EntidadEnemiga> ee;
	
	public static int VIDA = 100;
	public static int PUNT = 0;
	public static boolean audio = true;
	public static boolean DIFICULTAD = false;
	
	public static enum ESTADO{
		MENU,
		JUEGO,
		AYUDA,
		GAMEOVER
	};
	
	public static enum NIVEL{
		NIVEL1,
		NIVEL2,
		NIVEL3
	};
	
	public static ESTADO Estado = ESTADO.MENU;
	public static NIVEL Nivel = NIVEL.NIVEL1;
	
	public void iniciar(){
		requestFocus();
		BufferedImageLoader cargador = new BufferedImageLoader();
		
		try{
			spriteSheet = cargador.loadImage("/pato.png");
			spriteSheetExplosion = cargador.loadImage("/explosion.png");
			spriteSheetConstructor = cargador.loadImage("/ssconstructor.gif");
			
			fondo = cargador.loadImage("/fondo.png");
			fondoMenu = cargador.loadImage("/fondoMenu.png");
			fondoAyuda = cargador.loadImage("/fondoAyuda.png");
			fondoGameOver = cargador.loadImage("/fondoGameOver.jpg");
		}catch(IOException e){
			e.printStackTrace();
		}
		
		addKeyListener(new Teclado(this));
		this.addMouseListener(new Raton());
		
		tex = new Texturas(this);
		control = new Control(tex, this);
		jugador = new Jugador(100,250,tex,this,control);
		enemigo = new Enemigo(400,600,tex,control,this);
		control.añadeEnemigo(enemigocont);
		controlexplosion = new ControlExplosion(tex,this);
		menu = new Menu();
		ayuda = new Ayuda();
		gameOver = new GameOver();
		ea = control.getEntidadAmiga();
		ee = control.getEntidadEnemiga();
		
		if(audio==true)Sound.intro.loop();
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		iniciar();
		long ultimoInstante = System.nanoTime();
		final double cantidadTicks = 60.0;
		double ns = 1000000000 / cantidadTicks;
		double delta = 0;
		int actualizar = 0;
		int frames = 0;
		long refInstante = System.nanoTime();
		
		while(corriendo){
			long ahora = System.nanoTime();
			delta += (ahora - ultimoInstante) / ns;
			ultimoInstante = ahora;
			if(delta >=1){
				tick();
				actualizar++;
				delta--;
			}
			render();
			frames++;
			
			if(System.nanoTime() - refInstante > 1000000000){
				System.out.println(actualizar + " Ticks, Frames por segundo " + frames);
				actualizar = 0;
				frames = 0;
				refInstante = System.nanoTime();
			}
		}
		parar();
	}
	
	private void tick(){
		
		if(Estado == ESTADO.JUEGO){
			jugador.tick();
			control.tick();
			controlexplosion.tick();
		}
		//realizado con objeto enemigo y metodos para "ver" dentro de la clase enemigo
		if(jugador.getExplo() == true){
			controlexplosion.añadeExplosion(new Explosion((int)jugador.getX()-16,(int)jugador.getY()-32,tex));
			long now = System.nanoTime();
			controlexplosion.añadeInstanteExplosion(now);
			jugador.setExplo(false);
		}
		//realizado con variables publicas
		if(enemigo.exploenemigo == true){
			controlexplosion.añadeExplosion(new Explosion((int)enemigo.xenemigodown,(int)enemigo.yenemigodown,tex));
			long now = System.nanoTime();
			controlexplosion.añadeInstanteExplosion(now);
			enemigo.exploenemigo = false;
		}
		
		if(constructor.exploconstructor == true){
			controlexplosion.añadeExplosion(new Explosion((int)constructor.xconstructordown,(int)constructor.yconstructordown,tex));
			long now = System.nanoTime();
			controlexplosion.añadeInstanteExplosion(now);
			constructor.exploconstructor = false;
		}
		
		if(enemigodown >= enemigocont){
			enemigocont += 2;
			enemigodown = 0;
			control.añadeEnemigo(enemigocont);
		}
		
		if(Nivel == NIVEL.NIVEL1){
			if(enemigodown == enemigocont || enemigocont == 5){
				enemigocont += 1;
				enemigodown = 0;
				if(enemigocont < 5){control.añadeEnemigo(enemigocont);}
				else{
					enemigocont = 0;
					while(!ee.isEmpty()){ee.removeFirst();}
					Nivel = NIVEL.NIVEL2;
				}
			}
		}
		
		if(Nivel == NIVEL.NIVEL2){
			if(enemigodown == enemigocont || enemigocont == 5){
				enemigocont += 1;
				enemigodown = 0;
				if(enemigocont < 5){control.añadeEnemigo(enemigocont);}
				else{
					enemigocont = 0;
					while(!ee.isEmpty()){ee.removeFirst();}
					Nivel = NIVEL.NIVEL3;
				}
			}
		}
		
		if(Nivel == NIVEL.NIVEL3){
			if(constructorcont == 1){
				control.añadeConstructor(1);
				constructorcont++;
				enemigodown=1;
			}
		}
	}
	
	private void render(){
		BufferStrategy bs = this.getBufferStrategy();
		
		if(bs == null){
			createBufferStrategy(4);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		//Aqui se pinta el juego
		
		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), this);
		g.drawImage(fondo, 0, 0, this);
		
		if(Estado == ESTADO.JUEGO){
			
			jugador.render(g);
			control.render(g);
			controlexplosion.render(g);
		
			g.setColor(Color.red);
			g.fillRect(5, 5, 100, 20);

			g.setColor(Color.green);
			g.fillRect(5, 5, VIDA, 20);
		
			g.setColor(Color.black);
			g.drawRect(5, 5, 100, 20);
			
			Font font = new Font("Courier", Font.BOLD, 30);
			g.setFont(font);
			g.setColor(Color.black);
			g.drawString("Puntos:"+Integer.toString(Game.PUNT), Game.ANCHO*ESCALA -200, 30);
			
			Font font1 = new Font("Courier",Font.BOLD,20);
			g.setFont(font1);
			g.setColor(Color.blue);
			if(Nivel == NIVEL.NIVEL1) g.drawString("Nivel 1", Game.ANCHO*ESCALA - 120, 450);
			else if(Nivel == NIVEL.NIVEL2) g.drawString("Nivel 2", Game.ANCHO*ESCALA - 120, 450);
			else if(Nivel == NIVEL.NIVEL3) g.drawString("Nivel 3", Game.ANCHO*ESCALA - 120, 450);
		}else if(Estado == ESTADO.MENU){
			g.drawImage(fondoMenu, 0, 0, this);
			menu.render(g);
		}else if(Estado == ESTADO.AYUDA){
			g.drawImage(fondoAyuda, 0, 0, this);
			ayuda.render(g);
		}else if(Estado == ESTADO.GAMEOVER){
			try{
				Thread.sleep(1000);
			}catch(InterruptedException ex){
				Thread.currentThread().interrupt();
			}
			g.drawImage(fondoGameOver, 0, 0, this);
			gameOver.render(g);
		}
		//Aqui se acaba de pintar el juego
		g.dispose();
		bs.show();
	}
	
	public void musicBack(){
		if(audio == true){
			Sound.background.stop();
			audio = false;
		}
		else {
			audio = true;
			Sound.background.loop();
		}
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		if(Estado == ESTADO.JUEGO){
			
			if(key == KeyEvent.VK_F1){
				musicBack();
			}else if(key == KeyEvent.VK_RIGHT){
				jugador.setVelX(12);
				jugador.setMov(0);
			}else if(key == KeyEvent.VK_P){
				Estado = ESTADO.MENU;
			}else if(key == KeyEvent.VK_LEFT){
				jugador.setVelX(-12);
				jugador.setMov(0);
			}else if(key == KeyEvent.VK_UP){
				jugador.setVelY(-12);
				jugador.setMov(1);
			}else if(key == KeyEvent.VK_DOWN){
				jugador.setVelY(12);
				jugador.setMov(1);
			}else if(key == KeyEvent.VK_SPACE && !disparando){
				disparando = true;
				control.añadeEntidad(new Balas(jugador.getX(),jugador.getY(),tex,this,this.tipoBala));
				if(audio == true) Sound.disparos.play();
			}else if(key == KeyEvent.VK_C){
				this.tipoBala++;
				if(this.tipoBala>3)this.tipoBala=0;
				//if(audio == true)
				Sound.reload.play();
			}
		}
	}
	
	public void keyReleased(KeyEvent e){
		int key = e.getKeyCode();
		
		if(key == KeyEvent.VK_RIGHT){
			jugador.setVelX(0);
			jugador.setMov(0);
		}else if(key == KeyEvent.VK_LEFT){
			jugador.setVelX(0);
			jugador.setMov(0);
		}else if(key == KeyEvent.VK_UP){
			jugador.setVelY(0);
			jugador.setMov(0);
		}else if(key == KeyEvent.VK_DOWN){
			jugador.setVelY(0);
			jugador.setMov(0);
		}else if(key == KeyEvent.VK_SPACE){
			disparando = false;
			//jugador.setMov(0);
		}
	}
	
	private synchronized void start(){
		if(corriendo) return;
		corriendo = true;
		hilo = new Thread(this);
		hilo.start();
		System.out.println("Start");
	}
	
	public synchronized void parar(){
		if(!corriendo) return;
		corriendo = false;
		try{
			hilo.join();
		} catch(InterruptedException e){
			e.printStackTrace();
		}
		System.exit(1);
	}
	
	public static void main (String args[]){
		Game game = new Game();
		
		game.setPreferredSize(new Dimension(ANCHO * ESCALA, ALTO * ESCALA));
		game.setMaximumSize(new Dimension(ANCHO * ESCALA, ALTO * ESCALA));
		game.setMinimumSize(new Dimension(ANCHO * ESCALA, ALTO * ESCALA));
		
		JFrame frame = new JFrame(game.TITULO);
		
		frame.add(game);
		frame.pack();
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		
		game.start();
	}
	
	public BufferedImage getSpriteSheet(){
		return spriteSheet;
	}
	
	public BufferedImage getSpriteSheetExplosion(){
		return spriteSheetExplosion;
	}

	public BufferedImage getSpriteSheetConstructor(){
		return spriteSheetConstructor;
	}

	public int getEnemigocont() {
		return enemigocont;
	}

	public void setEnemigocont(int enemigocont) {
		this.enemigocont = enemigocont;
	}

	public int getEnemigodown() {
		return enemigodown;
	}

	public void setEnemigodown(int enemigodown) {
		this.enemigodown = enemigodown;
	}
	
	public double getjugadorX(){
		return this.jugador.getX();
	}
	
	public double getjugadorY(){
		return this.jugador.getY();
	}
	
}
