package com.duartqx.alison_spring_1.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

@Controller
public class ThymeleafController {
    @RequestMapping("/template/hello/{name}")
    public String hello(Model model, @PathVariable(value = "name") String name) {

        Map<String, String> context = new HashMap<String, String>() {
            {
                put("message", "Hello from Spring MVC with Thymeleaf");
                put("name", name);
            }
        };

        model.addAllAttributes(context);

        return "hello";
    }
}
