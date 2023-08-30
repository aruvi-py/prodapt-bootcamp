package com.prodapt.learningspring.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.prodapt.learningspring.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Integer>{
  
}
