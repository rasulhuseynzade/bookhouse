package com.example.bookhouse.config;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@RequiredArgsConstructor
public class WebSecurityConfig {
    private final UserDetailsService userDetailsService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeHttpRequests()
                .requestMatchers("/users/registrate").permitAll()
                .requestMatchers("/book_house/books/**").hasAnyRole( "USER", "ADMIN")
                .requestMatchers("/book_house/authors/**").hasAnyRole("ADMIN")
//                .requestMatchers(permitSwagger).permitAll()
                .anyRequest().authenticated()
                .and().formLogin();

        httpSecurity.csrf().disable();
        httpSecurity.userDetailsService(userDetailsService);
        return httpSecurity.build();
    }
    @Bean
    public PasswordEncoder passwordEncoder(){

        return new BCryptPasswordEncoder();
    }
    public static String[] permitSwagger = {

            "/api/v1/auth/**",
            "v3/api-docs/**",
            "v3/api-docs.yaml",
            "swagger-ui/**",
            "swagger-ui.html"
    };
}

