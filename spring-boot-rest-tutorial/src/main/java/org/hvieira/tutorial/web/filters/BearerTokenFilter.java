package org.hvieira.tutorial.web.filters;

import java.io.IOException;
import java.util.Collections;
import java.util.Optional;

import org.hvieira.tutorial.web.auth.AuthenticationService;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component
public class BearerTokenFilter extends OncePerRequestFilter {

    private final AuthenticationService authService = new AuthenticationService(){

        @Override
        public boolean isTokenValid(String token) {
            return true;
        }

    };

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
                
                Boolean authenticationResult = Optional.ofNullable(request.getHeader(HttpHeaders.AUTHORIZATION))
                // strip the initial "Bearer " part of the header value
                .map(ht -> ht.substring(7))
                .map(bt -> authService.isTokenValid(bt))
                .orElse(false);

            if (authenticationResult) {
                // see https://medium.com/@sallu-salman/implementing-token-based-authentication-in-a-spring-boot-project-dba7811ffcee
                // the constructor here is important, as one of the constructors simply has the "isAuthentication" property returning false. This one returns true
                Authentication authentication = new UsernamePasswordAuthenticationToken("dummyPrincipal", null, Collections.emptyList());
                SecurityContextHolder.getContext().setAuthentication(authentication);
            } else {
                response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
                return;
            }
            
            filterChain.doFilter(request, response);
    }
    
}
