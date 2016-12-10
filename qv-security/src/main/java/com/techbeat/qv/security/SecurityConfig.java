package com.techbeat.qv.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;


/**
 * Created by Max Guenes on 29/11/2016.
 */
//@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("admin").password("12345").roles("ADMIN");
        auth.inMemoryAuthentication().withUser("coord").password("12345").roles("COORD");
        auth.inMemoryAuthentication().withUser("user").password("12345").roles("USER");
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
            web
                .ignoring()
                .antMatchers("/resources/**");
    }

    protected void configure(HttpSecurity http) throws Exception {
            http
                .antMatcher("/api/**").authorizeRequests()
                .anyRequest().hasAnyRole("COORD", "ADMIN")
                .and().httpBasic();
        http.csrf().disable();
    }
}