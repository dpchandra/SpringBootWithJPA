package com.service;

import com.persistence.entity.Greeting;
import java.util.List;

public interface GreetingService {

    public List<Greeting> getAllGreetings();

    public void addGreeting(String name, long id);
}
