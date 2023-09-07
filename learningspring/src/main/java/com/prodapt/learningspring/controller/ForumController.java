package com.prodapt.learningspring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.prodapt.learningspring.controller.binding.AddPostForm;
import com.prodapt.learningspring.controller.exception.ResourceNotFoundException;
import com.prodapt.learningspring.entity.LikeRecord;
import com.prodapt.learningspring.entity.LikeId;
import com.prodapt.learningspring.entity.Post;
import com.prodapt.learningspring.entity.User;
import com.prodapt.learningspring.model.RegistrationForm;
import com.prodapt.learningspring.repository.LikeCRUDRepository;
import com.prodapt.learningspring.repository.LikeCountRepository;
import com.prodapt.learningspring.repository.PostRepository;
import com.prodapt.learningspring.repository.UserRepository;
import com.prodapt.learningspring.service.DomainUserService;
import com.prodapt.learningspring.service.IFavouritesService;

import jakarta.annotation.PostConstruct;
import jakarta.servlet.ServletException;

@Controller
@RequestMapping("/forum")
public class ForumController {
  
  @Autowired
  private UserRepository userRepository;
  
  @Autowired
  private PostRepository postRepository;
  
  @Autowired
  private DomainUserService domainUserService;
  
  @Autowired
  private LikeCRUDRepository likeCRUDRepository;

  @Autowired
  private IFavouritesService favouritesService;
  
  private List<User> userList;
  
  @PostConstruct
  public void init() {
    userList = new ArrayList<>();
  }

  @GetMapping("/favourites")
  public String getFavourites(Model model, @AuthenticationPrincipal UserDetails userDetails) {
    User loggedInUser = domainUserService.getByName(userDetails.getUsername()).get();
    List<Post> postsToDisplay = favouritesService.getFavouritePosts(loggedInUser);
    model.addAttribute("favourites", postsToDisplay);
    return "myViewName";
  }
  
  @GetMapping("/post/form")
  public String getPostForm(Model model, @AuthenticationPrincipal UserDetails userDetails) {
    AddPostForm postForm = new AddPostForm();
    User author = domainUserService.getByName(userDetails.getUsername()).get();
    postForm.setUserId(author.getId());
    model.addAttribute("postForm", postForm);
    return "forum/postForm";
  }
  
  @PostMapping("/post/add")
  public String addNewPost(@ModelAttribute("postForm") AddPostForm postForm, BindingResult bindingResult, RedirectAttributes attr) throws ServletException {
    if (bindingResult.hasErrors()) {
      System.out.println(bindingResult.getFieldErrors());
      attr.addFlashAttribute("org.springframework.validation.BindingResult.post", bindingResult);
      attr.addFlashAttribute("post", postForm);
      return "redirect:/forum/post/form";
    }
    Optional<User> user = userRepository.findById(postForm.getUserId());
    if (user.isEmpty()) {
      throw new ServletException("Something went seriously wrong and we couldn't find the user in the DB");
    }
    Post post = new Post();
    post.setAuthor(user.get());
    post.setContent(postForm.getContent());
    postRepository.save(post);
    
    return String.format("redirect:/forum/post/%d", post.getId());
  }
  
  @GetMapping("/post/{id}")
  public String postDetail(@PathVariable int id, Model model, @AuthenticationPrincipal UserDetails userDetails) throws ResourceNotFoundException {
    Optional<Post> post = postRepository.findById(id);
    if (post.isEmpty()) {
      throw new ResourceNotFoundException("No post with the requested ID");
    }
    model.addAttribute("post", post.get());
    //model.addAttribute("userList", userList);
    //int numLikes = likeCountRepository.countByPostId(id);
    model.addAttribute("likerName", userDetails.getUsername());
    int numLikes = likeCRUDRepository.countByLikeIdPost(post.get());
    model.addAttribute("likeCount", numLikes);
    return "forum/postDetail";
  }
  
  @PostMapping("/post/{id}/like")
  public String postLike(@PathVariable int id, String likerName, RedirectAttributes attr) {
    LikeId likeId = new LikeId();
    likeId.setUser(userRepository.findByName(likerName).get());
    likeId.setPost(postRepository.findById(id).get());
    LikeRecord like = new LikeRecord();
    like.setLikeId(likeId);
    likeCRUDRepository.save(like);
    return String.format("redirect:/forum/post/%d", id);
  }

  @GetMapping("/register")
  public String getRegistrationForm(Model model) {
    if (!model.containsAttribute("registrationForm")) {
      model.addAttribute("registrationForm", new RegistrationForm());
    }
    return "forum/register";
  }

  @PostMapping("/register")
  public String register(@ModelAttribute("registrationForm") RegistrationForm registrationForm, 
  BindingResult bindingResult, 
  RedirectAttributes attr) {
    if (bindingResult.hasErrors()) {
      attr.addFlashAttribute("org.springframework.validation.BindingResult.registrationForm", bindingResult);
      attr.addFlashAttribute("registrationForm", registrationForm);
      return "redirect:/register";
    }
    if (!registrationForm.isValid()) {
      attr.addFlashAttribute("message", "Passwords must match");
      attr.addFlashAttribute("registrationForm", registrationForm);
      return "redirect:/register";
    }
    System.out.println(domainUserService.save(registrationForm.getUsername(), registrationForm.getPassword()));
    attr.addFlashAttribute("result", "Registration success!");
    return "redirect:/login";
  }

  
}
