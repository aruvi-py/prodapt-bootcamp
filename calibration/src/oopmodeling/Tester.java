package oopmodeling;

import yahtzee.Die;
import yahtzee.LoadedDie;

public class Tester {
	public static void main(String[] args) {
		Point p = new Point(1, 2);
		Point o = new Point();
		System.out.println(p);
		System.out.println(o);
		System.out.println(p.distanceFrom(o));
		Point q = new Point(p);
		System.out.println(q);
		
		Die d = new Die();
		LoadedDie ld = new LoadedDie();
		d.roll();
		ld.roll();
		System.out.println(d.show());
		System.out.println(ld.show());
		System.out.println(ld);
	}
}
