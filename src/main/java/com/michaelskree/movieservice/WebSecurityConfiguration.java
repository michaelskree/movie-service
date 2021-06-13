package com.michaelskree.movieservice;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {

    /**
     * Don't require authentication on the health check endpoint
     */
    @Override
    public void configure(HttpSecurity http) throws Exception {
        http
            .csrf()
            .disable()
            .authorizeRequests()
            .antMatchers("/health")
            .permitAll()
            .anyRequest()
            .authenticated()
            .and()
            .httpBasic();
    }
}
