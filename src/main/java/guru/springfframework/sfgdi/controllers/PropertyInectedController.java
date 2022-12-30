package guru.springfframework.sfgdi.controllers;

import guru.springfframework.sfgdi.services.GreetingService;

public class PropertyInectedController {
    public GreetingService greetingService;

    public String getGreeting(){
        return greetingService.sayGreeting();
    }
}
