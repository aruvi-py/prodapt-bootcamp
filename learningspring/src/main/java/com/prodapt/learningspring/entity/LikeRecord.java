package com.prodapt.learningspring.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.Data;

@Entity
@Data
public class LikeRecord {
  
  
  @EmbeddedId
  private LikeId likeId;
  
}
