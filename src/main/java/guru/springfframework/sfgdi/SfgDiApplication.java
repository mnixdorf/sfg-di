package guru.springfframework.sfgdi;

import guru.springfframework.sfgdi.controllers.MyController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SfgDiApplication {

	public static void main(String[] args) {

		ApplicationContext ctx = SpringApplication.run(SfgDiApplication.class, args);

		MyController myController = (MyController) ctx.getBean("myController"); //has to be lower case from spring, must not be created -> is done by string
		//no webserver configured

		String greeting = myController.sayHello();

		System.out.println(greeting);
	}

}
