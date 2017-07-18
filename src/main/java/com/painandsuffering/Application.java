/**
 * Created by mrflo on 26.05.2017.
*/
package com.painandsuffering;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.Arrays;


@SpringBootApplication
@EnableJpaRepositories("com.painandsuffering.dao")
@ComponentScan
@EntityScan(basePackages = "com.painandsuffering.model")
public class Application{
    public static void main(String[] args) throws Exception {
        SpringApplication.run(Application.class, args);
    }
}