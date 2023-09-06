package com.talentsprint.cycleshop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;

import com.talentsprint.cycleshop.service.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class BasicConfiguration {
    
    @Autowired
    private CustomUserDetailsService userDetailsService;
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{
        auth.userDetailsService(userDetailsService);
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
        http
            .authorizeHttpRequests((requests) -> requests
            .requestMatchers("/register").permitAll()
            .anyRequest().authenticated())
            .logout(withDefaults())
            .formLogin(withDefaults());
        
        return http.build();
    }

    // @Bean
    // PasswordEncoder passwordEncoder() {
    //     return new BCryptPasswordEncoder();
    // }
    
}
