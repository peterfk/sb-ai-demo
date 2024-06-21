package com.example.sb_ai_demo.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    @GetMapping("/")
    /**
     * Returns a greeting message for the home page.
     *
     * @return A string representing the home page greeting.
     */
    public String home() {
        return "Home Page";
    }

    /**
     * Returns a simple greeting message.
     *
     * @return A string representing a basic greeting.
     */
    @GetMapping("/greet")
    public String greet() {
        return "Hello World!";
    }

    /**
     * Returns a personalized greeting message with a specified name.
     *
     * @param name The name to include in the greeting (defaults to 'World' if not
     *             provided).
     * @return A string representing a customized greeting.
     */
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }

    /**
     * Returns a health check response.
     *
     * @return A string indicating the application's health status.
     */
    @GetMapping("/health")
    public String health() {
        return "OK";
    }
}
