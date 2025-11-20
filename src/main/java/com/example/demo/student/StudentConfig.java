package com.example.demo.student;

import java.time.LocalDate;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner (StudentRepository repository)
    {
        return args -> {
          Student narendra = new Student(
                         "narendra",
                          "narendr.gollu@gmail.com",
                           LocalDate.of(2001,12,13)

            );
         Student kiran = new Student(
                         "kiran",
                          "kiran.chukka@gmail.com",
                           LocalDate.of(2003,10,23)

            );

            repository.saveAll(List.of(narendra, kiran));


        };
    }

}
