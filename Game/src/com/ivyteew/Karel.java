package com.ivyteew;

public class Karel {

	private int orientacion;
	private int x;
	private int y;
	private int cantidad_en_mochila;
	 
	
	public Karel(int orientacion, int x, int y, int cantidad_en_mochila){
		this.orientacion = orientacion;
		this.x = x;
		this.y = y;
		this.cantidad_en_mochila = cantidad_en_mochila;
	    
	}
	
	public Karel(int orientacion) {
		this(orientacion,35,35,0);
		
	}
	
	public void mover() {
		if(orientacion == 0 && y > 35) {
			y-=5;
		}
		
		if(orientacion == 1 && y < 500) {
			y+=5;
		}
		
		if(orientacion == 2 && x < 540) {
			x+=5;
		}
		
		if(orientacion == 3 && x > 35 ) {
			x-=5;
		}
		
	}
	
	public void girarIzq() {
		if(orientacion == 0)
	      {   
	       orientacion = 3;
	        
	        //System.out.println("Estoy mirando al Oeste");
	       }else {
	      if(orientacion == 1)
	      {
	         orientacion = 2;  
	         
	         //System.out.println("Estoy mirando al Este");
	      } 
	      else{
	      if(orientacion == 2)
	      {
	         orientacion = 0;
	      } 
	      else{
	       if(orientacion == 3)
	       {
	           orientacion = 1;  
	        //System.out.println("Estoy mirando al Sur");
	       }
	      }
	    }
	  }
	}
	
	public void girarDer() {
	
	      if(orientacion == 0)
	      {   
	    	  orientacion = 2; 
	        
	        //System.out.println("Estoy mirando al Oeste");
	       }else 
	      {
	      if(orientacion == 1)
	      {
	    	  orientacion = 3; 
	         
	         //System.out.println("Estoy mirando al Este");
	      } 
	      else
	      {
	      if(orientacion == 2)
	      {
	    	  orientacion =1 ;
	      } 
	      else
	      {
	       if(orientacion == 3)
	       {
	    	   orientacion = 0; 
	        //System.out.println("Estoy mirando al Sur");
	       }
	      }    
	     }          
	    }        
	  
	      
	}
	
	
	public int get_x() {return x;}
	public int get_y() {return y;}
	
	public int get_orientacion() {
		return orientacion;
	}
	
	public String toString() 
	  {
	     String mensaje = "";  
	     
	     if(orientacion == 0)
	     {
	         mensaje = "mirando al norte";
	     }
	          
	     if(orientacion == 1)
	     {
	         mensaje = "mirando al sur";
	     }
	        
	     if(orientacion == 2)
	     {
	         mensaje = "mirando al este";
	     }
	         
	     if(orientacion == 3)
	     {
	         mensaje = "mirando al oeste";
	     }    
	     return "Robot en la calle "+ " " + x +","+ " " +"avenida "+ y +","
	             + " " + mensaje;
	  } 

	public void set_cantidad_mochila(int cantidad_en_mochila) {
		this.cantidad_en_mochila = cantidad_en_mochila;
	}
	
	public int get_cantidad_mochila() {
		return cantidad_en_mochila;
	}
}
