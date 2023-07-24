package cards;

public class Testing {

	public static void main(String[] args) {
		Card c = new Card(1, 4);
		Card c2 = new Card(12, c.getSuit());
		System.out.println(c2);
	}
}
