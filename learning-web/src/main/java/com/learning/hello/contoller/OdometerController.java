package com.learning.hello.contoller;

import com.learning.hello.contoller.exception.UnsupportedActionException;

import odometer.Odometer;

public class OdometerController {
  private Odometer odometer;
  private static OdometerController inst;
  
  private OdometerController() {
    
  }
  
  public static OdometerController get() {
    if (inst == null) {
      inst = new OdometerController();
    }
    return inst;
  }
  
  public void init(int size) {
    odometer = new Odometer(size);
  }
  
  public void reset() {
    odometer.reset();
  }
  
  public void increment() {
    odometer.increment();
  }
  
  public void decrement() {
    odometer.decrementReading();
  }
  
  public int getReading() {
    return odometer.getReading();
  }
  
  public void performAction(String action) throws UnsupportedActionException{
    switch(action) {
    case "prev":
      decrement();
      break;
    case "next":
      increment();
      break;
    case "reset":
      reset();
      break;
    default:
      throw new UnsupportedActionException("This action not supported");
    }
  }
  
}
