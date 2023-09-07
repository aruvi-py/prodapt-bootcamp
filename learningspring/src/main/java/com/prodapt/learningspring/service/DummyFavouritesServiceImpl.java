package com.prodapt.learningspring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prodapt.learningspring.entity.Post;
import com.prodapt.learningspring.entity.User;
import com.prodapt.learningspring.repository.PostRepository;

@Service
public class DummyFavouritesServiceImpl implements IFavouritesService{

    @Autowired
    private PostRepository postRepository;

    @Override
    public List<Post> getFavouritePosts(User user) {
        List<Post> obviouslyNotFavouritePosts = new ArrayList<>();
        postRepository.findAll().forEach(obviouslyNotFavouritePosts::add);
        return obviouslyNotFavouritePosts;
    }
    
}
