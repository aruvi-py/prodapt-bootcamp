package calibration;

import java.util.function.Function;

public class Squarer implements Function<Integer, Integer>{
	@Override
	public Integer apply(Integer argument) {
		return argument * argument;
	}
}
