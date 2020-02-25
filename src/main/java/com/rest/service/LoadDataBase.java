package com.rest.service;


import com.rest.repository.UserRepository;
import com.rest.model.Roles;
import com.rest.model.User;
import lombok.extern.slf4j.Slf4j;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
class LoadDatabase {

    @Bean
    CommandLineRunner initDatabase(UserRepository repository) {
        return args -> {
            log.info("Preloading " + repository.save(new User("Leonardo", Roles.ADMIN)));
            log.info("Preloading " + repository.save(new User("Raphael", Roles.AUTHORIZED_USER)));
            log.info("Preloading " + repository.save(new User("Donatello", Roles.NOT_AUTHORIZED_USER)));
        };
    }
}
