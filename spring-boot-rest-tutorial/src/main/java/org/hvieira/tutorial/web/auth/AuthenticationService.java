package org.hvieira.tutorial.web.auth;

public interface AuthenticationService {

    boolean isTokenValid(String token);
    
}
