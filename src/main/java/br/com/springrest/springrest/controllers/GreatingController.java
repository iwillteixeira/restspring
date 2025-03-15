package br.com.springrest.springrest.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.springrest.springrest.model.Greeting;

@RestController
public class GreatingController {
    
    private static final String template = "Hello, %s";
    private final AtomicLong counter = new AtomicLong();
    
    @RequestMapping("/greeting")
    public Greeting greeting(
        @RequestParam(defaultValue="Word") 
        String name){
        return new Greeting(counter.incrementAndGet(), String.format(template,name));
    }
}
