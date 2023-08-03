package learning;

import odometer.Odometer;

public class OdometerController {
	
	private Odometer odometer;
	
	public OdometerController(Odometer odometer) {
		this.odometer = odometer;
		
	}
	
	public void increment() {
		odometer.increment();
	}
	
	public void decrement() {
		odometer.decrementReading();
	}
	
	public void reset() {
		odometer.reset();
	}
	
	public void resize(int newSize) {
		odometer = new Odometer(newSize);
	}
	
	
	
	
	
	
}
