package guru.springfframework.sfgdi.services;

import guru.springfframework.sfgdi.repositories.EnglishGreetingRepository;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;


public class I18NEnglishGreetingService implements GreetingService {


    private final EnglishGreetingRepository englishGreetingRepository;

    public I18NEnglishGreetingService(EnglishGreetingRepository englishGreetingRepository) {
        this.englishGreetingRepository = englishGreetingRepository;
    }

    @Override
    public String sayGreeting(){
        return englishGreetingRepository.getGreeting();
    }
}
