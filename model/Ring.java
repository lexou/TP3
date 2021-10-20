package model;

public class Ring {
	private final Point centre;
	private final int rad_in;
	private final int rad_out;
	
	
	//Constructeur
	public Ring(Point pt, int in, int out) {
		this.centre = pt;
		this.rad_in = in;
		this.rad_out = out;
		if (this.rad_in>=this.rad_out) {
			throw new IllegalArgumentException("The inner radius should be smaller than the outer one");
		}	
	}
	
	//Accesseurs
	public Point getCentre() {
		return centre;
	}
	
	public int getRad_in() {
		return rad_in;
	}
	
	public int getRad_out() {
		return rad_out;
	}
	
	//Methodes
	
	@Override
	public boolean equals(Object obj) {
		if (this==obj) {
            return true;
        }
        if (!(obj instanceof Ring)) {
        	return false;
        }
        Ring other = (Ring) obj;
        return centre.equals(other.centre) && rad_in==other.rad_in && rad_out==other.rad_out;
		
	}
	
	public String toString() {
		Point centro = new Point(this.centre);
		Circle circulo = new Circle(centro,this.rad_in);
		return circulo.toString()+ " outer radius= "+this.rad_out;
	}
	
	public boolean contains(Point pt) {
		Circle c_out = new Circle(this.getCentre(), rad_out);
		Circle c_in = new Circle(this.getCentre(), rad_in);
		if (c_out.contains(pt) && !c_in.contains(pt)) {
			return true;
		}
		return false;
	}
	
	public boolean contains(Point pt, Ring[] rings) {
		for (Ring r : rings) {
			if (r.contains(pt)) {
				return true;
			}
		}
		return false;
	}
	
}
