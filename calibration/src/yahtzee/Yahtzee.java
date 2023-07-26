package yahtzee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Yahtzee {
	
	private List<YahtzeeDie> dice;
	private Map<Category, Integer> categoryScores;
	
	private void createDieAndAdd() {
		YahtzeeDie d = new YahtzeeDie();
		dice.add(d);
	}
	
	public Yahtzee() {
		dice = new ArrayList<YahtzeeDie>();
		for (int i = 0; i < 5; i++)
			createDieAndAdd();
		categoryScores = new HashMap<>();
		for (Category c : Category.values())
			categoryScores.put(c, 0);
	}
	
	public void roll() {
		for (YahtzeeDie d : dice)
			if (!d.isFrozen)
				d.roll();
	}
	
	public void freeze(int index) {
		dice.get(index).isFrozen = true;
	}
	
	public int score (Category category) {
		return category.getScorer().score(dice);
	}
	
	public String showScoreboard() {
		return categoryScores.entrySet()
				.stream()
				.map(entry -> entry.getKey().name() + ":" + entry.getValue() + "\n")
				.collect(Collectors.joining());
				
	}
	
	@Override
	public String toString() {
		return String.format("Scoreboard:\n %s\n Dice: %s", showScoreboard(), dice.toString());
	}
	
	public static void play() {
		Yahtzee player1 = new Yahtzee();
		Scanner sc = new Scanner(System.in);
		System.out.println("Welcome to Yahtzee");
		System.out.println(player1);
		while(true) {
			int rollsRemaining = 3;
			while(rollsRemaining > 0) {
				System.out.println("rolling");
				rollsRemaining--;
				player1.roll();
				System.out.println(player1);
				System.out.println("Enter a comma-separated sequence of dice to freeze, -1 to freeze none: ");
				String toFreeze = sc.nextLine();
				if (!toFreeze.equals("-1")) {
					String[] indices = toFreeze.split(",");
					for (String index : indices)
						player1.freeze(Integer.valueOf(index.replace(" ", "")));
				}
			}
			System.out.println("These are the scores your hand would get in various categories");
			for (Category c : Category.values())
				System.out.println(c.name() + ":" + player1.score(c));
		}
	}
	
	public static void main(String[] args) {
		Die d0 = new Die();
		Die d1 = new Die();
		Die d2 = new Die();
		Die d3 = new Die();
		Die d4 = new Die();
		Die[] diceArr = {d0, d1, d2, d3, d4};
		List<Die> dice = Arrays.asList(diceArr);
		d0.set(2);
		d1.set(1);
		d2.set(3);
		d3.set(4);
		d4.set(3);
		CategoryScorer ones = new UpperCategory(1);
		CategoryScorer smallStraight = new Straight(4);
		CategoryScorer largeStraight = new Straight(5);
		CategoryScorer yahtzee = new MultiplesOfAKind(5);
		System.out.println(ones.score(dice));
		System.out.println(smallStraight.score(dice));
		System.out.println(largeStraight.score(dice));
		System.out.println(yahtzee.score(dice));
		//play();
	}
}
