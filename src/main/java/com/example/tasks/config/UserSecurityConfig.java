// package com.example.tasks.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.core.annotation.Order;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.web.SecurityFilterChain;

// @Configuration
// @Order(2)
// public class UserSecurityConfig {

//     @Bean
//     public SecurityFilterChain filterChain2(HttpSecurity http) throws Exception {
//         http.securityMatcher("/user/**")
//                 .csrf(csrf -> csrf.disable())
//                 .cors(Customizer.withDefaults())
//                 .authorizeHttpRequests(auth -> auth
//                         .requestMatchers("/user/**").hasAuthority("USER"))
//                 .formLogin(form -> form
//                         .loginPage("/user/login")
//                         .usernameParameter("username")
//                         .loginProcessingUrl("/user/login")
//                         .defaultSuccessUrl("/user/home", true)
//                         .permitAll())
//                 .logout(logout -> logout
//                         .logoutUrl("/user/logout")
//                         .logoutSuccessUrl("/"));

//         return http.build();
//     }
// }