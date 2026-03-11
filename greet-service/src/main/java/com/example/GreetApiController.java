package com.example;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetApiController {

    private final GreetService greetService;

    public GreetApiController(GreetService greetService) {
        this.greetService = greetService;
    }

    @RequestMapping("/api/hello/{name}")
    public String hello(@PathVariable String name) {
        return greetService.greet(name);
    }

}
