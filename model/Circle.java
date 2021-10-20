package model;

public class Circle {
	private final Point center;
	private final int radius;
	
	//Constructeur
	public Circle(Point centre, int rayon) {
		//this.center = new Point(c.getX(),c.getY()); THIS is the right way to do it in order to respect the non mutability. It's called "copie defense"
		this.center = centre;
		this.radius = rayon;
	}
	
	
	//Accesseurs
	public Point getCenter() {
		return center;
	}
	
	public int getRadius() {
		return radius;
	}
	
	
	//Methodes
	
	public Circle translate(int dx, int dy) {
		return new Circle(center.translate(dx, dy),radius);
	}
	
	public double area() {
		return Math.pow(radius,2)*Math.PI;
	}
	
	@Override
	public String toString() {
		return ("( "+center.toString()+" ; r= "+radius+" ; aire= "+this.area()+ " )");
	}
	
	public boolean contains(Point p) {
		//(x - center_x)^2 + (y - center_y)^2 < radius^2
		boolean res = false;
		double pythagore = Math.pow( p.getX()-center.getX() , 2) + Math.pow( p.getY()-center.getY() , 2);
		if (pythagore <= Math.pow(radius, 2)) {
			res = true;
		}
		return res;
	}
	
	public boolean contains(Point p, Circle[] circles) {
		for (Circle elem : circles) {
			if (elem.contains(p)) {
				return true;
			}
		}
		return false;	
	}	
	
	//correction contains
	/* Les 3 points signifient qu'on peut mettre un nombre indefini de cercles sans avoir besoin de preciser une taille
	 * Elle est static parce que les parametres sont tous donnés et donc pas besoin de l'appliquer à un objet
	 * 
	 * public static boolean contains (Point p, Circle... circles){
	 * 	for (Circle c : circles){
	 * 		c.contains(p);
	 * 	}
	 * }
	 * 
	 * */
	 
	
}
