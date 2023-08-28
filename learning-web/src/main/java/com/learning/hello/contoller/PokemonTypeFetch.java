package com.learning.hello.contoller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.net.ssl.HttpsURLConnection;

import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.WebContext;
import org.thymeleaf.web.IWebExchange;

import com.learning.hello.contoller.exception.UnsupportedActionException;

import jakarta.servlet.http.HttpServletResponse;

public class PokemonTypeFetch implements IController {
  
  private String fetchedResponse = "";

  @Override
  public void processGet(IWebExchange webExchange, TemplateEngine templateEngine, HttpServletResponse resp)
      throws UnsupportedActionException, IOException {
    WebContext ctx = new WebContext(webExchange);
    ctx.setVariable("response", fetchedResponse);
    templateEngine.process("TypeFetcher", ctx, resp.getWriter());
  }

  @Override
  public void processPost(IWebExchange webExchange, TemplateEngine templateEngine, HttpServletResponse resp)
      throws UnsupportedActionException, IOException {
    
    var request = webExchange.getRequest();
    Optional<String> name = Optional.ofNullable(request.getParameterValue("name"));
    String apiUrl = String.format("https://pokeapi.co/api/v2/pokemon/%s", name.isEmpty() ? "pikachu" : name.get());
    try {
      URI uri = new URI(apiUrl);
      var conn = (HttpsURLConnection) uri.toURL().openConnection();
      conn.setRequestMethod("GET");
      BufferedReader in = new BufferedReader(
          new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();
        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }
        in.close();
        fetchedResponse = content.toString();
     
    } catch (URISyntaxException e) {
      throw new IOException(e);
    }
    resp.sendRedirect(request.getRequestPath());
  }

}
