// package com.example.tasks.config;

// import java.util.List;

// import org.springframework.boot.CommandLineRunner;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// import com.example.tasks.entity.Role;
// import com.example.tasks.entity.User;
// import com.example.tasks.repository.UserRepository;

// @Configuration
// public class DatabaseLoader {
//     private UserRepository repo;
//     public DatabaseLoader(UserRepository repo) {
//         this.repo = repo;
//     }
    
//     @Bean
//     public CommandLineRunner initDatabase() {
//         return arg -> {
//             if (!repo.existsByUsername("admin")){
//                 User user1 = new User("admin", "Admin", "admin@gmail.com","admin123", Role.ADMIN);
//                 User user2 = new User("admin2", "Admin2", "admin2@gmail.com","admin123", Role.ADMIN);
//                 User user3 = new User("user", "User", "user@gmail.com","user123", Role.USER);
//                 repo.saveAll(List.of(user1, user2, user3));
//                 System.out.println("Database initialized with sample users.");
                
//             }else{
//                 System.out.println("Admin user already exists. Skipping database initialization.");
//             }
//         };
//     }
// }
