package oopmodeling;

public class Point {
	
	public final double x;
	public final double y;
	
	public Point(Point old) {
		this.x = old.x;
		this.y = old.y;
	}
	
	public Point(double x, double y) {
		this.x = x;
		this.y = y;
	}
	
	/*
	 * Initializes to the origin.
	 */
	public Point() {
		this.x = 0.0;
		this.y = 0.0;
	}
	
	public double distanceFrom(Point other) {
		return Math.sqrt(
				(this.x - other.x) * (this.x - other.x)
				+
				(this.y - other.y) * (this.y - other.y)
				);
	}
	
	public Point tranposeX(double units) {
		return new Point(this.x+units, this.y);
	}
	
	@Override
	public String toString() {
		return "(" + x + ", " + y + ")";
	}

}
