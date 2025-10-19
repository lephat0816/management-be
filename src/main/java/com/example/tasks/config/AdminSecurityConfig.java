// package com.example.tasks.config;

// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.core.annotation.Order;
// import org.springframework.security.config.Customizer;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.password.NoOpPasswordEncoder;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// import com.example.tasks.service.CustomUserDetailService;
// @Order(1)
// @Configuration
// public class AdminSecurityConfig {
//     @Bean
//     public UserDetailsService userDetailService() {
//         return new CustomUserDetailService();
//     }

//     @Bean
//     public PasswordEncoder passwordEncoder() {
//         return NoOpPasswordEncoder.getInstance();
//     }

//     @Bean
//     public SecurityFilterChain filterChain1(HttpSecurity http) throws Exception {
//         http.securityMatcher("/admin/**")
//             .csrf(csrf -> csrf.disable())
//             .cors(Customizer.withDefaults())
//             .authorizeHttpRequests(auth -> auth
//                 .requestMatchers("/admin/**").hasAuthority("ADMIN")
//             )
//             .formLogin(form -> form
//                 .loginPage("/admin/login")
//                 .usernameParameter("username")
//                 .loginProcessingUrl("/admin/login")
//                 .defaultSuccessUrl("/admin/home",true)
//                 .permitAll()
//             )
//             .logout(logout -> logout
//                 .logoutUrl("/admin/logout")
//                 .logoutSuccessUrl("/")
//             );


//         return http.build();
//     }
// }
