public class Folding {

	public static void main(String[] args) {
		int sum = 0;
		for (String argument : args) {
			sum += Integer.valueOf(argument);
		}
		System.out.println(sum);
	}
}
