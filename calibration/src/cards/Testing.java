package cards;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Testing {

	public static void main(String[] args) {
		Card c = new Card(1, 4);
		Card c2 = new Card(1, 3);
		Card c3 = new Card(1, 2);
		Card c4 = new Card(1, 1);
		Card c5 = new Card(2, 2);
		Hand h = new Hand();
		h.add(c);
		h.add(c2);
		h.add(c3);
		h.add(c4);
		h.add(c5);
		Hand h2 = h.sortedBySuitThenRank();
		System.out.println(h);
		System.out.println(h2);
	}
}
