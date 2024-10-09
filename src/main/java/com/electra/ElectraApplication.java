package com.electra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication(exclude = {HibernateJpaAutoConfiguration.class})
@EnableJpaAuditing
public class ElectraApplication {
    public static void main(String[] args) {
        SpringApplication.run(ElectraApplication.class, args);
    }
}
