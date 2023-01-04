package guru.springfframework.sfgdi.services;

import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE) //scope needed!
@Component
public class PrototypeBean {

    public PrototypeBean() {
        System.out.println("Creating a prototype bean!!!!!!!!!!!!!!!!!!!!!!!!!");
    }

    public String getMyScope(){
        return "I'm a Singleton";
    }
}
