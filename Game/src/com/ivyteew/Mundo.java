package com.ivyteew;

import javax.swing.JFrame;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class Mundo extends JFrame{

	private Image personaje;
	private static Image money;
    private boolean activo = false;
    public static ArrayList<Ellipse2D> list_elipse;
   
    public static Rectangle2D  rect1_perso;
    
	public Mundo() {
		setBounds(300,80,600,630);
		setTitle("GAME KAREL");
		setResizable(false);
		list_elipse = new ArrayList<>();
		
		DibujarMundo lamina = new DibujarMundo();
		Teclado tecla = new Teclado();
		addKeyListener(tecla);	
		add(lamina);
		
		
	
	}
	private class DibujarMundo extends JPanel{
		public void paintComponent(Graphics g) 
		
		{
			super.paintComponent(g);
			Graphics2D g2 = (Graphics2D)g;
			
	        //muros del perimetro
			Rectangle2D rect1 = new Rectangle2D.Double(0,0,10,560);
			g2.setPaint(Color.BLACK);
			g2.fill(rect1);
			g2.draw(rect1);
			
			Rectangle2D rect2 = new Rectangle2D.Double(0,0,583,10);
			g2.setPaint(Color.BLACK);
			g2.fill(rect2);
			g2.draw(rect2);
			
			Rectangle2D rect3 = new Rectangle2D.Double(584,0,10,560);
			g2.setPaint(Color.BLACK);
			g2.fill(rect3);
			g2.draw(rect3);
			
			Rectangle2D rect4 = new Rectangle2D.Double(0,550,583,10);
			g2.setPaint(Color.BLACK);
			g2.fill(rect4);
			g2.draw(rect4);
			
				
            Font fuente = new Font("Arial", Font.BOLD,16);
	        g2.setFont(fuente);
		    g.drawString("Monedas: " + Principal.robot.get_cantidad_mochila(), 100, 580);
		    
		    File img_pers = null;
		    
		    if(Principal.robot.get_orientacion() == 0) {
				img_pers = new File("src/sprites/norte.png");
		        
			
			}else if(Principal.robot.get_orientacion() == 1) {
				img_pers = new File("src/sprites/sur.png");
				
			}else if(Principal.robot.get_orientacion() == 2) {
				img_pers = new File("src/sprites/este.png");
				
			}else if(Principal.robot.get_orientacion() == 3) {
				img_pers = new File("src/sprites/oeste.png");
				
			}
		  
		    try {
				personaje = ImageIO.read(img_pers);
				
			    rect1_perso = new Rectangle2D.Double(Principal.robot.get_x(),Principal.robot.get_y(),28,28);
				Color color = new Color(0f,0f,0f,0f);
				g2.setPaint(color); 
			    g2.fill(rect1_perso);
				
				//es un método de Graphics2D
				g2.draw(rect1_perso);
				
				g.drawImage(personaje,Principal.robot.get_x(),Principal.robot.get_y(),28,28,null,null);
				

				
				
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		    
		    if(!activo) {
		    	dibujar_elem_estaticos(g);
		    	
		    	activo = true;
		    }else {
		    	for(Ellipse2D el: list_elipse) {
		    		
		    		Rectangle2D rect = new Rectangle2D.Double(el.getX(),el.getY(),12,12);
					Color color = new Color(0f,0f,0f,0f);
					g2.setPaint(color); 
				    g2.fill(rect);
				   
		    		Ellipse2D elipse = el;
					g2.setPaint(Color.YELLOW);
					g2.fill(elipse);
					g2.draw(elipse);
					
					elipse.setFrame(rect);
		    	}
		    }
		    
		    
		    
		    
	}
		
		
		
		public void dibujar_elem_estaticos(Graphics g) {
			
			Graphics2D g2 = (Graphics2D)g;
			int cantidad_money = (int) (Math.random()* 7) + 1;
			
		    double tempx = 0;
		    double tempy = 0;
			for(int j = 0; j < cantidad_money; j++) {
				double x2 = (double) (Math.random()* 500) + 20;
				double y2 = (double) (Math.random()* 500) + 20;
				
				if((x2 == Principal.robot.get_x()) || (x2 == (Principal.robot.get_x()- 50)) || 
						(x2 == (Principal.robot.get_x() + 50)) || (tempx == x2) || (x2 == tempx + 50) ||
						x2 == tempx - 50) {
				  x2 = (double) (Math.random()* 500) + 20;
				}
				
				if((y2 == Principal.robot.get_x()) || (y2 == (Principal.robot.get_x()- 50)) || 
						(y2 == (Principal.robot.get_x() + 50)) || (tempx == y2) || (y2 == tempx + 50) ||
						y2 == tempx - 50) {
				    y2 = (double) (Math.random()* 500) + 20;
				}
				
				tempx = x2;
				tempy = y2;
				
				Ellipse2D elipse = new Ellipse2D.Double(x2,y2,12,12);
				list_elipse.add(elipse);
				g2.setPaint(Color.YELLOW);
				g2.fill(elipse);
				g2.draw(elipse);
				
				
				
			}
		
			/*int x_rect_int = (int) (Math.random()* 500) + 35;
			int y_rect_int = (int) (Math.random()* 560) + 35;
			
			int x2_rect_int = (int) (Math.random()* 500) + 35;
			int y2_rect_int = (int) (Math.random()* 560) + 35;
			
			
		    if((x_rect_int == x2_rect_int) || (x_rect_int == x2_rect_int + 200) || (x_rect_int == x2_rect_int - 200) ) {
		    	 x_rect_int = (int) (Math.random()* 500) + 35;
		    }
		    
		    if(y_rect_int == y2_rect_int || (y_rect_int == y2_rect_int + 200) || (y_rect_int == y2_rect_int - 200)){
		    	 y_rect_int = (int) (Math.random()* 560) + 35;
		    }
			Rectangle2D rect5 = new Rectangle2D.Double(x_rect_int, y_rect_int + 35,10,100);
			g2.setPaint(Color.BLACK);
			g2.fill(rect5);
			g2.draw(rect5);
			
			Rectangle2D rect6 = new Rectangle2D.Double(x2_rect_int, y2_rect_int  + 35,10,100);
			g2.setPaint(Color.BLACK);
			g2.fill(rect6);
			g2.draw(rect6);*/
			
		}
		
		
		
 }
	
	
	private class Teclado implements KeyListener{

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			if((e.getKeyCode() == KeyEvent.VK_DOWN) || (e.getKeyCode() == KeyEvent.VK_S)) {
				if(Principal.robot.get_orientacion() == 0) {
					
					Principal.robot.girarIzq();
					Principal.robot.girarIzq();
					Colisiones.colision();
					Principal.robot.mover();
					Colisiones.colision();
					System.out.println(Principal.robot.toString());
					repaint();
				}
				
             if(Principal.robot.get_orientacion() == 1) {
            	 
            	 Principal.robot.mover();
            	 Colisiones.colision();
            	 System.out.println(Principal.robot.toString());
            	 repaint();
				}
             if(Principal.robot.get_orientacion() == 2) {
            	 Principal.robot.girarDer();
            	 Colisiones.colision();
				 Principal.robot.mover();
				 Colisiones.colision();
				 System.out.println(Principal.robot.toString());
				 repaint();
            	
			}
             if(Principal.robot.get_orientacion() == 3) {
            	 Principal.robot.girarIzq();
            	 Colisiones.colision();
            	 Principal.robot.mover();
            	 Colisiones.colision();
            	 System.out.println(Principal.robot.toString());
            	 repaint();
				}
			}
	        
	        if((e.getKeyCode() == KeyEvent.VK_LEFT) || (e.getKeyCode() == KeyEvent.VK_A)) {
	        	if(Principal.robot.get_orientacion() == 0) {
	        		 Principal.robot.girarIzq();
	        		 Colisiones.colision();
	            	 Principal.robot.mover();
	            	 Colisiones.colision();
	            	 System.out.println(Principal.robot.toString());
	            	 repaint();
				}
				
             if(Principal.robot.get_orientacion() == 1) {
            	 Principal.robot.girarDer();
            	 Colisiones.colision();
				 Principal.robot.mover();
				 Colisiones.colision();
				 System.out.println(Principal.robot.toString());
				 repaint();
				}
             if(Principal.robot.get_orientacion() == 2) {
            	 Principal.robot.girarDer();
            	 Principal.robot.girarDer();
            	 Colisiones.colision();
				 Principal.robot.mover();
				 Colisiones.colision();
				 System.out.println(Principal.robot.toString());
				 repaint();
            	
			}
             if(Principal.robot.get_orientacion() == 3) {
            	
            	 Principal.robot.mover();
            	 Colisiones.colision();
            	 System.out.println(Principal.robot.toString());
            	 repaint();
				}
			}
			
			if((e.getKeyCode() == KeyEvent.VK_RIGHT) || (e.getKeyCode() == KeyEvent.VK_D)) {
				if(Principal.robot.get_orientacion() == 0) {
					 Principal.robot.girarDer();
					 Colisiones.colision();
					 Principal.robot.mover();
					 Colisiones.colision();
					 System.out.println(Principal.robot.toString());
					 repaint();
				}
				
            if(Principal.robot.get_orientacion() == 1) {
            	Principal.robot.girarIzq();
            	Colisiones.colision();
           	    Principal.robot.mover();
           	    Colisiones.colision();
           	    System.out.println(Principal.robot.toString());
           	repaint();
			   
				}
            if(Principal.robot.get_orientacion() == 2) {
           	
            	Principal.robot.mover();
            	Colisiones.colision();
            	repaint();
			}
            if(Principal.robot.get_orientacion() == 3) {
            	 Principal.robot.girarDer();
            	 Principal.robot.girarDer();
            	 Colisiones.colision();
				 Principal.robot.mover();
				 Colisiones.colision();
				 System.out.println(Principal.robot.toString());
				 repaint();
           	    
				}
			}
			
			if((e.getKeyCode() == KeyEvent.VK_UP) || (e.getKeyCode() == KeyEvent.VK_W)) {
				if(Principal.robot.get_orientacion() == 0) {
					Principal.robot.mover();
					Colisiones.colision();
			
					System.out.println(Principal.robot.toString());
					repaint();
				}
				
            if(Principal.robot.get_orientacion() == 1) {
            	Principal.robot.girarDer();
            	Principal.robot.girarDer();
            	Colisiones.colision();
				 Principal.robot.mover();
				 Colisiones.colision();
				 System.out.println(Principal.robot.toString());
				 repaint();
				}
            if(Principal.robot.get_orientacion() == 2) {
            	Principal.robot.girarIzq();
            	Colisiones.colision();
           	    Principal.robot.mover();
           	 Colisiones.colision();
           	 System.out.println(Principal.robot.toString());
           	repaint();
			}
            if(Principal.robot.get_orientacion() == 3) {
            	Principal.robot.girarDer();
            	Colisiones.colision();
				 Principal.robot.mover();
				 Colisiones.colision();
				 System.out.println(Principal.robot.toString());
				 repaint();
				}
			}
			
		}

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
