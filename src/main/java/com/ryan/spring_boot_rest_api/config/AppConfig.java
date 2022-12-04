package com.ryan.spring_boot_rest_api.config;

import com.ryan.spring_boot_rest_api.repository.UserMemoryRepository;
import com.ryan.spring_boot_rest_api.repository.UserRepositoryInterface;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public UserRepositoryInterface userRepository(){

        UserMemoryRepository userMemoryRepository = new UserMemoryRepository();

        System.out.println("정말 등록하나요? =" + userMemoryRepository);
        return userMemoryRepository;
    }
}
