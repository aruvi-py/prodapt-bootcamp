package com.learning.hello;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name="pwdValServlet", urlPatterns="/validate")
public class PasswordValidationServlet extends HttpServlet{

  private static final long serialVersionUID = 6268770286168551818L;

  @Override
  public void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException {
    String pwd = req.getParameter("password");
    Path p = Paths.get("/home/aruvi/prodapt/banned-passwords.txt");
    boolean banned = false;
    try {
      List<String> lines = Files.readAllLines(p);
      for (String line : lines) {
        if (pwd.equalsIgnoreCase(line)) {
          banned = true;
        }
      }
      if (banned) {
        resp.getWriter().append("Banned password, try again!");
      }
      else {
        resp.getWriter().append("Password valid!");
      }
      resp.getWriter().close();
    } catch (IOException e) {
      e.printStackTrace();
      resp.sendError(HttpServletResponse.SC_BAD_REQUEST, "File reading error in server, try again later");
    }
  }

}
