package org.hvieira.tutorial.web;

import org.hvieira.tutorial.web.filters.BearerTokenFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity(debug = true)
public class SecurityConfig {

    @Autowired
    BearerTokenFilter bearerTokenFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests(request -> {
            request.requestMatchers("/error").permitAll();
            request.anyRequest().authenticated();
        })
                .csrf(CsrfConfigurer::disable)
                // https://docs.spring.io/spring-security/site/docs/3.2.0.RELEASE/apidocs/org/springframework/security/config/annotation/web/HttpSecurityBuilder.html#addFilter%28javax.servlet.Filter%29
                .addFilterAfter(bearerTokenFilter, BasicAuthenticationFilter.class);

        return http.build();
    }

}