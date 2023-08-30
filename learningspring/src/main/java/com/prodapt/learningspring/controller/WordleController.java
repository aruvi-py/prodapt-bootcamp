package com.prodapt.learningspring.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.prodapt.learningspring.model.Wordle;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import wordle.Word;

@Controller
@RequestMapping("/wordle")
public class WordleController {
  
  @Autowired
  private Wordle wordle;
  
  @GetMapping
  public String guessAndShow(Model model) {
    Word latestGuess = wordle.getLatestGuess();
    model.addAttribute("guess", latestGuess);
    return "wordle";
  }
  
  @PostMapping
  public void processFeedback(String feed1, String feed2, String feed3, String feed4, String feed5, HttpServletResponse resp) throws IOException {
    List<String> feedbacks = Arrays.asList(feed1, feed2, feed3, feed4, feed5);
    var validFeedbacks = Arrays.asList("red", "yellow", "green");
    for (var feedback: feedbacks) {
      if (!(validFeedbacks.contains(feedback)))
        throw new IOException("Bad input");
    }
    wordle.setLatestFeedback(feedbacks);
    wordle.addGuess();
    resp.sendRedirect("/wordle");
  }
  
//  @PostMapping
//  public void processFeedback(HttpServletRequest req, HttpServletResponse resp) throws IOException {
//    String feed1 = req.getParameter("feed1");
//    String feed2 = req.getParameter("feed2");
//    String feed3 = req.getParameter("feed3");
//    String feed4 = req.getParameter("feed4");
//    String feed5 = req.getParameter("feed5");
//  List<String> feedbacks = Arrays.asList(feed1, feed2, feed3, feed4, feed5);
//  wordle.setLatestFeedback(feedbacks);
//  wordle.addGuess();
//  resp.sendRedirect("/wordle");
//  }
  
}
