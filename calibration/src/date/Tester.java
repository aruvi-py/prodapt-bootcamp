package date;

public class Tester {
	public static void main(String[] args) {
		Date d = new Date(1, 1, 2019);
		System.out.println(d);
		d.decrementBy(10);
		d.incrementBy(10);
		System.out.println(d.format("dd-mm-yyyy"));
	}
}
