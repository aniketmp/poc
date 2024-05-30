package org.learning;

import org.learning.configurations.AppConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(AppConfig.class)
public class PocApplication {

    public static void main(String[] args) {
        SpringApplication.run(PocApplication.class, args);
    }

}
