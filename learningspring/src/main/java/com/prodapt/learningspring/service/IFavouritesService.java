package com.prodapt.learningspring.service;

import java.util.List;

import com.prodapt.learningspring.entity.Post;
import com.prodapt.learningspring.entity.User;

public interface IFavouritesService {
    public List<Post> getFavouritePosts(User user);
}
