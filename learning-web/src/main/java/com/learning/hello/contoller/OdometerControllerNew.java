package com.learning.hello.contoller;

import java.io.IOException;
import java.io.Writer;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;

import com.learning.hello.contoller.exception.UnsupportedActionException;

import jakarta.servlet.http.HttpServletResponse;

public class OdometerControllerNew implements IController{
  
  private OdometerModel model;
  
  public OdometerControllerNew() {
    this.model = OdometerModel.get();
    model.init(5);
  }

  @Override
  public void processPost(IWebExchange webExchange, TemplateEngine templateEngine, HttpServletResponse resp) throws UnsupportedActionException, IOException {
    String action =  webExchange.getRequest().getParameterValue("action");
    model.performAction(action);
    //processGet(webExchange, templateEngine, resp);
    resp.sendRedirect(webExchange.getRequest().getRequestPath());
  }
  
  @Override
  public void processGet(IWebExchange webExchange, TemplateEngine templateEngine, HttpServletResponse resp) throws UnsupportedActionException, IOException {
    final WebContext ctx = new WebContext(webExchange);
    Writer out = resp.getWriter();
    ctx.setVariable("reading", model.getReading());
    templateEngine.process("odometer", ctx, out);
  }

}
