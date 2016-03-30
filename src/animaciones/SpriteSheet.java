package animaciones;

import java.awt.image.BufferedImage;

public class SpriteSheet {
	private BufferedImage image;
	public SpriteSheet(BufferedImage image){
		this.image = image;
	}
	
	public BufferedImage grabImage(int col, int fil, int ancho, int alto){
		BufferedImage img = image.getSubimage((col*32)-32,(fil*32)-32,ancho,alto);
		return img;
	}
}
