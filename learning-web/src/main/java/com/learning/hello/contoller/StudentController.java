package com.learning.hello.contoller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;

import com.learning.hello.contoller.exception.UnsupportedActionException;
import com.learning.hello.model.Student;

import jakarta.servlet.http.HttpServletResponse;

public class StudentController implements IController{
  
  private List<Student> students;
  
  @Override
  public void processGet(IWebExchange webExchange, TemplateEngine templateEngine, HttpServletResponse resp)
      throws UnsupportedActionException, IOException {
    var ctx = new WebContext(webExchange);
    ctx.setVariable("studentlist", students);
    templateEngine.process("Classroom", ctx, resp.getWriter());
  }

  @Override
  public void processPost(IWebExchange webExchange, TemplateEngine templateEngine, HttpServletResponse resp)
      throws UnsupportedActionException, IOException {
    Optional<String> name = Optional.ofNullable(webExchange.getRequest().getParameterValue("name"));
    if (name.isPresent()) {
      var newStudent = new Student(name.get());
      if (students == null) {
        students = new ArrayList<>();
      }
      students.add(newStudent);
    }
    resp.sendRedirect(webExchange.getRequest().getRequestPath());
  }

}
