public class Folding {

	public static void method1() {
		System.out.println("I'm in method 1");
		method2();
		return;
	}

	public static void method2() {
		try {
		method3();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		
	}

	public static void method3() {
		throw new Exception();
	}

	public static void main(String[] args) {
		int sum = 0;
		for (String argument : args) {
			sum += Integer.valueOf(argument);
		}
		System.out.println(sum);
		method1();
	}
}
