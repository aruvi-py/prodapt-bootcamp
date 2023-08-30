package com.prodapt.learningspring.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.Data;

@Embeddable
@Data
public class LikeId implements Serializable{

  private static final long serialVersionUID = 5469065220719817005L;
  
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "user_id", referencedColumnName = "id")
  private User user;
  
  @OneToOne(cascade = CascadeType.ALL)
  @JoinColumn(name = "post_id", referencedColumnName = "id")
  private Post post;

}
