package com.ivyteew;

import java.awt.geom.*;
public class Colisiones {

	public static void colision() 
	
	{
	 int i = 0;
	 
	 while(i < Mundo.list_elipse.size()) {
	   if(Mundo.list_elipse.get(i).intersects(Mundo.rect1_perso)) {
		   Mundo.list_elipse.remove(i);
		   int cantidad_en_mochila = Principal.robot.get_cantidad_mochila() + 1;
		   Principal.robot.set_cantidad_mochila(cantidad_en_mochila);
	   }
	   
	   i++;
	 }  
	}

	
}
