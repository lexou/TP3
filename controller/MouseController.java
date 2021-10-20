package controller;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import model.Circle;
import model.Point;

public class MouseController extends JPanel implements MouseMotionListener{
	
	private int mx;
	private int my;
	private String texte;
	JTextArea textArea;

	
	public MouseController() {
		addMouseMotionListener(this);
	}
	
	@Override
	public void paint(Graphics g) {
		
		super.paint(g);
		Point pt = new Point(mx, my);
		Circle c = new Circle(pt, 20);
		g.drawOval(c.getCenter().getX(), c.getCenter().getY(), c.getRadius(), c.getRadius()); 
		
	}
	
	/*
	void saySomething(String something, MouseEvent e) {
		textArea.append(something+ " ("+ e.getX()+","+e.getY()+") "+" detected on "+e.getComponent().getClass().getName());
	} */
	
	
	@Override
	public void mouseDragged(MouseEvent e) {
		//saySomething("Mouse Dragged", e);

	}
	
	/*
	public static int[] mouseCoord(MouseEvent e) {
		int[] tab = new int[2];
		tab[0] = (int)e.getPoint().getX();
		tab[1] = (int)e.getPoint().getY();
		return tab;
	}*/
	
	
	@Override
	public void mouseMoved(MouseEvent e) {
		//saySomething("Mouse Moved", e);
		
		
		mx = (int)e.getPoint().getX();
		my = (int)e.getPoint().getY();
		texte = "X = "+mx+"; Y = "+my;
		
		System.out.println(texte);
		repaint();  
		
	}
	
}
