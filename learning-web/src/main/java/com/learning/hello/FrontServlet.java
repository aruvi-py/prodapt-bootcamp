package com.learning.hello;

import java.io.IOException;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import com.learning.hello.contoller.ControllerFactory;
import com.learning.hello.contoller.IController;
import com.learning.hello.contoller.exception.UnsupportedActionException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/service/*")
public class FrontServlet extends HttpServlet{

  private static final long serialVersionUID = 4769351924404472125L;
  private JakartaServletWebApplication application;
  private TemplateEngine templateEngine;
  
  @Override
  public void init() throws ServletException {
    application = JakartaServletWebApplication.buildApplication(getServletContext());
    application = JakartaServletWebApplication.buildApplication(getServletContext());
    final WebApplicationTemplateResolver templateResolver = 
        new WebApplicationTemplateResolver(application);
    templateResolver.setTemplateMode(TemplateMode.HTML);
    templateResolver.setPrefix("/WEB-INF/templates/");
    templateResolver.setSuffix(".html");
    templateEngine = new TemplateEngine();
    templateEngine.setTemplateResolver(templateResolver);
  }
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    // TODO Call the correct controller to deal with this.
    String path = req.getPathInfo();
    IController controller = ControllerFactory.get(path);
    final IWebExchange webExchange = 
        this.application.buildExchange(req, resp);
    try {
      controller.processGet(webExchange, templateEngine, resp);
    } catch (UnsupportedActionException e) {
      //if required ,do something with e.
      throw new ServletException(e);
    }
  }
  
  @Override
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    String action = req.getPathInfo();
    IController controller = ControllerFactory.get(action);
    final IWebExchange webExchange = 
        this.application.buildExchange(req, resp);
    try {
      controller.processPost(webExchange, templateEngine, resp);
    } catch (UnsupportedActionException e) {
      //if required ,do something with e.
      throw new ServletException(e);
    }
  }

}
