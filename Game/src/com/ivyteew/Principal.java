package com.ivyteew;

import javax.swing.JFrame;
public class Principal {

	public static Karel robot;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        int orientacion = 0;
        
        robot = new Karel(orientacion);
        System.out.println(robot.toString());
        
        Mundo mundo = new Mundo();
        mundo.setVisible(true);
		mundo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
	}

}
