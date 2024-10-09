package com.electra.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages = "com.electra.repository")
@EntityScan(basePackages = "com.electra.domain")// Adjust package as necessary
public class JpaConfig {
    // No need to define EntityManagerFactory and TransactionManager manually
}
