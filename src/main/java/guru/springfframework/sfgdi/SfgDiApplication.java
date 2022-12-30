package guru.springfframework.sfgdi;

import guru.springfframework.sfgdi.controllers.ConstructorInjectedController;
import guru.springfframework.sfgdi.controllers.MyController;
import guru.springfframework.sfgdi.controllers.PropertyInjectedController;
import guru.springfframework.sfgdi.controllers.SetterInjectedController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		MyController myController = (MyController) ctx.getBean("myController"); //has to be lower case from spring, must not be created -> is done by string
		//no webserver configured

		System.out.println("-------------- Primary Bean");

		System.out.println(myController.sayHello());

		System.out.println("------------ Property");

		PropertyInjectedController propertyInectedController = (PropertyInjectedController) ctx.getBean("propertyInjectedController");

		System.out.println(propertyInectedController.getGreeting());

		System.out.println("------------ Setter");

		SetterInjectedController setterInjectedController = (SetterInjectedController) ctx.getBean("setterInjectedController");

		System.out.println(setterInjectedController.getGreeting());

		System.out.println("------------ Constructor");

		ConstructorInjectedController constructorInjectedController = (ConstructorInjectedController) ctx.getBean("constructorInjectedController");

		System.out.println(constructorInjectedController.getGreeting());
	}

}
