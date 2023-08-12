package com.example.demo.student;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        return args -> {
            Student mariam = new Student(
                    1L,
                    "Mariam",
                    LocalDate.of(2000, Month.APRIL, 5),
                    "mariam.jamal@gmail.com");

            Student alex = new Student(
                    "alex",
                    LocalDate.of(2003, Month.JANUARY, 5),
                    "alex.jamal@gmail.com");

            repository.saveAll(List.of(mariam, alex));
        };
    }
}
