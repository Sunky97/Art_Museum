package com.sunky.gallery.config.auth;

import com.sunky.gallery.entity.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@RequiredArgsConstructor
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final CustomOAuth2UserService customOAuth2UserService;

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.csrf().disable().headers().frameOptions().disable().and().authorizeRequests()
                .antMatchers("/","/css/**","/image/**","/js/**","/h2-console/**","/painting/list").permitAll()
                .antMatchers("/api/v1/**").hasRole(Role.MEMBER.name())
                .anyRequest().authenticated().and().logout().logoutSuccessUrl("/painting/list")
                .and().oauth2Login().userInfoEndpoint().userService(customOAuth2UserService);
    }
}
