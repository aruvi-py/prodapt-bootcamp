package com.learning.hello;

import java.io.IOException;
import java.util.Random;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.templatemode.TemplateMode;
import org.thymeleaf.templateresolver.WebApplicationTemplateResolver;
import org.thymeleaf.web.IWebExchange;
import org.thymeleaf.web.servlet.JakartaServletWebApplication;

import com.learning.hello.contoller.HiLoController;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/hilo")
public class HiLoServlet extends HttpServlet{
  
  private HiLoController hlc;
  private JakartaServletWebApplication application;
  private TemplateEngine templateEngine;
  @Override
  public void init(ServletConfig config) throws ServletException {
    super.init(config);
    hlc = new HiLoController();
    hlc.reset();
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
  protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    hlc.setGuess(Integer.parseInt(req.getParameter("guess")));
    var out = resp.getWriter();
    final IWebExchange webExchange = 
        this.application.buildExchange(req, resp);
    final WebContext ctx = new WebContext(webExchange);
    ctx.setVariable("feedback", hlc.feedback());
    templateEngine.process("hilo", ctx, out);
    //out.print(String.format(getHtmlPage(), hlc.feedback()));
    if (hlc.judge() == 0)
      hlc.reset();
  }
  
  @Override
  protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    final IWebExchange webExchange = this.application.buildExchange(req, resp);
    final WebContext ctx = new WebContext(webExchange);
    templateEngine.process("hilo", ctx, resp.getWriter());
  }

}
