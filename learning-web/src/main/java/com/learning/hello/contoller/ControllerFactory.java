package com.learning.hello.contoller;

import java.util.HashMap;
import java.util.Map;

public class ControllerFactory {

  private static Map<String, IController> controllers;
  static {
    controllers = new HashMap<>();
    controllers.put("/odometer", new OdometerControllerNew());
  }
  
  public static IController get(String path) {
    return controllers.get(path);
  }
  
}
