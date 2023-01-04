package guru.springfframework.sfgdi.config;

import com.springframework.pets.PetService;
import com.springframework.pets.PetServiceFactory;
import guru.springfframework.sfgdi.datasource.FakeDataSource;
import guru.springfframework.sfgdi.repositories.EnglishGreetingRepository;
import guru.springfframework.sfgdi.repositories.EnglishGreetingRepositoryImpl;
import guru.springfframework.sfgdi.services.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.*;

//@PropertySource("classpath:datasource.properties") //because it is in resources folder
@ImportResource("classpath:sfgdi-config.xml") //can also be put in Application
@Configuration
public class GreetingServiceConfig {


    @Bean
    FakeDataSource fakeDataSource(@Value("${guru.username}")String username,
                                  @Value("${guru.password}")String password,
                                  @Value("${guru.jdbcurl}")String jdbcurl){
        FakeDataSource fakeDataSource = new FakeDataSource();
        fakeDataSource.setUsername(username);
        fakeDataSource.setPassword(password);
        fakeDataSource.setJdbcurl(jdbcurl);
        return fakeDataSource;
    }
    @Bean
    PetServiceFactory petServiceFactory(){
        return new PetServiceFactory();
    }

    @Profile({"dog", "default"})
    @Bean
    PetService dogPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("dog");
    }

    @Profile({"cat"})
    @Bean
    PetService catPetService(PetServiceFactory petServiceFactory){
        return petServiceFactory.getPetService("cat");
    }

    @Profile({"ES", "default"})
    @Bean("i18nService") //useds method name by default but since two cant have the same name this is required!
    I18NSpanishGreetingService i18NSpanishGreetingService(){
        return new I18NSpanishGreetingService();
    }
    @Bean
    EnglishGreetingRepository englishGreetingRepository(){
        return new EnglishGreetingRepositoryImpl();
    }
    @Profile({"EN"})
    @Bean
    I18NEnglishGreetingService i18nService(EnglishGreetingRepository englishGreetingRepository){
        return new I18NEnglishGreetingService(englishGreetingRepository);
    }

    @Primary
    @Bean
    PrimaryGreetingService primaryGreetingService(){
        return new PrimaryGreetingService();
    }
    //@Bean defined in XML
    ConstructorGreetingService constructorGreetingService(){
        return new ConstructorGreetingService();
    }

    @Bean
    PropertyInjectedGreetingService propertyInjectedGreetingService(){
        return new PropertyInjectedGreetingService();
    }

    @Bean
    SetterInjectedGreetingService setterInjectedGreetingService(){
        return new SetterInjectedGreetingService();
    }
}
