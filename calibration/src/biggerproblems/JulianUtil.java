package biggerproblems;

import java.util.Arrays;

public class JulianUtil {
	private static final int[] CUMULATIVE_NON_LEAP = {0, 0, 31, 59, 90, 120, 151, 181, 212, 243, 273, 304, 334, 365};
	private static final int[] CUMULATIVE_LEAP = {0, 0, 31, 60, 91, 121, 152, 182, 213, 244, 274, 305, 335, 366};
	private static final String SLASH = "/";
	private static final String COMMA = ",";
	private static final String SPACE = " ";
	private static final String MONTHS = "   janfebmaraprmayjunjulaugsepoctnovdec";	
	public static boolean isLeap(int year) {
		return (year % 100 != 0 && year % 4 == 0) || (year % 400 == 0);
	}
	
	public static int[] getCumulativeCalendar(int year) {
		return isLeap(year) ? CUMULATIVE_LEAP : CUMULATIVE_NON_LEAP;
	}
	
	public static String toMm(String month) {
		if (month.length() == 2)
			return month;
		else {
			month = month.toLowerCase();
			int index = MONTHS.indexOf(month);
			return String.valueOf(index / 3);
		}		
	}
	
	public static String formatAsDdMmYyyy(String date) {
		String modifiedDate = date.replace(SLASH, SPACE).replace(COMMA, SPACE);
		String[] components = modifiedDate.split(SPACE + "+");
		components[1] = toMm(components[1]);
		String ddMmYyyy = "";
		for (String component : components) {
			ddMmYyyy += component + SLASH;
		}
		return ddMmYyyy;
	}
	
	public static String toJulian(String ddmmyyyy) {
		String[] components = ddmmyyyy.split(SLASH);
		int day = Integer.valueOf(components[0]);
		int month = Integer.valueOf(components[1]);
		int year = Integer.valueOf(components[2]);
		int[] cumulativeCalendar = getCumulativeCalendar(year);
		return String.valueOf(year * 1000 + cumulativeCalendar[month] + day);
	}
	
	public static void main(String[] args) {
		System.out.println(toJulian(formatAsDdMmYyyy("01, Jan 2023")));

		System.out.println(toJulian(formatAsDdMmYyyy("25/jul/2017")));

		System.out.println(toJulian(formatAsDdMmYyyy("01,Feb     ,2013")));

		System.out.println(toJulian(formatAsDdMmYyyy("3/11/    2000")));
		
		System.out.println(Arrays.toString("heeeelper".split("e")));

		System.out.println(Arrays.toString("heeeelper".split("e+")));

		System.out.println(Arrays.toString("heeeelper".split("a*")));
	}

}
