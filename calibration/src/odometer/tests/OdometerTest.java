package odometer.tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import odometer.Odometer;
import odometer.exceptions.ReadingException;

class OdometerTest {

	private Odometer o;
	
	@BeforeEach
	void setUp() {
		o = new Odometer(5);
		assertEquals(12345, o.getReading());
	}
	
	@Test
	void testIncrementNonRollOver() {
		o.incrementReading();
		assertEquals(12346, o.getReading());
	}
	
	@Test
	void testIncrementRollOver() throws ReadingException {
		o.setReading(56789);
		o.incrementReading();
		assertEquals(12345, o.getReading());
	}

}
