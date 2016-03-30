package animaciones;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Animacion {

	private int velocidad;
	private int frames;
	private int indice = 0;
	private int conta = 0;
	
	private BufferedImage img1;
	private BufferedImage img2;
	private BufferedImage img3;
	private BufferedImage img4;
	private BufferedImage img5;
	private BufferedImage img6;
	private BufferedImage img7;
	private BufferedImage img8;
	private BufferedImage img9;
	private BufferedImage img10;
	private BufferedImage img11;
	private BufferedImage img12;
	private BufferedImage img13;
	private BufferedImage img14;
	
	private BufferedImage imagenActual;
	//14 frames animation
	public Animacion(int velocidad, BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4, BufferedImage img5,
			BufferedImage img6, BufferedImage img7, BufferedImage img8, BufferedImage img9, BufferedImage img10,
			BufferedImage img11, BufferedImage img12, BufferedImage img13, BufferedImage img14) {
		this.velocidad = velocidad;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.img5 = img5;
		this.img6 = img6;
		this.img7 = img7;
		this.img8 = img8;
		this.img9 = img9;
		this.img10 = img10;
		this.img11 = img11;
		this.img12 = img12;
		this.img13 = img13;
		this.img14 = img14;
		this.frames = 14;
	}
	
	
	//13 frames animation
	public Animacion(int velocidad, BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4,
			BufferedImage img5, BufferedImage img6, BufferedImage img7, BufferedImage img8, BufferedImage img9,
			BufferedImage img10, BufferedImage img11, BufferedImage img12, BufferedImage img13) {
		this.velocidad = velocidad;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.img5 = img5;
		this.img6 = img6;
		this.img7 = img7;
		this.img8 = img8;
		this.img9 = img9;
		this.img10 = img10;
		this.img11 = img11;
		this.img12 = img12;
		this.img13 = img13;
		this.frames = 13;
	}
	
	//12 frames animation
	public Animacion(int velocidad, BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4,
			BufferedImage img5, BufferedImage img6, BufferedImage img7, BufferedImage img8, BufferedImage img9,
			BufferedImage img10, BufferedImage img11, BufferedImage img12) {
		this.velocidad = velocidad;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.img5 = img5;
		this.img6 = img6;
		this.img7 = img7;
		this.img8 = img8;
		this.img9 = img9;
		this.img10 = img10;
		this.img11 = img11;
		this.img12 = img12;
		this.frames = 12;
	}


	//11 frames animation
	public Animacion(int velocidad, BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4,
			BufferedImage img5, BufferedImage img6, BufferedImage img7, BufferedImage img8, BufferedImage img9,
			BufferedImage img10, BufferedImage img11) {
		this.velocidad = velocidad;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.img5 = img5;
		this.img6 = img6;
		this.img7 = img7;
		this.img8 = img8;
		this.img9 = img9;
		this.img10 = img10;
		this.img11 = img11;
		this.frames = 11;
	}

	//10 frames animation
	public Animacion(int velocidad, BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4,
			BufferedImage img5, BufferedImage img6, BufferedImage img7, BufferedImage img8, BufferedImage img9,
			BufferedImage img10) {
		this.velocidad = velocidad;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.img5 = img5;
		this.img6 = img6;
		this.img7 = img7;
		this.img8 = img8;
		this.img9 = img9;
		this.img10 = img10;
		this.frames = 10;
	}


	//9 frames animation
	public Animacion(int velocidad, BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4,
			BufferedImage img5, BufferedImage img6, BufferedImage img7, BufferedImage img8, BufferedImage img9) {
		this.velocidad = velocidad;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.img5 = img5;
		this.img6 = img6;
		this.img7 = img7;
		this.img8 = img8;
		this.img9 = img9;
		this.frames = 9;
	}


	//8 frames animation
	public Animacion(int velocidad, BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4,
			BufferedImage img5, BufferedImage img6, BufferedImage img7, BufferedImage img8) {
		this.velocidad = velocidad;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.img5 = img5;
		this.img6 = img6;
		this.img7 = img7;
		this.img8 = img8;
		this.frames = 8;
	}


	//7 frames animation
	public Animacion(int velocidad, BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4,
			BufferedImage img5, BufferedImage img6, BufferedImage img7) {
		this.velocidad = velocidad;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.img5 = img5;
		this.img6 = img6;
		this.img7 = img7;
		this.frames = 7;
	}


	//6 frames animation
	public Animacion(int velocidad, BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4,
			BufferedImage img5, BufferedImage img6) {
		this.velocidad = velocidad;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.img5 = img5;
		this.img6 = img6;
		this.frames = 6;
	}


	//5 frames animation
	public Animacion(int velocidad, BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4,
			BufferedImage img5) {
		this.velocidad = velocidad;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.img5 = img5;
		this.frames = 5;
	}


	//4 frames animation
	public Animacion(int velocidad, BufferedImage img1, BufferedImage img2, BufferedImage img3, BufferedImage img4) {
		this.velocidad = velocidad;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.img4 = img4;
		this.frames = 4;
	}


	//3 frames animation
	public Animacion(int velocidad, BufferedImage img1, BufferedImage img2, BufferedImage img3) {
		this.velocidad = velocidad;
		this.img1 = img1;
		this.img2 = img2;
		this.img3 = img3;
		this.frames = 3;
	}


	//2 frames animation
	public Animacion(int velocidad, BufferedImage img1, BufferedImage img2) {
		this.velocidad = velocidad;
		this.img1 = img1;
		this.img2 = img2;
		this.frames = 2;
	}
	
	public void runAnimacion(){
		this.indice++;
		if(this.indice > this.velocidad){
			this.indice = 0;
			nextFrame();
		}
	}
	
	public void nextFrame(){
		//switch statement
		switch(this.frames){
		case 2:
			if(this.conta == 0)
				this.imagenActual = img1;
			if(this.conta == 1)
				this.imagenActual = img2;
			
			this.conta++;
			
			if(this.conta > this.frames) this.conta = 0;
			break;
		case 3:
			if(this.conta == 0)
				this.imagenActual = img1;
			if(this.conta == 1)
				this.imagenActual = img2;
			if(this.conta == 2)
				this.imagenActual = img3;

			this.conta++;
			
			if(this.conta > this.frames) this.conta = 0;
			break;
		case 4:
			if(this.conta == 0)
				this.imagenActual = img1;
			if(this.conta == 1)
				this.imagenActual = img2;
			if(this.conta == 2)
				this.imagenActual = img3;
			if(this.conta == 3)
				this.imagenActual = img4;

			this.conta++;
			
			if(this.conta > this.frames) this.conta = 0;
			break;
		case 5:
			if(this.conta == 0)
				this.imagenActual = img1;
			if(this.conta == 1)
				this.imagenActual = img2;
			if(this.conta == 2)
				this.imagenActual = img3;
			if(this.conta == 3)
				this.imagenActual = img4;
			if(this.conta == 4)
				this.imagenActual = img5;

			this.conta++;
			
			if(this.conta > this.frames) this.conta = 0;
			break;
		case 6:
			if(this.conta == 0)
				this.imagenActual = img1;
			if(this.conta == 1)
				this.imagenActual = img2;
			if(this.conta == 2)
				this.imagenActual = img3;
			if(this.conta == 3)
				this.imagenActual = img4;
			if(this.conta == 4)
				this.imagenActual = img5;
			if(this.conta == 5)
				this.imagenActual = img6;

			this.conta++;
			
			if(this.conta > this.frames) this.conta = 0;
			break;
		case 7:
			if(this.conta == 0)
				this.imagenActual = img1;
			if(this.conta == 1)
				this.imagenActual = img2;
			if(this.conta == 2)
				this.imagenActual = img3;
			if(this.conta == 3)
				this.imagenActual = img4;
			if(this.conta == 4)
				this.imagenActual = img5;
			if(this.conta == 5)
				this.imagenActual = img6;
			if(this.conta == 6)
				this.imagenActual = img7;

			this.conta++;
			
			if(this.conta > this.frames) this.conta = 0;
			break;
		case 8:
			if(this.conta == 0)
				this.imagenActual = img1;
			if(this.conta == 1)
				this.imagenActual = img2;
			if(this.conta == 2)
				this.imagenActual = img3;
			if(this.conta == 3)
				this.imagenActual = img4;
			if(this.conta == 4)
				this.imagenActual = img5;
			if(this.conta == 5)
				this.imagenActual = img6;
			if(this.conta == 6)
				this.imagenActual = img7;
			if(this.conta == 7)
				this.imagenActual = img8;

			this.conta++;
			
			if(this.conta > this.frames) this.conta = 0;
			break;
		case 9:
			if(this.conta == 0)
				this.imagenActual = img1;
			if(this.conta == 1)
				this.imagenActual = img2;
			if(this.conta == 2)
				this.imagenActual = img3;
			if(this.conta == 3)
				this.imagenActual = img4;
			if(this.conta == 4)
				this.imagenActual = img5;
			if(this.conta == 5)
				this.imagenActual = img6;
			if(this.conta == 6)
				this.imagenActual = img7;
			if(this.conta == 7)
				this.imagenActual = img8;
			if(this.conta == 8)
				this.imagenActual = img9;

			this.conta++;
			
			if(this.conta > this.frames) this.conta = 0;
			break;
		case 10:
			if(this.conta == 0)
				this.imagenActual = img1;
			if(this.conta == 1)
				this.imagenActual = img2;
			if(this.conta == 2)
				this.imagenActual = img3;
			if(this.conta == 3)
				this.imagenActual = img4;
			if(this.conta == 4)
				this.imagenActual = img5;
			if(this.conta == 5)
				this.imagenActual = img6;
			if(this.conta == 6)
				this.imagenActual = img7;
			if(this.conta == 7)
				this.imagenActual = img8;
			if(this.conta == 8)
				this.imagenActual = img9;
			if(this.conta == 9)
				this.imagenActual = img10;

			this.conta++;
			
			if(this.conta > this.frames) this.conta = 0;
			break;
		case 11:
			if(this.conta == 0)
				this.imagenActual = img1;
			if(this.conta == 1)
				this.imagenActual = img2;
			if(this.conta == 2)
				this.imagenActual = img3;
			if(this.conta == 3)
				this.imagenActual = img4;
			if(this.conta == 4)
				this.imagenActual = img5;
			if(this.conta == 5)
				this.imagenActual = img6;
			if(this.conta == 6)
				this.imagenActual = img7;
			if(this.conta == 7)
				this.imagenActual = img8;
			if(this.conta == 8)
				this.imagenActual = img9;
			if(this.conta == 9)
				this.imagenActual = img10;
			if(this.conta == 10)
				this.imagenActual = img11;

			this.conta++;
			
			if(this.conta > this.frames) this.conta = 0;
			break;
		case 12:
			if(this.conta == 0)
				this.imagenActual = img1;
			if(this.conta == 1)
				this.imagenActual = img2;
			if(this.conta == 2)
				this.imagenActual = img3;
			if(this.conta == 3)
				this.imagenActual = img4;
			if(this.conta == 4)
				this.imagenActual = img5;
			if(this.conta == 5)
				this.imagenActual = img6;
			if(this.conta == 6)
				this.imagenActual = img7;
			if(this.conta == 7)
				this.imagenActual = img8;
			if(this.conta == 8)
				this.imagenActual = img9;
			if(this.conta == 9)
				this.imagenActual = img10;
			if(this.conta == 10)
				this.imagenActual = img11;
			if(this.conta == 11)
				this.imagenActual = img12;

			this.conta++;
			
			if(this.conta > this.frames) this.conta = 0;
			break;
		case 13:
			if(this.conta == 0)
				this.imagenActual = img1;
			if(this.conta == 1)
				this.imagenActual = img2;
			if(this.conta == 2)
				this.imagenActual = img3;
			if(this.conta == 3)
				this.imagenActual = img4;
			if(this.conta == 4)
				this.imagenActual = img5;
			if(this.conta == 5)
				this.imagenActual = img6;
			if(this.conta == 6)
				this.imagenActual = img7;
			if(this.conta == 7)
				this.imagenActual = img8;
			if(this.conta == 8)
				this.imagenActual = img9;
			if(this.conta == 9)
				this.imagenActual = img10;
			if(this.conta == 10)
				this.imagenActual = img11;
			if(this.conta == 11)
				this.imagenActual = img12;
			if(this.conta == 12)
				this.imagenActual = img13;

			this.conta++;
			
			if(this.conta > this.frames) this.conta = 0;
			break;
		case 14:
			if(this.conta == 0)
				this.imagenActual = img1;
			if(this.conta == 1)
				this.imagenActual = img2;
			if(this.conta == 2)
				this.imagenActual = img3;
			if(this.conta == 3)
				this.imagenActual = img4;
			if(this.conta == 4)
				this.imagenActual = img5;
			if(this.conta == 5)
				this.imagenActual = img6;
			if(this.conta == 6)
				this.imagenActual = img7;
			if(this.conta == 7)
				this.imagenActual = img8;
			if(this.conta == 8)
				this.imagenActual = img9;
			if(this.conta == 9)
				this.imagenActual = img10;
			if(this.conta == 10)
				this.imagenActual = img11;
			if(this.conta == 11)
				this.imagenActual = img12;
			if(this.conta == 12)
				this.imagenActual = img13;
			if(this.conta == 13)
				this.imagenActual = img14;

			this.conta++;
			
			if(this.conta > this.frames) this.conta = 0;
			break;
		}
	}
	
	//offset no lo utilizamos, pero puede ser util: ligero movimiento horizontal
	public void drawAnimation(Graphics g, double x, double y, int offset){
		g.drawImage(this.imagenActual, (int)x - offset, (int)y, null);
	}


	public int getVelocidad() {
		return this.velocidad;
	}


	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}


	public int getConta() {
		return this.conta;
	}


	public void setConta(int conta) {
		this.conta = conta;
	}
	
	
}
