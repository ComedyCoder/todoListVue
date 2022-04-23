package com.example.springapp;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.FileNotFoundException;


@SpringBootApplication
public class SpringApplication {

    public static void main(String[] args) throws FileNotFoundException {
        org.springframework.boot.SpringApplication.run(SpringApplication.class, args);
    }

}
