package com.learning.hello.contoller;

import java.io.IOException;
import java.io.Writer;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.web.IWebExchange;

import com.learning.hello.contoller.exception.UnsupportedActionException;

import jakarta.servlet.http.HttpServletResponse;

public interface IController {
  public void processGet(IWebExchange webExchange, TemplateEngine templateEngine, HttpServletResponse resp) throws UnsupportedActionException, IOException;
  public void processPost(IWebExchange webExchange, TemplateEngine templateEngine, HttpServletResponse resp) throws UnsupportedActionException, IOException;

}
