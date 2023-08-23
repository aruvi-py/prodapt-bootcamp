package com.learning.hello.contoller;

import java.io.IOException;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.web.IWebExchange;

import com.learning.hello.contoller.exception.UnsupportedActionException;
import com.learning.hello.model.mankatha.Game;

import jakarta.servlet.http.HttpServletResponse;

public class MankathaReset implements IController{

  @Override
  public void processGet(IWebExchange webExchange, TemplateEngine templateEngine, HttpServletResponse resp)
      throws UnsupportedActionException, IOException {
    throw new UnsupportedActionException("Access this endpoint only using POST!");
  }

  @Override
  public void processPost(IWebExchange webExchange, TemplateEngine templateEngine, HttpServletResponse resp)
      throws UnsupportedActionException, IOException {
    Game game = Game.getInstance();
    game.reset();
    String prefix = webExchange.getRequest().getApplicationPath();
    resp.sendRedirect(prefix + "/service/mankatha/register");
  }

}
