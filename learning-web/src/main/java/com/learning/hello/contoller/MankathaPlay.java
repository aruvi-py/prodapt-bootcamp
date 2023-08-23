package com.learning.hello.contoller;

import java.io.IOException;
import java.util.Optional;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;

import com.learning.hello.contoller.exception.UnsupportedActionException;
import com.learning.hello.model.mankatha.Game;
import com.learning.hello.model.mankatha.Orientation;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;

public class MankathaPlay implements IController {

  @Override
  public void processGet(IWebExchange webExchange, TemplateEngine templateEngine, HttpServletResponse resp)
      throws UnsupportedActionException, IOException {
    WebContext ctx = new WebContext(webExchange);
    Game game = Game.getInstance();
    ctx.setVariable("game", game);
    if (game.winner().isPresent()) {
      ctx.setVariable("winner", game.winner().get().getCard());
      ctx.setVariable("hasWinner", true);
    }
    else {
      ctx.setVariable("hasWinner", false); 
    }
    templateEngine.process("mankatha/game", ctx, resp.getWriter());
  }

  @Override
  public void processPost(IWebExchange webExchange, TemplateEngine templateEngine, HttpServletResponse resp)
      throws UnsupportedActionException, IOException {
    Game game = Game.getInstance();
    var req = webExchange.getRequest();
    Optional<String> orientationCookieValue = Optional.ofNullable(req.getCookieValue("Current-Orientation"));
    if (orientationCookieValue.isEmpty())
      orientationCookieValue = Optional.of("in");
    Orientation current = Orientation.of(orientationCookieValue.get());
    game.deal(current);
    resp.addCookie(new Cookie("Current-Orientation", current.opposite().toString()));
    resp.sendRedirect(req.getRequestPath());
  }

}
