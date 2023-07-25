package odometer;

public class Odometer {
	
	private static final String DIGITS = "123456789";
	
	private int reading;
	
	private static int getMinReading(int size) {
		return Integer.valueOf(DIGITS.substring(0, size));
	}
	
	private static int getMaxReading(int size) {
		return Integer.valueOf(DIGITS.substring(size - 1, DIGITS.length()));
	}
	
	private static int getSize(int reading) {
		return String.valueOf(reading).length();
	}
	
	public Odometer(int size) {
		reading = getMinReading(size);
	}
	
	public Odometer(Odometer copy) {
		reading = copy.reading;
	}
	
	public int getReading() {
		return reading;
	}
	
	public void setReading(int reading) throws Exception{
		if (!isAscending(reading))
			throw new Exception("Reading has to have all its digits in strictly ascending order");
		else
			this.reading = reading;
	}
	
	@Override
	public String toString() {
		return "(" + reading + ")";
	}
	
	@Override
	public boolean equals(Object other) {
		if (!(other instanceof Odometer))
			return false;
		Odometer otherOdo = (Odometer) other;
		return otherOdo.reading == this.reading;
	}
	
	public static boolean isAscending(int reading) {
		if (reading < 10)
			return true;
		if(reading % 10 <= (reading / 10) % 10)
			return false;
		return isAscending(reading / 10);
	}
	
	
	public void incrementReading() {
		if (reading == getMaxReading(getSize(reading)))
			reading = getMinReading(getSize(reading));
		do {
			reading++;
		} while (!isAscending(reading));
	}
	
	public Odometer nextReading() {
		Odometer temp = new Odometer(this);
		temp.incrementReading();
		return temp;
	}

}
