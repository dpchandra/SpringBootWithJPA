package com.persistence;

import com.persistence.entity.Greeting;
import com.service.GreetingService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    GreetingService greetingService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... arg0) throws Exception {
        List<Greeting> greetings = greetingService.getAllGreetings();
        for (Greeting greeting : greetings) {
            System.out.println("id = " + greeting.getId() + " , name = " + greeting.getName());
        }

    }
}
