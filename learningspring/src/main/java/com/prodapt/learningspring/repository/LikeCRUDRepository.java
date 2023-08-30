package com.prodapt.learningspring.repository;

import org.springframework.data.repository.CrudRepository;

import com.prodapt.learningspring.entity.LikeRecord;

public interface LikeCRUDRepository extends CrudRepository<LikeRecord, Integer>{

}
