package guru.springfframework.sfgdi.services;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

public class I18NSpanishGreetingService implements GreetingService{

    @Override
    public String sayGreeting(){
        return "Hola Mundo - ES";
    }
}
