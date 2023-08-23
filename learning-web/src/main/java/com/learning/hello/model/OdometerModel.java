package com.learning.hello.model;

import com.learning.hello.contoller.exception.UnsupportedActionException;

import odometer.Odometer;

public class OdometerModel {
  private Odometer odometer;
  private static OdometerModel inst;
  
  private OdometerModel() {
    
  }
  
  public static OdometerModel get() {
    if (inst == null) {
      inst = new OdometerModel();
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
