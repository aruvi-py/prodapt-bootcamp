package oopmodeling;

public class Tester {
	public static void main(String[] args) {
		Point p = new Point(1, 2);
		Point o = new Point();
		System.out.println(p);
		System.out.println(o);
		System.out.println(p.distanceFrom(o));
		Point q = new Point(p);
		System.out.println(q);
		
	}
}
