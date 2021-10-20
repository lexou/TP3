package view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;

import controller.MouseController;
import model.Circle;
import model.Point;

public class MyDisplay extends JPanel {
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.RED);
		g.drawLine(0, 50, 500, 50 );
		g.setColor(Color.BLUE);
		Point pt = new Point(100, 100);
		Circle c = new Circle(pt, 200);
		g.drawOval(c.getCenter().getX(), c.getCenter().getY(), c.getRadius(), c.getRadius());
		
		
	}
	
	
	public static void main(String []args){
	
		JFrame frame = new JFrame("Java Avancé - Graphic Display");
		frame.setSize(new Dimension(500,500)); 
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		MyDisplay d = new MyDisplay(); 
		frame.add(d);		
		frame.setVisible(true);
		
		
		JFrame frame2 = new JFrame("Controleur");
		frame2.setSize(new Dimension(500, 500));
		frame2.setVisible(true);
		
		MouseController mouse = new MouseController();
		//frame2.setLocationRelativeTo(null);
		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame2.add(mouse);
		frame2.setVisible(true);

		

	}
	
}
