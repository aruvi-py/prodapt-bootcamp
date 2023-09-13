package com.talentsprint.cycleshop.controller;

import java.security.Principal;
import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.talentsprint.cycleshop.entity.Cycle;
import com.talentsprint.cycleshop.service.CycleService;

@RestController
@RequestMapping("/api")
public class CycleRestController {
    
    @Autowired
    private CycleService cycleService;

    @GetMapping("/health")
    public String checkhealth() {
        return "healthy";
    }

    @GetMapping("/cycle/list")
    public List<Cycle> all(Authentication authentication) {
        Jwt jwt = (Jwt) authentication.getPrincipal();
        System.out.println(jwt.getClaimAsString("scope"));
        return cycleService.listAvailableCycles();
    }
}
