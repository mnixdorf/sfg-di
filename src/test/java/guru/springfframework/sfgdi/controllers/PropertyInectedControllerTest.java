package guru.springfframework.sfgdi.controllers;

import guru.springfframework.sfgdi.services.GreetingServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PropertyInectedControllerTest {

    PropertyInectedController controller;

    @BeforeEach
    void setUp() {
        controller = new PropertyInectedController();

        controller.greetingService = new GreetingServiceImpl();
    }

    @Test
    void getGreeting() {
        System.out.println(controller.getGreeting());
    }
}