package com.talentsprint.cycleshop.business;

import org.springframework.stereotype.Component;

import com.talentsprint.cycleshop.entity.User;

import lombok.Data;

@Data
public class LoggedInUser {
    private User loggedInUser;
}
