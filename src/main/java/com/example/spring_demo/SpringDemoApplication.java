package com.example.spring_demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {
        try {
            ApplicationContext context = SpringApplication.run(SpringDemoApplication.class, args);
            System.out.println("Application démarrée avec succès!");
        } catch (Exception e) {
            System.err.println("Erreur au démarrage: " + e.getMessage());
            e.printStackTrace();
        }
    }
}