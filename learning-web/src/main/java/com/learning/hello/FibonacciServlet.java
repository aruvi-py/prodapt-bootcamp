package com.learning.hello;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Servlet implementation class FibonacciServlet
 */
public class FibonacciServlet extends HttpServlet {
  private static final long serialVersionUID = 1L;
  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */

  private static int fibonacci(int n) {
    if (n == 0) {
      return 1;
    } else if (n == 1) {
      return 1;
    } else {
      return fibonacci(n-1) + fibonacci(n-2);
    }
  }

  private static List<Integer> fibonaccis(int n) {
    return IntStream.range(0, n + 1).mapToObj(x -> fibonacci(x)).collect(Collectors.toList());
  }

  @Override
  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    //Generate the fibonacci sequence up to n numbers where n is the value defined by the query parameter "n".
    //i.e. the request looks like localhost:8080/learning-web/fibonacci?n=10
    //the response should be HTML-formatted comma-separated fibonacci numbers.
//    PrintWriter out = response.getWriter();
//    if (request.getParameter("n") == null) {
//      out.println("This is not the way to access this resource. Please give a value for the parameter 'n' in your query ");
//      return;
//    } else {
//      int limit = Integer.valueOf(request.getParameter("n"));
//
//      out.println(String.format("<p>%s</p>", fibonaccis(limit)));
//    }
    request.getRequestDispatcher("/test.jsp").forward(request, response);
  }

  @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    PrintWriter out = response.getWriter();
    if (request.getParameter("n") == null) {
      out.println("This is not the way to access this resource. Please give a value for the parameter 'n' in your query ");
      return;
    } else {
      int limit = Integer.valueOf(request.getParameter("formLimit"));
      out.println(String.format("<p>%s</p>", fibonaccis(limit)));
    }
  }

}
