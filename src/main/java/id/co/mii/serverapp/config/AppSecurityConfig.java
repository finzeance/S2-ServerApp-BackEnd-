/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package id.co.mii.serverapp.config;

import id.co.mii.serverapp.services.AppUserDetailService;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;
 
/**
 *
 * @author Zidane
 */
@Configuration
@EnableWebSecurity
@AllArgsConstructor
public class AppSecurityConfig extends WebSecurityConfigurerAdapter{
    
    private PasswordEncoder passwordEncoder;
    private AppUserDetailService AppUserDetailService;
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception{
        auth
                .userDetailsService(null)
                .passwordEncoder(passwordEncoder);
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http
                .cors()
                .disable()
                .csrf()
                .disable()
                .authorizeRequests()
//                .antMatchers(HttpMethod.POST,"/user")
//                .permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }
}
