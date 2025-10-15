package com.example.tasks.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class AdminSecurityConfig {
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) {
        try {
            http
                .authorizeHttpRequests((authz) -> authz
                    .requestMatchers("/admin/**").hasAnyAuthority("ADMIN")
                    .requestMatchers("/**").permitAll()
                    .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                    .loginPage("/login")
                    .defaultSuccessUrl("/", true)
                    .permitAll()
                )
                .logout((logout) -> logout.logoutSuccessUrl("/login?logout").permitAll());
            return http.build();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
} 
