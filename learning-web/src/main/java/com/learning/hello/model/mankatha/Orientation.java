package com.learning.hello.model.mankatha;

public enum Orientation {
  IN ("IN"),
  OUT ("OUT");
  
  private String value;
  
  private Orientation(String value) {
    this.value = value;
  }
  
  public static Orientation of(String val) {
    return val.equalsIgnoreCase("IN") ? IN : OUT;
  }
  
  @Override
  public String toString() {
    return value;
  }
  
  public Orientation opposite() {
    return this == IN ? OUT : IN;
  }
}
