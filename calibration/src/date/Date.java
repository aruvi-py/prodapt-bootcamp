package date;

public class Date {
	
	private int day;
	private int month;
	private int year;
	
	public static final int[] DAYS_MONTH_NONLEAP = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static final int[] DAYS_MONTH_LEAP = {0, 31, 29, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
	public static final int MONTHS_IN_YEAR = 12;
	
	public static final String DD_MM_YYYY_SLASHES = "dd/mm/yyyy";
	public static final String DD_MM_YYYY_HYPHENS = "dd-mm-yyyy";
	
	
	private static int[] getCalendar(boolean isLeap) {
		return isLeap ? DAYS_MONTH_LEAP : DAYS_MONTH_NONLEAP;
	}
	
	public Date(int day, int month, int year) {
		this.day = day;
		this.month = month;
		this.year = year;
	}
	
	public Date(Date copy) {
		this.day = copy.day;
		this.month = copy.month;
		this.year = copy.year;
	}
	
	public boolean isLeap() {
		return (year % 100 != 0 && year % 400 == 0) || (year % 4 == 0);
	}
	
	public void increment() {
		this.day++;
		if (this.day > getCalendar(isLeap())[this.month]) {
			this.day = 1;
			this.month++;
		}
		if (this.month > MONTHS_IN_YEAR) {
			this.month = 1;
			this.year++;
		}
	}
	
	public Date nextDate() {
		Date temp = new Date(this);
		temp.increment();
		return temp;
	}
	
	public void incrementBy(int step) {
		for (int i = 0; i < step; i++)
			increment();
	}
	
	public Date nextDateAfter(int step) {
		Date temp = new Date(this);
		temp.incrementBy(step);
		return temp;
	}
	
	public void decrement() {
		this.day--;
		if (this.day == 0) {
			this.month--;
			if (this.month == 0) {
				this.year--;
				this.month = MONTHS_IN_YEAR;
			}
			this.day = getCalendar(isLeap())[this.month];
		}
	}
	
	public Date prevDay() {
		Date temp = new Date(this);
		temp.decrement();
		return temp;
	}
	
	public void decrementBy (int step) {
		for (int i = 0; i < step; i++)
			decrement();
	}
	
	public Date prevDayBefore(int step) {
		Date temp = new Date(this);
		temp.decrementBy(step);
		return temp;
	}
	
	public String format(String formatSpecifier) {
		switch(formatSpecifier) {
		case DD_MM_YYYY_SLASHES:
			return String.format("%02d/%02d/%04d", day, month, year);
		
		case DD_MM_YYYY_HYPHENS:
			return String.format("%02d-%02d-%02d", day, month, year);
		default:
			return toString();
		}
	}
	
	@Override
	public String toString() {
		return format(DD_MM_YYYY_SLASHES);
	}

}
