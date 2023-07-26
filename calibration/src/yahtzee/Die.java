package yahtzee;

import java.util.Random;

public class Die {
	
	private int sides;
	private int value;
	private Random rng;
	
	public Die() {
		this(6);
	}
	
	public Die(int sides) {
		this.sides = sides;
		this.value = 1;
		this.rng = new Random();
	}
	
	public int show() {
		return value;
	}
	
	public void roll() {
		value = rng.nextInt(1, sides+1);
	}
	
	public void set(int value) {
		this.value = value;
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Die))
			return false;
		Die otherDie = (Die) other;
		return otherDie.value == this.value;
	}

}
