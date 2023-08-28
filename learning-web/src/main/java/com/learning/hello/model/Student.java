package com.learning.hello.model;

public class Student {
  private String name;
  public Student(String name) {
    this.name = name;
  }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  @Override
  public String toString() {
    return name;
  }

}
