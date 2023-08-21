package com.learning.hello;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Map;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.thymeleaf.context.IWebContext;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebApplication;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class HelloServlet extends HttpServlet{
  
  private JakartaServletWebApplication application;
  private TemplateEngine templateEngine;
  
  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    this.application = JakartaServletWebApplication.buildApplication(getServletContext());
    WebApplicationTemplateResolver wats = new WebApplicationTemplateResolver(application);
    wats.setTemplateMode(TemplateMode.HTML);
    wats.setPrefix("/WEB-INF/templates/");
    wats.setSuffix(".html");
    templateEngine = new TemplateEngine();
    templateEngine.setTemplateResolver(wats);
  }
  
  @Override
  public void doGet(HttpServletRequest req, HttpServletResponse resp) {
    try {
      Map<String, String[]> parameterMap = req.getParameterMap();
      parameterMap.entrySet().stream().forEach(entry -> {
        System.out.print("key: " + entry.getKey());
        System.out.print(" values: " + Arrays.toString(entry.getValue()) + "\n");
      });
      PrintWriter out = resp.getWriter();
      String userName = req.getParameter("name");
      final var webExchange = this.application.buildExchange(req, resp);
      WebContext ctx = new WebContext(webExchange);
      if (userName != null)
        ctx.setVariable("name", userName);
      templateEngine.process("hello", ctx, out);
      //out.println(String.format("<h1>Hello, %s!</h1>", userName));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }

}
