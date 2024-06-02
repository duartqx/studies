package com.duartqx.alison_spring_1.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("portuguese")
public class GreetingServicePortuguese implements GreetingService {

    @Override
    public String sayHello(String name) {
        return "Olá %s\n".formatted(name);
    }
}