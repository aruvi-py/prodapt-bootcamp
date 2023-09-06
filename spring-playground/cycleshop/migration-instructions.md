What is the User object spring security works with?

`org.springframework.security.core.userdetails.User`

How does spring security get the saved User object to compare with?

It needs you to provide a custom implementation for the interface `org.springframework.security.core.userdetails.UserDetailsService`

What is needed to implement the UserDetailsService interface?
You need to provide an implementation for the method with the signature
```
@Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
```

How do you tell spring to use your interface instead of whatever it has?

Write a configuration class with the 
```
@Configuration
@EnableWebSecurity
```
annotations.

What do spring need us to configure in the configuration class?
1. Which endpoints do we need to authenticate? Which endpoints do we let free? Which endpoints correspond to the login screen that we need to redirect to?
1. Which custom user details service implementation should spring use?
