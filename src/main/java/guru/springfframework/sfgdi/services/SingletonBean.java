package guru.springfframework.sfgdi.services;

import org.springframework.stereotype.Component;

@Component
public class SingletonBean { //resource efficient in comparison to prototype beans

    public SingletonBean() {
        System.out.println("Creating a singleton bean!!!");
    }

    public String getMyScope(){
        return "I'm a Singleton";
    }
}
