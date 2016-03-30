package main.entidades;

import java.util.LinkedList;
import main.GameObjeto;

public class Colisiones {

	public static boolean Colision(EntidadAmiga enta, EntidadEnemiga ente){
		
			if(enta.getBounds().intersects(ente.getBounds())){
				return true;
			}
		return false;
	}
	
	public static boolean Colision (EntidadEnemiga ente, EntidadAmiga enta){
		
			if(ente.getBounds().intersects(enta.getBounds())){
				return true;
			}
		return false;
	}
}
