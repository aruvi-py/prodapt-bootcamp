package com.learning.hello;

import java.io.IOException;

import jakarta.servlet.GenericServlet;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;

public class HeartbeatServlet extends GenericServlet{

  @Override
  public void init() {
    System.out.println("This line is printed when a servlet inits");
  }
  
  
  @Override
  public void service(ServletRequest arg0, ServletResponse arg1) throws ServletException, IOException {
    System.out.println("I am alive!");
    
    //if arg0.isHttpGet() return doGet(arg0, arg1);
  }
  
  @Override
  public void destroy() {
    System.out.println("This is called when the servlet is destroyed");
  }

}
