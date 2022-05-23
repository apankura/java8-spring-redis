package com.katarilab.java8aircraft;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

// @Configuration
// public class BasicSecurityConfig extends WebSecurityConfigurerAdapter {

//     public void configure(HttpSecurity http) throws Exception {
//         // http.authorizeRequests()
//         //         .antMatchers("/actuator/**").hasRole("ACTUATOR")
//         //         .anyRequest().permitAll();

//         http.authorizeRequests()
//                 .antMatchers("/traffic/**").hasRole("USER")
//                 .anyRequest().permitAll();
//     }
// }