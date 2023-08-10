package com.learning.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
  
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) {
    try {
      Map<String, String[]> parameterMap = req.getParameterMap();
      parameterMap.entrySet().stream().forEach(entry -> {
        System.out.print("key: " + entry.getKey());
        System.out.print(" values: " + Arrays.toString(entry.getValue()) + "\n");
      });
      PrintWriter out = resp.getWriter();
      String userName = parameterMap.get("name")[0];
      out.println(String.format("<h1>Hello, %s!</h1>", userName));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
