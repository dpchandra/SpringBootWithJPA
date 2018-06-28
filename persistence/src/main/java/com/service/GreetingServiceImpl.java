package com.service;

import com.persistence.repository.GreetingRepository;
import com.persistence.entity.Greeting;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingServiceImpl implements GreetingService {

    private static final String template = "Hello, %s!";

    @Autowired
    private GreetingRepository greetingRepository;

    private final AtomicLong counter = new AtomicLong();

    public List<Greeting> getAllGreetings() {
        List<Greeting> result = new ArrayList<Greeting>();
        Iterable<Greeting> greetings = greetingRepository.findAll();
        for (Greeting greeting : greetings) {
            result.add(greeting);
        }
        return result;
    }

    public void addGreeting(String name, long id) {
        Greeting greeting = new Greeting();
        greeting.setId(counter.incrementAndGet());
        greeting.setName(String.format(template, name));
        System.out.println("in addGreeting" + greeting);
        greetingRepository.save(greeting);
    }
}
