/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jpatest.controller;

import com.persistence.entity.Greeting;
import com.service.GreetingService;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author user
 */
@RestController
@ComponentScan("com.service")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Autowired
    GreetingService greetingService;

    @RequestMapping("/insert")
    public void greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        greetingService.addGreeting(String.format(template, name), counter.incrementAndGet());
    }

    @RequestMapping("/show")
    public List<Greeting> getGreetings() {
        return greetingService.getAllGreetings();
    }

}
