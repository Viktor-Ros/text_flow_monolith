package com.example.text_flow;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class TextFlowApplication {

    public static void main(String[] args) {
        SpringApplication.run(TextFlowApplication.class, args);
    }

}
