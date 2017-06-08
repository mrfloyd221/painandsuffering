/**
 * Created by mrflo on 26.05.2017.
*/
package com.painandsuffering;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import java.util.Arrays;


@SpringBootApplication
public class Application{
    public static void main(String[] args) throws Exception {
        System.setProperty("spring.datasource.driverClassName", "org.postgresql.Driver");
        System.setProperty("spring.datasource.url", "jdbc:postgresql://192.168.99.100:32768/shopdb");
        System.setProperty("spring.datasource.username", "admin");
        System.setProperty("spring.datasource.password", "admin");
        SpringApplication.run(Application.class, args);
    }
}