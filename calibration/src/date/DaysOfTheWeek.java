package date;
import java.util.Arrays;

public enum DaysOfTheWeek {
	SUNDAY(0, "Sunday"), MONDAY(1, "Monday"), 
	TUESDAY(2, "Tuesday"), WEDNESDAY(3, "Wednesday"),
	THURSDAY(4, "Thursday"), FRIDAY(5, "Friday"), SATURDAY(6, "Saturday");
	
	private int dayOfTheWeek;
	private String name;
	
	private DaysOfTheWeek(int dayOfTheWeek, String name) {
		this.dayOfTheWeek = dayOfTheWeek;
		this.name = name;
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public static DaysOfTheWeek fromInt(int dayOfTheWeek) {
		return Arrays.stream(values())
				.filter(x -> x.dayOfTheWeek == dayOfTheWeek)
				.findFirst()
				.get();
	}
	
	public static DaysOfTheWeek fromName(String name) {
		return Arrays.stream(values())
					.filter(x -> x.name == name)
					.findFirst()
					.get();
	}
}
